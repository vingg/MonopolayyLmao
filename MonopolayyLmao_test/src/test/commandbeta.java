//package core;
//import java.util.Random;
//
//import squares.Square;
//import squares.SquareInfo;
//
//public class Commands {
//	private String outputText;
//	public Board board;
//	public GameState gameState;
//	
//	public Commands(Board inBoard, GameState inGameState){
//		board = inBoard;
//		gameState = inGameState;
//	}
//	
//	public String GameCommands(String[] inputText) {
//		outputText = "";
//		if(!gameState.getGameStart()){
//			try{
//				int playerCount = Integer.parseInt(inputText[0]);
//				if(playerCount <=6 && playerCount >= 2){
//					gameState = new GameState(playerCount);
//					gameState.gameStart();
//					for(int i=0;i<playerCount;i++){
//						 board.layeredPane.add(board.players[i].ship.label, new Integer(i+2));
//					 }
//					 
//					 for(int i=0;i<playerCount;i++){
//						 board.players[i].ship.setLocation(0);
//					}
//					 outputText = "Starting a " + playerCount + " player game!\n"
//							+ "Write all player names on one line and press enter\n";	
//				}
//				else outputText = "Invalid number of players\nEnter a number of players\n";
//			}catch(NumberFormatException e){
//				outputText = "Invalid input\nEnter a number of players\n";
//			}
//			return outputText;
//			
//		}
//		if (!gameState.playerNamesSet()){
//			outputText = "";
//			
//			try{
//				if (inputText.length == gameState.getPlayerCount()){
//					for (int i= 0;i<gameState.getPlayerCount();i++){
//						board.players[i].setPlayerName(inputText[i]);
//						outputText+= "Player "+(i+1)+" is "+board.players[i].getPlayerName()+"\n";
//					}
//					gameState.setTurn(0);
//					int currentTurn = 0;
//					Player turnPlayer = board.players[currentTurn];
//					//roll dice to find out which player is going first
//					int[] rollArray = new int[gameState.getPlayerCount()];
//					outputText += "Rolling to see who goes first:\n";
//					//Dice[] rollArray = new Dice[gameState.getPlayerCount()];
//					for (int i= 0;i<gameState.getPlayerCount();i++){
//						rollArray[i]=rollDice();
//						outputText += board.players[i].getPlayerName() + " rolled " + rollArray[i] + "\n";
//					}
//					int max = rollArray[0];
//					int maxIndex=0;
//					for (int i= 1;i<gameState.getPlayerCount();i++){
//						if (rollArray[i]>max){
//							max=rollArray[i];
//							maxIndex=i;
//						}
//					}
//
//					turnPlayer = board.players[maxIndex];
//					//gameState.setTurn(maxIndex-1);
//					//gameState.nextTurn();
//					gameState.setTurn(maxIndex);
//					outputText = outputText + turnPlayer.getPlayerName() + " is going first\nEnter ''help'' to see list of commands\n";
//					gameState.playerNamesDone();
//					
//					}else{
//						outputText = "Invalid input\nEnter " + gameState.getPlayerCount() + " player names\n";
//					}
//			}catch (NumberFormatException e){
//				outputText = "Invalid input\nEnter " + gameState.getPlayerCount() + " of player names\n";
//			}
//			return outputText;
//		}
//		
//		else{
//			int currentTurn = gameState.getTurn();
//			Player turnPlayer = board.players[currentTurn];
//			
//			if((turnPlayer.hasQuit()!=true)||(!turnPlayer.isBankrupt()!=true)){ 
//	//HELP COMMAND
//				if (inputText[0].equalsIgnoreCase("help"))
//					{
//						outputText = "\nThe following commands are available:\n"
//								+ "help - see this menu\n"
//								+ "move - roll the dice\n"
//								+ "balance - check your funds\n"
//								+ "rent - pay rent, if due\n"
//								+ "mortgage [property] - mortgage property"
//								+ "redeem [property] - redeem the property if mortgaged"
//								+ "build [property] - build houses on property"
//								+ "demolish [property] - remove houses from property"
//								+ "bankrupt - this player declares bankruptcy"
//								+ "done - end this player's turn\n"
//								+ "quit - this player quits the game\n\n"
//								+ "exit - exit the game";
//						return outputText;
//					}
//				//useful debug command: move exactly 1 space as if you rolled that much
//			
//	//MOVE COMMAND
//					if (inputText[0].equalsIgnoreCase("move") || inputText[0].equalsIgnoreCase("roll"))
//					{
//						if(gameState.getHasRolled()){
//							outputText = "You have used your roll for this turn\n";
//							return outputText;
//						}
//						else{
//							int rollArray[] = new int[2], rollSum = 0;
//							outputText = "You have rolled: ";
//							for (int i=0;i<2;i++){
//								int move = rollDice();
//								rollArray[i]=move;
//								rollSum += move;
//							}
//							outputText += rollArray[0] + " + " + rollArray[1] + " = " + rollSum + "\n";
//							
//							gameState.setHasRolled(rollArray[0]!=rollArray[1]);
//							if (!gameState.getHasRolled()) outputText += "You rolled doubles\n";
//							turnPlayer.move(rollSum);
//							Square currSquare = board.squares[turnPlayer.getPosition()];
//							
//							outputText += "You landed on: " + currSquare.getName(); 
//							if(currSquare.getSquareType() == 1 || currSquare.getSquareType() == 2 || currSquare.getSquareType() == 3 || currSquare.getSquareType() == 9){
//								outputText += " (" + SquareInfo.SQUARE_TYPE_NAMES[currSquare.getSquareType()] + ")";
//							}
//							outputText += "\n";
//							
//							gameState.setRentDue(currSquare.isOwned() && currSquare.owner() != currentTurn);
//							return outputText;
//						}
//						
//					}
//	//BALANCE COMMAND
//					if (inputText[0].equalsIgnoreCase("balance")){
//						outputText = "You have "
//										+ turnPlayer.balance.getBalance()
//										+" in the bank\n";
//						return outputText;
//					}
//	//PROPERTY COMMAND
//					if (inputText[0].equalsIgnoreCase("property")){
//						outputText = turnPlayer.balance.showAllProperty();
//						return outputText;
//					}
//	//BUY COMMAND
//					if (inputText[0].equalsIgnoreCase("buy"))
//					{
//						//first find square of current position
//						Square currSquare = board.squares[turnPlayer.getPosition()];
//						if(!currSquare.isOwnable()){
//							outputText = "Sorry, you cannot purchase this\n+"
//									+"It is still your turn," + turnPlayer.getPlayerName() + "\n";
//						}
//						//and if it's not owned...
//						if(currSquare.isOwned()){
//							outputText = "Sorry, this is already owned\n" 
//										+ "It is still your turn, " + turnPlayer.getPlayerName() + "\n";
//							return outputText;
//						}
//						//then buy it
//						turnPlayer.buyProperty(currSquare);
//						outputText = "You have bought this property\nYou now have "
//										+turnPlayer.balance.getBalance()+" in the bank\n";
//						return outputText;
//					}
//	//RENT COMMAND
//					if (inputText[0].equalsIgnoreCase("rent")){
//						Square currSquare = board.squares[turnPlayer.getPosition()];
//						if (!currSquare.isMortgaged()){
//							if(!currSquare.isOwnable()){
//								outputText += "This square cannot be owned, therefore no rent is due.\n";
//							}
//							if(gameState.getRentDue()){
//								outputText += "You paid " + turnPlayer.payRent(currSquare) 
//												+ " in rent to Player " + (currSquare.owner() +1) + "\n";
//							}
//							else if(!currSquare.isOwned()){
//								outputText += "This square is not currently owned, therefore no rent is due.\n";
//							}
//							else{
//								outputText += "You currently own this square, therefore no rent is due.\n";
//							}
//						}else{
//							outputText="Property is mortgaged\n"
//									+ "Redeem property via the redeem <property> command before renting\n";
//						}
//						return outputText;
//					}
//	//MORTGAGE COMMAND
//					if (inputText[0].equalsIgnoreCase("mortgage")){
//						String propertyName = "";
//						
//						for(int i = 1;i<inputText.length;i++){
//							propertyName += inputText[i];
//							if(i<inputText.length-1) propertyName += " ";
//						}
//						int propertyNum = SquareInfo.findPropertyNum(propertyName);
//						if(propertyNum==-1){
//							outputText += "Error: this site does not exist\n";
//						}
//						else{
//							Square square = board.squares[propertyNum];
//							if (!square.isMortgaged()){
//								if (square.owner()==turnPlayer.getPlayerNum()){
//									//mortgage command
//									turnPlayer.recieveMortgage(square);
//									outputText="You have mortgaged "+propertyName+" for "+square.mortgage()+"\n"
//											+ "You now have " +turnPlayer.balance.getBalance()+" in the bank\n";
//									//set property to 'mortgaged'
//								}else{
//									outputText="You cannot mortgage this property\n";
//								}
//							}else{
//								outputText="This property is already mortgaged";
//							}
//	
//						}
//						return outputText;
//					}
//	//REDEEM COMMAND
//					if (inputText[0].contains("redeem")){
//						Square currSquare = board.squares[turnPlayer.getPosition()];
//						String propertyName = inputText[0].replace("mortgage ", "");
//						if (currSquare.isMortgaged()){
//							turnPlayer.payRedeem(currSquare);
//							outputText="You have redeemed "+propertyName+" for "+currSquare.mortgage()+"\n"
//									+ "You now have " +turnPlayer.balance.getBalance()+" in the bank\n";
//						}else{
//							outputText="This property has not been mortgaged";
//						}
//						//check if property is 'mortgaged'
//						//if so: subtract mortgage amount + 10% interest, remove 'mortgaged' flag
//						//else cannot redeem property
//						return outputText;
//					}
//	//BUILD COMMAND
//					if (inputText[0].equalsIgnoreCase("build")){
//						String propertyName = "";
//						
//						for(int i = 1;i<inputText.length;i++){
//							propertyName += inputText[i];
//							if(i<inputText.length-1) propertyName += " ";
//						}
//						int propertyNum = SquareInfo.findPropertyNum(propertyName);
//						if(propertyNum==-1){
//							outputText += "Error: this site does not exist\n";
//						}
//						else{
//							Square square = board.squares[propertyNum];
//							if(square.owner()!=turnPlayer.getPlayerNum()) outputText += "Error: you do not own this property\n";
//							else if(square.getSquareType()!=1) outputText += "Error: you cannot build on a square that is not a Site\n";
//							else if(!turnPlayer.balance.properties.checkForColorSet(square)) outputText += "Error: you must own a complete set of this square's color in order to build on it.\n";
//							else if(square.isMortgaged()) outputText += "Error: cannot build on mortgaged properties.\n";
//						
//							else if(!square.build()) return "Error: you already have the maximum number of buildings on this property\n";
//							else{
//								outputText = "Success! There ";
//								int check = square.getBuildings();
//								if(check==5) outputText += " is now a hotel on this property\n";
//								else if(check == 1) outputText += " is now a house on this property\n";
//								else outputText += " are now " + check + " houses on this property\n";
//							}
//						}
//						return outputText;
//					}
//	//DEMOLISH COMMAND
//					if (inputText[0].equalsIgnoreCase("demolish")){
//						String propertyName = "";
//						
//						for(int i = 1;i<inputText.length;i++){
//							propertyName += inputText[i];
//							if(i<inputText.length-1) propertyName += " ";
//						}
//						int propertyNum = SquareInfo.findPropertyNum(propertyName);
//						if(propertyNum==-1){
//							outputText += "Error: this site does not exist\n";
//						}
//						else{
//							Square square = board.squares[propertyNum];
//							if(square.owner()!=turnPlayer.getPlayerNum()) return "Error: you do not own this property\n";
//							else if(square.getSquareType()!=1) return "Error: squares which are not sites cannot have buildings\n";
//							
//							else if(!square.destroy()) return "Error: you already have the maximum number of buildings on this property\n";
//							else{
//								String outString = "Success! There ";
//								int check = square.getBuildings();
//								if(check==0) outString += " are now no buildings on this property.\n";
//								else if(check==1) outString += " is now 1 house on this property.\n";
//								else outString += " are now " + check + " houses on this property\n";
//								
//								return outString;
//							}
//						}
//						
//					}
//	//BANKRUPT COMMAND
//					if (inputText[0].equalsIgnoreCase("bankrupt")){
//						if (turnPlayer.balance.getBalance()>=0){
//							turnPlayer.declareBankruptcy();
//							outputText = board.players[gameState.getTurn()].getPlayerName()+ " is bankrupt\n"
//									+ board.players[gameState.getTurn()].getPlayerName()+" leaves the game\n";
//							gameState.nextTurn();
//							outputText+="It is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
//						}else{
//							outputText="You cannot declare bankruptcy, you still have "+turnPlayer.balance.getBalance()+" in the bank\n";
//						}
//						return outputText;
//					}
//	//DONE COMMAND
//					if (inputText[0].equalsIgnoreCase("done"))
//					{
//						if(gameState.getHasRolled()){
//							gameState.nextTurn();
//							while(turnPlayer.hasQuit()){
//								gameState.nextTurn();
//								outputText="test";
//							}
//							outputText = "Ending your turn:\nIt is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
//							return outputText;
//						}
//						outputText = "Error: you still have to roll.\n"
//								+ "It is still your turn, " + board.players[gameState.getTurn()].getPlayerName() + "\n";
//						return outputText;
//						
//					}
//	//QUIT COMMAND
//					if (inputText[0].equalsIgnoreCase("quit")){
//						turnPlayer.quit();
//						board.players[gameState.getTurn()].ship.label.setVisible(false);
//						outputText=board.players[gameState.getTurn()].getPlayerName()+" has quit the game\n";
//						//reassign names array
//						
//						//reset player count, check greater than 1
//						
//						//turnPlayer.setPlayerNum(turnPlayer.getPlayerNum()-1);
//						
//						gameState.nextTurn();
//						outputText+="It is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
//						return outputText;
//					}
//	//EXIT COMMAND
//					if (inputText[0].equalsIgnoreCase("exit")){
//						System.exit(0);
//						
//					}
//				
//			}else{
//				gameState.nextTurn();
//				outputText="It is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
//			}
//		}
//		return null;
//		
//	}
//
//	public int rollDice(){
//		Random rand = new Random();
//		int result = rand.nextInt(6) + 1;
//		return result;
//	}
//
//}

