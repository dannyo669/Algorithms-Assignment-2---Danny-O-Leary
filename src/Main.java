import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;



import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;


public class Main
{
  private Recommender recommender;

  public Main() throws Exception
  {
	   File datastore = new File("moviedata.xml");
	    Serializer serializer = new XMLSerializer(datastore);

	    recommender = new Recommender(serializer);
	    if (datastore.isFile())
	    {
	      recommender.load();
	    }
	    recommender.store();
  }

  public static void main(String[] args) throws Exception
  {
    Main main = new Main();
    

    Shell shell = ShellFactory.createConsoleShell("mr", "Welcome to recommeder-console - ?help for instructions", main);
    shell.commandLoop();
    
    main.recommender.store();
  }

  @Command(description="Create a new User")
  public void createUser (@Param(name="first name") String firstName, @Param(name="last name") String lastName, 
                          @Param(name="age")      int age,     @Param(name="gender")  String gender,	
                          @Param(name="occupation")		String occupation)
  {
    recommender.addUsers(firstName, lastName, age, gender, occupation);
  }

  @Command(description="Delete a User")
  public void deleteUser (@Param(name="id") int id)
  {
    recommender.removeUser(id);
  }
  
  @Command(description="Create a new movie")
  public void createMovie (@Param(name="name spaces with %20") String name) throws IOException{
	  recommender.readInMovie(name);
  }
  
  @Command(description="Get a Movie")
  public void getMovie(@Param(name="id") int id)
  {
	  System.out.println(recommender.getMovieDetails(id-1));
  }
  
  @Command(description="Add a rating")
  public void addRating(@Param(name="user id") int userId, @Param(name="movie id") int movieId, @Param(name="rating") int ratings){
	  recommender.addRating(userId, movieId, ratings);
  }
  
  @Command(description="Get Users Ratings")
  public void getUsersRatings(@Param(name="user id") int userId){
	  recommender.getUsersRatedMovies(userId);
  }
  
  @Command(description="Get Average Ratings")
  public void getAverageRating(@Param(name="movie id") int movieId){
	  System.out.println(recommender.getAverageRating(movieId));
  }
  
  @Command(description="Get Top Ten Movies")
  public void getTopTen(){
	  System.out.println(recommender.getTopTen());
  }
  
  @Command(description="Recommend Moves")
  public void getRecommendedMovies(@Param(name="user id") int userId){
	  recommender.getUserRecommendations(userId);
  }
}