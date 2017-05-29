package com.filocha.finder;

import https.webapi_allegro_pl.service.*;
import https.webapi_allegro_pl.service_php.ServicePort;
import https.webapi_allegro_pl.service_php.ServiceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@Component
public class AuctionFinderImpl implements AuctionFinder {

    @Value("${userLogin}")
    private String userLogin;

    @Value("${userPassword}")
    private String userPassword;

    @Value("${webApiKey}")
    private String webApiKey;

    @PostConstruct
    @Scheduled(fixedRate = 60 * 60 * 1000)
    private void login() {
        doLogin(userLogin, userPassword, webApiKey);
    }

    @Override
    public List<ItemsListType> findAuctions(String keyword) {
        ServiceService allegroWebApiService = new ServiceService();
        ServicePort allegro = allegroWebApiService.getServicePort();

        DoGetItemsListRequest itemsreq = new DoGetItemsListRequest();
        itemsreq.setCountryId(1);
        itemsreq.setWebapiKey(webApiKey);
        itemsreq.setResultSize(8);

        ArrayOfFilteroptionstype filter = new ArrayOfFilteroptionstype();
        FilterOptionsType fotcat = new FilterOptionsType();
        fotcat.setFilterId("search");

        ArrayOfString categories = new ArrayOfString();
        categories.getItem().add(keyword);

        fotcat.setFilterValueId(categories);
        filter.getItem().add(fotcat);

        itemsreq.setFilterOptions(filter);

        CompletableFuture<ItemsListType> result = new CompletableFuture<>();
        DoGetItemsListResponse doGetItemsList = allegro.doGetItemsList(itemsreq);

        //TODO finish handler with new generated code from wsdl
        Consumer<ItemsListType> handler = (arg -> {
            result.complete(arg);
        });

        ArrayOfItemslisttype items = doGetItemsList.getItemsList();
        return items.getItem();
        //return result;
    }

    private static long getLocalVersion(String webApiKey) {
        ServiceService allegroWebApiService = new ServiceService();
        ServicePort allegro = allegroWebApiService.getServicePort();

        int countryCode = 1;

        DoQueryAllSysStatusRequest params = new DoQueryAllSysStatusRequest();
        params.setCountryId(countryCode);
        params.setWebapiKey(webApiKey);
        DoQueryAllSysStatusResponse response = allegro.doQueryAllSysStatus(params);

        return response.getSysCountryStatus().getItem().get(0).getVerKey();
    }

    private static void doLogin(String userLogin, String userPassword, String webApiKey) {
        ServiceService allegroWebApiService = new ServiceService();

        ServicePort allegro = allegroWebApiService.getServicePort();

        DoLoginRequest doLoginRequest = new DoLoginRequest();
        doLoginRequest.setUserLogin(userLogin);
        doLoginRequest.setUserPassword(userPassword);
        doLoginRequest.setCountryCode(1);
        doLoginRequest.setLocalVersion(getLocalVersion(webApiKey));
        doLoginRequest.setWebapiKey(webApiKey);

        allegro.doLogin(doLoginRequest);
    }


}
