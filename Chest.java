import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.image.*;

public class Chest extends GamePiece{
    private BufferedImage chestImage;
    
    public Chest(int x, int y, ID id,SpriteSheet ss){
	super(x, y, id,ss);
	chestImage = ss.getImage(44,46,32,32);
	}
	
	public void tick(){
	
	}
	
	public void render(Graphics g){
	    g.drawImage(chestImage,x,y,null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
	
