public class HeadOfTheDepartment extends Person {

    public HeadOfTheDepartment(String name, int age, String position, int id, String infected) {
        this.name = name;
        this.position = "Завкафедрой";
        this.age = age;
        this.id = id;
        this.infected = infected;
    }



    @Override
    public String getLisence() {
        if (this.infected.equals("+")){
            return String.format("Завкафедрой \nИмя и Фамилия: %s не может продолжать ходить на работу в связи с возрастом", this.name);
        }
        else {
            if (this.age < 65) {
                return String.format("Завкафедрой \nИмя и Фамилия: %s может продолжать ходить на работу", this.name);
            } else {
                return String.format("Завкафедрой \nИмя и Фамилия: %s не может продолжать ходить на работу в связи с возрастом", this.name);
            }
        }
    }
}
