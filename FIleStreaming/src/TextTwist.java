import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

public class TextTwist {
	public static boolean canMake(String word, String letters) {
		char[] wordCharArr = word.toCharArray();
		char[] lettersCharArr = letters.toCharArray();
		
		boolean match = true;
		for (int i = 0; i < wordCharArr.length; i++) {
			for (int j = 0; j < lettersCharArr.length; j++) {
				if (lettersCharArr[j] == wordCharArr[i]) {
					lettersCharArr[j] = '!';
					wordCharArr[i] = '!';
				}
			}
			if (wordCharArr[i] != '!') {
				match = false;
				break;
			}
		}
		return match;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while (true) {
			Scanner infile = new Scanner( new File("dictionary3.txt") );
			Robot keyboard = new Robot();
			
			System.out.print("Your 6 letters: ");
			String letters = input.nextLine();
			
			for (int i = 2; i > 0; i--) {
				System.out.println("Starting in " + i + " seconds");
				Thread.sleep(1000);
			}
			
			while (infile.hasNext()) {
				String word = infile.nextLine();
				
				if (canMake(word, letters)) {
					char[] wordCharArr = word.toCharArray();
					
					for (char character : wordCharArr) {
						keyboard.keyPress(KeyEvent.VK_A + (character - 'a'));
						Thread.sleep(5);
					}
					Thread.sleep(5);
					keyboard.keyPress(KeyEvent.VK_ENTER);
				}
			}
			System.out.println("Completed Entry!");
		}
	}
}
