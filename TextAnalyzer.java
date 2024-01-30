package com.java.practice;

public class TextAnalyzer {

    public static void analyzeText(String text) {
        int wordCount = countWords(text);
        int vowelCount = countVowels(text);
        int sentenceCount = countSentences(text);

        System.out.println("Words: " + wordCount + ", Vowels: " + vowelCount + ", Sentences: " + sentenceCount);
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    private static int countVowels(String text) {
        int vowelCount = 0;
        String vowels = "aeiouAEIOU";

        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelCount++;
            }
        }

        return vowelCount;
    }

    private static int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    public static void main(String[] args) {
        String inputText = "Recent years have brought about an influx of new electric motorcycles geared towards fun and enjoyment, particularly off-road. From weird and interesting bikes that blur the lines between e-bike and motorcycle to full on electric motocross, it’s obvious that the future is bright when it comes to electric off-roader.";
        analyzeText(inputText);
    }
}