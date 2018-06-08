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
	    
	    if(tempPiece.getId() == ID.Player){
		if(getDetectionRadius().intersects(tempPiece.getBounds())){
		    velX = (tempPiece.getX() - velX) / Math.abs(tempPiece.getX() - velX);
	       	    velY = (tempPiece.getY() - velY) / Math.abs(tempPiece.getY() - velY);
		}else
		    if(choice == 0){
			velX = (r.nextInt(5 - -5) + -5);
			velY = (r.nextInt(5 - -5) + -5);
		    }
	    
	    
	    }

	    if(tempPiece.getId() == ID.Block){
		if(getOuterBounds().intersects(tempPiece.getBounds())){
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
	    if(tempPiece.getId() == ID.Sword){
	    	if(getBounds().intersects(tempPiece.getBounds())){
	    		hp -= 50;
	    		client.removePiece(tempPiece);
	    }
	}
    }
    if(hp <= 0) client.removePiece(this);
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

    public Rectangle getDetectionRadius(){
	return new Rectangle(x - 16, y - 16, 1000,1000);
    }
}
