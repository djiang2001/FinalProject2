import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.*;

public class Adventurer extends GamePiece {

	Client client;
	Game game;
    private BufferedImage adventImage;
    
    public Adventurer(int x, int y, ID id, Client client, Game game,SpriteSheet ss) {
	super(x, y, id,ss);
		this.client = client;
		this.game = game;

		adventImage = ss.getImage(8,10,32,32);
	}

	public void tick() {
		x += velX;
		y += velY;

		collision();
		// Movement
		if (client.isUp())
			velY = -5;
		else if (!client.isDown())
			velY = 0;

		if (client.isDown())
			velY = 5;
		else if (!client.isUp())
			velY = 0;

		if (client.isRight())
			velX = 5;
		else if (!client.isLeft())
			velX = 0;

		if (client.isLeft())
			velX = -5;
		else if (!client.isRight())
			velX = 0;
	}

	private void collision() {
		for (int i = 0; i < client.piece.size(); i++) {


		    GamePiece tempPiece = client.getPiece().get(i);

			if (tempPiece.getId() == ID.Block) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			if (tempPiece.getId() == ID.Chest) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					
					if(game.myHp < 100 && game.numSpears < 100){
						game.myHp += 20;
						game.numSpears += 10;
						client.removePiece(tempPiece);
					}
					else if(game.myHp == 100 && game.numSpears < 100){
					    game.myHp = 100;
					    game.numSpears += 10;
					    client.removePiece(tempPiece);
					}
					else{
						game.myHp = 100;
						game.numSpears = 100;
						client.removePiece(tempPiece);
					}
				}
			}
			
			if (tempPiece.getId() == ID.Enemy) {
			    if (getBounds().intersects(tempPiece.getBounds())) {
				game.myHp-= .25;
			    }
			}

			if (tempPiece.getId() == ID.Boss){
			    if(getBounds().intersects(tempPiece.getBounds())){
				game.myHp --;
			    }
			}
		}
	}
	
	public void render(Graphics g) {
	    g.drawImage(adventImage,x,y,null);

	}

	public Rectangle getBounds() {
	    return new Rectangle(x, y, 16,24);
	}

}
