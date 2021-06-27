package com.company;

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ex47 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/Ex47text.txt"))) {

            String[] textList = bufferedReader.lines().toArray(String[]::new);
            int countWords = 0;
            int punctuationSignCount = 0;

        for (String s : textList) {

            Pattern wordPattern = Pattern.compile("\\w+");
            Matcher wordMatcher = wordPattern.matcher(s);

            Pattern punctuationSignPattern = Pattern.compile("[!.?,;]");
            Matcher punctuationSignMatcher = punctuationSignPattern.matcher(s);

            while (wordMatcher.find()) {
                countWords++;
            };

            while (punctuationSignMatcher.find()) {
                punctuationSignCount++;
            }

        }

        System.out.println("Count of words is " + countWords);
        System.out.println("Count of punctuation signs is " + punctuationSignCount);

    } catch (FileNotFoundException e) {

            throw new FileNotFoundException("File not found!");

    } catch (IOException e) {


        throw new IOException("IO exception");
    }
    }

}
