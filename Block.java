import java.awt.*;

public class Block extends GamePiece{

    public Block(int x, int y, ID id,SpriteSheet ss){
	super(x,y,id,ss);
    }

    public void tick(){

    }

    public void render(Graphics g){
	g.setColor(Color.black);
	g.fillRect(x,y,32,32);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,32,32);
    }
    
}
