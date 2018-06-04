import java.awt.*;
import java.util.*;
public class Enemy extends GamePiece{

    private Client client;
    int hp = 100;
    Random r = new Random();
    int choice = 0;
    
    public Enemy(int x,int y, ID id, Client client){
	super(x,y,id);
	this.client = client;
    }

    public void tick(){
	x += velX;
	y+= velY;

	choice = r.nextInt(10);
	
	for(int i = 0; i < client.piece.size(); i++){
	    GamePiece tempPiece = client.piece.get(i);

	    if(tempPiece.getId() == ID.Block){
	    }
	} //collision

	if(choice == 0){
	    velX = (r.nextInt(5 - -5) + -5);
	    velY = (r.nextInt(5 - -5) + -5);
	}
    }

	
    }

    public void render(Graphics g){
	g.setColor(Color.yellow);
	g.fillRect(x,y,32,32);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,32,32);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x-16, y - 16, 64, 64);
    }

}
