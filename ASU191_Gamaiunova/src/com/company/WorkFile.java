package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.Scanner;

public class WorkFile {
    public WorkFile() {
    }

    public static int loadMFile (String name) throws IOException {
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        int out = Integer.parseInt(scanner.nextLine());
        scanner.close();
        return out;
    }

    public static String loadSFile (String name) throws IOException {
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        String output = scanner.nextLine();
        scanner.close();
        return output;

    }

    public static void writeFile(String name, String filename) throws IOException {
        String fn = filename + ".txt";
        File file = new File(fn);
        PrintWriter pw = new PrintWriter(file);
        pw.println(name);
        pw.close();
    }
    public static void writeByte(String name, String filename) {
        String fn = filename + ".txt";
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(fn));
            os.write(name.getBytes(), 0, name.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
