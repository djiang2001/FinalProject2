import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
	public String name = "PlayerUnknownMaze";
	private Container c;
	private JFrame menuscreen;
	private JButton startbutton;
	private JButton instructions;
	public Main(){
		menuscreen = new JFrame("Breakout Menu Screen");
		startbutton = new JButton("PLAY");
		startbutton.setPreferredSize(new Dimension(100,100));
		startbutton.setBounds(200,200,200,200);
		instructions = new JButton("HOW TO PLAY");
		instructions.setPreferredSize(new Dimension(100,100));
		instructions.setBounds(100,100,100,100);
		menuscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = menuscreen.getContentPane();
		this.setLayout(null);
		this.add(startbutton);
		c.add(this);
		this.add(instructions);
		c.add(this);
		this.setPreferredSize(new Dimension(1000,563));
		menuscreen.pack();
		menuscreen.setVisible(true);
		
	
	}
	public void paintComponent(Graphics g){
	
	}
	
	public static void main(String[] args){
		new Main();
	}
	
	public void actionPerformed(ActionEvent arg){
	
	}
}