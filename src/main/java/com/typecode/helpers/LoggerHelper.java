package com.typecode.helpers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class LoggerHelper {

    public static void logResponse(String response, String description) {
        log.info("=== RESPONSE LOG ===");
        log.info("Description: {}", description);
        log.info("Response Body: {}", response);
        log.info("====================");
    }

    public static void logTop10Words(String responseBody, String logDescription) {
        Map<String, Long> wordFrequency = Arrays.stream(responseBody.split("\\W+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Map.Entry<String, Long>> top10Words = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .toList();

        log.info("=== {} ===", logDescription);
        for (int i = 0; i < top10Words.size(); i++) {
            Map.Entry<String, Long> entry = top10Words.get(i);
            log.info("{}. {} - {}", i + 1, entry.getKey(), entry.getValue());
        }
        log.info("====================");
    }
}
