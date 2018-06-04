import java.awt.*;
import java.util.*;

public class Boss extends GamePiece{

    private Client client;
    int hp = 1000;

    public Boss(int x,int y, ID id, Client client){
	GamePiece tempPiece = client.piece.get(i);

	if(tempPiece.getId() == ID.Block){
	}
	//collision

	
    }

    public void tick(){
	v += velX;
	y+= velY;
	
    }
    
    public void render(Graphics g){
	g.setColor(Color.green);
	g.fillRect(x,y,150,150);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,150,150);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x - 75,y - 75,300,300);
    }
	
}
