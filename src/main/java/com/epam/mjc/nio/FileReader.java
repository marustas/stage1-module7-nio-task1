package com.epam.mjc.nio;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] nameLine = null;
        String[] ageLine = null;
        String[] emailLine = null;
        String[] phoneLine = null;

        try (FileInputStream input = new FileInputStream(file)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            nameLine = reader.readLine().replace(" ", "").split(":");
            ageLine = reader.readLine().replace(" ", "").split(":");
            emailLine = reader.readLine().replace(" ", "").split(":");
            phoneLine = reader.readLine().replace(" ", "").split(":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nameLine != null && ageLine != null && emailLine != null && phoneLine != null) {
            return new Profile(nameLine[1], Integer.valueOf(ageLine[1]), emailLine[1], Long.valueOf(phoneLine[1]));
        }
        return new Profile();
    }

}