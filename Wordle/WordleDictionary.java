package Wordle;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordleDictionary {

    private static final int NUM_POSSIBLE_WORDLES = 2315;
    
    /**
     * Finds a word from the wordle list 
     * 
     * @param index the line in the word list file, to fetch a wordle from
     * @return word from wordlelist.txt
     */
    public static String getWord(int index) {

        String word = "error";

        File file = new File("Wordle\\wordlelist.txt");
        assert file.exists() : "wordlelist.txt does not exist";

        try {
            Scanner scan = new Scanner(file);

            for (int i = 0; i < index; i++) {
                word = scan.nextLine();
            }
            scan.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        return word;
    }

    /**
     * Fetches a random wordle from wordlelist.txt
     * @return random wordle
     */
    public static String getRandomWordle() {
        int index = (int) (Math.random() * NUM_POSSIBLE_WORDLES);
        return getWord(index);
    }

    /**
     * Checks whether or not a guess is a valid word to guess via going through a valid answers list.
     * 
     * @param answer the guess in question
     * @return whether or not the guess is a valid word
     */
    public static boolean checkValidAnswer(String answer) {

        File file = new File("Wordle\\validanswers.txt");
        assert file.exists() : "the file words.txt doesn't exist";
        
        try {
        
        Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                if (answer.equals(scan.nextLine())) {
                    scan.close();
                    return true;
                }
            }
            scan.close();
        }
        catch (FileNotFoundException ex) {
        System.out.println("file not found");
        }

        return false;
    }
}