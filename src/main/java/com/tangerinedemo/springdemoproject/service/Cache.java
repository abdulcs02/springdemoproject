package com.tangerinedemo.springdemoproject.service;

import java.util.Optional;

public interface Cache <K, V>{
    boolean put(String key, String value);
    String get(String key);
    int size();
    boolean delete(String key);
    void  clear();
}
