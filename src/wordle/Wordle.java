package wordle;

import java.util.Scanner;

public class Wordle {
  
  public static void main(String[] args) throws Exception {

    String[] words = {"other",
"there",
"which",
"their",
"about",
"write",
"would",
"these",
"thing",
"could",
"sound",
"water",
"first",
"place",
"where",
"after",
"round",
"every",
"under",
"great",
"think",
"cause",
"right",
"three",
"small",
"large",
"spell",
"light",
"house",
"again",
"point",
"world",
"build",
"earth",
"stand",
"found",
"study",
"still",
"learn",
"plant",
"cover",
"state",
"never",
"cross",
"start",
"might",
"story",
"while",
"press",
"close",
"night",
"north",
"white",
"begin",
"paper",
"group",
"music",
"those",
"often",
"until",
"river",
"carry",
"began",
"horse",
"watch",
"color",
"plain",
"usual",
"young",
"ready",
"above",
"leave",
"black",
"short",
"class",
"order",
"south",
"piece",
"since",
"whole",
"space",
"heard",
"early",
"reach",
"table",
"vowel",
"money",
"serve",
"voice",
"power",
"field",
"pound",
"drive",
"stood",
"front",
"teach",
"final",
"green",
"quick",
"ocean",
"clear",
"wheel",
"force",
"plane",
"stead",
"laugh",
"check",
"shape",
"bring",
"paint",
"among",
"grand",
"heart",
"heavy",
"dance",
"speak",
"count",
"store",
"train",
"sleep",
"prove",
"catch",
"mount",
"board",
"glass",
"grass",
"visit",
"month",
"happy",
"eight",
"raise",
"solve",
"metal",
"seven",
"third",
"shall",
"floor",
"coast",
"value",
"fight",
"sense",
"quite",
"broke",
"scale",
"child",
"speed",
"organ",
"dress",
"cloud",
"quiet",
"stone",
"climb",
"stick",
"smile",
"trade",
"mouth",
"exact",
"least",
"shout",
"wrote",
"clean",
"break",
"blood",
"touch",
"brown",
"equal",
"woman",
"whose",
"radio",
"spoke",
"human",
"party",
"agree",
"chair",
"fruit",
"thick",
"guess",
"sharp",
"crowd",
"sight",
"hurry",
"chief",
"clock",
"enter",
"major",
"fresh",
"allow",
"print",
"block",
"chart",
"event",
"quart",
"truck",
"noise",
"level",
"throw",
"shine",
"wrong",
"broad",
"anger",
"claim",
"sugar",
"death",
"skill",
"women",
"thank",
"match",
"steel",
"guide",
"score",
"apple",
"pitch",
"dream",
"total",
"basic",
"smell",
"track",
"shore",
"sheet",
"favor",
"spend",
"chord",
"share",
"bread",
"offer",
"slave",
"chick",
"enemy",
"reply",
"drink",
"occur",
"range",
"steam",
"meant",
"teeth",
"shell"};
    // getting random word from String
    String word = words[(int)(Math.random()*words.length)];

   

    Scanner userGuess = new Scanner(System.in);
    int guesses = 6;

    String guess = "";

    Intro.intro();

    while(!guess.equals(word)&&guesses>0){

      System.out.print("\nType your guess here: \n");
      guess = userGuess.nextLine().toLowerCase().trim();
      
      // Error provision for input
      if(guess.length()!=5){
        System.out.println("\nGuess must be 5 characters.");
        continue;
      }
      
      // Iterating and comparing word char to guess char
      for (int i = 0; i<word.length(); i++){
        boolean found = false;
        for (int j = 0; j<word.length(); j++){
          if(guess.charAt(i)==word.charAt(i)){
            System.out.print("+");
            found = true;
            break;
          }
          else if(guess.charAt(i)==word.charAt(j)){
            System.out.print("-");
            found = true;
            break;
          } 
        }
        if(!found){
          System.out.print("*");
        }
      }
      guesses--;
      if (guess != word){
      System.out.println("\n\nYou have " + guesses + " guesses remaining.");}
    }
    userGuess.close();
    if (guess.equals(word)){
      System.out.println("\nYou guessed correctly! Good job!");
    }
    else System.out.println("\nYou failed! The word was: "+word+" better luck next time.");
    Api.getApi(word);
  }
}
