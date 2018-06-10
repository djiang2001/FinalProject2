import java.awt.*;
import java.awt.image.*;

public class Block extends GamePiece{

    private BufferedImage blockImage;

    public Block(int x, int y, ID id,SpriteSheet ss){
	super(x,y,id,ss);
	blockImage = ss.getImage(19,9,32,32);
    }

    public void tick(){

    }

    public void render(Graphics g){
	g.drawImage(blockImage,x,y,null);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,32,32);
    }
    
}
