import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


import edu.princeton.cs.introcs.In;

/**
 * 
 * @author Danny
 *
 */
public class Recommender {

	private ArrayList<Users> users;
	private ArrayList<Movies> movies;
	private ArrayList<String> categoryNames;
	private Serializer serializer;

	/**
	 * Constructor 
	 * @throws Exception
	 */

	public Recommender(Serializer serializer) throws Exception{
		users = new ArrayList<Users>();
		movies = new ArrayList<Movies>();
		categoryNames = new ArrayList<String>();
		setUpArrayList();
		this.serializer=serializer;
	}
	
	public static void main(String[] args){
		
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		users = (ArrayList<Users>) serializer.pop();
		movies = (ArrayList<Movies>) serializer.pop();
	}

	public void store() throws Exception
	{
		serializer.push(users);
		serializer.push(movies);
		serializer.write(); 
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
,	 */
	public void removeUser(int id){
		users.remove(id);
	}

	/**
	 * adds a rating to a specific movie
	 * @param userId
	 * @param movieId
	 * @param ratings
	 */
	public void addRating(int userId, int movieId, int ratings){
		movies.get(movieId).addRating(userId, ratings);
	}

	/**
	 * gets all the movies a user has rated
	 */
	public void getUsersRatedMovies(int userId){
		for(int i=0; i<movies.size(); i++){
			if(movies.get(i).getUserRating(userId)!=0){
			System.out.println(movies.get(i).getName() + "ratings " + movies.get(i).getUserRating(userId));
			}
		}
	}

	/**
	 * gets a movies average rating
	 */
	public double getAverageRating(int movieId){
		return movies.get(movieId).getAverageRating();
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
	 * @param cat2 
	 */
	public void addMovie(String name, String date, String imdbUrl, ArrayList<String> cat){
		movies.add(new Movies(name, date, imdbUrl, cat));
	}

	/**
	 * returns the movie details
	 */
	public String getMovieDetails(int i){
		return (movies.get(i).toString());
	}

	/**
	 * check if the film has a category
	 * @return the categories
	 */
	private boolean getTrueOrFalse(int i) {
		if(i == 1){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * returns the top ten movies (highest first)
	 */
	public String getTopTen(){
		Movies temp;
		Movies current;
		String str="";
		for (int i=0; i<movies.size(); i++){
			for(int j = 0; j< movies.size()-1; j++)
			{
				if(movies.get(j+1).getAverageRating()>movies.get(j).getAverageRating())
				{
					temp=movies.get(j+1);
					current=movies.get(j);
					movies.set(j, temp);
					movies.set(j+1, current); 
				}
			}
		}
		for(int i=0; i<10; i++){
			str += movies.get(i).toString() + "\n";
		}
		return str;
	}

	/**
	 * returns the recommended movies for a user
	 * 
	 * @param userId
	 */
	public void getUserRecommendations(int userId){
		int value=0;
		int user=0;
		ArrayList<Movies> recommendations = new ArrayList<Movies>();
		//this gets who's recomendations are the closest
		for(int i=1; i<users.size(); i++){
			if(i != userId){
				int newValue=0;
				for(int j=0; j<movies.size()-1; j++){
					if(movies.get(j).getUserRating(i) != 0 && movies.get(j).getUserRating(userId) != 0){ //0 means they haven't rated it
						newValue+=movies.get(j).getUserRating(i)*movies.get(j).getUserRating(userId);
					}
				}
				if(newValue>value){
					value=newValue;
					user = i;
				}
			}
		}
		for(int a=0; a<movies.size(); a++){
			if(movies.get(a).getUserRating(userId) == 0 && movies.get(a).getUserRating(user) > 2){
				if(recommendations.size()<10){
					recommendations.add(movies.get(a)); //ensures the array is only 10 in size max
				}
			}
		}
		Movies temp;
		Movies current;
		for(int e=0; e<recommendations.size(); e++){
			for(int d=0; d<recommendations.size()-1; d++){

				if(recommendations.get(d+1).getAverageRating()>recommendations.get(d).getAverageRating())
				{
					temp=recommendations.get(d+1);
					current=recommendations.get(d);
					recommendations.set(d, temp);
					recommendations.set(d+1, current); 	
				}
			}
		}
		for(int c=0; c<recommendations.size(); c++){
			System.out.println(recommendations.get(c).toString());
		}
	}
	
	/**
	 * Reads in the category of a movie from IMDB 
	 * reference: http://www.omdbapi.com/
	 * @throws IOException 
	 */
     public void readInMovie(String movie) throws IOException{
    	 movie = "http://www.omdbapi.com/?t=" + movie;
    	 String delims = "[,]";
    	 URL url = (new URL(movie));
    	 BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    	 String inputLine;
    	 String str = "";
    	 ArrayList<String> category = new ArrayList<>();
    	 while ((inputLine = in.readLine()) != null){
    		 String[] userTokens = inputLine.split(delims);
    		 for(int i=0; i<userTokens.length; i++){
    			for (int a=0; a<categoryNames.size(); a++){
    				if(userTokens[i].contains(categoryNames.get(a))){
    					category.add(userTokens[i]);
    				}
    			}
    			if(userTokens[i].contains("imdbID")){
    				str = userTokens[i].substring(10, userTokens[i].length()-1);
    			}
    		 }
			 addMovie(userTokens[0], userTokens[3], "http://www.imdb.com/" + str, category);
    	 }
     }
     
	/**
	 * sets up an arraylist of users
	 */
	private void setUpArrayList(){
		File usersFile = new File("Data/users.dat");
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

			// get user and rating from data source
			String userDetails3 = inUsers3.readLine();

			// parse user details string
			String[] userTokens3 = userDetails3.split(delims);

			// add user to array list
			if (userTokens3.length == 2) {
				categoryNames.add(userTokens3[0]);
			}
		}

		File usersFile2 = new File("Data/items.dat");
		In inUsers2 = new In(usersFile2);
		ArrayList<String> cat = new ArrayList<String>();

		while(!inUsers2.isEmpty()){
			cat = new ArrayList<String>();
			// get user and rating from data source
			String userDetails2 = inUsers2.readLine();
			//parse user details string
			String[] userTokens2 = userDetails2.split(delims);
			// add movie to an array list
			if(userTokens2.length == 23){
				for(int i=4; i<23; i++){
					if(getTrueOrFalse(Integer.parseInt(userTokens2[i]))){
						String str = categoryNames.get(i-4);
						cat.add(str);
					}
				}
				addMovie(userTokens2[1], userTokens2[2], userTokens2[3], cat);
			}
		}

		File ratingsFile = new File("Data/ratings.dat");
		In inRatings = new In(ratingsFile);

		while(!inRatings.isEmpty()){
			// get user and rating from data source
			String userDetails2 = inRatings.readLine();
			//parse user details string
			String[] userTokens2 = userDetails2.split(delims);
			// add movie to an array list
			if(userTokens2.length == 4){			
				addRating(Integer.parseInt(userTokens2[0]), Integer.parseInt(userTokens2[1])-1, Integer.parseInt(userTokens2[2]));
			}
		}
	}
}



