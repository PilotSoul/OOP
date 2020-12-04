package com.company;

import java.util.Random;

public class Array {
    private int amount;
    private int[] arr;

    public Array(){
        this.amount = new Random().nextInt(41) + 10;
        this.arr = createArr();
    }

    public Array(int amount){
        this.amount = amount;
        this.arr = createArr();
    }

    private int[] createArr(){
        this.arr = new int[this.amount];

        this.arr[0] = this.arr[1] = 1;

        this.amount = this.amount - 2; //так как 2 элемента задано
        int i = 0;

        while (i < this.amount) {
            this.arr[i + 2] = this.arr[i + 1] + this.arr[i];

            i++;
        }
        return this.arr;
    }

    public String getArr(){
        int i = 0;

        while (i < 10) {
            int element = this.arr[i];

            if (element % 2 == 0) {
                System.out.print("$" + this.arr[i] + " ");
            } else {
                System.out.print(this.arr[i] + " ");
            }

            i++;
        }
        return null;
    }
    public Array(Array a){
        this.amount = a.amount;
        this.arr = a.arr;

    }
    public String getForSave(){
        int i = 0;
        String mass = "";

        while (i < 10) {
            int element = this.arr[i];

            if (element % 2 == 0) {
                mass = mass + "$" + Integer.toString(this.arr[i]) + " ";
            } else {
                mass = mass + Integer.toString(this.arr[i]) + " ";
            }

            i++;
        }
        return mass;
    }
    public void setArr(int chislo){
        this.arr[0] = chislo;
    }

}
