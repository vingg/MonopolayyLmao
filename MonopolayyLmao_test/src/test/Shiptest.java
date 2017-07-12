//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//
//import core.Coordinates;

//package test;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//
//import core.Coordinates;
//
//public class Ship{
//	JLabel label;
//	Coordinates coordinates;
//	private int imageWidth, imageHeight, playerNum, currLocation;
//	ImageIcon[] image = new ImageIcon[5];
//	for(int i=1;i<=6;i++){
//		image[i] = new ImageIcon("./res/smolship"+i+".png");
//		}
//	ImageIcon playerIcon;
//	
//	Ship(int input){
//		//image = new ImageIcon[input];
//		playerIcon = image[input];
//		label = new JLabel(playerIcon);
//		coordinates = new Coordinates();

//
//private int imageWidth, imageHeight, playerNum, currLocation;
//	ImageIcon playerIcon;
//	
//	Ship(int input){
//		image[input] = new ImageIcon("./res/smolship"+input+".png");
//		playerIcon = image[input];
//		label = new JLabel(playerIcon);
//		coordinates = new Coordinates();
//		imageWidth = playerIcon.getIconWidth();
//		imageHeight = playerIcon.getIconHeight();
//		playerNum = input;
//	}