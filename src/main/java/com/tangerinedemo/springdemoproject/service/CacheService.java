package com.tangerinedemo.springdemoproject.service;

import com.tangerinedemo.springdemoproject.domain.Cache;
import com.tangerinedemo.springdemoproject.dto.CacheRequest;
import com.tangerinedemo.springdemoproject.repo.CacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CacheService {

    @Autowired
    private CacheRepository cacheRepository;

    @Transactional
    public void put(CacheRequest cacheRequest) {
        Cache cache = new Cache();
        cache.setKey(cacheRequest.getKey());
        cache.setValue(cacheRequest.getValue());
        cacheRepository.save(cache);
    }

    @Transactional(readOnly = true)
    public String get(String key) {
        return cacheRepository.get(key).map(Cache::getValue).orElse(null);
    }

    @Transactional
    public void delete(String key) {
        cacheRepository.delete(key);
    }

    @Transactional
    public void clear() {
        cacheRepository.clear();
    }

    @Transactional(readOnly = true)
    public List<Cache> getAll() {
        return cacheRepository.findAll();
    }


}
