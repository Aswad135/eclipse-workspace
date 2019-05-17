package Bingo;

/**
 ******************************************************************************
 *                    HOMEWORK 2, 15-111
 ******************************************************************************
 *                            BINGO
 ******************************************************************************
 *
 * The main program for the Bingo game
 *
 *
 *****************************************************************************

 /*****************************************************************************

               There is no need to modify this file.

 *****************************************************************************/


import java.io.*;

public class MainDriver
{
   public static void main (String[] args) throws IOException
   {
		Bingo game = new Bingo();
		game.write("input1.txt");
		game.read("input1.txt");
		int x = game.playGame();
		System.out.println("the winning number is " + x);
	}
}
