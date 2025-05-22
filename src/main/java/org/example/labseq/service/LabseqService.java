package org.example.labseq.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class LabseqService {

    // Cache using ConcurrentHashMap
    private final ConcurrentHashMap<Integer, Long> cache = new ConcurrentHashMap<>();

    public long calculateLabseq(int n) {
        // Check cache first
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // First, ensure we have all values from 0 to n calculated
        for (int i = 0; i <= n; i++) {
            if (!cache.containsKey(i)) {
                long result;

                // Base cases
                if (i == 0) {
                    result = 0;
                } else if (i == 1) {
                    result = 1;
                } else if (i == 2) {
                    result = 0;
                } else if (i == 3) {
                    result = 1;
                } else {
                    // Iterative case: l(i) = l(i-4) + l(i-3)
                    // We know these values are already in cache because we're building up
                    result = cache.get(i - 4) + cache.get(i - 3);
                }
                // Store in cache
                cache.put(i, result);
            }
        }
        return cache.get(n);
    }
}