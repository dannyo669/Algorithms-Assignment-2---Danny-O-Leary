import java.util.ArrayList;
import java.util.Date;


public class Movies {

	
	private String name;
	private String date;
	private String imdbUrl;
	private ArrayList<String> categories;

	/**
	 * Constructor for movies
	 * @param name
	 * @param date
	 * @param imdbUrl
	 * @param category
	 */
	public Movies(String name, String date, String imdbUrl, ArrayList<String> categories){
		this.name=name;
		this.date=date;
		this.imdbUrl=imdbUrl;
		this.categories=categories;
	}

	/**
	 * returns the movie name
	 * @return the name
	 */
	public String getName() {
		return name;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movies name=" + name + ", date=" + date + ", imdbUrl="
				+ imdbUrl +  ", categories="
				+ categories + "]";
	}
	
	
}
