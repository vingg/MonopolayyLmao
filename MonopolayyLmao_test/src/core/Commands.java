package core;
import java.util.Random;

import squares.Square;
import squares.SquareInfo;

public class Commands {
	private String outputText;
	public Board board;
	public GameState gameState;
	private Player turnPlayer;
	private int currentTurn;
	private int playerCount;

	public Commands(Board inBoard, GameState inGameState){
		board = inBoard;
		gameState = inGameState;
	}
	
	public String GameCommands(String[] inputText) {
		outputText = "";
		if(!gameState.getGameStart()){
			try{
				playerCount = Integer.parseInt(inputText[0]);
				if(playerCount <=6 && playerCount >= 2){
					gameState = new GameState(playerCount);
					gameState.setDPC(playerCount);
					gameState.gameStart();
					for(int i=0;i<playerCount;i++){
						 board.layeredPane.add(board.players[i].ship.label, new Integer(i+2));
					 }
					 
					 for(int i=0;i<playerCount;i++){
						 board.players[i].ship.setLocation(0);
					}
					 outputText = "Starting a " + playerCount + " player game!\n"
							+ "Write all player names on one line and press enter\n";	
				}
				else outputText = "Invalid number of players\nEnter a number of players\n";
			}catch(NumberFormatException e){
				outputText = "Invalid input\nEnter a number of players\n";
			}
			return outputText;
			
		}
		if (!gameState.playerNamesSet()){
			outputText = "";
			
			try{
				if (inputText.length == gameState.getPlayerCount()){
					for (int i= 0;i<gameState.getPlayerCount();i++){
						board.players[i].setPlayerName(inputText[i]);
						outputText+= "Player "+(i+1)+" is "+board.players[i].getPlayerName()+"\n";
					}
					gameState.setTurn(0);
					int currentTurn = 0;
					Player turnPlayer = board.players[currentTurn];
					//roll dice to find out which player is going first
					int[] rollArray = new int[gameState.getPlayerCount()];
					outputText += "Rolling to see who goes first:\n";
					//Dice[] rollArray = new Dice[gameState.getPlayerCount()];
					for (int i= 0;i<gameState.getPlayerCount();i++){
						rollArray[i]=rollDice();
						outputText += board.players[i].getPlayerName() + " rolled " + rollArray[i] + "\n";
					}
					int max = rollArray[0];
					int maxIndex=0;
					for (int i= 1;i<gameState.getPlayerCount();i++){
						if (rollArray[i]>max){
							max=rollArray[i];
							maxIndex=i;
						}
					}

					turnPlayer = board.players[maxIndex];
					//gameState.setTurn(maxIndex-1);
					//gameState.nextTurn();
					gameState.setTurn(maxIndex);
					outputText = outputText + turnPlayer.getPlayerName() + " is going first\nEnter ''help'' to see list of commands\n";
					gameState.playerNamesDone();
					
					}else{
						outputText = "Invalid input\nEnter " + gameState.getPlayerCount() + " player names\n";
					}
			}catch (NumberFormatException e){
				outputText = "Invalid input\nEnter " + gameState.getPlayerCount() + " of player names\n";
			}
			return outputText;
		}
		
		else{
			currentTurn = gameState.getTurn();
			turnPlayer = board.players[currentTurn];
			
			if(!board.players[currentTurn].getQuit()){
	//HELP COMMAND
				if (inputText[0].equalsIgnoreCase("help"))
					{
						help();
					}
	//MOVE COMMAND
				else if (inputText[0].equalsIgnoreCase("move") || inputText[0].equalsIgnoreCase("roll")){
						moveTurnPlayer();
					}
	//BALANCE COMMAND
				else if (inputText[0].equalsIgnoreCase("balance")){
						seeBalance();
					}
	//PROPERTY COMMAND
				else if (inputText[0].equalsIgnoreCase("property")){
						outputText = turnPlayer.balance.showAllProperty();
					}
	//BUY COMMAND
				else if (inputText[0].equalsIgnoreCase("buy"))
					{
						buyProperty();
					}
	//BANKRUPT COMMAND
				else if (inputText[0].equalsIgnoreCase("bankrupt")){
						outputText+=board.players[gameState.getTurn()].getPlayerName()+" has declared bankruptcy\n";
	                    removePlayer();
	                }
	//MORTGAGE COMMAND
				else if (inputText[0].equalsIgnoreCase("mortgage") && inputText.length == 2){
						mortgageProperty(inputText[1]);
					}
	//REDEEM COMMAND
				else if (inputText[0].contains("redeem") && inputText.length == 2){
						redeemProperty(inputText[1]);
					}
	//BUILD COMMAND
				else if (inputText[0].equalsIgnoreCase("build") && inputText.length == 2){
						buildProperty(inputText[1]);
					}
	//DEMOLISH COMMAND
				else if (inputText[0].equalsIgnoreCase("demolish") && inputText.length == 2){
						demolishProperty(inputText[1]);
					}
	//GOOJ CARD COMMAND
				else if (inputText[0].equalsIgnoreCase("gooj")){
					if (!turnPlayer.getGoojCard()){
						outputText+="You do not own a Get Out Of Jail Free card\n";
					}
					int tempCurrentTurn=currentTurn;

					int buyerNum=0;
					outputText+=currentTurn;
					for(int i=0;i<6;i++){
					if (board.players[i].getPlayerName().equalsIgnoreCase(inputText[1])&&i!=tempCurrentTurn){
							buyerNum=board.players[currentTurn].getPlayerNum();
							outputText+=buyerNum;
						}
					}
					
					gameState.setTurn(buyerNum);
					turnPlayer.setGoojCard(true);
					turnPlayer.balance.subtractBalance(50);
					outputText+="The Get Out Of Jail Free Card has been sold to "+board.players[buyerNum].getPlayerName();
					gameState.setTurn(tempCurrentTurn);
					turnPlayer.setGoojCard(false);
					turnPlayer.balance.addBalance(50);
					outputText+=" by " + board.players[tempCurrentTurn].getPlayerName()+ " for £50\n";
					
				}

	//DONE COMMAND
				else if (inputText[0].equalsIgnoreCase("done"))
					{
						//player cannot end turn if in debt
						if(turnPlayer.balance.getBalance()<0){
							outputText+="You cannot continue with a negative balance\n"
									+ "Please choose to mortgage a property or declare bankruptcy\n";
						}else{
						endTurn();
						}
					}
	//QUIT Command
				else if (inputText[0].equalsIgnoreCase("quit")){
						removePlayer();
					}
	//EXIT Command
				else if (inputText[0].equalsIgnoreCase("exit"))
					{
						System.exit(0);
						return null;
					}
	//DEBUG COMMANDS
				//find propertyNum of user input site
				else if (inputText[0].equalsIgnoreCase("findprop")){
						String propertyName = "";
						for(int i = 1;i<inputText.length;i++){
							propertyName += inputText[i];
							if(i<inputText.length-1) propertyName += " ";
						}
						outputText += propertyName + "\n";
						outputText += "property: " + SquareInfo.findShortPropertyNum(propertyName) + "\n";
					}
				else if (inputText[0].equalsIgnoreCase("goojtest")){
					turnPlayer.setGoojCard(true);
					outputText+="You have a GOOJF card\n";
				}
				else if (inputText[0].equalsIgnoreCase("goojcheck")){
					if(turnPlayer.getGoojCard())
					outputText+="You have a GOOJF card\n";
				}
				//send player to jail
				else if (inputText[0].equalsIgnoreCase("jail")){
						turnPlayer.moveToJail();
						gameState.setHasRolled(true);
						outputText += "You've been sent to jail.\n";
					}
				else if (inputText[0].equalsIgnoreCase("add")){
					outputText+=inputText[1]+" has been added to balance\n";
					turnPlayer.balance.addBalance(Integer.parseInt(inputText[1])) ;
				}
				else if (inputText[0].equalsIgnoreCase("subtract")){
					outputText+=inputText[1]+" has been removed from balance\n";
					turnPlayer.balance.subtractBalance(Integer.parseInt(inputText[1])) ;
				}
				//get number of house
				else if (inputText[0].equalsIgnoreCase("houses")){
					outputText+="You have "+turnPlayer.getHousesOwned()+" houses"
							+ " and "+turnPlayer.getHotelsOwned()+" hotels";
				}
				//move player a set amount ie: "step 3" moves player 3 spaces
				else if (inputText[0].equalsIgnoreCase("step")){
					int rollArray[] = new int[2];
					rollArray[0] = Integer.parseInt(inputText[1]);
					rollArray[1] = Integer.parseInt(inputText[2]);
					moveTurnPlayer(rollArray);
				}

		//COMMAND NOT AVAILABLE
				else{
					outputText += "This command is not available\n";

				}

				}else{
					outputText += board.players[gameState.getTurn()].getPlayerName()+" has quit the game\n";
					gameState.nextTurn();
					outputText += "It is now your turn, "+board.players[gameState.getTurn()].getPlayerName()+"\n";
				}

			}
		return outputText;

		}

