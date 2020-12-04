package com.company;

public class WorkString {
    private String text;

    WorkString() {
        this.text = "adela, frfe";
    }

    WorkString(String text) {
        this.text = text;
    }

    WorkString(WorkString s){
        this(s.text);
    }

    private String createNew_str() {
        String[] word_check = this.text.split("[,. ]+"); //Разделяем строку на слова

        for (int i = 0; i < word_check.length; i++) {
            //Проверка первой и последней буквы
            String wch = word_check[i];
            if (wch.toLowerCase().charAt(0) != wch.toLowerCase().charAt(wch.length() - 1))
                this.text = this.text.replace(word_check[i], "");
        }
        return this.text;
    }

    public String getNew_str() {
        return "После удаления слов,начинающихся\nи оканчивающихся на разные буквы,\n получилась такая строка:\n " + createNew_str();
    }

    public String getForSaveNew(){
        return createNew_str();
    }

    private int countTotal() {
        int before = this.text.length(); //Подсчитываем длину текста
        int after = this.text.replaceAll("[,.;!:?]", "").length(); //Подсчитываем длину текста без знаков препинания
        return before - after;
    }

    public String getTotal(){
        String st;
        if (countTotal() > 0)
            st = "Количество знаков препинания в тексте:" + Integer.toString(countTotal());
        else
            st = "Увы, в заданном тексте мне не удалось найти знаки препинания";
        return st;
    }
    public int getForSaveTotal(){
        return countTotal();
    }

    public String choiceOf(int ch){
        String save = "";
        String k = Integer.toString(getForSaveTotal());;
        if (ch == 1)
            save = k;
        if (ch == 2)
            save = getForSaveNew();
        return save;
    }

    public void setStr(String znak){
        if (znak.equals("!") || znak.equals(".") || znak.equals("?") || znak.equals(",") || znak.equals(";"))
            this.text += znak;
    }
    public String getStr(){
        return this.text;
    }
}
