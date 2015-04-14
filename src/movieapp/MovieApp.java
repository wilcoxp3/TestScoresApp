/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;
import java.util.ArrayList;
public class MovieApp
{
    public static void main(String[] args)
    {
        ArrayList<Movie> movies = new ArrayList(100);
        
        for (int i = 0; i < 100; i++)
        {
            movies.add(i, MovieIO.getMovie(i + 1));
        }
        
        System.out.println("Welcome to the Movie List Application.\n");
        System.out.println("There are 100 movies in the list.\n");
        while (true)
        {
            int counter = 0;
        
            String category = Validation.getString("What category are you interested in? ");
            for (Movie m : movies)
            {
                
                
                if (category.equalsIgnoreCase(m.getCategory()))
                {
                    System.out.println(m.getTitle());
                    counter++;
                }
            }
            
            if (counter == 0)
            {
                System.out.println("Invalid category. Please enter a valid movie category.");
                System.out.println("Valid categories are: \nanimated\ndrama\nhorror\nmusical\nscifi\n");
            }
            else if (!Validation.getContinue("\nContinue? (y/n): "))
            {
                break;
            }
        }
        System.out.println("DONE");
    }
}
