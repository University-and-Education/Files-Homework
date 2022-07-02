package ru.homework.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ContactUtils {

    private final static Pattern PATTERN = Pattern.compile("[^\\d]");


    /**
     * The method formats numbers from a "dirty" format into an actual form like "+7 (***) *** - ****".
     *
     * @param dirtyPhoneNumbers - list of numbers where formatting was not performed
     * @return - formatted numbers("+7 (***) *** - ****").
     */
    public static List<String> getCorrectPhoneNumber(List<String> dirtyPhoneNumbers) {

        return dirtyPhoneNumbers.stream().map(dirtyNumber -> {
            dirtyNumber = PATTERN.matcher(dirtyNumber).replaceAll("");
            if (dirtyNumber.length() <= 7) {
                dirtyNumber = "812" + dirtyNumber;
            }
            String prefix = dirtyNumber.substring(0, dirtyNumber.length() - 10);
            String body = dirtyNumber.substring(dirtyNumber.length() - 10);

            prefix = prefix.isEmpty() ? "+7" : "+" + prefix;

            return String.format("%s (%s) %s-%s", prefix, body.substring(0, 3),
                    body.substring(3, 6), body.substring(6, 10));
        }).collect(Collectors.toList());
    }
}