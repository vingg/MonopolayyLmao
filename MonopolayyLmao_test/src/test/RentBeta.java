//import squares.Square;

//					int rentDue = currSquare.rent();
//					if (!currSquare.isMortgaged()){
//						if(!currSquare.isOwnable()){
//							outputText += "This square cannot be owned, therefore no rent is due.\n";
//						}
//						if(!currSquare.isOwned()){
//							outputText += "This square is not currently owned, therefore no rent is due.\n";
//						}
//						else if (currSquare.isOwned()) {
//							if (gameState.getRentDue() && rentDue <= turnPlayer.balance.getBalance()) {
//								outputText += "You paid " + turnPlayer.payRent(currSquare)
//										+ " in rent to Player " + (currSquare.owner() + 1) + "\n"
//										+ "Your balance is now " + turnPlayer.balance.getBalance() + "\n";
//							} else if (gameState.getRentDue() && rentDue > turnPlayer.balance.getBalance()) {
//								outputText += "Cannot pay the rent as your balance is too low.\n";
//							}
//						}
//						else{
//							outputText += "You currently own this square, therefore no rent is due.\n";
//						}
//					}else{
//						outputText="Property is mortgaged\n"
//								+ "Redeem property via the redeem <property> command before renting\n";
//					}
//					}
