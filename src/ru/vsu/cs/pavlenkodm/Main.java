package ru.vsu.cs.pavlenkodm;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("D:\\2020\\москва\\img_3773.jpg");
        list.add("D:\\2010\\питер\\img_1757.jpg");
        list.add("C:\\projects\\2013\\library.sln");
        list.add("2018\\january\\january.xlsx");
        list.add("C:\\documents\\summer2018.pdf");
        list.add("\\program Files\\stringFinder.exe");
        System.out.println();
        System.out.println("По расширению, затем по имени файла – по возрастанию (в алфавитном порядке)");
        ArrayList<SortsFale.File> file=SortsFale.sortsFileExtensionTop(list);
        for (SortsFale.File s : file) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
        System.out.println("По расширению, затем по имени файла – по убыванию");
        ArrayList<SortsFale.File> file1=SortsFale.sortsFileExtensionLower(list);
        for (SortsFale.File s : file1) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
        System.out.println("По имени файла – по возрастанию");
        ArrayList<SortsFale.File> file2=SortsFale.sortsFileNameTop(list);
        for (SortsFale.File s : file2) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
        System.out.println("По имени файла – по убыванию");
        ArrayList<SortsFale.File> file3=SortsFale.sortsFileNameLower(list);
        for (SortsFale.File s : file3) {
            System.out.println(s);
        }
    }
}
