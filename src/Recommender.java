import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import edu.princeton.cs.introcs.In;

/**
 * 
 * @author Danny
 *
 */
public class Recommender {

	private ArrayList<Users> users;
	private ArrayList<Movies> movies;
	private ArrayList<Integer> categories;
	private Categories cat;
	String categoryNames[] = new String[19];

	/**
	 * Constructor 
	 * @throws Exception
	 */
	public Recommender() throws Exception{
		users = new ArrayList<Users>();
		movies = new ArrayList<Movies>();
		categories = new ArrayList<Integer>();
		setUpArrayList();
	}
	public static void main(String []  args) throws Exception{
		Recommender recommender = new Recommender();
	}

	/**
	 * Adds users to an arraylist
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param occupation
	 */
	public void addUsers(String firstName, String lastName, int age, String gender, String occupation){
		users.add(new Users(firstName, lastName, age, gender, occupation));
	}

	/**
	 * Remove a user from the arraylist
	 */
	public void removeUser(int id){
		users.remove(id);
	}
	
	/**
	 * Allows a user to add a rating
	 */
	public void addRating(int id){
		
	}
	/**
	 * returns the current user
	 * @param i
	 */
	public Users getUser(int i){
		return users.get(i);
	}

	/**
	 * adds a movie to an arraylist of movies
	 */
	public void addMovie(String name, String date, String imdbUrl, Categories category){
		movies.add(new Movies(name, date, imdbUrl, category));
	}

	/**
	 * returns the movie details
	 */
	public Movies getMovieDetails(int i){
		Movies movie = new Movies(movies.get(i).getName(), movies.get(i).getDate(), movies.get(i).getImdbUrl(), 
				movies.get(i).getCategory());
		return(movie);
	}
	
	
	/**
	 * return every category the movie is in
	 * @param i
	 * @return
	 */
	public ArrayList<String> getCategory(int i){
		ArrayList<String> moviesCategory = new ArrayList<String>();
		for(int a=0; a<19; a++){
			if(cat.getTrueOrFalse(a) == true){
				moviesCategory.add(categoryNames[a]);
			}
		}
		return moviesCategory;
	}

	/**
	 * sets up an arraylist of users
	 */
	private void setUpArrayList(){
		File usersFile = new File("Data/users5.dat");
		In inUsers = new In(usersFile);
		//each field is separated(delimited) by a '|'
		String delims = "[|]";
		while (!inUsers.isEmpty()) {
			// get user and rating from data source
			String userDetails = inUsers.readLine();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			// add user to array list
			if (userTokens.length == 7) {
				addUsers(userTokens[1], userTokens[2], Integer.parseInt(userTokens[3]), userTokens[4], 
						userTokens[5]);
			}
		}

		File usersFile3 = new File("Data/genre.dat");
		In inUsers3 = new In(usersFile3);
		//each field is separated(delimited) by a '|'
		while (!inUsers3.isEmpty()) {
			int i=0;
			// get user and rating from data source
			String userDetails3 = inUsers3.readLine();

			// parse user details string
			String[] userTokens3 = userDetails3.split(delims);

			// add user to array list
			if (userTokens3.length == 2) {
				this.categoryNames[i]=userTokens3[0];
			}
			System.out.println(categoryNames[i]);
			i++;
		}

		File usersFile2 = new File("Data/items5.dat");
		In inUsers2 = new In(usersFile2);
		while(!inUsers2.isEmpty()){
			// get user and rating from data source
			String userDetails2 = inUsers2.readLine();

			//parse user details string
			String[] userTokens2 = userDetails2.split(delims);
			// add movie to an array list
			if(userTokens2.length == 23){
				for(int i=4; i<23; i++){
					categories.add(Integer.parseInt(userTokens2[i]));
				}
				cat = new Categories(categories);
				addMovie(userTokens2[1], userTokens2[2], userTokens2[3], cat);
			}
		}
	}
}



