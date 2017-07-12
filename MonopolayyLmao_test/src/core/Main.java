package core;

public class Main {
	public static void main(String[] args) {
		Panel panel = new Panel();
		GameState gameState=new GameState(0);
		Board board = panel.createAndShowGUI(gameState); 
		board.infoPanel.append("\n");
		
	 }

}

	