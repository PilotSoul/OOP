package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.Scanner;

public class WorkFile {
    static String traceback = "";
    public static String getTrace() {
        return traceback;
    }

    public static void setTrace(String traceback) {
        WorkFile.traceback = traceback;
    }
    public WorkFile() {
    }

    public static int loadMFile (String name) throws IOException {
        try{
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            int out = Integer.parseInt(scanner.nextLine());
            scanner.close();
            return out;
        }
        catch(FileNotFoundException e){
            setTrace("Файл с данным именем не найден. Возможно, вы указали имя файла без разрешения. Попробуйте снова");
        }
        return 0;
    }

    public static String loadSFile (String name) throws IOException {
        try {
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            String output = scanner.nextLine();
            scanner.close();
            return output;
        }
        catch(FileNotFoundException e){
            setTrace("Файл с данным именем не найден. Возможно, вы указали имя файла без разрешения. Попробуйте снова");
        }
        return "";
    }

    public static void writeFile(String name, String filename) {
        try {
            String fn = filename + ".txt";
            File file = new File(fn);
            PrintWriter pw = new PrintWriter(file);
            pw.println(name);
            pw.close();
        }catch (FileNotFoundException e) {
        setTrace("Возникла ошибка. Попробуйте снова");
        }
    }
    public static void writeByte(String name, String filename) {
        String fn = filename + ".txt";
        OutputStream os = null;
        name = name.substring(name.indexOf("\n")+1,name.length()-1);
        try {
            os = new FileOutputStream(new File(fn));
            os.write(name.getBytes(), 0, name.length());
        } catch (IOException e) {
                setTrace("Возникла ошибка. Попробуйте снова");
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
