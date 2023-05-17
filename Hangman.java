import java.util.Scanner;
import java.util.Arrays;


public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {
    "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String chosenWord = chooseRandomWord();
        String[] chosenWordSplit = chosenWord.split("");
        int gallowsStage = 0;
        String letter = "";
        String[] guessedWord = new String[chosenWordSplit.length];
        System.out.println("Wellcome to the Gallows, Pirate!");
        System.out.println("*******************************");
        while (true){
            int matches = 0;
            System.out.println(printGallows(gallowsStage));
            System.out.println(gallowsStage);
            if (letter == ""){
                for (int i = 0;i < chosenWord.length(); i++){
                    guessedWord[i] = "_";
                }
                
            }if (letter != "") {
                for (int i = 0; i < chosenWordSplit.length; i++){
                    if (letter.equals(chosenWordSplit[i])){
                        guessedWord[i] = letter + " ";
                        matches ++;
                    } 
                }
                if (matches == 0){
                    gallowsStage +=1;
                }
                
            } if (gallowsStage == 6){
                System.out.println("\n\n" + printGallows(gallowsStage));
                System.out.println("Ahoy, fellow pirates!");
                break;
            }
            Arrays.stream(guessedWord).forEach(System.out::print);
            if (String.join(",",guessedWord).equals(String.join(" ,",chosenWordSplit))){
                System.out.println("Shiver Me Timbers! I survived");
                break;
            }
            System.out.print("\n\n\nTake a Guess > ");
            letter = scan.nextLine();
            System.out.println("\n*******************************");
        }
        


    }


    public static String chooseRandomWord(){
        int Min = 0;
        int Max = words.length-1;
        int randNum = Min + (int)(Math.random() * ((Max - Min) + 1));
        String returnWord = words[randNum];
        return returnWord;
    }


    public static String printGallows(int stage){
        switch(stage){
            case 0:
            return gallows[0];
            case 1:
            return gallows[1];
            case 2:
            return gallows[2];
            case 3:
            return gallows[3];
            case 4:
            return gallows[4];
            case 5:
            return gallows[5];
            case 6:
            return gallows[6];
            default:
            return "";

        }
    }

}





