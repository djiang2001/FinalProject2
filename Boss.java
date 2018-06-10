import java.awt.*;
import java.util.*;

public class Boss extends GamePiece{

    private Client client;
    int hp = 1000;

    
    public Boss(int x,int y, ID id, Client client,SpriteSheet ss){
	super(x,y,id,ss);
	this.client = client;
    }

    public void tick(){
	velX = 1;
	velY = 1;
	x += velX;
	y += velY;

	
	for(int i = 0; i < client.piece.size(); i++){
	    GamePiece tempPiece = client.piece.get(i);


	    if(tempPiece.getId() == ID.Block){
		if(getOuterBounds().intersects(tempPiece.getBounds())){
		    x += (velX*5) *-1;
		    y += (velY*5)* -1;
		    velX = velX * -1;
		    velY = velY * -1;
		    //collision
		} 
	    }
	}
    }
	
    
    public void render(Graphics g){
	g.setColor(Color.green);
	g.fillRect(x,y,150,150);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,150,150);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x + 10 ,y + 10,180,180);
    }
	
}
