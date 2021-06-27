package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex46 {

    public static void main(String[] args) {

        File path = new File("data/");
        File[] filesAndCatalogues = path.listFiles();
        List<String> fileList = new ArrayList<>();
        List<String> catalogueList = new ArrayList<>();

        if (filesAndCatalogues != null) {
            for (File f : filesAndCatalogues) {
                if (f.isDirectory()) {
                    catalogueList.add(f.getName());
                } else if (f.isFile()) {
                    fileList.add(f.getName());
                }
            }
        }

        System.out.println("Displaying files: ");
        System.out.println(fileList);
        System.out.println("Displaying catalogues: ");
        System.out.println(catalogueList);

    }

}
