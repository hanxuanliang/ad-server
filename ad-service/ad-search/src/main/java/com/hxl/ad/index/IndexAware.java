package com.hxl.ad.index;

/**
 * @Description: index 操作接口
 * @Author: hanxuanliang
 * @Date: 2020/2/24 15:37
 */
public interface IndexAware<K, V> {

    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}

