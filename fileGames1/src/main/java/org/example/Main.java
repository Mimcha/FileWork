package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        File dir = new File("M://Java//task//02JavaSE//Games");
        File src = new File(dir, "src");
        File res = new File(dir, "res");
        File savegames = new File(dir, "savegames");
        File temp = new File(dir, "temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File mainJ = new File(main, "Main.Java");
        File utilsJ = new File(main, "Utils.Java");
        File tempT = new File(temp, "temp.txt");
        StringBuilder log = new StringBuilder("Лог" + "\n");

        if (src.mkdir())
            log.append("Успешно создан каталог " + src + "\n");
        else
            log.append("Не удалось создать каталог " + src + "\n");
        if (res.mkdir())
            log.append("Успешно создан каталог " + res + "\n");
        else
            log.append("Не удалось создать каталог " + res + "\n");
        if (savegames.mkdir())
            log.append("Успешно создан каталог " + savegames + "\n");
        else
            log.append("Не удалось создать каталог " + savegames + "\n");
        if (temp.mkdir())
            log.append("Успешно создан каталог " + temp + "\n");
        else
            log.append("Не удалось создать каталог " + temp + "\n");
        if (main.mkdir())
            log.append("Успешно создан каталог " + main + "\n");
        else
            log.append("Не удалось создать каталог " + main + "\n");
        if (test.mkdir())
            log.append("Успешно создан каталог " + test + "\n");
        else
            log.append("Не удалось создать каталог " + test + "\n");
        if (drawables.mkdir())
            log.append("Успешно создан каталог " + drawables + "\n");
        else
            log.append("Не удалось создать каталог " + drawables + "\n");
        if (vectors.mkdir())
            log.append("Успешно создан каталог " + vectors + "\n");
        else
            log.append("Не удалось создать каталог " + vectors + "\n");
        if (icons.mkdir())
            log.append("Успешно создан каталог " + icons + "\n");
        else
            log.append("Не удалось создать каталог " + icons + "\n");


        try {
            if (mainJ.createNewFile())
                log.append("Успешно создан файл" + mainJ + "\n");
        } catch (IOException e) {
            log.append("Не удалось создать файл" + mainJ + "\n");
            throw new RuntimeException(e);
        }
        try {
            if (utilsJ.createNewFile())
                log.append("Успешно создан файл" + utilsJ + "\n");
        } catch (IOException e) {
            log.append("Не удалось создать файл" + utilsJ + "\n");
            throw new RuntimeException(e);
        }
        try {
            if (tempT.createNewFile())
                log.append("Успешно создан файл" + tempT + "\n");

        } catch (IOException e) {
            log.append("Не удалось создать файл" + tempT + "\n");
            throw new RuntimeException(e);
        }
        try (FileWriter writer = new FileWriter(tempT, false)) {
            writer.write(String.valueOf(log));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}