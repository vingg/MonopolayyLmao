package core;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

public class Panel extends JFrame {
	private static final long serialVersionUID = -4415728416623737434L;

	static Board createAndShowGUI(GameState gameState) {
		 Board board = new Board(gameState);
		 board.myFrame.setSize(910,720);
		 board.myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 board.boardLabel.setBounds(0,0, board.boardImage.getIconWidth(), board.boardImage.getIconHeight()); // X, Y, X2, Y2 (top left corner, bottom right corner)
		 board.layeredPane.add(board.boardLabel, new Integer(1));//the Integer () means what layer they are on, higher number = above
		 board.infoPanel.setWrapStyleWord(true);
		 board.infoPanel.setEditable(false);
		 board.infoPanel.setLineWrap(true);
		 
		 DefaultCaret caret = (DefaultCaret)board.infoPanel.getCaret();
		 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		 
		 JScrollPane scrollBar = new JScrollPane(board.infoPanel);
		 scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		 scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 
		 
		 //mainPanel.add(boardPanel, BorderLayout.CENTER); No need anymore?
		 board.mainPanel.add(scrollBar, BorderLayout.LINE_END); //note that we add the scrollbar INSTEAD of the textpanel directly
		 board.mainPanel.add(board.cmdPanel, BorderLayout.PAGE_END);
		 board.mainPanel.add(board.layeredPane);
		 board.myFrame.getContentPane().add(BorderLayout.CENTER, board.mainPanel);
		 board.mainPanel.setVisible(true);
		 board.myFrame.setVisible(true); 
		 
		 board.infoPanel.append("WELCOME TO MONOPOLAYYLMAO\nEnter a number of players\n");
		 
		 
			 return board;
	}


	
}