//OTHER STUFF
//for (int i=gameState.getTurn();i<newPlayerCount;i++){
//	tempLocationHolder[i]=board.players[i+1].ship.getLocation();
//	board.players[i].ship.setLocation(tempLocationHolder[i]);
//}
//

//copy over names
//for (int i=gameState.getTurn();i<newPlayerCount;i++){
//        tempNameHolder[i]=board.players[i+1].getPlayerName();
//        board.players[i].setPlayerName(tempNameHolder[i]);
//  }

//################################################################################################//
/*
package core;
import java.util.Random;

import javax.swing.ImageIcon;

import squares.Square;
import squares.SquareInfo;

public class Commands {
	private String outputText;
	public Board board;
	public GameState gameState;
	
	public Commands(Board inBoard, GameState inGameState){
		board = inBoard;
		gameState = inGameState;
	}
	
	public String GameCommands(String[] inputText) {
		outputText = "";
		if(!gameState.getGameStart()){
			try{
				int playerCount = Integer.parseInt(inputText[0]);
				if(playerCount <=6 && playerCount >= 2){
					gameState = new GameState(playerCount);
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
			int currentTurn = gameState.getTurn();
			Player turnPlayer = board.players[currentTurn];
			
			if(turnPlayer.getQuit()!=true){
//HELP COMMAND
			if (inputText[0].equalsIgnoreCase("help"))
				{
					outputText = "\nThe following commands are available:\n"
							+ "help - see this menu\n"
							+ "\n"
							+ "TURN OPTIONS\n"
							+ "move - roll the dice\n"
							+ "done - end this player's turn\n"
                            + "bankrupt - declare bankruptcy\n"
							+ "quit - current player leaves the game"
							+ "\n"
							+ "HOUSING\n"
							+ "buy - buy a property\n"
							+ "rent - pay rent, if due\n"
							+ "mortgage [property] - mortgage property\n"
							+ "redeem [property] - redeem the property if mortgaged\n"
							+ "balance - check your funds\n"
							+ "exit - close the application"
							+ "\n";

					return outputText;
				}
			//useful debug command: move exactly 1 space as if you rolled that much
			
			if (inputText[0].equalsIgnoreCase("step"))
			{
				if(gameState.getHasRolled()){
					outputText = "You have used your roll for this turn\n";
					return outputText;
				}
				else{
					gameState.setHasRolled(true);
					outputText = "You rolled:" + 1 + "\n";
					if (!gameState.getHasRolled()) outputText += "You rolled doubles\n";
					turnPlayer.move(1);
					Square currSquare = board.squares[turnPlayer.getPosition()];
					if(currSquare.isOwned() && currSquare.owner() != currentTurn){
						outputText += "You paid " + turnPlayer.payRent(currSquare) 
										+ " in rent to Player " + (currSquare.owner() +1) + "\n";
					}
					return outputText;
				}
			}
				//debug command: find propertyNum of user input site
				if (inputText[0].equalsIgnoreCase("findprop")){
					String propertyName = "";
					for(int i = 1;i<inputText.length;i++){
						propertyName += inputText[i];
						if(i<inputText.length-1) propertyName += " ";
					}
					outputText += propertyName + "\n";
					outputText += "property: " + SquareInfo.findShortPropertyNum(propertyName) + "\n";
					return outputText;
				} 
				//TODO: make this debug command
				if (inputText[0].equalsIgnoreCase("jail")){
					turnPlayer.moveToJail();
					return "You're in jail now.\n";
				}
//MOVE COMMAND
				if (inputText[0].equalsIgnoreCase("move") || inputText[0].equalsIgnoreCase("roll"))
				{
					if(gameState.getHasRolled()){
						outputText = "You have used your roll for this turn\n";
						return outputText;
					}
					else{
						int rollArray[] = new int[2], rollSum = 0;
						outputText = "You have rolled: ";
						for (int i=0;i<2;i++){
							int move = rollDice();
							rollArray[i]=move;
							rollSum += move;
						}
						outputText += rollArray[0] + " + " + rollArray[1] + " = " + rollSum + "\n";
						
						gameState.setHasRolled(rollArray[0]!=rollArray[1]);
						if (!gameState.getHasRolled()) outputText += "You rolled doubles\n";
						turnPlayer.move(rollSum);
						Square currSquare = board.squares[turnPlayer.getPosition()];
						
						outputText += "You landed on: " + currSquare.getName(); 
						if(!currSquare.getName().equalsIgnoreCase(currSquare.getShortName())) outputText += " [" + currSquare.getShortName() + "]";
						if(currSquare.getSquareType() == 1 || currSquare.getSquareType() == 2 || currSquare.getSquareType() == 3 || currSquare.getSquareType() == 9){
							outputText += " (" + SquareInfo.SQUARE_TYPE_NAMES[currSquare.getSquareType()] + ")";
						}
						outputText += "\n";
						
						gameState.setRentDue(currSquare.isOwned() && currSquare.owner() != currentTurn);
						return outputText;
					}
					
				}
//BALANCE COMMAND
				if (inputText[0].equalsIgnoreCase("balance")){
					outputText = "You have "
									+ turnPlayer.balance.getBalance()
									+" in the bank\n";
					return outputText;
				}
//PROPERTY COMMAND
				if (inputText[0].equalsIgnoreCase("property")){
					outputText = turnPlayer.balance.showAllProperty();
					return outputText;
				}
//BUY COMMAND
				if (inputText[0].equalsIgnoreCase("buy"))
				{
					//first find square of current position
					Square currSquare = board.squares[turnPlayer.getPosition()];
					if(!currSquare.isOwnable()){
						outputText = "Sorry, you cannot purchase this\n+"
								+"It is still your turn," + turnPlayer.getPlayerName() + "\n";
					}
					//and if it's not owned...
					if(currSquare.isOwned()){
						outputText = "Sorry, this is already owned\n" 
									+ "It is still your turn, " + turnPlayer.getPlayerName() + "\n";
						return outputText;
					}
					//then buy it
					turnPlayer.buyProperty(currSquare);
					outputText = "You have bought this property\nYou now have "
									+turnPlayer.balance.getBalance()+" in the bank\n";
					return outputText;
				}
//RENT COMMAND
				if (inputText[0].equalsIgnoreCase("rent")){
					Square currSquare = board.squares[turnPlayer.getPosition()];
					int rentDue = currSquare.rent();
					if (!currSquare.isMortgaged()){
						if(!currSquare.isOwnable()){
							outputText += "This square cannot be owned, therefore no rent is due.\n";
						}
						if(!currSquare.isOwned()){
							outputText += "This square is not currently owned, therefore no rent is due.\n";
						}
						else if (currSquare.isOwned()) {
							if (gameState.getRentDue() && rentDue <= turnPlayer.balance.getBalance()) {
								outputText += "You paid " + turnPlayer.payRent(currSquare)
										+ " in rent to Player " + (currSquare.owner() + 1) + "\n"
										+ "Your balance is now " + turnPlayer.balance.getBalance() + "\n";
							} else if (gameState.getRentDue() && rentDue > turnPlayer.balance.getBalance()) {
								outputText += "Cannot pay the rent as your balance is too low.\n";
							}
						}
						else{
							outputText += "You currently own this square, therefore no rent is due.\n";
						}
					}else{
						outputText="Property is mortgaged\n"
								+ "Redeem property via the redeem <property> command before renting\n";
					}
					return outputText;
				}

//BANKRUPT COMMAND
                if (inputText[0].equalsIgnoreCase("bankrupt")){
                    for(int i=0;i<=39;i++){
                        Square forSquare = board.squares[i];
                        if (turnPlayer.getPlayerNum() == forSquare.owner()){
                            forSquare.destroyAll();
                            forSquare.setUnowned();
                        }
                    }
                    
//                    turnPlayer.setQuit();
//                    String tempNameHolder[] = new String[gameState.getPlayerCount()-1];
//                    int tempLocationHolder[] = new int[gameState.getPlayerCount()-1];
//                    //copy over names
//                    for (int i=gameState.getTurn();i<gameState.getPlayerCount();i++){
//                    	tempNameHolder[i]=board.players[i+1].getPlayerName();
//                    	board.players[i].setPlayerName(tempNameHolder[i]);
//                    }
                    //copy over locations?
                 
                   
                    
                    outputText  += "Player has left the game\n"
                                + "It is now the next player's turn\n";
                    gameState.nextTurn();
                    return outputText;
                }

//MORTGAGE COMMAND
				if (inputText[0].equalsIgnoreCase("mortgage")){
					String propertyName = inputText[1];
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
					return outputText;
				}
//REDEEM COMMAND
				if (inputText[0].contains("redeem")){
					String propertyName = inputText[1];
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

					return outputText;
				}
//BUILD COMMAND
				if (inputText[0].equalsIgnoreCase("build")){
					String propertyName = inputText[1];
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
							
							else if(!square.build()) return "Error: you already have the maximum number of buildings on this property\n";
							else{
								turnPlayer.balance.subtractBalance(square.buildingCost());
								outputText = "Success! There ";
								int check = square.getBuildings();
								if(check==5) outputText += " is now a hotel on this property\n";
								else if(check == 1) outputText += " is now a house on this property\n";
								else outputText += " are now " + check + " houses on this property\n";
								
							}
						}
						
					}
					return outputText;
				}
//DEMOLISH COMMAND
				if (inputText[0].equalsIgnoreCase("demolish")){
					String propertyName = inputText[1];
					int propertyNum = SquareInfo.findShortPropertyNum(propertyName);
					if(propertyNum==-1){
						outputText += "Error: this site does not exist\n";
					}
					else{
						Square square = board.squares[propertyNum];
						if(square.owner()!=turnPlayer.getPlayerNum()) return "Error: you do not own this property\n";
						else if(square.getSquareType()!=1) return "Error: squares which are not sites cannot have buildings\n";
						
						else if(!square.destroy()) return "Error: you already have the maximum number of buildings on this property\n";
						else{
							turnPlayer.balance.addBalance(square.buildingCost()/2);
							String outString = "Success! There ";
							int check = square.getBuildings();
							if(check==0) outString += " are now no buildings on this property.\n";
							else if(check==1) outString += " is now 1 house on this property.\n";
							else outString += " are now " + check + " houses on this property\n";
							
							return outString;
						}
					}
					
				}
//QUIT COMMAND
				if (inputText[0].equalsIgnoreCase("quit")){
					 
					outputText+=board.players[currentTurn].getPlayerName()+" has quit the game\n";
					turnPlayer.setQuit();
					int playerCount = gameState.getPlayerCount();
					int newPlayerCount = gameState.getPlayerCount()-1;
	                String tempNameHolder[] = new String[newPlayerCount];
	                int tempLocationHolder[] = new int[newPlayerCount];
                   
	           //WORKS PERFECTLY IF LAST PLAYER IS REMOVED... LMAO
	                //will have to remove all Jlabels, repaint them, except for the player that has quit
	               
	                board.layeredPane.remove(board.players[currentTurn].ship.label);
	                turnPlayer.setQuit();
	                //board.players[gameState.getTurn()].ship.label.setVisible(false);
//	                for (int i=currentTurn;i<playerCount;i++){
//	                board.players[currentTurn].ship.label = board.players[currentTurn+1].ship.label;
//	                }
	                
	              //  int turnSave=currentTurn;
                    gameState.nextTurn();
					outputText += "Ending your turn:\nIt is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
//					gameState = new GameState(newPlayerCount);
//					gameState.gameStart();
//					gameState.playerNamesDone();
					//gameState.setTurn(turnSave);

					
                    return outputText;
				}
				
//DONE COMMAND
				if (inputText[0].equalsIgnoreCase("done"))
				{
					if(gameState.getHasRolled()){
						gameState.nextTurn();
					
						outputText = "Ending your turn:\nIt is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
						return outputText;
						
						
					}
					outputText = "Error: you still have to roll.\n"
							+ "It is still your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
					return outputText;
					
				}
//EXIT COMMAND
				if (inputText[0].equalsIgnoreCase("exit"))
				{
					System.exit(0);
					return null;
				}
				else{
					outputText = "This command is not available\n";
					return outputText;
				}
			}else{
				gameState.nextTurn();
				outputText = "It is now your turn, " + board.players[gameState.getTurn()].getPlayerName() +"\n";
			}
		}
		return outputText;
	}

	public int rollDice(){
		Random rand = new Random();
		int result = rand.nextInt(6) + 1;
		return result;
	}

}

*/

//gameState.setTurn(currentTurn);

//copy over locations
