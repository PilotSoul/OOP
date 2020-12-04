package com.company;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class MainWindow extends JFrame {
    static JRadioButton task1RadioButton=new JRadioButton("Задание 1");
    static JRadioButton task2RadioButton = new JRadioButton("Задание 2");
    static JRadioButton task3RadioButton=new JRadioButton("Задание 3");

    private JTextArea label1 = new JTextArea("Введите строку для \nудаления слов, начинающихся \nи заканчивающихся на \nразные буквы:");
    private JTextArea label2 = new JTextArea("Введите строку\nдля подсчета знаков \nпрепинания в тексте:");
    private JTextArea label3 = new JTextArea("Введите количество \nсимволов последовательности \nФибоначчи:");
    private JLabel label4 = new JLabel("Прочитать из файла (с расширением)");
    private JLabel label6 = new JLabel("Нажмите для получения ответа");
    private JLabel label7 = new JLabel("Сохранить в файл\n");
    private JLabel label9 = new JLabel("");

    static JRadioButton copRadioButton=new JRadioButton("С копией");
    static JRadioButton nocopRadioButton = new JRadioButton("Без копии");
    static JTextField  copt = new JTextField ();

    static JButton buttonTask=new JButton("Выполнить");
    static JButton buttonOpen = new JButton("Открыть");
    static JButton buttonSave = new JButton("Сохранить");

    private JTextArea label8 = new JTextArea("      Нажмите для выполнения\n        задания по умолчанию");
    private JLabel label10 = new JLabel("");
    static JButton buttonUM=new JButton("Выполнить по ум.");
    static JTextField  text = new JTextField ();
    static JTextField  text2 = new JTextField ();
    static JTextField  text1 = new JTextField ();
    static SpinnerModel value1 = new SpinnerNumberModel(10, 10, 49, 1);
    static JSpinner spin2 = new JSpinner(value1);
    static JTextField  text3 = new JTextField ();


    public MainWindow(){
        super("Window for tasks");


        setBounds(100,100,700,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //создаём контейнер
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8,3));
        //Container container1 = this.getContentPane();
        //container1.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //группируем задания
        ButtonGroup group = new ButtonGroup();
        group.add(task1RadioButton);
        group.add(task2RadioButton);
        group.add(task3RadioButton);

        //группируем копийные элементы
        ButtonGroup group2 = new ButtonGroup();
        group2.add(copRadioButton);
        group2.add(nocopRadioButton);

        //изначально выбрана первая задача и выполнение без копии
        task1RadioButton.setSelected(true);
        nocopRadioButton.setSelected(true);

        //делаем недоступными JTextArea
        //label5.setEditable(false);
        label1.setEditable(false);
        label2.setEditable(false);
        label3.setEditable(false);
        label8.setEditable(false);

        //устанавливаем им текст
        label1.setBackground(null);
        label2.setBackground(null);
        label3.setBackground(null);
        label8.setBackground(null);

        Font font = new Font("Baskerville", Font.BOLD, 14);
        label8.setFont(font);

        //и выравнивание
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setHorizontalAlignment(SwingConstants.CENTER);

        // добавляем в контейнер поочерёдно блоки
        container.add(task1RadioButton);
        container.add(task2RadioButton);
        container.add(task3RadioButton);

        container.add(label1);
        container.add(label2);
        container.add(label3);

        container.add(text);
        container.add(text2);
        container.add(spin2);

        container.add(nocopRadioButton);
        container.add(copRadioButton);
        container.add(copt);

        container.add(label6);
        container.add(label9);
        //container.add(label5);
        container.add(buttonTask);

        container.add(label4);
        container.add(text3);
        container.add(buttonOpen);

        container.add(label7);
        container.add(text1);
        container.add(buttonSave);

        container.add(label8);
        container.add(label10);
        container.add(buttonUM);
        //создаём слушателей для обработки нажатия кнопок
        buttonTask.addActionListener(new EventListener());
        buttonSave.addActionListener(new EventListener());
        buttonOpen.addActionListener(new EventListener());
        buttonUM.addActionListener(new EventListener());
    }

}

