import java.awt.*;
public abstract class GamePiece{
    int x,y;
    float velX = 0, velY = 0;
	
    public GamePiece(int x, int y){
	this.x = x;
	this.y = y;
	ID id;
    }

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
