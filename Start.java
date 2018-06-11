import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class Start extends JFrame {
    private Container pane;
    private JFrame home = new JFrame("Start Page");
    private JButton start = new JButton("Start");
    private JLabel backImage;
    public Start() {
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    home.dispose();
		    new Story();
		}
	    });
	/*
	instructions.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    home.dispose();
		    new Instructions();
		}
	    });*/
	
	backImage = new JLabel();
	backImage.setLayout(new FlowLayout(FlowLayout.CENTER));
	backImage.add(Box.createRigidArea(new Dimension(300,300)));

	backImage.setIcon(new ImageIcon("TEXT HERE.png"));

	start.setPreferredSize(new Dimension(200,50));
	
	start.setLocation(100,100);

	start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	
	backImage.add(start);
	backImage.add(Box.createRigidArea(new Dimension(400,400)));
	pane.add(backImage);
	this.pack();
	this.setVisible(true);
	

	this.setTitle("MazeUnknown BattleGrounds");
	this.setResizable(false);
	this.setSize(500,500);
	this.setLocation(100,10);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
		new Start();
    }
}