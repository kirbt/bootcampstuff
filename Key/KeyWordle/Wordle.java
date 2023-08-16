package KeyWordle;

import java.util.Scanner;
    
public class Wordle {
    
    // Create instance variables for the correct answer and amount of tries.
    // Make sure to initialize said variables in the constructor !!
    private String answer;
    private int tries;
    private boolean finished;

    public Wordle() {
        answer = WordleDictionary.getRandomWordle();
        System.out.println(answer);

        tries = 6;
        finished = false;
    }

    /**
     * Should checks if there are no tries left. If there are 0 tries, return true
     * @return whether or not there are any tries left
     */
    public boolean checkNoTriesLeft() {
        return tries <= 0;
    }

    /**
     * Checks if the guess matches the wordle. Prints out 5 symbols corresponding to the letters of the guess. If
     * a letter is in the correct position, it is +, if it is in the wrong position, it is =, if it doesn't match
     * any of the letters of the wordle, it is -. If the guess is correct, end the game on a win, if the guess is incorrect, end the game on a loss.
     * 
     * Note: Make sure the guess is converted to lowercase at the start.
     * 
     * @param guess
     * 
     * Precondition: The guess is 5 letters long and is a "valid answer" according to the WordleDictionary
     */
    public void guess(String guess) {
        if (guess.length() != 5) {
            System.out.println("Invalid word, needs to be 5 letters long.");
            return;
          }
        if (!WordleDictionary.checkValidAnswer(guess)) {
        System.out.println("invalid word");
        return;
        }
    
        String result = "";
        
        for (int i = 0; i < guess.length(); i++) {
        if (Character.toString(guess.charAt(i)).equals(Character.toString(answer.charAt(i)))) {
            result += "+";
        }
        else if (answer.indexOf(Character.toString(guess.charAt(i))) != -1) {
            result += "=";
        }
        else {
            result += "-";
        }
        }
        System.out.println(result);
        tries -= 1;
        if (guess.equals(answer)) {
        endGame(true);
        }
        else if (tries <= 0) {
        endGame(false);
        }
    }

    /**
     * endGame should set finished to true and print a win message with the amount of tries it took, and a loss message.
     * Both messages should also display what the answer was.
     * 
     * @param win whether or not to end the game on a win or a loss
     */
    public void endGame(boolean win) {
        System.out.println("\n-----------------------------------");
        if (win) {
            System.out.println("\nYou won! The Wordle was " + answer.toUpperCase());
            System.out.println("Solved in " + (6 - tries) + " tries.");
        }
        else {
            System.out.println("\nYou lost! The Wordle was " + answer.toUpperCase());
        }
        System.out.println("\n-----------------------------------");
        finished = true;
    }


    /**
     * playWordle initializes a Scanner object in order to take user input.
     * It should also continuously print the amount of tries left and also call the guess method using the
     * user's input in a while loop until the game is finished. 
     * 
     */
    public void playWordle() {
        Scanner scan = new Scanner(System.in);

        System.out.println(" ---- WORDLE ---- ");
        
        while (!finished) {
        System.out.println("\n" + tries + " tries left");
        System.out.println("input guess here:");
        guess(scan.nextLine().toLowerCase());

        }

        scan.close();
    }
}
