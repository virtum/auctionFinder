package com.filocha.finder;

import https.webapi_allegro_pl.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuctionFinderImpl implements AuctionFinder {

    @Value("${userLogin}")
    private String userLogin;

    @Value("${userPassword}")
    private String userPassword;

    @Value("${webApiKey}")
    private String webApiKey;

    @Override
    public long getLocalVersion() {
        ServiceService allegroWebApiService = new ServiceService();
        ServicePort allegro = allegroWebApiService.getServicePort();

        int countryCode = 1;

        DoQueryAllSysStatusRequest params = new DoQueryAllSysStatusRequest();
        params.setCountryId(countryCode);
        params.setWebapiKey(webApiKey);
        DoQueryAllSysStatusResponse response = allegro.doQueryAllSysStatus(params);

        return response.getSysCountryStatus().getItem().get(0).getVerKey();
    }

    @Override
    public String doLogin(long localVersion) {
        ServiceService allegroWebApiService = new ServiceService();

        ServicePort allegro = allegroWebApiService.getServicePort();

        DoLoginRequest doLoginRequest = new DoLoginRequest();
        doLoginRequest.setUserLogin(userLogin);
        doLoginRequest.setUserPassword(userPassword);
        doLoginRequest.setCountryCode(1);
        doLoginRequest.setLocalVersion(localVersion);
        doLoginRequest.setWebapiKey(webApiKey);

        DoLoginResponse doLoginResponse = allegro.doLogin(doLoginRequest);
        return doLoginResponse.getSessionHandlePart();
    }

    @Override
    public List<ItemsListType> findAuctions() {
        ServiceService allegroWebApiService = new ServiceService();
        ServicePort allegro = allegroWebApiService.getServicePort();

        DoGetItemsListRequest itemsreq = new DoGetItemsListRequest();
        itemsreq.setCountryId(1);
        itemsreq.setWebapiKey(webApiKey);

        ArrayOfFilteroptionstype filter = new ArrayOfFilteroptionstype();
        FilterOptionsType fotcat = new FilterOptionsType();
        fotcat.setFilterId("category");

        ArrayOfString categories = new ArrayOfString();
        categories.getItem().add("4");
        fotcat.setFilterValueId(categories);
        filter.getItem().add(fotcat);

        itemsreq.setFilterOptions(filter);

        DoGetItemsListResponse doGetItemsList = allegro.doGetItemsList(itemsreq);

        ArrayOfItemslisttype items = doGetItemsList.getItemsList();
        return items.getItem();
    }
}
