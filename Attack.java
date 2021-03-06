import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.*;

public class Attack extends GamePiece {

    private Client client;
    private BufferedImage spearImage;
    
    public Attack(int x, int y, ID id, Client client,SpriteSheet ss, int mx, int my) {
	super(x, y, id,ss);
	this.client = client;
	velX = (mx - x)/10;
	velY = (my - y)/10;
	spearImage = ss.getImage(17,30,32,32);
    }

    public void tick() {
		x += velX;
		y += velY;

		for (int i = 0; i < client.getPiece().size(); i++) {
		    GamePiece tempPiece = client.getPiece().get(i);

			if (tempPiece.getId() == ID.Block) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					client.removePiece(this);
				}
			}
		}
	}

	public void render(Graphics g) {
	    g.drawImage(spearImage,x,y,null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
