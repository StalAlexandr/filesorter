/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexandrstal.filesorter;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SorterManager {

    Sorter sorter = new YearMonthSorter();

    public void doSort(String path) throws Exception {
        Path currentPath = Paths.get(path);
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Path pathForFile = sorter.pathToFile(file);
                    Path pathForMove = currentPath.resolve(pathForFile);

                    File pfm = pathForMove.toFile();
                    if (!pfm.exists()) {
                        pfm.mkdirs();
                    }
                    Path mvPath = pathForMove.resolve(file.getName());
                    Files.move(file.toPath(), mvPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл " + file.getAbsolutePath() + " копируется в " + mvPath.toFile().getAbsolutePath());
                }catch (Exception e){
                    System.err.println("Ошибка при работе с файлом " + file.getAbsolutePath());
                }
                
            }
        }

    }
;

}
