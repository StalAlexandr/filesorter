/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexandrstal.filesorter;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author nstal
 */
interface Sorter {
    
    Path pathToFile(File file) throws Exception;
    
}
