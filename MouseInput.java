import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Client client;
	private Camera camera;

	public MouseInput(Client client,Camera camera) {
		this.client = client;
		this.camera = camera;
	}

	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());

		for (int i = 0; i < client.piece.size(); i++) {
			GamePiece tempPiece = client.piece.get(i);

			if (tempPiece.getId() == ID.Player) {
				client.addPiece(
						new Attack(tempPiece.getX() + 16, tempPiece.getY() + 24, ID.Sword, client, mx, my));
			}
		}
	}
}
