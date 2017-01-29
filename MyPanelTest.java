import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;


public class MyPanelTest extends JFrame {
	private static void createAndShowGUI() {
		 JFrame myFrame = new JFrame("Sample Frame");
		 myFrame.setSize(750,600);
		 myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 
		 JPanel mainPanel = new JPanel();
		 mainPanel.setLayout(new BorderLayout());
		 
		 JButton boardPanel = new JButton("The board will go here");
		 JTextArea infoPanel = new JTextArea(10, 20); 
		 JTextField cmdPanel = new JTextField(30);
		 //these don't actually work yet, we'll still have to
		 //write the conditions for i/o
		 
		 //board image
		 ImageIcon icon = new ImageIcon("C:\\Users\\Laura\\Desktop\\MonopolayyLmao\\board.jpg"); //will change address later
		 JLabel boardImage = new JLabel(icon);
		 boardPanel.add(boardImage);
		 
		 infoPanel.setWrapStyleWord(true);
	     infoPanel.setEditable(false);
	     infoPanel.setLineWrap(true);
		 mainPanel.add(boardPanel, BorderLayout.CENTER);
		 mainPanel.add(infoPanel, BorderLayout.LINE_END);
	     mainPanel.add(cmdPanel, BorderLayout.PAGE_END);
	     myFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		 mainPanel.setVisible(true);
		 myFrame.setVisible(true); 
		
		 infoPanel.append("The quick brown fox jumps over the lazy dog.");
	 }
	
	public static void main(String[] args) {
		 createAndShowGUI(); 
	 }
}