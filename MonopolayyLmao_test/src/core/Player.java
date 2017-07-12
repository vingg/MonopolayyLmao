package core;

import squares.Square;

public class Player {
	static public int isPlaying;//used to check if player is still in game
	private int playerNum, position, turnsInJail, housesOwned=0, hotelsOwned=0;
	private String playerName;
	Ship ship;
	Balance balance;
	private boolean inJail, hasQuit, goojCard;

	
	Player(int input){
		playerNum=input;
		position = turnsInJail = 0;
		ship = new Ship(playerNum);
		balance = new Balance();
		isPlaying = 1;//test token
		inJail = false;
		hasQuit = false;
		goojCard=false;
	}
	public void setPlayerNum(int input){
		playerNum = input;
	}
	
	public int getPlayerNum(){
		return playerNum;
	}

	public int isPlaying(){
		return isPlaying;
	}

	public void notPlaying(){//change test token
		isPlaying = 0;
	}
	
	public void setPlayerName(String name){
		playerName = name;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void move(int amount){
		ship.move(amount);
		position+=amount;
		position=position%40;
	}
	public void moveTo(int nextPosition){
		int moveAmount = (nextPosition - position) % 40;
		move(moveAmount);
	}
	public void moveBackwardsTo(int nextPosition){
		//intentionally does NOT invoke move(), to prevent accidentally giving GO money
		int moveAmount = (position - nextPosition) % 40;
		ship.move(-moveAmount);
		position -= moveAmount;
		position %= 40;
	}
	public void moveToJail(){
		ship.moveToJail();
		position = 10;
		inJail = true;
	}
	public void freeFromJail(){
		inJail = false;
	}
	public boolean inJail(){
		return inJail;
	}
	public void spentTurnInJail(){
		turnsInJail++;
	}
	public int getTurnsInJail(){
		return turnsInJail;
	}
	public void resetTurnsInJail(){
		turnsInJail = 0;
	}
	public int getPosition(){
		return position;
	}
	/**
	 * buy this property from the bank(i.e. at full price)
	 */
	public int buyProperty(Square currPosition){
		balance.addProperty(currPosition);
		int price = currPosition.price();
		balance.subtractBalance(price);
		currPosition.setOwnership(playerNum);
		return price;
	}
	public int payRent(Square square){
		balance.subtractBalance(square.rent());
		return(square.rent());
	}

	public int recieveMortgage(Square square){
		balance.addBalance(square.mortgage());
		return(square.mortgage());
	}
	
	public int payRedeem(Square square){
		balance.subtractBalance(square.redeem());
		return (square.redeem());
	}
	
	public void setQuit(){
		hasQuit = true;
	}
	
	public boolean getQuit(){
		return hasQuit;
	}
	public void setHousesOwned(int i){
		housesOwned+=i;
	}
	public int getHousesOwned(){
		return housesOwned;
	}
	public void setHotelsOwned(int i){
		hotelsOwned+=i;
	}
	public int getHotelsOwned(){
		return hotelsOwned;
	}
	public void setGoojCard(boolean b){
		goojCard=b;
	}
	public boolean getGoojCard(){
		return goojCard;
	}

	/*	if(properties.getSquare(square.getSquareNum())==null|| !properties.checkForColorSet(square)){
			String outputString = "Error: ";
			if(square.getSquareType()!= 1) outputString += "This is not a Site,"
		} 
	}*/
}

