public class Student {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>=0 && age<=120) {
            this.age = age;
        }
        else System.out.println("Возраст должен быть от 0 до 120 ");
    }
}
