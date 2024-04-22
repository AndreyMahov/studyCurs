package org.mahov.streamApi;

import java.util.List;

public class StockBlockFabric {

    public static List<StockBlock> getStockBlockList(){
        StockBlock stockBlock1 = new StockBlock(1000, 2012);
        StockBlock stockBlock2 = new StockBlock(1100, 2012);
        StockBlock stockBlock3 = new StockBlock(1200, 2012);
        StockBlock stockBlock4 = new StockBlock(1300, 2013);
        StockBlock stockBlock5 = new StockBlock(1400, 2014);
        StockBlock stockBlock6 = new StockBlock(1500, 2015);
        StockBlock stockBlock7 = new StockBlock(1600, 2016);
        StockBlock stockBlock8 = new StockBlock(1700, 2008);

        return List.of(stockBlock1, stockBlock2, stockBlock3, stockBlock4, stockBlock5, stockBlock6, stockBlock7, stockBlock8);
    }
}
