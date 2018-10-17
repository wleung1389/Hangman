package HangmanByWaiHin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        while(gameRunning)
        {
                System.out.println("Choose your game mode. 1 for Solo, 2 for 2-Player");
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
                    System.out.println("The AI chose " + aiChoice + " .");
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
                        while(gameRunning == true)
                        {
                            if(word.contains("_") && tries > 0)
                            {
                                String alphabet = "abcdefghijklmnopqrstuvwxyz";
                                rndNum = Math.floor(Math.random() * 25) + 0;
                                int rnd = (int)rndNum;
                                String guess = alphabet.substring(rnd, rnd + 1);
                                alphabet = alphabet.substring(0,rnd) + alphabet.substring(rnd);
                                System.out.println("Is " + guess + " a letter in your word? Type in y for yes and n for no.");
                                String response = scanner.next().substring(0,1).toLowerCase();
                                if(word.contains("_"))
                                {
                                    if(response.equals("y"))
                                    {
                                        System.out.println("Where do the letters appear? Type in a number greater than 0(i.e. A _ A _ would be 1,3).");
                                        String positions = scanner.next();
                                        while(positions.contains(","))
                                        {
                                            int num1 = Integer.parseInt(positions.substring(0, positions.indexOf(",")));
                                            positions = positions.substring(positions.indexOf(",")+1);
                                            word = word.substring(0, num1-1) + word.substring(num1-1).replaceFirst("_", guess);
                                        }
                                        word = word.substring(0, Integer.parseInt(positions) - 1) + word.substring(Integer.parseInt(positions)-1).replaceFirst("_", guess);
                                        System.out.println(word);
                                    }
                                    else
                                    {
                                        tries--;
                                    }
                                }
                            }
                            else if (tries <= 0)
                            {
                                System.out.println("Congratulations! You won. The AI used all it's attempts but couldn't find your word.");
                                gameRunning = false;
                            }
                            else if (!word.contains("_"))
                            {
                                String noSpacesWord = "";
                                for(int i = 0; i < word.length(); i+=2)
                                {
                                    noSpacesWord += word.substring(i,i+1);
                                }
                                System.out.println("The AI has guessed your word. Your word was " + noSpacesWord + " . Good Game.");
                                gameRunning = false;
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("WIP");
                }
            }
        }
    }
