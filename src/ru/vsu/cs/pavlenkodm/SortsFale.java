package ru.vsu.cs.pavlenkodm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortsFale {

    static class File implements Comparable<File> {
        String filePath;
        String name;
        String fileExtension;

        public File(String name, String filePath, String fileExtension) {
            this.name = name;
            this.filePath = filePath;
            this.fileExtension = fileExtension;
        }

        @Override
        public String toString() {
            return String.format("%s        Имя: %s        Расширение: %s", filePath, name, fileExtension);
        }

        @Override
        public int compareTo(File o) {
            return this.name.compareTo(o.name);
        }

        public String getName() {
            return name;
        }

        public String getFilePath() {
            return filePath;
        }

        public String getFileExtension() {
            return fileExtension;
        }
    }

    public static String getExpansion(String str) {
        String str1 = getNameWithExpansion(str);
        String[] arrSplit = str1.split("\\.");
        return arrSplit[1];
    }

    public static String getName(String str) {
        String str1 = getNameWithExpansion(str);
        String[] arrSplit = str1.split("\\.");
        return arrSplit[0];
    }

    public static String getNameWithExpansion(String str) {
        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9_-]+[.]+[а-яА-Яa-zA-Z0-9_-]+");
        Matcher matcher = pattern.matcher(str);
        String newStr = "";
        while (matcher.find()) {
            newStr = str.substring(matcher.start(), matcher.end());
        }
        return newStr;
    }


    public static ArrayList<File> createFale(ArrayList<String> list) {
        ArrayList<File> file = new ArrayList<File>();
        for (int i = 0; i < list.size(); i++) {
            String name = getName(list.get(i));
            String fileExtension = getExpansion(list.get(i));
            file.add(new File(name, list.get(i), fileExtension)) ;
        }
        return file;
    }

    public static ArrayList<File> sortsFileExtensionTop(ArrayList<String> list) {
        ArrayList<File> List = SortsFale.createFale(list);
        List.sort(Comparator
                .comparing(File::getFileExtension)
                .thenComparing(File::getName));
        return List;
    }

    public static ArrayList<File> sortsFileExtensionLower(ArrayList<String> list) {
        ArrayList<File> List = SortsFale.createFale(list);
        List.sort(Comparator
                .comparing(File::getFileExtension).reversed()
                .thenComparing(Comparator.comparing(File::getName).reversed()));
        return List;
    }

    public static ArrayList<File> sortsFileNameTop(ArrayList<String> list) {
        ArrayList<File> List = SortsFale.createFale(list);
        List.sort(Comparator
                .comparing(File::getName));
        return List;
    }

    public static ArrayList<File> sortsFileNameLower(ArrayList<String> list) {
        ArrayList<File> List = SortsFale.createFale(list);
        List.sort(Comparator
                .comparing(File::getName).reversed());
        return List;
    }
}
