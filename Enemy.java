import java.awt.*;
import java.util.*;
public class Enemy extends GamePiece{

    private Client client;
    int hp = 100;
    Random r = new Random();
    int choice = 0;
    int spawnX,spawnY;
    
    public Enemy(int x,int y, ID id, Client client,SpriteSheet ss){
	super(x,y,id,ss);
	spawnX = x;
	spawnY = y;
	this.client = client;
    }

    public void tick(){
	x += velX;
	y+= velY;

	choice = r.nextInt(10);
	
	for(int i = 0; i < client.piece.size(); i++){
	    GamePiece tempPiece = client.piece.get(i);
	    

		if(tempPiece.getId() == ID.Block){
		    if(getOuterBounds().intersects(tempPiece.getBounds())){
			x += (velX * 5) * -1;
			y += (velY * 5) * -1;
			velX *=  -1;
			velY *=  -1;
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
	/*if(hp <= 0){
	    x = spawnX;
	    y = spawnY;
	    hp = 100;

	}*/
		if(hp <= 0){
			client.removePiece(this);
		}
    }

    public void render(Graphics g){
	g.setColor(Color.yellow);
	g.fillRect(x,y,15,15);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,15,15);
    }

    public Rectangle getOuterBounds(){
	return new Rectangle(x-8, y - 8, 32, 32);
    }
}
