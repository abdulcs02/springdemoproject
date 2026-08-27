package com.tangerinedemo.springdemoproject.controller;

import com.tangerinedemo.springdemoproject.dto.CacheRequest;
import com.tangerinedemo.springdemoproject.service.LRUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
public class LRUCacheController {

    @Value("${cache.capacity:5}")
    private int cacheCapacity;

    LRUCache lruCache = new LRUCache(cacheCapacity);


    @GetMapping("/lrucache/{key}")
    public ResponseEntity<String> getCache(@PathVariable String key) {
        String value = lruCache.get(key);
        if (value != null) {
            return ResponseEntity.ok(value);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/lrucache")
    public void putCache(@RequestBody CacheRequest cacheRequest) {
       lruCache.put(cacheRequest.getKey(), cacheRequest.getValue());

    }

    @DeleteMapping("/lrucache/{key}")
    public void deleteCache(@PathVariable String key) {
      lruCache.delete(key);
    }

    @DeleteMapping("/lrucache")
    public void clearCache() {
        lruCache.clear();
    }

    @GetMapping("/lrucache/all")
    public ResponseEntity<Map<String,String>> getAllCache() {
        Map<String,String> allCache = lruCache.getAll();
        return ResponseEntity.ok(allCache);
    }



}
