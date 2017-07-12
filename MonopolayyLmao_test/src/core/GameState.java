/*this class will keep track of global game data,
 * such as the number of players, their locations,
 * their funds and their properties. The player class
 * refers to a single Player, and there is an array of 
 * Player in GameState.*/
package core;
public class GameState{
	private int playerCount;
	private boolean gameStart, hasRolled, rentDue, playerNameSet;
	private int playerTurn, doublesThisTurn;
	private int dynamicPlayerCount;
	GameState(int players){
		playerCount = players;
		playerTurn = doublesThisTurn = 0;
		gameStart = hasRolled = rentDue = playerNameSet = false;
	}
	public void gameStart(){
		gameStart=true;
	}
	public boolean getGameStart(){
		return gameStart;
	}
	
	public void gameEnd(){
		gameStart=false;
	}
	
	public int getPlayerCount(){
		return playerCount;
	}
	public void setDPC(int i){
		dynamicPlayerCount=i;
	}
	public int getDPC(){
		return dynamicPlayerCount;
	}
	public void nextTurn(){
		//int playing = Player.isPlaying();//test idea with token on player which would be checked for active/inactive
		//if(Player.isPlaying()){
		if(playerTurn == playerCount -1) playerTurn =0;
		else playerTurn++;
		//}
		hasRolled = false;
		doublesThisTurn = 0;
	}
	
	public void setTurn(int turn){
		playerTurn = turn;
	}
	
	public int getTurn(){
		return playerTurn;
	}
	public boolean getHasRolled(){
		return hasRolled;
	}
	public void setHasRolled(boolean b){
		hasRolled = b;
	}
	public int getDoublesThisTurn(){
		return doublesThisTurn;
	}
	public void rolledDoubles(){
		doublesThisTurn++;
	}
	public void resetDoublesThisTurn(){
		doublesThisTurn = 0;
	}
	public boolean getRentDue(){
		return rentDue;
	}
	public void setRentDue(boolean b){
		rentDue = b;
	}
	public boolean playerNamesSet(){
		return playerNameSet;
	}
	
	public void playerNamesDone(){
		playerNameSet = true;
	}
}