package org.jakarta.persistence.api.maakoodisto.test.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
public class FileReadingUtils {


    private FileReadingUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Read a file from resources folder
     *
     * @param filePath - path to file in resources folder
     * @return file content as string
     */
    public static String readFileAsStringFromResources(String filePath) {

        if (filePath == null)
            throw new IllegalArgumentException("File path is null");

        ClassLoader classLoader = FileReadingUtils.class.getClassLoader();

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        classLoader.getResourceAsStream(filePath), StandardCharsets.UTF_8))) {
            for (int c = br.read(); c != -1; c = br.read())
                sb.append((char)c);
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found");
        }

        return  sb.toString();

    }
}
