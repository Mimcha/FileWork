package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Создать три экземпляра класса GameProgress.
        GameProgress gg1 = new GameProgress(100, 1, 1, 2.0);
        GameProgress gg2 = new GameProgress(50, 2, 2, 12.0);
        GameProgress gg3 = new GameProgress(1200, 10, 6, 200.0);
        // Путь к папке сохранений
        String savegamesWay = "M://Java//task//02JavaSE//Games//savegames//";

        //Сохранить сериализованные объекты GameProgress в папку savegames из предыдущей задачи.


        saveGame(savegamesWay + "save1.dat", gg1);
        saveGame(savegamesWay + "save2.dat", gg2);
        saveGame(savegamesWay + "save3.dat", gg3);


        // Путь к архиву
        String zipFilePath = savegamesWay + "games.zip";
        List<String> filesToZip = new ArrayList<>();
        filesToZip.add(savegamesWay + "save1.dat");
        filesToZip.add(savegamesWay + "save2.dat");
        filesToZip.add(savegamesWay + "save3.dat");

        // Создаем ZIP-архив
        zipFiles(zipFilePath, filesToZip);

        // Удаляем оригинальные файлы
        deleteFiles(filesToZip);
    }

    private static void saveGame(String saveWay, GameProgress gameProg) {
        try (FileOutputStream fos = new FileOutputStream(saveWay);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProg);
            System.out.println("Сохранение игры в файл: " + saveWay);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении игры: " + e.getMessage());
        }

    }

    public static void zipFiles(String zipFilePath, List<String> filesToZip) {
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for (String filePath : filesToZip) {
                try (FileInputStream fis = new FileInputStream(filePath)) {
                    ZipEntry zipEntry = new ZipEntry(new File(filePath).getName());
                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) >= 0) {
                        zos.write(buffer, 0, length);
                    }
                    zos.closeEntry();
                    System.out.println("Добавлен файл в архив: " + filePath);
                } catch (IOException e) {
                    System.out.println("Ошибка при добавлении файла в архив: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании ZIP-архива: " + e.getMessage());
        }
    }

    public static void deleteFiles(List<String> filesToDelete) {
        for (String filePath : filesToDelete) {
            File file = new File(filePath);
            if (file.delete()) {
                System.out.println("Удален файл: " + filePath);
            } else {
                System.out.println("Не удалось удалить файл: " + filePath);
            }
        }
    }
}
