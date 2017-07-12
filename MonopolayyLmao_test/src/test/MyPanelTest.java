package test;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//import javax.swing.AbstractAction;
//import javax.swing.Action;
//import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.WindowConstants;
//import javax.swing.text.DefaultCaret;
//
//
//public class MyPanelTest extends JFrame {
//	private static void createAndShowGUI() {
//		JFrame myFrame = new JFrame("MonopolayyLmao"); 
//		 myFrame.setSize(750,600);
//		 myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		 
//		 JPanel mainPanel = new JPanel();
//		 mainPanel.setLayout(new BorderLayout());
//		 
//		 JPanel boardPanel = new JPanel();
//		 JTextArea infoPanel = new JTextArea(10, 20); 
//		 JTextField cmdPanel = new JTextField(30);
//		 
//		 // i/o for command panel
//		 cmdPanel.addActionListener(new ActionListener(){
//		 public void actionPerformed(ActionEvent e){
//			 	GameCommands(infoPanel, cmdPanel); //pass the cmdpanle and infopanel so method will work
//		 	}
//		 });
//		 
//		 //board image
//		 ImageIcon icon = new ImageIcon("src/board.jpg"); //still set to temp board
//		 JLabel boardImage = new JLabel(icon);
//		 boardPanel.add(boardImage);
//		 
//		 infoPanel.setWrapStyleWord(true);
//	     infoPanel.setEditable(false);
//	     infoPanel.setLineWrap(true);
//	     
//	     JScrollPane scrollBar = new JScrollPane(infoPanel);
//	     scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	     scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	     
//		 mainPanel.add(boardPanel, BorderLayout.CENTER);
//	     mainPanel.add(scrollBar, BorderLayout.LINE_END); //note that we add the scrollbar INSTEAD of the textpanel directly
//	     mainPanel.add(cmdPanel, BorderLayout.PAGE_END);
//	     myFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
//		 mainPanel.setVisible(true);
//		 myFrame.setVisible(true); 
//		
//		 infoPanel.append("Mei is cancer\n");
//	}
//
//	public static void GameCommands(JTextArea infoPanel, JTextField cmdPanel){
//		String text = cmdPanel.getText();
//		boolean gameStart = true; //added so the code could be tested
//		 if(gameStart==true)
//		 {
//			 try{
//				 int playerCount = Integer.parseInt(text);
//				 if(playerCount>6){
//					 infoPanel.append("Error: invalid input: please enter a number of players no greater than 6\n");
//				 }
//				 else{
//					 /*for(int i=0;i<playerCount;i++){
//				  * 	addPlayer();
//				  * }
//				 TODO: figure out where to declare playerCount */
//					 infoPanel.append("Starting a " + playerCount + " player game!\nEnter 'roll' to roll the dice.\n");
//				 gameStart=false;
//				 }
//				 
//			 } catch (NumberFormatException numErr){
//				 infoPanel.append("Error: invalid input: please enter a number of players no greater than 6\n");
//			 }
//		 }
//		 else{
//			 infoPanel.append("You entered: " + text + '\n');
//			 if(text.equalsIgnoreCase("roll")){
//				 Random rand = new Random();
//				 int rollResult = rand.nextInt(6);
//				 infoPanel.append("You rolled: " + rollResult);
//				 //player.move(roll); 
//				 //or however we phrase it
//			 }
//		 }
//		 
//		 cmdPanel.selectAll();
//	 }
//	
//
//	public static void main(String[] args) {
//		//JFrame now declared in main and passed as an argument into method
//		
//		createAndShowGUI(); 
//	 }
//}