	private void help(){
		outputText = "\nThe following commands are available:\n"
				+ "help - see this menu\n"
				+ "\n"
				+ "TURN OPTIONS\n"
				+ "move - roll the dice\n"
				+ "done - end this player's turn\n"
                + "bankrupt - declare bankruptcy\n"
				+ "\n"
				+ "HOUSING\n"
				+ "buy - buy a property\n"
				+ "build [property] - build a house on property"
				+ "demolish [property] - remove a house property"
				+ "rent - pay rent, if due\n"
				+ "mortgage [property] - mortgage property\n"
				+ "redeem [property] - redeem the property if mortgaged\n"
				+ "balance - check your funds\n"
				+ "\n"
				+ "OTHER"
				+ "gooj [player] - sell Get Out Of Jail Free card to player"
				+ "exit - close the game window"
				+ "\n";
	}

	public int rollDice(){
		Random rand = new Random();
		int result = rand.nextInt(6) + 1;
		return result;
	}
	private void moveTurnPlayer(int rollArray[]){

		if(gameState.getHasRolled()){
			outputText = "You have used your roll for this turn\n";
		}
		else{
			
		
		int rollSum = rollArray[0] + rollArray[1];
		outputText = "You have rolled: ";
		
		if(turnPlayer.inJail()){
			rollInJail(rollArray);
		}
		else{
			outputText += rollArray[0] + " + " + rollArray[1] + " = " + rollSum + "\n";
			if(rollArray[0]==rollArray[1]){
				gameState.rolledDoubles();
				outputText += "You rolled doubles\n";
			}
			if(gameState.getDoublesThisTurn()>=3){
				turnPlayer.moveToJail();
				outputText += "You have been sent to jail for rolling 3 sets of doubles in a row!\n";
				gameState.setHasRolled(true);
			}
			else{
				gameState.setHasRolled(rollArray[0]!=rollArray[1]);
				processRoll(rollArray);
				}
		}
		}
	}
	private void moveTurnPlayer(){
			int rollArray[] = new int[2], rollSum = 0;
			for (int i=0;i<2;i++){
				int move = rollDice();
				rollArray[i]=move;
				rollSum += move;
			}
			moveTurnPlayer(rollArray);
	}

