import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    	boolean playAgain = true;
    	while(playAgain) {
	        Scanner s = new Scanner(System.in);
	        boolean validWord = false;
	        String word = "";
	        System.out.println("What is the word or phrase you want your friend to guess?");
	        while (validWord == false) {
	        	word = s.nextLine();
		        if(!(word.contains("_"))) {
		        	validWord = true;
		        }
		        else {
		        	System.out.println("That was an invalid word. Please input another");
		        }
	        }
	        System.out.println("How many missed guesses do you want to give them?");
	        int tries = s.nextInt();
	        HangMan game = new HangMan(word,tries);
	        for(int i = 0; i < 100; i++) {
	        	System.out.println();
	        }
	        while(game.winCondition() == 1){
	        	game.update();
	        	System.out.println("Enter your guess here: ");
	            char g = s.next().toLowerCase().charAt(0);
	            if(game.isLetter(g) == 0){
	                System.out.println("You Have Already Guessed The Letter: " + g + ". Guess Again");
	            }
	            else if(game.isLetter(g) == 1) {
	            	System.out.println("You Cannot Guess That Character!");
	            }
	            else if(game.isLetter(g) == 3){
	                System.out.println("This Letter Was In The Word: "+ g);
		            game.updateLetter(g);
	            }
	            else{
	                System.out.println("Ouch! The Letter You Guessed Was Not In The Word: " + g);
	                game.subtractTries();
		            game.updateLetter(g);
	            }
	        }
	        game.update();
	        if(game.winCondition() == 2) {
	        	System.out.println("YOU WIN");
	        }
	        if(game.winCondition() == 0) {
	        	System.out.println("YOU LOSE");
	        }
	        System.out.println("Do You Want To Play Again? y/n");
	        s.nextLine();
	        
	        String answer = s.nextLine();
	        if(answer.toLowerCase().equals("y")) {
	        	playAgain = true;
	        }
	        else {
	        	playAgain = false;
	        }
    	}
     }
}
