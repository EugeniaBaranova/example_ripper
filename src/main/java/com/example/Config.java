package com.example;

import com.example.annotation.InjectRandomIntAnnotationBeanPostProcessor;
import com.example.annotation.ProfilingHandlerBeanPostProcessor;
import com.example.annotation.TextWritersAnnotationBeanPostProcessor;
import com.example.writer.GoodByeWriter;
import com.example.writer.GoodDayWriter;
import com.example.writer.HelloWriter;
import com.example.writer.TextWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PostProxyInvokerContextListener postProxyInvokerContextListener(){
        return new PostProxyInvokerContextListener();
    }

    @Bean
    public BaseApplication baseApplication() {
        return new BaseApplication(goodDayWriter());
    }

    @Bean
    public TextWriter goodDayWriter() {
        return new GoodDayWriter();
    }

    @Bean
    public TextWriter goodByeWriter() {
        return new GoodByeWriter();
    }

    @Bean
    public TextWriter helloWriter() {
        return new HelloWriter();
    }

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean
    public TextWritersAnnotationBeanPostProcessor textWritersAnnotationBeanPostProcessor() {
        return new TextWritersAnnotationBeanPostProcessor();
    }

    @Bean
    public TextWriterFactory textWriterFactory(){
        return new TextWriterFactory();
    }

    @Bean
    public ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws Exception {
        return new ProfilingHandlerBeanPostProcessor();
    }
}
