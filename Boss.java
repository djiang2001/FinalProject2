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
			x += (velX * 2) * -1;
			y += (velY * 2) * -1;
			velX *=  -1;
			velY *=  -1;
		    }else
			if(choice == 0){
			    velX = (r.nextInt(2*5+1) -5);
			    velY = (r.nextInt(2*5+1) -5);
			    }
		} else if(tempPiece.getId() == ID.Player){
		    if(getOuterBounds().intersects(tempPiece.getBounds())){
			velX = (tempPiece.getX() - x)/ 100;
			velY = (tempPiece.getY() - y) / 100;
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
	return new Rectangle(x,y,15,15);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x - 8 ,y - 8,32,32);
    }
    public Rectangle getDetectionRadius(){
	return new Rectangle(x - 8, y - 8, 500,500);
    }
}

