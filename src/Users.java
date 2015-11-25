import java.util.ArrayList;

/**
 * 
 * @author Danny
 *
 */
public class Users {

	private int userId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String occupation;
	/**
	 * Sets up Users
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param occupation
	 */
	public Users(String firstName, String lastName, int age, String gender, String occupation){
		 if(firstName.length() < 15){
			 this.firstName=firstName;
		 }
		 else{
			 this.firstName=firstName.substring(0, 14);
		 }
		 
		 if(lastName.length() < 15){
			 this.lastName=lastName;
		 }
		 else{
			 this.lastName=lastName.substring(0, 14);
		 }
		 
		 this.age=age;
		 
		 if(gender.length() == 1){
			 this.gender=gender;
		 }
		 else{
			 System.out.println("Not a valid input, must be M/F");
		 }
		 
		 if(occupation.length() < 20){
			 this.occupation=occupation;
		 }
		 else{
			 occupation.substring(0, 19);
		 }
	}
	
	
	/**
	 * returns the users id.
	 * @return
	 */
	public int getUserId() {
		return userId;
	}
	
	
	/**
	 * Sets the users id
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * returns the users first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
    /**
     * sets the users first name 
     * @param firstName
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * returns the users last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * sets the users last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * return the users age
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * sets the users age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * returns the users gender
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * sets the users age
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * returns the users occupation
	 * @return
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * sets the users occupation
	 * @param occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
