package ru.homework.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    private final static String ROOT_FOLDER_PATH = "C:/Users/Vartanyan/IdeaProjects/pet-project/Files Homework/src/test/resources/files";


    /**
     * Finds a directory along the path.
     *
     * @return - path for working with files.
     */
    public static Path findFolderWithFiles() {
        return Paths.get(ROOT_FOLDER_PATH);
    }

    /**
     * Method for determining the file extension.
     *
     * @param file - file to check.
     * @return - the file type. If the file is without permission, it returns an empty string.
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}