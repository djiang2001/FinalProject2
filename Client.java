import java.awt.Graphics;
import java.util.*;

public class Client{
    LinkedList<GamePiece> piece = new LinkedList<GamePiece>();
    private boolean up = false;
    private boolean down = false;
    private boolean right = false;
    private boolean left = false;

    public void tick(){
	for(int i = 0; i < piece.size(); i++){
	    GamePiece tempPiece = piece.get(i);
	    tempPiece.tick();
	}
    }

    public void render(Graphics g){
	for(int i = 0; i < piece.size(); i++){
	    GamePiece tempPiece = piece.get(i);
	    tempPiece.render(g);
	    
	}
    }

    public void addPiece(GamePiece tempPiece){
	piece.add(tempPiece);
    }

    public void removePiece(GamePiece tempPiece){
	piece.remove(tempPiece);
    }

    public LinkedList<GamePiece> getPiece(){
	return piece;
    }
    
    public void setPiece(LinkedList<GamePiece> piece){
	this.piece = piece;
    }

    public boolean isUp(){
	return up;
    }

    public void setUp(boolean up){
	this.up = up;
    }

    public boolean isDown(){
	return down;
    }

    public void setDown(boolean down){
	this.down = down;
    }

    public boolean isRight(){
	return right;
    }

    public void setRight(boolean right){
	this.right = right;
    }

    public boolean isLeft() {
	return left;
    }

    public void setLeft(boolean left){
	this.left = left;
    }
}
