
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInformationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате Фамилия Имя Отчество датарождения номертелефона пол:");

        try {
            String input = scanner.nextLine().trim();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Введено неверное количество данных");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверно указан пол");
            }

            String filename = surname + ".txt";
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber +  " " +gender + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении-записи в файл: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка в введенных данных: " + e.getMessage());
        }
    }
}



