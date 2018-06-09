import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Adventurer extends GamePiece {

	Client client;
	Game game;

	public Adventurer(int x, int y, ID id, Client client, Game game) {
		super(x, y, id);
		this.client = client;
		this.game = game;
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

			GamePiece tempPiece = client.piece.get(i);

			if (tempPiece.getId() == ID.Block) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			if (tempPiece.getId() == ID.Chest) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					game.numSpears += 10;
					game.myHp += 50;
					client.removePiece(tempPiece);
				}
			}
			
			if (tempPiece.getId() == ID.Enemy) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					game.myHp--;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 16, 24);

	}

	public Rectangle getBounds() {
	    return new Rectangle(x, y, 16,24);
	}

}
