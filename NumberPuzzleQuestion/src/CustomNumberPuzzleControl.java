import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		int pos=0;
		
		//Getting the position of the clicked button
		for(Button value: buttons) {
			if(value == buttonClicked) {
				break;
			}
			pos++;
		}
		
		//Checking if the button is adjacent to the empty cell
		if (pos+1==emptyCellId && pos%4!=3 || pos-1==emptyCellId && pos%4!=0
				|| pos+4 == emptyCellId || pos-4 == emptyCellId) {
			swapButton(buttons[emptyCellId], buttonClicked);
			emptyCellId = pos;
		}
		
		return emptyCellId;

	}
	
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int i=0;
		while(i<arr.length) {
			int a = getRandomNumber();
			//Checking if number is in the range (1,15)
			if (a>0 && a<16) {
				int count = 0;
				for (int j=0; j<i+1; j++) {
					if(arr[j]==a) {
						count++; //Checking for repetition
						break;
					}
				}
				if (count == 0) {
					arr[i] = a; //Assigning value
					i++;
				}
			}
		}
	
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		
		int arr[]= getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
			if(arr[i]==i+1) {
				winner = false;
			}
		}

		return winner;
	}
}
