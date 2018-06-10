import java.awt.*;
import java.util.*;
import java.awt.image.*;

public class Boss extends GamePiece{

    private Client client;
    private BufferedImage bossImage;
    int choice = 0;
    Random r = new Random();
    int hp = 1000;

    
    public Boss(int x,int y, ID id, Client client,SpriteSheet ss){
	super(x,y,id,ss);
	this.client = client;
	bossImage = ss.getImage(1,3,32,32);
    }

  public void tick(){
	x += velX;
	y+= velY;

	choice = r.nextInt(10);
	
	for(int i = 0; i < client.piece.size(); i++){
	    GamePiece tempPiece = client.getPiece().get(i);
	    

		if(tempPiece.getId() == ID.Block){
		    if(getOuterBounds().intersects(tempPiece.getBounds())){
			x += (velX * 5) * -4;
			y += (velY * 5) * -4;
			velX *=  -4;
			velY *=  -4;
		    }else
			if(choice == 0){
			    velX = (r.nextInt(4 - -4) + -4);
			    velY = (r.nextInt(4 - -4) + -4);
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
	g.drawImage(bossImage,x,y,null);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,32,32);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x + 10 ,y + 10,48,48);
    }
	
}
