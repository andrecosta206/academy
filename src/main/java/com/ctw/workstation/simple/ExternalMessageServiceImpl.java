package com.ctw.workstation.simple;

import io.quarkus.arc.impl.Mockable;
import io.quarkus.logging.Log;

public class ExternalMessageServiceImpl implements ExternalMessageService {

    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello from outer space " + name;
    }

    @Override
    public String sayHelloFromOuterSpace() {
        Log.info("Hello from outer space");
        return "Hello from outer space";
    }
}
