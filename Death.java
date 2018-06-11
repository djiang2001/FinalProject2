import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class Death extends JFrame{
    private Container pane;
    private JFrame death = new JFrame("Resurrect?");
    private JButton retry = new JButton("Resurrect");
    private JLabel backImage;
     
    public Death(){

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	retry.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    death.dispose();
		    new Game();
		    pane.remove(retry);
		    pane.revalidate();
		    setVisible(false);
		}
	    });

	backImage = new JLabel();
	backImage.setLayout(new FlowLayout(FlowLayout.CENTER));
	backImage.add(Box.createRigidArea(new Dimension(300,300)));

	backImage.setIcon(new ImageIcon("Death.png"));

	retry.setPreferredSize(new Dimension(200,50));

	retry.setLocation(100,100);

	retry.setFont(new Font("Times New Roman",Font.PLAIN,20));

	backImage.add(retry);
	backImage.add(Box.createRigidArea(new Dimension(400,400)));
	pane.add(backImage);
	this.pack();
	this.setVisible(true);

	this.setTitle("Death is Only A Beginning");
	this.setResizable(false);
	this.setSize(400,560);
	this.setLocation(700,250);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
	new Death();
    }
    
}
