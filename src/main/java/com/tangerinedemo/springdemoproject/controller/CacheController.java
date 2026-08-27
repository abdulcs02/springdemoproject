package com.tangerinedemo.springdemoproject.controller;

import com.tangerinedemo.springdemoproject.domain.Cache;
import com.tangerinedemo.springdemoproject.dto.CacheRequest;

import com.tangerinedemo.springdemoproject.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    @GetMapping("/cache/{key}")
    public ResponseEntity<String> getCache(String key) {
        String value = cacheService.get(key);
        if (value != null) {
            return ResponseEntity.ok(value);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cache")
    public void putCache(@RequestBody CacheRequest cacheRequest) {
        cacheService.put(cacheRequest);
    }

    @DeleteMapping("/cache/{key}")
    public void deleteCache(@PathVariable String key) {
        cacheService.delete(key);
    }

    @DeleteMapping("/cache")
    public void clearCache() {
        cacheService.clear();
    }

    @GetMapping("/cache/all")
    public ResponseEntity<List<Cache>> getAllCache() {
       return ResponseEntity.ok(cacheService.getAll());
    }
}
