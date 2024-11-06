package com.devsione.enigmate.util;

import com.devsione.enigmate.service.CipherService;

import java.util.ArrayList;
import java.util.List;

public class VigenereUtil {

    //reusable key processor to simplify encoding and decoding formula
    private static List<Integer> processKey(String key){
        List<Integer> intKey = new ArrayList<>();
        for (char ch : key.toLowerCase().toCharArray()){
            intKey.add(ch - 'a');
        }
        return intKey;
    }

    //method to preserve case using the ASCII range
    private static int processChar(char ch){

        return switch (Character.getType(ch)) {
            case Character.UPPERCASE_LETTER -> 'A';
            case Character.LOWERCASE_LETTER -> 'a';
            default -> 0;
        };
    }

    //encoding method
    public static String encode(String message, String key){
        List<Integer> intKey = processKey(key);
        StringBuilder encodedMessage = new StringBuilder();
        int keyIndex = 0;

        for (char ch : message.toCharArray()) {
            int charCase = processChar(ch);

            if (charCase != 0){
                int shift = intKey.get(keyIndex % intKey.size());
                ch = (char) ((ch - charCase + shift) % 26 + charCase);
                keyIndex++;
            }

            encodedMessage.append(ch);
        }

        return encodedMessage.toString();
    }

    // decoding method
    public static String decode(String message, String key){
        List<Integer> intKey = processKey(key);
        StringBuilder decodedMessage = new StringBuilder();
        int keyIndex = 0;

        for (char ch : message.toCharArray()) {
            int charCase = processChar(ch);

            if (charCase != 0){
                int shift = intKey.get(keyIndex % intKey.size());
                ch = (char) ((ch - charCase - shift + 26) % 26 + charCase);
                keyIndex++;
            }

            decodedMessage.append(ch);
        }

        return decodedMessage.toString();
    }


}
