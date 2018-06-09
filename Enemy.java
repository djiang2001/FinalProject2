import java.awt.*;
import java.util.*;
public class Enemy extends GamePiece{

    private Client client;
    int hp = 100;
    Random r = new Random();
    int choice = 0;
    int spawnX,spawnY;
    
    public Enemy(int x,int y, ID id, Client client){
	super(x,y,id);
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
	    

		if(tempPiece.getId() == ID.Player){
		    if(getDetectionRadius().intersects(tempPiece.getBounds())){
			float dist = (float) Math.sqrt((tempPiece.getX()-x)*(tempPiece.getX()-x) + (tempPiece.getY()-y)*(tempPiece.getY()-y));
			velX = (tempPiece.getX() - x) / dist;
			velY = (tempPiece.getY() - x) / Math.abs(tempPiece.getY() - velY)/ dist;
		    }else
			if(choice == 0){
			    velX = (r.nextInt(5 - -5) + -5);
			    velY = (r.nextInt(5 - -5) + -5);
			}
		}


	    
	    if(tempPiece.getId() == ID.Sword){
	    	if(getBounds().intersects(tempPiece.getBounds())){
		    hp -= 20;
		    client.removePiece(tempPiece);
		}
	    }
	}
	if(hp <= 0){
	    x = spawnX;
	    y = spawnY;
	    hp = 100;

	};
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

    public Rectangle getDetectionRadius(){
	return new Rectangle(x - 4, y - 4, 500,500);
    }
}
