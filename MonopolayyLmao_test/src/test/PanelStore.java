package test;
//import java.awt.BorderLayout;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.WindowConstants;
//
//public class PanelStore extends JFrame {
//	private static void createAndShowGUI(GameState gameState) {
//		Board board = new Board();
//		 board.myFrame.setSize(910,720);
//		 board.myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		 board.boardLabel.setBounds(0,0, board.boardImage.getIconWidth(), board.boardImage.getIconHeight()); // X, Y, X2, Y2 (top left corner, bottom right corner)
//		 board.layeredPane.add(board.boardLabel, new Integer(1));//the Integer () means what layer they are on, higher number = above
//		 board.infoPanel.setWrapStyleWord(true);
//		 board.infoPanel.setEditable(false);
//		 board.infoPanel.setLineWrap(true);
//		 
//		 JScrollPane scrollBar = new JScrollPane(board.infoPanel);
//		 scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		 scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		 
//		 //mainPanel.add(boardPanel, BorderLayout.CENTER); No need anymore?
//		 board.mainPanel.add(scrollBar, BorderLayout.LINE_END); //note that we add the scrollbar INSTEAD of the textpanel directly
//		 board.mainPanel.add(board.cmdPanel, BorderLayout.PAGE_END);
//		 board.mainPanel.add(board.layeredPane);
//		 board.myFrame.getContentPane().add(BorderLayout.CENTER, board.mainPanel);
//		 board.mainPanel.setVisible(true);
//		 board.myFrame.setVisible(true); 
//		 
//		 board.infoPanel.append("WELCOME TO MONOPOLAYYLMAO\n\n");
//		 
//		 for(int i=0;i<6;i++){
//			 board.layeredPane.add(board.players[i].ship.label, new Integer(i+2));
//		 }
//		 
//		 for(int j=0;j<40;j++){
//			 for(int i=0;i<6;i++){
//				 board.players[i].ship.setLocation(j);
//				 try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//				}
//			 }
//		 } 
//	}
//
//	//all we need for now, but a template for the structure future methods should take
//		//ie: the infoPanel and cmdPanel shouldn't be needed to be passed as parameters anymore.
//		public String Echo(String inputText) {
//			String outputText;
//			outputText=inputText;
//			return outputText;
//		}
//	
//		public String Move(String command) {
//			
//			return null;
//		}
//		
//	public static void GameCommands(JTextArea infoPanel, JTextField cmdPanel, GameState gameState){
//		//GameSetUp(infoPanel, cmdPanel, gameState);
//		
//		//infoPanel.append("Enter 'roll' to roll the dice.\n");
//		//TakeTurn(infoPanel, cmdPanel);
//		
//	}
//	
//	
//	
///*
//	public static boolean GameSetUp(JTextArea infoPanel, JTextField cmdPanel, GameState gameState){
//		String text = cmdPanel.getText();
//=======
//		 board.infoPanel.append("WELCOME TO MONOPOLAYYLMAO\n\nEnter the number of players\n\n");
//	}
//
//	public static void GameCommands(Board board, GameState gameState){
//		GameSetUp(board, gameState);
//		
//		board.infoPanel.append("Enter 'roll' to roll the dice.\n");
//		TakeTurn(board);
//		
//	}
//
//	public static boolean GameSetUp(Board board, GameState gameState){
//		String text = board.cmdPanel.getText();
//>>>>>>> origin/master
//		if(gameState.getGameStart()==false){
//			try{
//				int playerCount = Integer.parseInt(text);
//			 
//				if(playerCount>6){
//				 board.infoPanel.append("Error: invalid input: please enter a number of players no greater than 6\n");
//				}else{
//				
//					gameState = new GameState(playerCount);
//					board.infoPanel.append("Starting a " + gameState.getPlayerCount()+" player game\n");
//				}
//			 
//			} catch (NumberFormatException numErr){
//			 //needs to be commented out or it appears every time a command is entered
//			// infoPanel.append("Error: invalid input: please enter a number of players no greater than 6\n");
//			}
//		}
//		return true;
//	}
//	
//	public static void TakeTurn(Board board){
//		//	Player playerNo = new Player();
//		String text = board.cmdPanel.getText();
//		//Coordinates playerPosition = new Coordinates();
//			
//			
//		if(text.equalsIgnoreCase("roll")){
//			board.infoPanel.append("You entered: " + text + "\n");
//			int result = rollDice();
//			board.infoPanel.append("You rolled: " + result + "\n");
//			
//			board.infoPanel.append("Enter 'roll' to roll the dice.\n");
//			//player.move(roll); 
//			 //or however we phrase it
//			 }
// 
//
//		board.cmdPanel.setText("");
//	}
//
//	public static int rollDice(){
//		 Random rand = new Random();
//		 int rollResult1 = rand.nextInt(6);
//		 int rollResult2 = rand.nextInt(6);
//		 int rollResult = rollResult1 + rollResult2;
//		 
//		 return rollResult;
//	}
//*/
//	public static void main(String[] args) {
//		GameState gameState=new GameState(0);
//		createAndShowGUI(gameState); 
//	 }
//}
