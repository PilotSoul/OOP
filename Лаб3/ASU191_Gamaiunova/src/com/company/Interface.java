package com.company;

import java.util.Scanner;
import java.io.*;

public class Interface {
    private static Scanner in = new Scanner(System.in);
    private static Array massiv;
    private static WorkString stroka;
    private static Exception exception;

    Interface() {
        System.out.println("МЕНЮ");
        choiceInput();
    }

    private static void choiceInput() {
            System.out.print("Выберите задание: 1 - числа Фибоначчи, 2 - работа со строкой, 3 - закрыть программу\n>");
            int choice = in.nextInt();
            int ch;
            try{
                switch (choice) {
                    case 1:
                        System.out.print("Выберите способ ввода\n1. Прочитать из файла\n2. Ввести вручную \n3. По умолчанию\n4. Вернуться в главное меню\n>");
                        ch = in.nextInt();
                        in.nextLine();
                        menuFib(ch);
                        break;
                    case 2:
                        System.out.print("Выберите способ ввода\n1. Прочитать из файла \n2. Ввести вручную \n3. По умолчанию\n4. Вернуться в главное меню\n>");
                        ch = in.nextInt();
                        in.nextLine();
                        menuStr(ch);
                        break;
                    case 3:
                        System.out.print("Работа программы прекращена");
                        System.exit(3);
                        break;
                    default:
                        throw exception;
                }
            }
            catch (Exception IndexOutOfBoundException){
                System.out.println("Нет такого номера, Попробуйте снова");
                choiceInput();
                return;
            }

        }

        private static void menuFib ( int choice){
            int ch;
            switch (choice) {
                case 1:
                    System.out.print("Введите название файла\n>");
                    String path = in.nextLine();
                    try {
                        int amount = WorkFile.loadMFile(path);
                        massiv = new Array(amount);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Вы переведены в главное меню");
                        choiceInput();
                    }
                    break;
                case 2:
                    System.out.print("Введите количество элементов массива\n>");
                    int amount = in.nextInt();
                    massiv = new Array(amount);
                    break;
                case 3:
                    massiv = new Array();
                    break;
                case 4:
                    choiceInput();
            }
            System.out.print("Вы хотите поработать с копией? 1 -да, 2 - нет\n>");
            ch = in.nextInt();
            String save;
            switch (ch) {
                case 1:
                    Array massiv1 = new Array(massiv);
                    System.out.println("Первые 10 чисел Фибоначчи: ");
                    massiv.getArr();
                    System.out.println();
                    System.out.println("Копия с переустановленным первым элементом");
                    massiv1.setArr(2);
                    massiv1.getArr();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Первые 10 чисел Фибоначчи: ");
                    massiv.getArr();
                    System.out.println();
                    break;
            }
            save = massiv.getForSave();
            int ch_save;
            System.out.println("Вы хотите сохранить полученный результат?\n1. Да \n2. Нет");
            ch_save = in.nextInt();
            in.nextLine();
            switch(ch_save){
                case 1:
                    System.out.println("Введите название файла без расширения");
                    String path = in.nextLine();
                    WorkFile.writeByte(save, path);
                    System.out.println("Файл сохранён");
                    break;
                default:
                    System.out.print("Работа программы прекращена");
                    System.exit(3);
                    break;
            }
            System.out.print("Работа программы прекращена");
            System.exit(3);
        }

        private static void menuStr ( int choice){
            int ch;
            int ch_save;
            switch (choice) {
                case 1:
                    System.out.print("Введите название файла\n>");
                    String path = in.nextLine();
                    try {
                        String text = WorkFile.loadSFile(path);
                        stroka = new WorkString(text);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Вы переведены в главное меню");
                        choiceInput();
                    }
                    break;
                case 2:
                    System.out.print("Введите любой текст:\n>");
                    String text = in.nextLine();
                    stroka = new WorkString(text);
                    break;
                case 3:
                    stroka = new WorkString();
                    break;
                case 4:
                    choiceInput();
                case 5:
                    in.nextLine();
                    System.out.println("Введите новую строку");
                    String new_str = in.nextLine();
                    stroka.setFStr(new_str);
            }
            int k;
            System.out.println("Выберите задание: 1 - подсчет знаков препинания, 2 - удаление слов, 3 - изменение исходной строки");
            ch = in.nextInt();
            k = ch;
            String save;
            switch (ch) {
                case 1:
                    System.out.println("Вы хотите изменить значение копии и вывести ее? 1 - да, 2 - нет");
                    int cho = in.nextInt();
                    in.nextLine();
                    if (cho == 1) {
                        WorkString stroka1 = new WorkString(stroka);
                        System.out.println("Введите знак препинания");
                        String znak = in.nextLine();
                        stroka1.setStr(znak);
                        //Работа с конструктором копирования
                        System.out.println("Копия");
                        stroka1.getTotal();
                        System.out.println("Оригинал");
                        stroka.getTotal();
                    } else {
                        stroka.getTotal();
                    }
                    break;
                case 2:
                    stroka.getNew_str();
                    break;
                case 3:
                    menuStr(5);
                    break;
            }
            save = stroka.choiceOf(k);
            System.out.println("Вы хотите сохранить полученный результат?\n1. Да \n2. Нет");
            ch_save = in.nextInt();
            in.nextLine();
            switch(ch_save){
                case 1:
                    System.out.println("Введите название файла без расширения");
                    String path = in.nextLine();
                    try {
                        WorkFile.writeFile(save, path);
                        System.out.println("Файл сохранён");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.print("Работа программы прекращена");
                    System.exit(3);
                    break;
            }
            System.out.print("Работа программы прекращена");
            System.exit(3);
        }
    }
