import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class Story extends JFrame {
  private static Container pane;
    private JFrame start = new JFrame("Introduction");
    private static JButton enter = new JButton("Continue");
    private static JTextArea intro = new JTextArea();
    private static String words = "In a realm far away, monsters of unknown creation were creating havoc. These monsters escape from the dreaded labyrinth, said to have been created by an ancient cult. Every few months, worthy heroes, unnamed, known as warriors unknown,  are sent in, only to never return. You have been chosen, and now you must face your fate. Save your people, or die trying...";

    //Game Intro Constructor
    public Story(){
	pane = this.getContentPane();
	this.setTitle("WarriorsUnkownMaze");
	this.setSize(500,500);
	this.setLocation(700 ,250);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//Add properties
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	enter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    new Game();
		    intro.append("Enter!");
		    pane.remove(enter);
		    pane.revalidate();
		    setVisible(false);
		}
	    }
	    );
	intro.setFont(new Font("Segoe Script",Font.ITALIC, 20));
	intro.setLineWrap(true);
	intro.setWrapStyleWord(true);
	intro.setEditable(false);
	pane.add(intro);
	pane.add(enter);
	enter.setVisible(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

  //Animation Code
  public static void appendtext(){
    for (int i = 0; i < words.length(); i++){
      intro.append(words.charAt(i) + "");
      /*try {
        Thread.sleep(40);}catch(Exception e){}*/
	}
    enter.setVisible(true);
  }

    //Main
    public static void main(String[]args){
	/*	Story intro = new Story();
  	intro.setVisible(true);
   	intro.setResizable(false);
	appendtext();
	*/
    }

}
