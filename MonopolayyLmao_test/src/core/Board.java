package core;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import squares.Square;
import squares.SquareGo;
import squares.SquareGoToJail;
import squares.SquareInfo;
import squares.SquareJail;
import squares.SquareParking;
import squares.SquareSite;
import squares.SquareStation;
import squares.SquareTax;
import squares.SquareUtility;
import squares.SquareCommunity;
import squares.SquareChance;

public class Board{
	//all these are public
	JFrame myFrame;
	JPanel mainPanel;
	JTextArea infoPanel;
	JTextField cmdPanel;
	JLayeredPane layeredPane;
	ImageIcon boardImage;
	ImageIcon shipImage;
	JLabel boardLabel; 
	JLabel ship; 
	Player[] players;
	Square squares[], jailSquare;
	CardList commChest;
	CardList chance;
	
	Board(GameState gameState){
		myFrame = new JFrame("MonopolayyLmao");
		myFrame.setResizable(false);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		infoPanel = new JTextArea(10, 20);
		cmdPanel = new JTextField(30);
		layeredPane = new JLayeredPane();
		boardImage = new ImageIcon("./res/board.jpg"); 
		shipImage = new ImageIcon("./res/smolship.png");
		boardLabel = new JLabel(boardImage);
		ship = new JLabel(shipImage);

		commChest = new CardList(16);
		chance = new CardList(16);
		commChest.fill();
		chance.fill();
		
		players = new Player[6];
		for(int i=0;i<6;i++){
			players[i]=new Player(i);
		}
		squares = new Square[SquareInfo.NUM_SQUARES];
		for(int squareCount=0;squareCount<SquareInfo.NUM_SQUARES;squareCount++){
			squares[squareCount] = setSquares(squareCount);
		}
		Commands commands = new Commands(this, gameState);
		cmdPanel.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 	String cmdPanelText = cmdPanel.getText();
				 	String[] splitCmdPanelText = cmdPanelText.split("\\W+");
				 	infoPanel.append(commands.GameCommands(splitCmdPanelText));
				 	cmdPanel.setText("");
				 }
			 });
	}
	//Initializes the correct type of square
	private Square setSquares(int squareNum){
		//first find which info matches the square
		int squareType = SquareInfo.SQUARE_TYPES[squareNum];
		
		//then use appropriate constructor
		switch(squareType){
		case 0: return new SquareGo();
		
		case 1: int siteNum =0;
				for(int i=0;i<squareNum;i++){
					if (SquareInfo.SQUARE_TYPES[i]==1) siteNum++;
				}
				return new SquareSite(squareNum, siteNum);
				
		case 2: int stationNum=0;
				for(int i=0;i<squareNum;i++){
					if (SquareInfo.SQUARE_TYPES[i]==2) stationNum++;
				}
				return new SquareStation(squareNum, stationNum);
		case 3: int utilityNum=0;
				for(int i=0;i<squareNum;i++){
					if (SquareInfo.SQUARE_TYPES[i]==3) utilityNum++;
				}
				return new SquareUtility(squareNum, utilityNum);
		case 4: return new SquareCommunity(squareNum);
		case 5: return new SquareChance(squareNum);
		case 6: return new SquareJail(squareNum);
		case 7: return new SquareParking(squareNum);
		case 8: return new SquareGoToJail(squareNum);
		case 9: int taxNum=0;
				for(int i=0;i<squareNum;i++){
					if (SquareInfo.SQUARE_TYPES[i]==9) taxNum++;
				}
				return new SquareTax(squareNum, taxNum);
		}
		return null;	
	}
}
