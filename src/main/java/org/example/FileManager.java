package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static StringBuilder log = new StringBuilder("Лог" + "\n");

    // Метод для создания папки
    static void newFolder(String way) {
        File directory = new File(way);
        if (directory.mkdir()) {
            log.append("Папка успешно создана: ").append(way).append("\n");
        } else {
            log.append("Не удалось создать папку: ").append(way).append("\n");
        }
    }

    // Метод для создания файла
    public void newFile(String way) {
        File file = new File(way);
        try {
            if (file.createNewFile()) {
                log.append("Файл успешно создан: ").append(way).append("\n");
            } else {
                log.append("Не удалось создать файл: ").append(way).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла: ").append(way).append(" - ").append(e.getMessage()).append("\n");
        }
    }

    // Метод для записи лога в файл
    public void writeLogToFile(String logFileWay) {
        try (FileWriter writer = new FileWriter(logFileWay)) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога в файл: " + e.getMessage());
        }
    }
}
