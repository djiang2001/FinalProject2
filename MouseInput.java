import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Client client;
    private Camera camera;
    private Game game;
    private SpriteSheet ss;

    public MouseInput(Client client,Camera camera, Game game,SpriteSheet ss) {
	this.client = client;
	this.camera = camera;
	this.game = game;
	this.ss = ss;
    }

    public void mousePressed(MouseEvent e) {
	int mx = (int) (e.getX() + camera.getX());
	int my = (int) (e.getY() + camera.getY());

	for (int i = 0; i < client.getPiece().size(); i++) {
	    GamePiece tempPiece = client.getPiece().get(i);

	    if (tempPiece.getId() == ID.Player && game.numSpears >= 1) {
		client.addPiece(
				new Attack(tempPiece.getX() + 8, tempPiece.getY() + 12, ID.Sword, client,ss, mx, my));
		game.numSpears--;
	    }
	}
    }
}
