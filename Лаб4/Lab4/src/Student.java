public class Student extends Person{

    public Student(String name, int age, String position, int id, String infected) {
        this.name = name;
        this.position = "Студент";
        this.age = age;
        this.id = id;
        this.infected = infected;
    }

    @Override
    public String getLisence() {
        if (this.infected.equals("-")) {
            return String.format("Студент \nИмя и Фамилия: %s может продолжать ходить на пары", this.name);
        }
        else{
            return String.format("Студент \n Имя и Фамилия: %s не может продолжать ходить на пары", this.name);
        }
    }
}
