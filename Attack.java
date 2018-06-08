import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

public class Attack extends GamePiece {

	private Client client;

	public Attack(int x, int y, ID id, Client client, int mx, int my) {
		super(x, y, id);
		this.client = client;

		/*	int dX = mx - x;
		int dY = my - y;
		double dist = Math.sqrt(x*x + y*y);*/
		velX = (mx - x) / 10;//(int) (30 * dX/dist);
		velY = (my - y) / 10; //(int) (30 * dY/dist);
	}

	public void tick() {
		x += velX;
		y += velY;

		for (int i = 0; i < client.piece.size(); i++) {
			GamePiece tempPiece = client.piece.get(i);

			if (tempPiece.getId() == ID.Block) {
				if (getBounds().intersects(tempPiece.getBounds())) {
					client.removePiece(this);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 10, 10);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}

}
