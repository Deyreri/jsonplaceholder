package com.typecode.helpers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PostWordFrequencyHelper {

    public static Map<String, Long> getTop10Words(String text) {
        return Arrays.stream(text.split("\\W+")) // Разбиваем текст на слова
                .filter(word -> !word.isEmpty()) // Убираем пустые строки
                .map(String::toLowerCase) // Приводим к нижнему регистру
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Считаем частоту
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Сортируем по убыванию частоты
                .limit(10) // Берём топ-10 слов
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)); // Возвращаем результат
    }
}
