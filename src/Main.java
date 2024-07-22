import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        student.setAge(18);
        System.out.println(student.getAge());
        Field field = student.getClass().getDeclaredField("age");
        field.setAccessible(true);
        field.set(student, 140);
        System.out.println(student.getAge());
        System.out.println(field.get(student));
    }
}