	private void rollInJail(int[] rollArray){
		//no matter what, you only get 1 roll if you start the turn in jail.
		gameState.setHasRolled(true);

		int rollSum = rollArray[0] + rollArray[1];
		outputText = "You have rolled: ";
		outputText += rollArray[0] + " + " + rollArray[1];
		if(rollArray[0]!=rollArray[1]){
			if(turnPlayer.getTurnsInJail()<2){
				turnPlayer.spentTurnInJail();
				outputText += "\nYou need doubles to escape jail! You have " + (3-turnPlayer.getTurnsInJail()) +  " turns left\n";
				return;
			}
			else{
				outputText += "\nYou have failed to roll doubles 3 times in a row. Must pay a ï¿½50 fine.\n\n";
				turnPlayer.balance.addBalance(-50);
			}
		}
		else{
			gameState.rolledDoubles();
			outputText += "=" + rollSum + "\nYou rolled doubles! You escaped!\n";
		}
			turnPlayer.freeFromJail();
			processRoll(rollArray);
	}
								
	private void processRoll(int[] rollArray){
		int rollSum = rollArray[0] + rollArray[1];
		Square prevSquare = board.squares[turnPlayer.getPosition()];
		turnPlayer.move(rollSum);
		Square currSquare = board.squares[turnPlayer.getPosition()];

		outputText += "You landed on: " + currSquare.getName();
		if(!currSquare.getName().equalsIgnoreCase(currSquare.getShortName())) outputText += " [" + currSquare.getShortName() + "]";
		if(currSquare.getSquareType() == 1 || currSquare.getSquareType() == 2 || currSquare.getSquareType() == 3 || currSquare.getSquareType() == 9){
			outputText += " (" + SquareInfo.SQUARE_TYPE_NAMES[currSquare.getSquareType()] + ")";
		}
		outputText += "\n";
		if(currSquare.getSquareType()==SquareInfo.TYPE_GO_TO_JAIL){
			turnPlayer.moveToJail();
			gameState.setHasRolled(true);
			outputText += "You've been sent to jail.\n";
		}
		if(currSquare.getSquareNum()-prevSquare.getSquareNum()<0){
			turnPlayer.balance.addBalance(200);
			outputText+="You have passed GO\n200 has been added to you bank account";
		}
		if(currSquare.getSquareType()==9){
			if (SquareInfo.TAX_NAMES[0].equals(currSquare.getName())){
				turnPlayer.balance.subtractBalance(SquareInfo.TAX_AMOUNTS[0]);
				outputText+="You have have landed on "+currSquare.getName()
					+"\n200 has been subtract from your bank account";
			}else if (SquareInfo.TAX_NAMES[1].equals(currSquare.getName())){
				turnPlayer.balance.subtractBalance(SquareInfo.TAX_AMOUNTS[1]);
				outputText+="You have have landed on "+currSquare.getName()
					+"\n100 has been subtract from your bank account";
			}
		}
			//TODO: insert functions for landing on certain spaces, chance/community etc.
			gameState.setRentDue(currSquare.isOwned() && currSquare.owner() != currentTurn);
	}

