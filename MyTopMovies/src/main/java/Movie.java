import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Movie{

    public String index;
    public String name;
    public double rate;
    public String genre;
    public String year;

    public Movie(){}

    public Movie (Movie a){
        this.index = a.index;
        this.name = a.name;
        this.rate = a.rate;
        this.genre = a.genre;
        this.year = a.year;
    }

    public Movie(String index, String name, double rate, String genre, String year){
        this.index = index;
        this.name = name;
        this.rate = rate;
        this.genre = genre;
        this.year = year;
    }

    public Movie(String name, double rate){
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return (index+". "+ name+"\nЖанр: "+ genre + "\n" + year + "\nОценка: " + rate+ "\n");
    }

    public static String ListToString(ArrayList<Movie> Movies){
        String result = "";
        for(Movie movie:Movies){
            if (result == "")
                result = (result + movie.name + "\nОценка: " + movie.rate +"\n");
            else
                result = (result+ "\n" + movie.name + "\nОценка: " + movie.rate +"\n");
        }
        return result;
    }

    public static String ListToStringForFile(ArrayList<Movie> Movies){
        String result = "";
        for(Movie movie:Movies){
                result = (result + movie.name + ": " + movie.rate +"\n");
        }
        return result;
    }

    public static String GetKinoAfishaTop(int number)throws IOException {
        Document doc = Jsoup.connect("https://www.kinoafisha.info/rating/movies/").get();

        Elements Indexes = doc.getElementsByAttributeValue("class", "movieItem_position");
        Elements Names = doc.getElementsByAttributeValue("class", "movieItem_title");
        Elements Rates = doc.getElementsByAttributeValue("class", "rating_num");
        Elements Genres = doc.getElementsByAttributeValue("class", "movieItem_genres");
        Elements Years = doc.getElementsByAttributeValue("class", "movieItem_year");

        String result = "";
        for (int i = 0; i < number; i++) {
            Movie A = new Movie(Indexes.get(i).text(), Names.get(i).text(),
                    Double.parseDouble(Rates.get(i).text()),
                    Genres.get(i).text(), Years.get(i).text());
            if(result == "")
                result = (result + A.toString());
            else result = (result + "\n" + A.toString());
        }
        return result;

    }

    public static String GetKinoAfishaTop()throws IOException {
        return GetKinoAfishaTop(10);
    }

}
