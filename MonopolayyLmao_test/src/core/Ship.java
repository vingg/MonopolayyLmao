package core;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ship{
	ImageIcon image;
	JLabel label;
	Coordinates coordinates;
	private int imageWidth, imageHeight, playerNum, currLocation;
	
	Ship(int input){
		image = new ImageIcon("./res/smolship"+(input+1)+".png");
		label = new JLabel(image);
		coordinates = new Coordinates();
		imageWidth = image.getIconWidth();
		imageHeight = image.getIconHeight();
		playerNum = input;
	}
	public void setLocation(int location){
		location %= 40;
		label.setBounds(Coordinates.getCoordX(location), 
				Coordinates.getCoordY(location) + 5*playerNum, imageWidth, imageHeight);
		currLocation = location;
	}
	
	public int getLocation(){
		return currLocation;
	}
	
	public void move(int amount){
		setLocation(currLocation + amount);
	}
	public void moveToJail(){
		label.setBounds(Coordinates.getJailCoordX(), 
				Coordinates.getJailCoordY() + 5*playerNum, imageWidth, imageHeight);
		currLocation = 10;
	}
}