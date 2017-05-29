package com.filocha.finder;

import https.webapi_allegro_pl.service.ItemsListType;

import java.util.List;

public interface AuctionFinder {

    List<ItemsListType> findAuctions(String keyword);
}
