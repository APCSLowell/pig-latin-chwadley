import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String word) {
	String vowels = "aeiou";
	for (int i=0;i<word.length();i++) {
		String a = word.substring(i,i+1);
		if (vowels.indexOf(a)!=-1) return i;
	}
	return -1;
    }


    public String pigLatin(String s) {
	    int a = findFirstVowel(s);
	    if (a == -1) {
		return s + "ay";
	    } else if (a == 0) {
		return s + "hay"
	    } else {
		return s.substring(a)+s.substring(0,a)+"ay";
	    }
    }
}
