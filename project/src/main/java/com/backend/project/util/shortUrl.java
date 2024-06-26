package com.backend.project.util;

import java.util.Random;


public class shortUrl {
    public static String[] getShortUrl() {

        int length = 5;
        String serverName = "http://localhost:8080/";

        String shortUrlCode = generateRandomString(length);
        String shortUrl = serverName + shortUrlCode;

        String[] data = new String[2];
        data[0] = shortUrl;
        data[1] = shortUrlCode;

        return data;
    }


    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
