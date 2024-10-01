package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        // Списки папок и файлов для создания
        ArrayList<String> directories = new ArrayList<>();
        ArrayList<String> files = new ArrayList<>();

        // Добавляем пути для создания папок
        String dir = "M://Java//task//02JavaSE//Games//";
        directories.add(dir + "src");
        directories.add(dir + "res");
        directories.add(dir + "savegames");
        directories.add(dir + "temp");
        directories.add(dir + "src//main");
        directories.add(dir + "src//test");
        directories.add(dir + "res//drawables");
        directories.add(dir + "res//vectors");
        directories.add(dir + "res//icons");


        // Добавляем пути для создания файлов
        files.add(dir + "src//main//Main.Java");
        files.add(dir + "src//main//Utils.Java");
        files.add(dir + "temp//temp.txt");


        // Создаем папки
        for (String direct : directories) {
            fileManager.newFolder(direct);
        }

        // Создаем файлы
        for (String file : files) {
            fileManager.newFile(file);
        }

        // Записываем лог в файл
        fileManager.writeLogToFile(dir + "temp//temp.txt");
    }


}
