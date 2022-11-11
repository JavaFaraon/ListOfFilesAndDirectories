package org.example;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    static String indent = "";

    public static void main(String[] args)
    {
        System.out.println("Введите путь к папке, чтобы увидеть её содержимое: ");
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        File directory = new File(path);
        if(!directory.exists()){
            System.out.println("Папки с введеным именем не существует");
        }
        else if(!directory.isDirectory()){
            System.out.println(directory.getName() + " не является папкой");
        }
        else {
            printAllDirectoryFiles(directory);
        }
    }

    static void printAllDirectoryFiles(File dir){
        for(File file : Objects.requireNonNull(dir.listFiles())) {
            if (!file.isDirectory()){
                print(file);
            }
            else {
                printDir(file);
                indent = indent + "     ";
                printAllDirectoryFiles(file);
            }
        }
        indent = "";
    }

    static void print(File file){
        System.out.println(indent + file.getName());
    }
    static void printDir(File file){
        System.out.println(indent + file.getName().toUpperCase() + "\\");
    }
}