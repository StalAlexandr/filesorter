/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexandrstal.filesorter;

import java.io.File;

/**
 *
 * @author nstal
 */
public class App {

    public static void main(String... args) throws Exception {
        
        if (args.length<1){
            System.err.println("Необходимо задать путь к директории с файлами");
            return;
        }
       
        File dir = new File(args[0]);
        if (!dir.isDirectory()||!dir.exists()){
            System.err.println("Директории " + args[0] + " не существует");        
        }
        
        SorterManager manager = new SorterManager();
        manager.doSort(args[0]);
    }
}
