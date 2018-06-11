import java.awt.*;
import java.util.*;
import java.awt.image.*;

public class Enemy extends GamePiece{

    private Client client;
    private BufferedImage enemyImage;
    int hp = 100;
    Random r = new Random();
    int choice = 0;
    
    public Enemy(int x,int y, ID id, Client client,SpriteSheet ss){
	super(x,y,id,ss);
	this.client = client;
	enemyImage = ss.getImage(7,9,32,32);
    }

    public void tick(){
	x += velX;
	y+= velY;

	choice = r.nextInt(10);
	
	for(int i = 0; i < client.getPiece().size(); i++){
	    GamePiece tempPiece = client.piece.get(i);
	    

		if(tempPiece.getId() == ID.Block){
		    if(getOuterBounds().intersects(tempPiece.getBounds())){
			x += (velX * 2) * -1;
			y += (velY * 2) * -1;
			velX *=  -1;
			velY *=  -1;
		    }else
			if(choice == 0){
			    velX = (r.nextInt(2*2+1) -2);
			    velY = (r.nextInt(2*2+1) - 2);
			}
		}


	    
	    if(tempPiece.getId() == ID.Sword){
	    	if(getBounds().intersects(tempPiece.getBounds())){
		    hp -= 25;
		    client.removePiece(tempPiece);
		}
	    }
	}
		if(hp <= 0){
			client.removePiece(this);
		}
    }

    public void render(Graphics g){
	g.drawImage(enemyImage,x,y,null);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,15,15);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x-8, y - 8, 32, 32);
    }
}
