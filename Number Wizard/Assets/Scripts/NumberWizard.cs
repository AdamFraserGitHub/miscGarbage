using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NumberWizard : MonoBehaviour {
	int maxGuess;
	int minGuess;
	int guess;

	void Start () {
		startGame();
	}

	// Update is called once per frame
	void Update () {
		//up arrow
		if(Input.GetKeyDown(KeyCode.UpArrow)){
			minGuess = guess;
			nextGuess();
		}
		//down arrow
		else if(Input.GetKeyDown(KeyCode.DownArrow)){
			maxGuess = guess;
			nextGuess();
		}
		//return
		else if(Input.GetKeyDown(KeyCode.Return)){
			print("YAY I WON XD");
			startGame();//restarts game once PC has won
		}
	}

	void startGame() {
		guess = 1000000 / 2;
		minGuess = 0;
		maxGuess = 1000000;

		nextGuess();

		print("Welcome to Number Wizard!");
		print("Pick a number in your head but don't tell me what it is.");

		print("The highest number you can pick is " + maxGuess);
		print("The lowest number you can pick is " + minGuess);

		print("is the number higher or lower or higher than " + guess + "?");
		print("up arrow for higher, down arrow for lower, return for correct guess!");

		maxGuess = maxGuess + 1; //avoids max guess caping at max - 1 due to rounding
	}

	void nextGuess() {
		guess = (maxGuess + minGuess) / 2;

		print("is the number higher or lower or higher than " + guess + "?");
		print("up arrow for higher, down arrow for lower, return for correct guess!");
	}
}
