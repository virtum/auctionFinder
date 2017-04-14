package com.filocha.finder;

import https.webapi_allegro_pl.service.ItemsListType;
import java.util.List;

public interface AuctionFinder {

    long getLocalVersion();

    String doLogin(long localVersion);

    List<ItemsListType> findAuctions(String keyword);
}
