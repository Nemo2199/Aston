package homework_readfile;
import java.io.*;

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', surname='" + surname + "'}";
    }

    public static void main(String[] args) {
        String filename = "src/homework_readfile/person.txt";

        // Создание файла с полями
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Name: Jane");
            writer.newLine();
            writer.write("Surname: Doe");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Чтение данных из файла и создание объекта Person
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String name = null;
            String surname = null;
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    name = line.substring(6);
                } else if (line.startsWith("Surname: ")) {
                    surname = line.substring(9);
                }
            }

            if (name != null && surname != null) {
                Person newPerson = new Person(name, surname);
                System.out.println("Created Person: " + newPerson);
            } else {
                System.err.println("Error: Could not read Person data from file.");
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}