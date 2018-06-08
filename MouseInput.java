import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Client client;
	private Camera camera;
	private Game game;

	public MouseInput(Client client,Camera camera, Game game) {
		this.client = client;
		this.camera = camera;
		this.game = game;
	}

	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());

		for (int i = 0; i < client.piece.size(); i++) {
			GamePiece tempPiece = client.piece.get(i);

			if (tempPiece.getId() == ID.Player && game.numSpears >= 1) {
				client.addPiece(
						new Attack(tempPiece.getX() + 16, tempPiece.getY() + 24, ID.Sword, client, mx, my));
						game.numSpears--;
			}
		}
	}
}
