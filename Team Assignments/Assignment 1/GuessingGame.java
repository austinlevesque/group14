import java.util.Random;
import java.util.Scanner;


public class GuessingGame {

    public void play (){                        //initializes the program
       int numberToGuess = randomNum();         //calls method to return a random number that the user must guess
       String userGuess = guessAsString();      //calls method that prompts user for input
       boolean noDigits = allDigits(userGuess); //checks if the user's input can be converted into a number
       checkValue(userGuess, numberToGuess);    //sends string into checkvalue
    }

    public int randomNum(){    //called in play(), generates random number which is assigned as numberToGuess
        int numberToGuess = new Random().nextInt(10) + 1;
        return numberToGuess;
    }
    public String guessAsString (){
        String stringGuess;
        Scanner keyboard = new Scanner (System.in);
        stringGuess = keyboard.next();
        return stringGuess;
    }  
    //allDigits returns false if there if there is one non-number present in user submitted guess
    public boolean allDigits(String aString) {
        boolean noDigits = true;
        for (int index = 0; index < aString.length() && noDigits; index++){
            char aChar = aString.charAt(index);
            if (!Character.isDigit(aChar)){
                noDigits = false;
            }
        }
        return noDigits;
    }
        public void checkValue(String guess, int numberToGuess){    //after the user 
        
        Boolean incorrect = true;
        while (incorrect){
            System.out.print("Enter your guess: ");
            String guessAsString = keyboard.next();
            if (allDigits(guess)){
                int guess = Integer.parseInt(guess);
                if (1 <= guess && guess <= 10){
                    System.out.println("valid guess");
                    if (guess < numberToGuess) {
                        System.out.println("Too low");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high");
                    } else {
                        incorrect = false;
                        System.out.println("You guessed it.");
                    }
                } else {
                    System.out.println("not valid");
                }                   
            } else {
                System.out.println("Please enter a number");               
            }            
        }   
    }
    
    