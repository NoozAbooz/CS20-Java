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
						if(character == 'a') keyboard.keyPress(KeyEvent.VK_A);
						else if(character == 'b') keyboard.keyPress(KeyEvent.VK_B);
						else if(character == 'c') keyboard.keyPress(KeyEvent.VK_C);
						else if(character == 'd') keyboard.keyPress(KeyEvent.VK_D);
						else if(character == 'e') keyboard.keyPress(KeyEvent.VK_E);
						else if(character == 'f') keyboard.keyPress(KeyEvent.VK_F);
						else if(character == 'g') keyboard.keyPress(KeyEvent.VK_G);
						else if(character == 'h') keyboard.keyPress(KeyEvent.VK_H);
						else if(character == 'i') keyboard.keyPress(KeyEvent.VK_I);
						else if(character == 'j') keyboard.keyPress(KeyEvent.VK_J);
						else if(character == 'k') keyboard.keyPress(KeyEvent.VK_K);
						else if(character == 'l') keyboard.keyPress(KeyEvent.VK_L);
						else if(character == 'm') keyboard.keyPress(KeyEvent.VK_M);
						else if(character == 'n') keyboard.keyPress(KeyEvent.VK_N);
						else if(character == 'o') keyboard.keyPress(KeyEvent.VK_O);
						else if(character == 'p') keyboard.keyPress(KeyEvent.VK_P);
						else if(character == 'q') keyboard.keyPress(KeyEvent.VK_Q);
						else if(character == 'r') keyboard.keyPress(KeyEvent.VK_R);
						else if(character == 's') keyboard.keyPress(KeyEvent.VK_S);
						else if(character == 't') keyboard.keyPress(KeyEvent.VK_T);
						else if(character == 'u') keyboard.keyPress(KeyEvent.VK_U);
						else if(character == 'v') keyboard.keyPress(KeyEvent.VK_V);
						else if(character == 'w') keyboard.keyPress(KeyEvent.VK_W);
						else if(character == 'x') keyboard.keyPress(KeyEvent.VK_X);
						else if(character == 'y') keyboard.keyPress(KeyEvent.VK_Y);
						else if(character == 'z') keyboard.keyPress(KeyEvent.VK_Z);
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
