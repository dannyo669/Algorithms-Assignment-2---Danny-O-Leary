import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;


public class Movies {

	
	private String name;
	private String date;
	private String imdbUrl;
	private ArrayList<String> categories;
    private long movieID;
    private Hashtable<Integer, Integer> ratings;
    private static long counter =01;
	/**
	 * Constructor for movies
	 * @param name
	 * @param date
	 * @param imdbUrl
	 * @param category
	 */
	public Movies(String name, String date, String imdbUrl, ArrayList<String> categories){
		this.movieID=counter++;
		this.name=name;
		this.date=date;
		this.imdbUrl=imdbUrl;
		this.categories=categories;
		ratings = new Hashtable<Integer, Integer>();
	}

	/**
	 * returns the movie name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the movies id
	 */
	public long getMovieID(){
		return movieID;
	}
	
	/**
	 * Sets the movies id
	 */
	public void setMovieID(int i){
		movieID=i;
	}
	
	/**
	 * sets the movies name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the date the movie was released
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * sets the date the movie was released
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * returns the link to imdb for the movie
	 * @return the imdbUrl
	 */
	public String getImdbUrl() {
		return imdbUrl;
	}

	/**
	 * sets the imdb url
	 * @param imdbUrl the imdbUrl to set
	 */
	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	/**
	 * adds a rating to a specific movie
	 * @param userId
	 * @param movieId
	 * @param ratings
	 */
	public void addRating(int userId,int ratings){
		this.ratings.put(userId, ratings);
	}
	
	/**
	 * 	returns all a users ratings
	 * @return 
	 */
	public Integer getUserRating(int userId){
			if(ratings.containsKey(userId)){
	//			System.out.println(getName() + " rating: " + ratings.get(userId));
				return ratings.get(userId);
			}
			return 0;
	}
	
	/**
	 * returns the average rating of the movie
	 */
	public double getAverageRating(){
		double sum=0.0;
		int b=0;
		Enumeration<Integer> e = ratings.elements();
		while(e.hasMoreElements()){
			int a=e.nextElement();
			if(a!=0){
			sum+=a;
			}
			else{
				b++;
			}
		}
		
		return toTwoDecimalPlaces(sum/ratings.size()-b);
	}
	
	/*
	 * This method allows a double to be returned to two decimal places
	 */
	private double toTwoDecimalPlaces(double num)
	{
		return (int) (num *100 ) /100.0; 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movies [name=" + name + ", date=" + date + ", imdbUrl="
				+ imdbUrl + ", categories=" + categories + ", movieID="
				+ movieID + ", rating=" + getAverageRating() + "]";
	}
	
	
}
