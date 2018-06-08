import java.util.*;
import java.awt.*;

public class MouseInput extends MouseAdapter{

    private Client client;

    public MouseInput(Client client){
	this.client = client;
	this.camera = camera;
    }

    public void MousePressed(MouseEvent e){
	int mx = (int) (e.getX() + camera.getX());
	int my = (int) (e.getY() + camera.getY());

	for(int i = 0; i < client.piece.size();i++){
	    GamePiece tempPiece = client.piece.get(i);

	    if(tempObject.getId() == Player){
		handler.addObject(new Attack(tempObject.getX() + 16, tempObject.getY() + 24, ID.Attack,client));
	    }
	}
    }





}
