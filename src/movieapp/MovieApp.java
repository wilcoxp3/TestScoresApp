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
        //create new ArrayList of size 100 items
        ArrayList<Movie> movies = new ArrayList(100);
        
        //populate the ArrayList with Movie objects using the getMovie static
        //method from the class MovieIO. There are 100 movies total.
        for (int i = 0; i < 100; i++)
        {
            movies.add(i, MovieIO.getMovie(i + 1));
        }
        
        //print opening message
        System.out.println("Welcome to the Movie List Application.\n");
        System.out.println("There are 100 movies in the list.\n");
        while (true)
        {
            //initialize a counter to determine if any movies were found in
            //that category
            int counter = 0;
            
            //get the category choice from the user
            String category = Validation.getString("What category are you interested in? ");
            
            //check if the category entered matches the category of any of the
            //Movie objects in the movies ArrayList. If found, print the Movie
            //title and increment the counter.
            for (Movie m : movies)
            {
                if (category.equalsIgnoreCase(m.getCategory()))
                {
                    System.out.println(m.getTitle());
                    counter++;
                }
            }
            
            //If the counter is 0, no the user has entered an invalid category.
            //Print the valid category options.
            if (counter == 0)
            {
                System.out.println("Invalid category. Please enter a valid movie category.");
                System.out.println("Valid categories are: \nanimated\ndrama\nhorror\nmusical\nscifi\n");
            }
            //After the user has entered a valid category, prompt to continue.
            else if (!Validation.getContinue("\nContinue? (y/n): "))
            {
                break;
            }
        }
        System.out.println("DONE");
    }
}