import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.princeton.cs.introcs.In;


public class Categories {

boolean categories[] = new boolean[19];

	public Categories(ArrayList<Integer> cat){
		int i=0;
		for(boolean categories: categories){
		   if(cat.get(i) == 1){
			   this.categories[i] = true;
		   }
		   else{
			   this.categories[i] = false;
		   }
		   i++;
		}
	}

	/**
	 * check if the film has a category
	 * @return the categories
	 */
	public boolean getTrueOrFalse(int i) {
		if(categories[i] == true){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(boolean[] categories) {
		this.categories = categories;
	}
	
	
}
