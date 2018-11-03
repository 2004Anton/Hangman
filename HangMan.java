public class HangMan{
    private int tries; //number of mis-guesses
    private String word; //word that they want to guess
    private String revealed; //how much of the word they have guessed
    private String guessed; //what letters they have guessed
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public HangMan(String word,int tries){
        this.word = word;
        this.tries = tries;
        this.revealed = "";
        this.guessed = "";
        //To define the length and actual letters that you have revealed?
        //I dont know how to explain
        for(int i = 0; i < word.length(); i++){
        	if(ALPHABET.contains(word.substring(i,i+1).toLowerCase())) {
        		revealed = revealed + "_";
        	}
        	else {
        		revealed = revealed + word.substring(i,i+1);
        	}
        }
        //to put in the letters you have guessed
        //i dont know how to explain
        for(int i = 0; i < ALPHABET.length();i++) {
        	guessed = guessed + " ";
        }
    }
    //self explainable
    public void update(){
    	System.out.println("The Length Of The Phrase Is: " + word.length() + " (includes non-characters)");
        System.out.println("Number Of Missed Guesses Left: " + tries);
        System.out.println("What You Have Revealed So Far: " + revealed);
        System.out.println("Letters You Have Guessed: " + guessed);
    }
    public int isLetter(char guess){
        for(int i = 0; i < guessed.length();i++){
            if (guessed.charAt(i) == guess){
                return 0; // Has already been guessed
            }
        }
        if(this.inAlphabet(guess) != -1) {
        	for(int i = 0; i < word.length(); i++) {
        		if(word.toLowerCase().charAt(i)==guess) {
        			return 3;//in the alphabet and in the word
        		}
        	}
        	return 2;//in alphabet but not in word
        }
       return 1; //not in the alphabet, so they cannot guess it
    }
    public void updateLetter(char guess){
        for (int i = 0; i < word.length(); i++){
            if(word.toLowerCase().charAt(i) == guess){
                revealed = revealed.substring(0,i) + guess + revealed.substring(i+1,revealed.length());
            }
        }
        if(this.inAlphabet(guess) != -1) {
    		guessed = guessed.substring(0,this.inAlphabet(guess)) + guess + guessed.substring(this.inAlphabet(guess)+1,guessed.length());
    	}
    }
    public void subtractTries() {
    	tries--;
    }
    public int inAlphabet(char letter) {
    	for(int i = 0; i < ALPHABET.length();i++) {
    		if (ALPHABET.charAt(i) == letter) {
    			return i;
    		}
    	}
    	return -1; //character not in alphabet
    }
    public int winCondition(){
        if (tries <= 0){
            return 0; //Lost
        }
        if(this.revealed.equals(this.word)) {
        	return 2;//won
        }
        return 1; //haven't won or lost yet
    }
}

