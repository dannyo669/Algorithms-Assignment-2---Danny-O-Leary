import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;


public class Main
{
  public Recommender recommender;

  public Main() throws Exception
  {
	  recommender = new Recommender();
  }

  public static void main(String[] args) throws Exception
  {
    Main main = new Main();
    

    Shell shell = ShellFactory.createConsoleShell("pm", "Welcome to pacemaker-console - ?help for instructions", main);
    shell.commandLoop();
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
  public void createMovie (@Param(name="name") String name, @Param(name="date") String date, @Param(name="imdbUrl") 
  String imdbUrl, ArrayList<String> category){
	  recommender.addMovie(name, date, imdbUrl, category);
  }
  
  @Command(description="Get a Movie")
  public void getMovie(@Param(name="id") int id)
  {
	  System.out.println(recommender.getMovieDetails(id));
  }
}