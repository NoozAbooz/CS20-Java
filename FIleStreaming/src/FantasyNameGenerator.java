import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FantasyNameGenerator {

	public static void main(String[] args) throws Exception {
		for (int k = 0; k < 20; k++) {
			Scanner maleNames = new Scanner( new File("maleNames.txt") );
			Scanner femaleNames = new Scanner( new File("femaleNames.txt") );
			Scanner lastNames = new Scanner( new File("lastNames.txt") );

			int gender = myTools.random(0, 1);
			
			String firstName = "";
			String lastName = "";
			
			// first name
			if (gender == 0) { // female
				for (int i = 0; i < myTools.random(1, 20); i++) {
					if (femaleNames.hasNextLine()) {
						firstName = femaleNames.nextLine();
					}
				}
			} else { // male
				for (int i = 0; i < myTools.random(1, 20); i++) {
					if (maleNames.hasNextLine()) {
						firstName = maleNames.nextLine();
					}
				}
			}
			
			for (int i = 0; i < myTools.random(1, 20); i++) {
				if (lastNames.hasNextLine()) {
					lastName = lastNames.nextLine();
				}
			}
			
			System.out.println(firstName + " " + lastName);
		}
	}

}
