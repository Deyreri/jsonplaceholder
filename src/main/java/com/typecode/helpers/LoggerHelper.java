package com.typecode.helpers;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoggerHelper {

    // Логирование тела ответа и описание в Allure
    public static void logResponse(String response, String description) {
        System.out.println("=== RESPONSE LOG ===");
        System.out.println("Description: " + description);
        System.out.println("Response Body: " + response);
        System.out.println("====================");

        // Добавление вложения в Allure
        Allure.addAttachment("Response Description", description);
        Allure.addAttachment("Response Body", "application/json", response, "json");
    }

    // Логирование топ-10 слов и добавление в Allure
    public static void logTop10Words(String responseBody, String logDescription) {
        Map<String, Long> wordFrequency = Arrays.stream(responseBody.split("\\W+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Map.Entry<String, Long>> top10Words = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .toList();

        StringBuilder top10WordsLog = new StringBuilder("=== " + logDescription + " ===\n");
        for (int i = 0; i < top10Words.size(); i++) {
            Map.Entry<String, Long> entry = top10Words.get(i);
            String logLine = (i + 1) + ". " + entry.getKey() + " - " + entry.getValue();
            System.out.println(logLine);
            top10WordsLog.append(logLine).append("\n");
        }
        System.out.println("=========================");

        // Добавление в Allure отчёт
        Allure.addAttachment("Top 10 Words", "text/plain", new ByteArrayInputStream(top10WordsLog.toString().getBytes()), "txt");
    }
}
