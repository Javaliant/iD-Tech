
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Arena {
	public static Random generator = new Random();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		//System.out.print("What is your hero name? ");
		Character player1 = new Character(input.nextLine());
		//System.out.print("What is your opponent's name? ");
		Character player2 = new Berserker(input.nextLine());

		Character.battle(player1, player2);
	}
}
