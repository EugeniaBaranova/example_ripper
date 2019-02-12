package com.example.serviceLocator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SomeServicefactoryImpl implements SomeServiceFactory {


    private Map<String, SomeService> dispatcherMap = new ConcurrentHashMap<>();

    public SomeServicefactoryImpl() {

        for(int i = 0; i < 100; i++){

            dispatcherMap.put("key" + i, new SomeService() {
                @Override
                public void someAction() {
                    System.out.println("Service !2");
                }
            });
        }

        dispatcherMap.put("someHelloService", new SomeHelloService());
        dispatcherMap.put("someGoodByeService", new SomeGoodByeService());
    }

    @Override

    public SomeService getSome(String service) {
        return dispatcherMap.get(service);
    }
}
