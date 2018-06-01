import java.awt.*;

public abstract class GamePiece{
    private int x,y;
    private float velX = 0, velY = 0;
    private ID id;
	
    public GamePiece(int x, int y,ID id){
	this.x = x;
	this.y = y;
	this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public ID getId(){
	return id;
    }
    
    public int getX(){
	return x;
    }
	
    public void setX(int x){
	this.x = x;
    }
	
    public int getY(){
	return y;
    }
	
    public void setY(int y){
	this.y = y;
    }

    public float getVelX(){
	return velX;
    }

    public void setVelX(float velX){
	this.velX = velX;
    }

    public float getVelY(){
	return velY;
    }

    public void setVelY(float velY){
	this.velY = velY;
    }

	
}
