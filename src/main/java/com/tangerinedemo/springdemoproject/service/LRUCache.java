package com.tangerinedemo.springdemoproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LRUCache<K,V> implements Cache<K,V> {


        private final int capacity;
        private final LinkedHashMap<K, V> map;

        public LRUCache(@Value("5") int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCache.this.capacity;
                }
            };
        }


    @Override
    public boolean put(String key, String value) {
            Cache<String, String> cache = new LRUCache<>(capacity);
            cache.put(key, value);

        return true;
    }

    @Override
    public String get(String key) {
        Cache<String, String> cache = new LRUCache<>(capacity);
            return cache.get(key);
    }

    @Override
        public synchronized int size() {
            return map.size();
        }

    @Override
    public boolean delete(String key) {
        Cache<String, String> cache = new LRUCache<>(capacity);
            return cache.delete(key);
    }


    @Override
    public synchronized void clear() {
            map.clear();
        }

    public Map<String,String> getAll() {
        Cache<String, String> cache = new LRUCache<>(capacity);
            return (Map<String, String>) cache;
    }
}
