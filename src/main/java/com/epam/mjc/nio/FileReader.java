package com.epam.mjc.nio;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] nameLine = null;
        String[] ageLine = null;
        String[] emailLine = null;
        String[] phoneLine = null;
        String name = "";
        Integer age = 0;
        String email = "";
        Long phone = 0L;

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
            name = nameLine[1];
            age = Integer.valueOf(ageLine[1]);
            email = emailLine[1];
            phone = Long.valueOf(phoneLine[1]);
        }
        return new Profile(name, age, email, phone);
    }

}