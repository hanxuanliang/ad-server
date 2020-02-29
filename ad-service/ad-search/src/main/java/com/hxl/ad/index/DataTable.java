package com.hxl.ad.index;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 索引缓存【当注入的类比较多的时候就用这种缓存map的方式去调用】
 * @Author: hanxuanliang
 * @Date: 2020/2/28 14:21
 */
@Component
public class DataTable implements ApplicationContextAware, PriorityOrdered {
    // 应用程序需要什么就要完成什么Aware

    private static ApplicationContext applicationContext;

    // 保存所有的Index服务
    public static final Map<Class<?>, Object> DATA_TABLE_MAP = new ConcurrentHashMap<>(16);

    @Override
    @SuppressWarnings("all")
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataTable.applicationContext = applicationContext;
    }

    @Override
    public int getOrder() {
        // 定义初始化Bean顺序【HIGHEST_PRECEDENCE：值越小越先被启动】
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }

    @SuppressWarnings("all")
    public static <T> T of(Class<T> clazz) {
        // 直接通过类去调用获取实例
        // DataTable.of(AdUnitIndex.class) 这种调用
        T instance = (T) DATA_TABLE_MAP.get(clazz);
        if (null != instance) { return instance; }

        DATA_TABLE_MAP.put(clazz, bean(clazz));
        return (T) DATA_TABLE_MAP.get(clazz);
    }

    @SuppressWarnings("all")
    private static <T> T bean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    @SuppressWarnings("all")
    private static <T> T bean(Class clazz) {
        return (T) applicationContext.getBean(clazz);
    }
}

