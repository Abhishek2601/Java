import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by abhishekshukla on 1/27/17.
 */

class Movie implements  Comparable<Movie>{
    private String name;
    private int year;
    private double rating;

    public Movie(String name, double rating, int year){
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public int compareTo(Movie movie){
        return this.year -movie.year;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }
}

class RatingCompare implements Comparator<Movie>{
    public int compare(Movie m1 , Movie m2){
        if(m1.getRating() < m2.getRating())
            return -1;
        else if(m1.getRating() > m2.getRating())
            return 1;
        else
            return 0;
    }
}

class NameCompare implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){
        return m1.getName().compareTo(m2.getName());
    }
}

public class Main {
    public static void main(String [] args){
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("\nSorted by year");
        Collections.sort(list);
        for (Movie movie: list)
            System.out.println(movie.getYear() + " " +
                    movie.getRating() + " " +
                    movie.getName()+" ");

        System.out.println("\n Sorted by Rating ");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list,ratingCompare);
        for (Movie movie: list)
            System.out.println(movie.getYear() + " " +
                    movie.getRating() + " " +
                    movie.getName()+" ");


        System.out.println("\n Sorted by Name ");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list,nameCompare);
        for (Movie movie: list)
            System.out.println(movie.getYear() + " " +
                    movie.getRating() + " " +
                    movie.getName()+" ");

    }

}
