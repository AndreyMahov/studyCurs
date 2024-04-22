package org.mahov.streamApi;

import java.util.Collections;
import java.util.List;

public class BrokerFabric {

    public static List<Broker> createBrokerList() {
        Broker broker1 = new Broker("Anton", BrokerageFirm.GOLDEN_SOCK);
        Broker broker2 = new Broker("Egor", BrokerageFirm.GOLDEN_SOCK);
        Broker broker3 = new Broker("Vadim", BrokerageFirm.WELL_FED_GOOSE);
        Broker broker4 = new Broker("Ivan", BrokerageFirm.WELL_FED_GOOSE);
        Broker broker5 = new Broker("Sergey", BrokerageFirm.WELL_FED_GOOSE);
        Broker broker6 = new Broker("Oly", BrokerageFirm.lION_GATE);

        return List.of(broker1, broker2, broker3, broker4, broker5, broker6);
    }
}