	private void seeBalance(){
		outputText = "You have "
				+ turnPlayer.balance.getBalance()
				+" in the bank\n";
	}

	private void buyProperty(){
		//first find square of current position
		Square currSquare = board.squares[turnPlayer.getPosition()];
		if(!currSquare.isOwnable()){
			outputText = "Sorry, you cannot purchase this.\n"
					+"It is still your turn," + turnPlayer.getPlayerName() + "\n";
		}
		//and if it's not owned...
		else if(currSquare.isOwned()){
			outputText += "Sorry, this is already owned\n"
						+ "It is still your turn, " + turnPlayer.getPlayerName() + "\n";
		}
		else{
			//then buy it
		turnPlayer.buyProperty(currSquare);
		outputText += "You have bought "+ currSquare.getName()+"\nYou now have "
						+turnPlayer.balance.getBalance()+" in the bank\n";
		}
		
	}

	private void buildProperty(String propName){
		String propertyName = propName;
		int propertyNum = SquareInfo.findShortPropertyNum(propertyName);
		if(propertyNum==-1){
			outputText += "Error: this site does not exist\n";
		}
		else{
			Square square = board.squares[propertyNum];
			if(square.owner()!=turnPlayer.getPlayerNum()) outputText += "Error: you do not own this property\n";
			else if(square.getSquareType()!=1) outputText += "Error: you cannot build on a square that is not a Site\n";
			else if(!turnPlayer.balance.properties.checkForColorSet(square)) outputText += "Error: you must own a complete set of this square's color in order to build on it.\n";
			else if(square.isMortgaged()) outputText += "Error: cannot build on mortgaged properties.\n";

			else{
				Square squaresInGroup[] = turnPlayer.balance.properties.getColorGroup(square.getColor());
				boolean tooManyBuildings = false;
				for(int i=0;i<squaresInGroup.length;i++){
					if(!square.equals(squaresInGroup[i])){
						if(square.getBuildings()>squaresInGroup[i].getBuildings()){
							tooManyBuildings = true;
							System.out.println(square.toString() + " has more buildings than "
												+ squaresInGroup[i] + "\n"
												+ square.getBuildings() + " > "
												+ squaresInGroup[i].getBuildings());
						}
					}
				}
				if(tooManyBuildings) outputText += "Error: you have too many buildings on this property already. Build more on others in this group.\n";

				else if(!square.build()) outputText += "Error: you already have the maximum number of buildings on this property\n";
				else{
					turnPlayer.balance.subtractBalance(square.buildingCost());
					outputText = "Success! There ";
					int check = square.getBuildings();
					if(check==5){ 
						outputText += " is now a hotel on this property\n";
						turnPlayer.setHotelsOwned(1);
					}else if(check == 1){
						outputText += " is now a house on this property\n";
						turnPlayer.setHousesOwned(1);
					}
					else {
						outputText += " are now " + check + " houses on this property\n";
						turnPlayer.setHousesOwned(1);
					}
				}
			}
		}
	}

