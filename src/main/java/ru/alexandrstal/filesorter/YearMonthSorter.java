/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexandrstal.filesorter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class YearMonthSorter implements Sorter {

    private DateFormat df = new SimpleDateFormat("yyyy/MM");

    public YearMonthSorter() {
    }

    @Override
    public Path pathToFile(File file) throws Exception {
        BasicFileAttributes attr
                = Files.readAttributes(file.toPath(), BasicFileAttributes.class);

        return Paths.get(df.format(attr.lastModifiedTime().toMillis()));
    }
}
