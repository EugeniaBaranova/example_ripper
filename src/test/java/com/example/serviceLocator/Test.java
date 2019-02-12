package com.example.serviceLocator;

import com.example.serviceLocator.Config.ServiceLocatorConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/*
@RunWith(Parameterized.class)
*/
public class Test {

    private SomeServiceFactory serviceFactory;
    private SomeService someService;
    private SomeServiceFactory customFactory;


 /*   @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0];
    }*/

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ServiceLocatorConfiguration.class);
        serviceFactory = context.getBean(SomeServiceFactory.class);
        someService = () -> System.out.println("test");
        this.customFactory = new SomeServicefactoryImpl();
    }


    @org.junit.Test
    public void singleThreadTest() {
        final int COUNT = 1;
        Queue<Long> queue = new ArrayDeque<>();

        for (int i = 1; i <= COUNT; i++) {
            long start = System.nanoTime();
            SomeService someHelloService = serviceFactory.getSome("someHelloService");
            /*SomeService someHelloService1 = customFactory.getSome("someHelloService");*/
            long end = System.nanoTime();
            long result = end - start;
            /*System.out.println("Result " + i + " : " + result);*/
            queue.add(result);
        }


        Long avgResult = 0L;
        Iterator<Long> iterator = queue.iterator();

        while (iterator.hasNext()) {
            Long item = iterator.next();
            avgResult = avgResult + item;
        }

        System.out.println("Avg result :" + avgResult.longValue() / COUNT);

    }

}
