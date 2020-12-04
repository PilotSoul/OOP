package com.company;

import javax.swing.*;
import java.awt.*;

public class Do extends JDialog {
    private JLabel label1 = new JLabel("Выполненное задание");
    static JTextArea label2 = new JTextArea();

    public Do(){
        //создаём контейнер, описывающий структуру окна
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1));
        label1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        label1.setFont(new Font("Serif", Font.PLAIN, 24));
        label2.setEditable(false);

        container.add(label1);
        container.add(label2);
        //Делаем невидимым окно
        setVisible(false);
        //Устанавливаем размеры
        setSize(300, 250);
        //Отображаем по центру
        setLocationRelativeTo(null);
    }
}
