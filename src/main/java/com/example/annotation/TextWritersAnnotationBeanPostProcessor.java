package com.example.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TextWritersAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final String TEXT_FACTORY_BEAN_NAME = "textWriterFactory";

    private Map<String, Object> textWriters = new HashMap<String, Object>();

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        TextWriters annotation = bean.getClass().getAnnotation(TextWriters.class);
        if (annotation != null) {
            String textWriterName = annotation.name();
            textWriters.put(textWriterName, bean);
        }
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(TEXT_FACTORY_BEAN_NAME.equals(beanName)){
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                Class<?> fieldType = field.getType();
                if (Map.class.equals(fieldType)){
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, textWriters);
                }
            }
        }
        return bean;
    }
}
