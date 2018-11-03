import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    	boolean playAgain = true;
    	while(playAgain) {
	        Scanner s = new Scanner(System.in);
	        System.out.println("What is the word or phrase you want your friend to guess?");
	        String word = s.nextLine();
	        System.out.println("How many mis-guesses do you want to give them?");
	        int tries = s.nextInt();
	        HangMan p = new HangMan(word,tries);
	        for(int i = 0; i < 100; i++) {
	        	System.out.println();
	        }
	        while(p.winCondition() == 1){
	        	p.update();
	        	System.out.println("Enter your guess here: ");
	            char g = s.next().toLowerCase().charAt(0);
	            if(p.isLetter(g) == 0){
	                System.out.println("You Have Already Guessed The Letter: " + g + ". Guess Again");
	            }
	            else if(p.isLetter(g) == 2){
	                System.out.println("This Letter Was In The Word: "+ g);
		            p.updateLetter(g);
	            }
	            else{
	                System.out.println("Ouch! The Letter You Guessed Was Not In The Word: " + g);
	                p.subtractTries();
		            p.updateLetter(g);
	            }
	        }
	        p.update();
	        if(p.winCondition() == 2) {
	        	System.out.println("YOU WIN");
	        }
	        if(p.winCondition() == 0) {
	        	System.out.println("YOU LOSE");
	        }
	        System.out.println("Do You Want To Play Again? y/n");
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
