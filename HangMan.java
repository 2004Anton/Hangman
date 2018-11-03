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
        //To 
        for(int i = 0; i < word.length(); i++){
        	if(ALPHABET.contains(word.substring(i,i+1).toLowerCase())) {
        		revealed = revealed + "_";
        	}
        	else {
        		revealed = revealed + word.substring(i,i+1);
        	}
        }
        for(int i = 0; i < ALPHABET.length();i++) {
        	guessed = guessed + " ";
        }
    }
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
        for(int i = 0; i < ALPHABET.length(); i++) {
        	if(ALPHABET.charAt(i) == guess) {
        		 for(int k = 0; k < word.length(); k++){
        	         if(word.toLowerCase().charAt(k) == guess){
        	            return 3;//in the alphabet and in the word
        	         }
        		 }
        		 return 2;//in the alphabet, but not in the word
        	}
        }
       return 1; //not in the alphabet, so they cannot guess it
        
    }
    public void updateLetter(char guess){
        for (int i = 0; i < word.length(); i++){
            if(word.toLowerCase().charAt(i) == guess){
                revealed = revealed.substring(0,i) + guess + revealed.substring(i+1,revealed.length());
            }
        }
        for(int i = 0; i < ALPHABET.length();i++) {
        	if(ALPHABET.charAt(i) == guess) {
        		guessed = guessed.substring(0,i) + guess + guessed.substring(i+1,guessed.length());
        	}
        }
    }
    public void subtractTries() {
    	tries--;
    }
    public int winCondition(){
        if (tries <= 0){
            return 0;
        }
        for(int i = 0; i < revealed.length();i++){
            if(revealed.charAt(i) == '_'){
                return 1;
            }
        }
        return 2;
    }
}

