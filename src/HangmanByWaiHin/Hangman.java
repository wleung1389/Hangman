package HangmanByWaiHin;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your gamemode. 1 for Solo, 2 for 2-Player");
        int gamemode = scanner.nextInt();
        if(gamemode == 1)
        {
            System.out.println("You have chosen Solo mode.");
            int pPoints = 0;
            int aiPoints = 0;
            System.out.println("To determine who goes first we will play rock-paper-scissors. Type in r(ock), p(aper) or s(cissors).");
            double rndNum = Math.floor(Math.random() * 3) + 1;
            String pChoice = scanner.next().substring(0,1).toLowerCase();
            String aiChoice = "";
            String first = "";
            if(rndNum == 1)
            {
                aiChoice = "r";
            }
            if(rndNum == 2)
            {
                aiChoice = "p";
            }
            if(rndNum == 3)
            {
                aiChoice = "s";
            }
            if(aiChoice.equals(pChoice))
            {
                System.out.println("It is a tie but to get right into the action the player will go first");
                first = "p";
            }
            else
            {
                if(aiChoice.equals("r") && pChoice.equals("s"))
                {
                    first = "a";
                }
                else
                {
                    if(aiChoice.equals("p") && pChoice.equals("r"))
                    {
                        first = "a";
                    }
                    else
                    {
                        if(aiChoice.equals("s") && pChoice.equals("p"))
                        {
                            first = "a";
                        }
                        else
                        {
                            first = "p";
                        }
                    }
                }
            }
            if(first.equals("p"))
            {
                System.out.println("Player goes first. Please type in the length of your word.");
                int wordlength = scanner.nextInt();
                String word = "";
                int tries = 10;
                for(int i = 0; i < wordlength; i++)
                {
                    word += "_ ";
                }
                System.out.println(word);
                if(tries > 0)
                {
                    String alphabet = "abcdefghijklmnopqrstuvwxyz";
                    rndNum = Math.floor(Math.random() * 25) + 0;
                    int rnd = (int)rndNum;
                    String guess = alphabet.substring(rnd, rnd + 1);
                    alphabet = alphabet.substring(0,rnd) + alphabet.substring(rnd);
                    System.out.println("Is " + guess + " a letter in your word? Type in y for yes and n for no.");
                    String response = scanner.next().substring(0,1).toLowerCase();
                    if(response.equals("y"))
                    {
                        System.out.println("How much times does your letter appear?");
                        int numTimes = scanner.nextInt();
                        for(int i = 0; i > numTimes; i++)
                        {
                            
                        }
                    }
                }
            }
        }
        else
        {

        }
    }
}
