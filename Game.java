
import java.awt.Canvas;

public class Game extends Canvas{

    public Game(){
	new Window(1000, 563,"PlayersUnknownMaze", this);
	
    }
    
    
    public static void main(String[]args){
	new Game();
    }
}
