

/*****************************************

 * The main driver program for project3
 * The program searchs for given zip code
 * By the way, do I need spaces in both sides of "=="?
 ***********************************************/
import java.io.*;
import javax.swing.JOptionPane;

public class search_by_array {
	static Place[] place;
	static int i;
	static int k = 0;
	static int c;
	//set all the index variavles that could be assessed by the whole program



	public static void readfile() {
		String fileName = "zips.txt";
		String line;
		String subline;
		String[] storeString;
		String[] storeString2;
		String[] loadZip;
		String[] loadState;
		String[] loadTown;
		String[] storeTownState;

		//set up the local variables that could be assessed by readfile.



		try{


			FileReader inputFile = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			//read data file and split it.


			line = bufferReader.readLine();
			storeString = line.split(" ");
			storeString2 = storeString[1].split(",");
			i = Integer.parseInt(storeString2[0]);
			//read the number of lines from the first line of the txt

			storeString = new String[i];
			loadZip = new String[i];
			loadState = new String[i];
			loadTown = new String[i];
			place = new Place[i];
			//bulid arrays according to the number of the lines




			while ((line = bufferReader.readLine()) != null) {

				storeString[c] = line;//store each line from the stream
				storeString2 = storeString[c].split("\t");//split it by tab
				loadZip[c] = storeString2[0];//assign the zips
				storeTownState = storeString2[3].split(",");//split again because the town and state comma
				loadState[c] = storeTownState[1];;//assign the state
				loadTown[c] = storeTownState[0];;//assign the town
				place[c] = new Place(loadZip[c],loadTown[c],loadState[c]);;//plug the zip town state values into place objects
				c++;

			}
			bufferReader.close();
		} catch(Exception e) {
			System.out.println("Error while reading file line by line:" + e.getMessage());
		}

	}

	public static void main(String[]args) {
		readfile();//run the readfile static method to build a array of assigned place objects
		String[] options = {"Do it again?", "Exit"};//options used for JOptionPane later
		int response = 0;// used for JOptionPane later
		int indexOfZip;//options used for JOptionPane latter
		long totalTime2;

		do {
			try {
				String dataStr = JOptionPane.showInputDialog("Enter a zip code");
				boolean test = false;//set default test as false. test is used to record if the zip is found or not
				if (dataStr != null) {
					long startTime2 = System.nanoTime();//record the run time
					while (k<i) {
						if (place[k].getZip().equals(dataStr)) {
							test = true;//if inputs match any data, change the test into true, so we can stop searching at this point.
							break;//if found, stop.
						}
						if (test == false) {
							 k = k + 1;//increment k
						}
					}
					long endTime2 = System.nanoTime();
					totalTime2 = (endTime2 - startTime2);
					System.out.println ("The time for linear search is "+totalTime2);//print out the start and end time difference

				}
				
				if (test == true) {
					response = JOptionPane.showOptionDialog(null,
							"You asked me to search for zip code:"+dataStr+" The zip code "+dataStr+" belongs to "+place[k].getTown()+","+place[k].getState()+" Do you want me to search again?",
							"results",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,options[0]);
					//if data matchs the input, tell user the result in JOptionPane
				} else {
					JOptionPane.showMessageDialog(null,"Invalid imput zip code. try again.", "Input Error",JOptionPane.ERROR_MESSAGE);
					//if user input do not mathch, tell user to input another valid one in JOptionpane
				}


				if (test == true) {
					System.out.println("You asked me to search for zip code:"+dataStr);
					System.out.println("The zip code "+dataStr+" belongs to"+place[k].getTown()+","+place[k].getState());
					System.out.println("Do you want me to search again?");
					//if data matchs the input, print in concole the result

				} else {
					System.out.println("You asked me to search for zip code:"+dataStr);
					System.out.println("The zip code "+dataStr+" does not exist.");
					System.out.println("Do you want me to search again?");

					//if data does not match the input, print in concole that it do not exist.
				}
				k=0;//reset t. because some users may want to do it again.
			} catch ( NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Bad Numeric String. try again.", "Input Error",JOptionPane.ERROR_MESSAGE);
				//catch exception if the users input not numeric value.
			}
		} while (response == 0);//set a condition for the loop to allow do it again.
		if (response != 0) {
			System.out.println("No");
			System.out.println("Good Bye!");
			//print in concole
		} else {
			System.out.println("Yes");
			//print in concole
		}
		//press exit and get into the binary search part!
		String inp = JOptionPane.showInputDialog("Use binary search to find your town and state");
        //set another input window to allow user to make binary search
		int index = BinarySearch1.BinarySearch1(place, inp);
		//get the index from the binary search method
		System.out.println(place[index].toString());
		// print the zip town and state out




	}


}

