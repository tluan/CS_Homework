import javax.swing.*;
import java.util.*;
public class BinarySearch1 {
	public static int BinarySearch1(Place[] place, String input) {
		//make a new int array with the same size as the place
		int index = 0;
		int[] zipOnly = new int[place.length];
		//
		int leng = input.length();
	     //test if the input is a vaild five digits number
			if (leng == 5) {
				//if it is, then sort
				Arrays.sort(place);
				for (int i = 0; i < place.length; i++) {
           //so here, I make an int array and give the value of the zip code from the place after I sort it.
					//so for each zip code, the index for that zip code may be the same for
					//this int array and the zip of place objects
					zipOnly[i] = Integer.parseInt(place[i].getZip());
				}
				long startTime = System.nanoTime();
				 index=Arrays.binarySearch(zipOnly, Integer.parseInt(input));
				//I search the index of input zip in the int array. And it will return a index that we can get the same
				//zip from  the place array objects.
				long endTime  = System.nanoTime();
				long totalTime = (endTime - startTime);
				System.out.println("The time for binary search is "+totalTime);//record the run time and print
				return index;
                //return the sesult of binary search 
			}
			return index;

		}

}

