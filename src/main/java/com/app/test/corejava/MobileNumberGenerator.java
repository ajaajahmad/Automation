package com.app.test.corejava;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MobileNumberGenerator {

    public static Set<String> generateMobileNumbersBatch(int batchSize) {
        String[] prefixArray = {"99", "98", "97", "96", "95", "94", "93", "92", "91", "88", "87", "86", "85", "84", "83", "82", "81", "80", "79", "78", "77", "76", "75"};
        Set<String> generatedNumbers = new HashSet<>();
        Random random = new Random();

        while (generatedNumbers.size() < batchSize) {
            String prefix = prefixArray[random.nextInt(prefixArray.length)];
            String restDigits = String.format("%08d", random.nextInt(100000000));
            String number = prefix + restDigits;

            if (!generatedNumbers.contains(number)) {
                generatedNumbers.add(number);
            }
        }

        return generatedNumbers;
    }

    public static void main(String[] args) {
        int batchSize = 5;
        Set<String> mobileNumbers = generateMobileNumbersBatch(batchSize);

        for (String number : mobileNumbers) {
            System.out.println(number);
        }
    }
}