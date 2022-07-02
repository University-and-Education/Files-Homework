package ru.homework.service;

import ru.homework.util.ContactUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberService {

    /**
     * The method reads all phone numbers from the file list.
     * If, while reading, there are letters or other characters, it deletes them and checks the number for correctness.
     *
     * @param fileList - list of files where numbers are stored.
     * @return - phone numbers from files in "dirty" form.
     */
    private List<String> getAllNumbersFromFileList(List<File> fileList) {
        List<String> actualPhoneNumbers = new ArrayList<>();
        fileList.forEach(x -> {
            List<String> line = null;
            try {
                line = Files.lines(x.toPath()).collect(Collectors.toList()).stream()
                        .filter(s -> s.replaceAll("[^0-9]", "").length() >= 7)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line != null) {
                actualPhoneNumbers.addAll(line);
            }
        });
        return actualPhoneNumbers;
    }

    /**
     * The method, getting a list of files with numbers, finds the numbers and returns them in formatted form.
     *
     * @param fileList - list of files where numbers are stored.
     * @return - formatted phone numbers from files.
     */
    public List<String> getAllActualPhoneNumbers(List<File> fileList) {
        List<String> dirtyPhoneNumbers = getAllNumbersFromFileList(fileList);
        return new ArrayList<>(ContactUtils.getCorrectPhoneNumber(dirtyPhoneNumbers));
    }
}