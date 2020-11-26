abstract public class Person {
        protected String name;
        protected String position;
        protected int age;
        protected int id;
        protected String infected;

        public String getInformation() {
                return String.format("ID: %s Имя и Фамилия: %s Возраст: %s Позиция: %s", this.id, this.name, this.age, this.position);
        };
        public boolean getInfected(){
                if (infected.equals("+")){
                        return true;
                }
                else{
                        return false;
                }
        };
        public abstract String getLisence();
}
