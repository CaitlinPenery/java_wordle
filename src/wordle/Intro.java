package wordle;

public class Intro {
  public static void intro(){
    System.out.println("\nWelcome to my Wordle clone.");
    System.out.println("\nYou have 6 tries to guess a five letter randomly chosen word.");
    System.out.println("\nIf the letter is correct it will return +");
    System.out.println("If the letter is in the word but not the correct position it will return -");
    System.out.println("If the letter is not in the word it will return *");
  }
}
