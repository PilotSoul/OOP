import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Department {
    private static int id = 100;
    protected static ArrayList<Person> people = new ArrayList<>();
    private static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        System.out.println("1. Добавить\n2. Показать список\n3. Удалить\n4. Поиск зараженных\n5. Статистика\n0. Выйти из программы");
        System.out.print("Введите действие, которое хотите выполнить: ");
        int Choice = Integer.parseInt(Input.readLine());
        switch (Choice) {
            case 1:
                add();
                id += 1;
                break;
            case 2: {
                showList(people);
                break;
            }
            case 3:
                System.out.print("Введите ID человека, которого хотите убрать из списка: ");
                int id = Integer.parseInt(Input.readLine());
                deletePerson(id, people);
                break;
            case 4:
                searchByInfection(people);
                break;
            case 5:
                statistics(people);
                System.out.println("Вы хотите получить информацию по возрасту? (0 - yes/1 -no)");
                int choice = Integer.parseInt(Input.readLine());
                if (choice == 0) {
                    informationByAge(people);
                }
                break;
            case 0:
                System.exit(0);
                break;
        }
        menu();
    }

    private static void statistics(ArrayList<Person> people) throws IOException {
        boolean people_inf;
        int all_people = all_people(people);
        int amount_people_inf = 0;
        for (Person a : people) {
            people_inf = a.getInfected();
            if (people_inf){
                amount_people_inf += 1;
            }
        }
        if ((amount_people_inf*100/all_people) >= (100 - (amount_people_inf*100/all_people))){
            System.out.println("Пора закрывать институт");
            System.out.println("Процент заболевших " + (amount_people_inf*100/all_people) + "%");
        }
        else {
            System.out.println("Обстановка нормальная");
            System.out.println("Процент заболевших " + (amount_people_inf*100/all_people) + "%");
        }

    }

    private static int all_people(ArrayList<Person> people){
        return people.size();
    }

    private static void informationByAge(ArrayList<Person> people){
        String str;
        for (Person a : people) {
            str = a.getLisence();
            System.out.println(str);;
        }
    }

    private static void add() throws IOException {
        System.out.println("Введите Имя и Фамилию");
        String name = Input.readLine();
        System.out.println("Введите возраст");
        int age = Integer.parseInt(Input.readLine());
        System.out.println("Введите должность (Студент/Профессор/Завкафедрой)");
        String position = Input.readLine();
        System.out.println("Введите статус: заражён = '+' не заражён = '-'");
        String infected = Input.readLine();
        if (position.equals("Студент")) {
            people.add(new Student(name, age, position, id, infected));
            System.out.println(position + " " + name + " был добавлен в список");
        } else if (position.equals("Профессор")) {
            people.add(new Professor(name, age, position, id, infected));
            System.out.println(position + " " + name + " был добавлен в список");
        } else if (position.equals("Завкафедрой")) {
            people.add(new HeadOfTheDepartment(name, age, position, id, infected));
            System.out.println(position + " " + name + " был добавлен в список");
        } else {
            System.out.println("К сожалению, такой позиции нет, попробуйте снова");
            add();
        }
    }

    private static void showList(ArrayList<Person> List) {
        for (Person a : List) {
            System.out.println(a.getInformation());
        }
    }

    public static void deletePerson(int id, ArrayList<Person> List) {
        String stroka;
        int valueOfID;
        char[] dst = new char[3];
        Person tmp = null;
        for (Person a : List) {
            stroka = a.getInformation();
            stroka.getChars(4, 7, dst, 0);
            valueOfID = Integer.parseInt(String.valueOf(dst));
            if (valueOfID == id) {
                tmp = a;
            }
        }
        people.remove(tmp);
    }

    public static void searchByInfection(ArrayList<Person> List) {
        boolean people_inf;
        int amount_people_inf = 0;
        for (Person a : List) {
            people_inf = a.getInfected();
            if (people_inf) {
                amount_people_inf += 1;
                System.out.println(a.getInformation());
            }
        }
        System.out.println("Количество зараженных " + amount_people_inf);
    }
}



