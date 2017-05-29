package com.filocha.finder;

import https.webapi_allegro_pl.service.ItemsListType;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AuctionFinder {

    CompletableFuture<List<ItemsListType>> findAuctions(String keyword);
}
