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
	y += velY;

	choice = r.nextInt(10);
	
	for(int i = 0; i < client.piece.size(); i++){
	    GamePiece tempPiece = client.piece.get(i);


	    if(tempPiece.getId() == ID.Block){
		if(getBounds().intersects(tempPiece.getBounds())){
		    x += (velX*2)*-1;
		    y += (velY*2)*-1;
		    velX = 0;
		    velY = 0;
		    //collision
		} else
		    if(choice == 0){
			velX = (r.nextInt(5 - -5) + -5);
			velY = (r.nextInt(5 - -5) + -5);
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
	return new Rectangle(x - 75,y - 75,300,300);
    }
	
}
