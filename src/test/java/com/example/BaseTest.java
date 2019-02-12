package com.example;

import com.example.writer.TextWriter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

    @Test
    public void writeWhenHelloWriter() throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        while (true) {
            Thread.sleep(150);
            BaseApplication baseApplication = context.getBean(BaseApplication.class);
            baseApplication.start();

            System.out.println("");

            TextWriterFactory textWriterFactory = context.getBean(TextWriterFactory.class);
            TextWriter writer = textWriterFactory.getTextWriter("good bye");
            writer.write();
        }
    }

    @Test
    public void writeWhenBWriter() throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BaseApplication baseApplication = context.getBean(BaseApplication.class);
    }
}
