package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EventListener implements ActionListener {
    //поля для получения данных полей
    private MainWindow m;
    private Do d;
    public void actionPerformed(ActionEvent e) {
        d = new Do();
        d.setVisible(true);
        if (e.getActionCommand().equals("Выполнить")) {

            if (m.task2RadioButton.isSelected()) {
                WorkString stroka = new WorkString(m.text2.getText());
                if (m.copRadioButton.isSelected()){
                    WorkString stroka1 = new WorkString(stroka);
                    String znak = m.copt.getText();
                    stroka1.setStr(znak);
                    //Работа с конструктором копирования
                    d.label2.setText("Копия\n" + stroka1.getTotal()+"\nОригинал\n" + stroka.getTotal());
                }
                else{
                    d.label2.setText(stroka.getTotal());
                }
            }
            else if (m.task3RadioButton.isSelected()) {
                Array array = new Array((int) m.spin2.getValue());
                if (m.copRadioButton.isSelected()) {
                    d.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Копию можно вызывать только для второго задания");
                }
                else{
                    d.label2.setText("Числа Фибоначчи\n" + array.getForSave());
                }
            } else {
                if (m.copRadioButton.isSelected()) {
                    d.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Копию можно вызывать только для второго задания");
                }
                else {
                    WorkString stroka = new WorkString(m.text.getText());
                    d.label2.setText(stroka.getNew_str());
                }
            }
        } else
            //если была нажата кнопка "Save"
            if (e.getActionCommand().equals("Сохранить")) {
                WorkFile sv = new WorkFile();
                if (m.task2RadioButton.isSelected()) {
                        d.setVisible(false);
                        sv.writeFile(d.label2.getText(), m.text1.getText());
                        if (!sv.getTrace().equals("")) {
                            d.setVisible(false);
                            JOptionPane.showMessageDialog(null, sv.getTrace());
                            sv.setTrace("");
                        }
                } else if (m.task3RadioButton.isSelected()) {
                    try {
                        sv.writeByte(d.label2.getText(), m.text1.getText());
                        if (!sv.getTrace().equals("")){
                            d.setVisible(false);
                            JOptionPane.showMessageDialog(null,sv.getTrace());
                            sv.setTrace("");
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    sv.writeFile(d.label2.getText(), m.text1.getText());
                    if (!sv.getTrace().equals("")){
                        d.setVisible(false);
                        JOptionPane.showMessageDialog(null,sv.getTrace());
                        sv.setTrace("");
                    }

                }
            }
                //если была нажата кнопка "Open"
                if (e.getActionCommand().equals("Открыть")) {
                    WorkFile so = new WorkFile();

                    if (m.task1RadioButton.isSelected() == true) {
                        try {
                            String path = m.text3.getText();
                            String text;
                            text = WorkFile.loadSFile(path);
                            WorkString stroka = new WorkString(text);
                            d.label2.setText(stroka.getTotal());
                            if (!so.getTrace().equals("")){
                                d.setVisible(false);
                                JOptionPane.showMessageDialog(null,so.getTrace());
                                so.setTrace("");
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else if (m.task2RadioButton.isSelected() == true) {
                        try {
                            String path = m.text3.getText();
                            String text = null;
                            text = WorkFile.loadSFile(path);
                            WorkString stroka = new WorkString(text);
                            d.label2.setText(stroka.getNew_str());
                            if (!so.getTrace().equals("")){
                                d.setVisible(false);
                                JOptionPane.showMessageDialog(null,so.getTrace());
                                so.setTrace("");
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else {
                        Array massiv;
                        try {
                            String path = m.text3.getText();
                            int amount = WorkFile.loadMFile(path);
                            massiv = new Array(amount);
                            d.label2.setText("Числа Фибоначчи\n" + massiv.getForSave());
                            if (!so.getTrace().equals("")){
                                d.setVisible(false);
                                JOptionPane.showMessageDialog(null,so.getTrace());
                                so.setTrace("");
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }

                if (e.getActionCommand().equals("Выполнить по ум.")) {

                    if (m.task2RadioButton.isSelected()) {
                        WorkString stroka = new WorkString();
                        d.label2.setText(stroka.getTotal());
                    }
                    else if (m.task3RadioButton.isSelected()) {
                        Array array = new Array();
                        d.label2.setText("Числа Фибоначчи\n" + array.getForSave());
                    } else {
                        WorkString stroka = new WorkString();
                        d.label2.setText(stroka.getNew_str());
                    }
                }
            }
        }

