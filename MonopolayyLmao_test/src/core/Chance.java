package core;


public class Chance {

    public static String chanceCard(int chanceCardNumber, Board board, Player player) {
    	String outputText = "";
    	int oldPosition = player.getPosition();
    	int repairs;
    	switch(chanceCardNumber){
    	case 0: player.moveTo(0); 
    			outputText +="Move to Go! Collect £200.\n";
    			player.balance.addBalance(200);
    			outputText += "Gained £200 for passing GO!\n";
    	case 1: player.moveToJail();
    			outputText +="Go to jail. Move directly to jail. Do not pass Go. Do not collect £200.\n";
    	case 2: player.moveTo(24);
    			outputText +="Advance to Pall Mall. If you pass Go collect £200.\n";
    			if(player.getPosition()< oldPosition){
    				player.balance.addBalance(200);
        			outputText += "Gained £200 for passing GO!\n";
    			}
    	case 3: player.moveTo(15);
    			outputText +="Take a trip to Marylebone Station and if you pass Go collect £200.\n";
    			if(player.getPosition()< oldPosition){
    				player.balance.addBalance(200);
        			outputText += "Gained £200 for passing GO!\n";
    			}
    	case 4: player.moveTo(13);
    			outputText +="Advance to Trafalgar Square. If you pass Go collect £200.\n";
    			if(player.getPosition()< oldPosition){
    				player.balance.addBalance(200);
        			outputText += "Gained £200 for passing GO!\n";
    			}
    	case 5: player.moveTo(39);
    			outputText +="Advance to Mayfair.\n";
    	case 6: player.move(-3);
    			outputText +="Go back three spaces.\n";
    	case 7: repairs = 25*player.getHousesOwned()+100*player.getHotelsOwned();
    			player.balance.subtractBalance(repairs);
    			outputText +="Pay repairs of £"+repairs+".\n";
    	case 8: repairs = 40*player.getHousesOwned()+115*player.getHotelsOwned();
				player.balance.subtractBalance(repairs);
				outputText +="Pay repairs of £"+repairs+".\n";
    	case 9: player.balance.subtractBalance(150);
    			outputText +="Pay school fees of £150.\n";
    	case 10: player.balance.subtractBalance(20);
    			 outputText +="Drunk in charge fine: £20.\n";
    	case 11: player.balance.subtractBalance(15);
    			outputText +="Speeding fine: £15.\n";
    	case 12: player.balance.addBalance(150);
    			 outputText +="Your building loan matures. Receive £150.\n";
    	case 13: player.balance.addBalance(100);
    			 outputText +="You have won a crossword competition. Collect £100.\n";
    	case 14: player.balance.addBalance(50);
    	   		 outputText +="Bank pays you a dividend of £50.\n";
    	case 15: //TODO: Get out of jail free. This card may be kept until needed or sold.
    			player.setGoojCard(true);

    	}
    	return outputText;
    }
}