package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;

public class Ex48 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/Ex48text.txt"))) {

            String[] textList = bufferedReader.lines().toArray(String[]::new);

            List<String> numsList = getNumberMatches(textList);

            List<String> filteredNumsList = filterOutRepetitions(numsList);

            System.out.println("Displaying numbers: ");
            System.out.println(numsList);

            System.out.println("Displaying unique numbers: ");
            System.out.println(filteredNumsList);


        } catch (FileNotFoundException e) {

            throw new FileNotFoundException("File not found!");

        } catch (IOException e) {

            throw new IOException("IO exception");
        }

    };

    private static ArrayList<String> filterOutRepetitions (List<String> inList) {

        ArrayList<String> list = new ArrayList<>(inList);
        int length = list.size();

        for (int i = length - 1; i > -1 ; i--) {

            if (list.indexOf(list.get(i)) != i) {

                list.remove(i);

            }

        };

        return list;

    };

    private static ArrayList<String> getNumberMatches (String[] textList) {

        ArrayList<String> result = new ArrayList<>();

        for (String s : textList) {

            Pattern digitPattern = Pattern.compile("\\d+");
            Matcher digitMatcher = digitPattern.matcher(s);


            while (digitMatcher.find()) {
                result.add(digitMatcher.group());
            };

        };

        return result;

    };



}
