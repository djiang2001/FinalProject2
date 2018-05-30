
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    
    public Game(){
	new Window(1000, 563,"PlayersUnknownMaze", this);
	
    }
    
    private void start() {
	isRunning = true;
	thread = new Thread(this);
	thread.start();
    }

    private void stop() {
	isRunning = false;
	try {
	    thread.join();
	} catch (InterruptedException e) {
	}
    }

    public void run() {

    }

    public void tick(){

    }

    public void render(){

    }
    
    public static void main(String[]args){
	new Game();
    }
}
