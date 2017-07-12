package core;

import core.Player;
import core.Board;


public class CommChest {

    public static String commChestCard(int commChestCardNumber, Board board, Player player) {
    	String outputText = "";
    	int oldPosition = player.getPosition();
    	switch(commChestCardNumber){
    	case 0: player.moveTo(0); 
    			outputText += "Move to Go! Collect £200.\n";
    			player.balance.addBalance(200);
    			outputText += "Gained £200 for passing GO!\n";
    	case 1: player.moveBackwardsTo(19); 
    			outputText += "Go back to Old Kent Road.\n";
    	case 2: player.moveToJail();
    			outputText += "Go to jail. Do not pass Go. Do not collect £200.\n";
    	case 3: player.balance.subtractBalance(100);
    			outputText += "Pay hospital £100.\n";
    	case 4: player.balance.subtractBalance(50);
    			outputText += "Doctor's fee. Pay £50.\n";
    	case 5: player.balance.subtractBalance(50);
    			outputText += "Pay your insurace premium of £50.\n";
    	case 6: player.balance.addBalance(200);
    			outputText += "Bank error in your favour. Collect £200\n";
    	case 7: player.balance.addBalance(100);
    			outputText += "Annuity matures. Collect £100.\n";
    	case 8: player.balance.addBalance(100);
    			outputText += "You inherit £100.\n";
    	case 9: player.balance.addBalance(50);
    			outputText += "From sale of stock you get £50.\n";
    	case 10: player.balance.addBalance(25);
    			 outputText += "Recieve interest on 7% preference shares: £25.\n";
    	case 11: player.balance.addBalance(20);
    			 outputText += "Income tax refund. Collect £20.\n";
    	case 12: player.balance.addBalance(10);
    			 outputText += "You have won second place in a beauty contest. Collect £10.\n";
    	case 13: for(int i = 0; i<board.players.length;i++){
    				if(board.players[i].getPlayerNum()!=player.getPlayerNum()){
    					board.players[i].balance.subtractBalance(10);
    					player.balance.addBalance(10);
    				}
    			 }
    			 outputText += "It is your birthday. Collect £10 from each player.\n";
    	case 14: //TODO: get out of jail free card
    			 outputText += "Get out of jail free. This card may be kept until needed or sold.\n";
    	case 15: //TODO: //Grand Opera Night
    			 outputText += "Grand Opera Night- Collect $50 from every player for opening night seats\n";
    			 for(int i = 0; i<board.players.length;i++){
     				if(board.players[i].getPlayerNum()!=player.getPlayerNum()){
     					board.players[i].balance.subtractBalance(50);
     					player.balance.addBalance(50);
     				}
     			 }
    	}
    	return outputText;
    }
}