	private void demolishProperty(String propName){
		String propertyName = propName;
		int propertyNum = SquareInfo.findShortPropertyNum(propertyName);
		if(propertyNum==-1){
			outputText += "Error: this site does not exist\n";
		}
		else{
			Square square = board.squares[propertyNum];
			if(square.owner()!=turnPlayer.getPlayerNum()) outputText += "Error: you do not own this property\n";
			else if(square.getSquareType()!=1) outputText += "Error: squares which are not sites cannot have buildings\n";

			else if(!square.destroy()) outputText += "Error: you already have the maximum number of buildings on this property\n";
			else{
				turnPlayer.balance.addBalance(square.buildingCost()/2);
				outputText = "Success! There ";
				int check = square.getBuildings();
				if(check==0){
					outputText += " are now no buildings on this property.\n";
					turnPlayer.setHousesOwned(-1);
				}
				else if(check==1){
					outputText += " is now 1 house on this property.\n";
					turnPlayer.setHousesOwned(-1);
				}
				else if(check==4) turnPlayer.setHotelsOwned(-1);
				else outputText += " are now " + check + " houses on this property\n";


			}
		}
	}

	private void redeemProperty(String propName){
		String propertyName = propName;
		int propertyNum = SquareInfo.findShortPropertyNum(propertyName);
		if(propertyNum==-1){
			outputText += "Error: this site does not exist\n";
		}
		else{
			Square square = board.squares[propertyNum];
			if (square.isMortgaged()){
			turnPlayer.payRedeem(square);
			outputText="You have redeemed "+propertyName+" for "+square.mortgage()+"\n"
					+ "You now have " +turnPlayer.balance.getBalance()+" in the bank\n";
			}else{
				outputText="This property has not been mortgaged";
			}
			//check if property is 'mortgaged'
			//if so: subtract mortgage amount + 10% interest, remove 'mortgaged' flag
			//else cannot redeem property
		}
	}

	private void mortgageProperty(String propName){
		String propertyName = propName;
		int propertyNum = SquareInfo.findShortPropertyNum(propertyName);
		if(propertyNum==-1){
			outputText += "Error: this site does not exist\n";
		}
		else{
			Square square = board.squares[propertyNum];
			if (!square.isMortgaged()){
				if (square.owner()==turnPlayer.getPlayerNum()){
					//mortgage command
					turnPlayer.recieveMortgage(square);
					outputText="You have mortgaged "+propertyName+" for "+square.mortgage()+"\n"
							+ "You now have " +turnPlayer.balance.getBalance()+" in the bank\n";
					//set property to 'mortgaged'
				}else{
					outputText="You cannot mortgage this property\n";
				}
			}else{
				outputText="This property is already mortgaged";
			}

		}
	}

	private void endTurn(){
		if(gameState.getHasRolled()){
			gameState.nextTurn();
//			if(board.players[currentTurn].getQuit()){
//				gameState.nextTurn();
//			}else{
				outputText += "Ending your turn:\nIt is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
//			}
		}
		else{
			outputText = "Error: you still have to roll.\n"
				+ "It is still your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
		}
	}

	private void removePlayer(){
		if (gameState.getDPC()>2){
			for(int i=0;i<=39;i++){
	            Square forSquare = board.squares[i];
	            if (turnPlayer.getPlayerNum() == forSquare.owner()){
	                forSquare.destroyAll();
	                forSquare.setUnowned();
	            }

	        }
			board.layeredPane.remove(board.players[currentTurn].ship.label);
			board.players[currentTurn].setQuit();
			System.out.println(board.players[currentTurn].getQuit());
	        outputText += board.players[gameState.getTurn()].getPlayerName()+" has left the game\n";
			gameState.nextTurn();
			outputText += "It is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
			gameState.setDPC(gameState.getDPC()-1);
			System.out.println(gameState.getDPC());
			System.out.println(board.players[currentTurn].getQuit());
			
		}else{
			turnPlayer.setQuit();
			while (board.players[currentTurn].getQuit()==true&&board.players[gameState.getTurn()].getPlayerName()!=null){
				currentTurn++;
				}
			
			gameState.setTurn(currentTurn);
			outputText+= "Game Over!\nThe winner is "+board.players[gameState.getTurn()].getPlayerName() +"!\n";
			gameState.gameEnd();
		}
	}
}

