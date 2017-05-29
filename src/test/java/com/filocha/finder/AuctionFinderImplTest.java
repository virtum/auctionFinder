//package com.filocha.finder;
//
//import https.webapi_allegro_pl.service.ItemsListType;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.greaterThan;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class AuctionFinderImplTest {
//
//    @Autowired
//    private AuctionFinderImpl auctionFinder;
//
//    @Test
//    public void shouldFindAnyAuction() {
//        List<ItemsListType> auctions = auctionFinder.findAuctions("nokia");
//        assertThat(auctions.size(), greaterThan(0));
//    }
//
//
//}
