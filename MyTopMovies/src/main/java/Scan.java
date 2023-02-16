import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Scan {
    public static ArrayList<Movie> ScanFile(String path) throws IOException {
        ArrayList<Movie> MyMovies = new ArrayList<Movie>();
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        while (scanner.hasNextLine()){
            String film = scanner.nextLine();
            String[] parameters = film.split(": ");
            Movie movie = new Movie();
            movie.name = parameters[0];
            movie.rate = Double.parseDouble(parameters[1]);
            MyMovies.add(movie);
        }
        scanner.close();
        return MyMovies;
    }

    public static void SetDefaultListIntoFile(String path) throws IOException {
        String DEFAULT = "Форма голоса: 10 \n"+"Этот глупый свин не понимает мечту девочки зайки: 10\n" + "Пасажиры: 10\n" + "Воспоминания об убийстве: 10\n" + "Отель гранд будапешт: 10\n"+ "Джокер: 10\n" + "Жмурки: 10\n" + "Тачки (все части): 10\n" + "Зеленая миля: 9\n" + "Подозрительные лица: 9\n" + "Пластиковые воспоминания: 8\n" + "Чудачества любви не помеха: 8\n" + "Сядь за руль моей машины: 8\n" + "Назад в будущее(все части): 8\n" + "Жозе, тигр и рыба: 8\n" + "Таксист: 8\n" + "Брат: 8\n" + "Класс превосходства: 7\n"+ "Драйв: 7\n" + "Американский психопат: 7";
        FileWriter fw = new FileWriter("src/main/java/MyMovies.txt");
        fw.write(DEFAULT);
        fw.close();
    }

    public static void SetDefaultList(ArrayList<Movie> MyMovies, String path) throws IOException {
        MyMovies.clear();
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        while (scanner.hasNextLine()){
            String film = scanner.nextLine();
            String[] parameters = film.split(": ");
            Movie movie = new Movie();
            movie.name = parameters[0];
            movie.rate = Double.parseDouble(parameters[1]);
            MyMovies.add(movie);
        }
        scanner.close();
    }

}
