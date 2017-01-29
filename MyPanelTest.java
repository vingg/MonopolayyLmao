import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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


public class MyPanelTest{
	 private static void createAndShowGUI() {
		 JFrame myFrame = new JFrame("Sample Frame");
		 myFrame.setSize(750,600);
		 myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 
		 JPanel panel1 = new JPanel();
		 panel1.setLayout(new BorderLayout());
		 
		 JButton button = new JButton("The board will go here");
		 JTextArea output = new JTextArea(10, 20); 
		 JTextField input = new JTextField(30);
		 //these don't actually work yet, we'll still have to
		 //write the conditions for i/o
		 
		 output.setWrapStyleWord(true);
	     output.setEditable(false);
	     output.setLineWrap(true);
		 panel1.add(button, BorderLayout.CENTER);
		 panel1.add(output, BorderLayout.LINE_END);
	     panel1.add(input, BorderLayout.PAGE_END);
	     myFrame.getContentPane().add(BorderLayout.CENTER, panel1);
		 panel1.setVisible(true);
		 myFrame.setVisible(true); 
		
		 output.append("The quick brown fox jumps over the lazy dog.");
	 }
	 public static void main(String[] args) {
		 createAndShowGUI(); 
	 }
}