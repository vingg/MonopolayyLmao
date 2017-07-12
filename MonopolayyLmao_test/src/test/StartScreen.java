package test;
//package core;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.WindowConstants;
//import javax.swing.border.LineBorder;
//
//public class StartScreen extends JFrame{
//	//private int i;
//	public Board board;
//	public GameState gameState;
//	private int playerCount;
//	private String[] playerNameArray = new String[6];
//	
//	public void welcomeScreen(){
//		JFrame welcomeFrame = new JFrame("MonopolayyLmao");
//		welcomeFrame.setResizable(false);
//		welcomeFrame.setSize(500, 300);
//		welcomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		
//		JPanel welcomePanel = new JPanel();
//		JLabel welcomeLabel = new JLabel("Welcome to MonopolayyLmao!");
//		JLabel creditLabel = new JLabel("Made by Laura Brierton, Peter Concannon and Vincentas Glusinskas");
//		JButton continueButton = new JButton("Continue");
//		continueButton.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				 welcomeFrame.setVisible(false);
//				 welcomeFrame.dispose();
//				 gameSetUp();
//				}
//			});
//		GridBagLayout gridLayout = new GridBagLayout();
//		welcomeFrame.setLayout(gridLayout);
//		GridBagConstraints c = new GridBagConstraints();
//		
//		c.fill = GridBagConstraints.CENTER;
//		c.weighty = 1; 
//		c.gridx = 0;
//		c.gridy = 0;
//		welcomeFrame.add(welcomeLabel, c);
//		c.fill = GridBagConstraints.CENTER;
//		c.gridx = 0;
//		c.gridy = 1;
//		welcomeFrame.add(creditLabel, c);
//		c.fill = GridBagConstraints.PAGE_END;
//		c.gridx = 0;
//		c.gridy = 2;
//		c.weighty = 5; 
//		welcomeFrame.add(continueButton, c);
//		
//		welcomeFrame.setVisible(true);
//	}
//	
//	public void gameSetUp(){
//		JFrame startFrame = new JFrame("MonopolayyLmao");
//		startFrame.setResizable(false);
//		startFrame.setSize(500, 300);
//		startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		
//		JPanel startPanel = new JPanel();
//		JLabel playerLabel = new JLabel("Please enter the number of players between 2 and 6");
//		
//		JTextField startTextField = new JTextField(10);
//		startTextField.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				String playerString = startTextField.getText();
//				playerCount = Integer.parseInt(playerString);
//				try{
//					if(playerCount <=6 && playerCount >= 2){
//						startFrame.setVisible(false); 
//						startFrame.dispose();
//						gameState.setPlayerCount(playerCount);
//						getPlayerNames();
//					}else{
//						
//					}
//				}catch(NumberFormatException x){
//					
//				}
//			}
//		});
//		
//		startPanel.add(playerLabel, BorderLayout.PAGE_START);
//		startPanel.add(startTextField, BorderLayout.CENTER);
//		startFrame.add(startPanel);
//		startFrame.setVisible(true);
//	
//	}
//	
//	public void getPlayerNames(){
//		JFrame playerFrame = new JFrame("MonopolayyLmao");
//		playerFrame.setResizable(false);
//		playerFrame.setSize(500, 300);
//		playerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		playerFrame.setVisible(true);
//		int playerNum=getPlayerNum();
//		JTextField[] playerTextField = new JTextField[playerNum];
//		JLabel[] playerLabel = new JLabel[playerNum];
//		//JTextField textFieldTemp;
//		
//		
//		JButton submit = new JButton("submit");
//		submit.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				try{
//					for (int i=0;i<playerNum;i++){
//						if (playerTextField[i].getText()!=null){
//							String playerNameTemp=playerTextField[i].getText();
//							setPlayerName(i, playerNameTemp);
//							
//						}else{
//							
//						}
//					}
//					playerFrame.setVisible(false); 
//					playerFrame.dispose();
//				}catch(NullPointerException x){
//						
//				}
//			}
//		});
//		
//		for (int i = 0; i < playerTextField.length; i++) {
//			playerTextField[i] = new JTextField();
//			playerFrame.add(playerTextField[i]);
//			}
//		
//		GridBagLayout gridLayout = new GridBagLayout();
//		playerFrame.setLayout(gridLayout);
//		GridBagConstraints c = new GridBagConstraints();
//
//		for (int i = 0;i < playerTextField.length; i++){
//			
//			playerLabel[i] = new JLabel("Player " + (i+1) + " name");
//			c.fill = GridBagConstraints.HORIZONTAL;
//			c.gridx = 0;
//			c.gridy = i;
//			playerFrame.add(playerLabel[i], c);
//			c.weightx = 0.5;
//			c.fill = GridBagConstraints.HORIZONTAL;
//			c.gridx = 1;
//			c.gridy = i;
//			playerFrame.add(playerTextField[i], c);
//		}
//		c.weightx = 0.5;
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 0;
//		c.gridwidth = 2;
//		c.gridy=playerTextField.length+1;
//		playerFrame.add(submit, c);
//	}
//	public void setPlayerNum(int i){
//		playerCount = i;
//	}
////	public int getPlayerNum(){
////		return playerCount;
////	}
//	public void setPlayerName(int i, String playerName){
//		playerNameArray[i]=playerName;
//	}
//	public String getPlayerName(int i){
//		return playerNameArray[i];
//	}
//}
