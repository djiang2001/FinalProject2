import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    Client client;

    public KeyInput(Client client){
	this.client = client;
    }

    public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();

	for(int i = 0; i < client.piece.size(); i++){
	    GamePiece tempPiece = client.piece.get(i);

	    if(tempPiece.getId() == ID.Player){
		if(key == KeyEvent.VK_W) client.setUp(true);
		if(key == KeyEvent.VK_S) client.setDown(true);
		if(key == KeyEvent.VK_A) client.setLeft(true);
		if(key == KeyEvent.VK_D) client.setRight(true);
		
	    }
	    /*if(tempPiece.getId() == ID.Block){
	    if(key == KeyEvent.VK_L) client.setAttack(true);
	    }*/

	}

    }

    public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();

	
	for (int i = 0; i < client.piece.size(); i++) {
			GamePiece tempPiece = client.piece.get(i);

			if (tempPiece.getId() == ID.Player) {
				if (key == KeyEvent.VK_W)
					client.setUp(false);
				if (key == KeyEvent.VK_S)
					client.setDown(false);
				if (key == KeyEvent.VK_A)
				    client.setLeft(false);
				if (key == KeyEvent.VK_D)
				    client.setRight(false);
			}
			/*if(tempPiece.getId() == ID.Block){
	    		if(key == KeyEvent.VK_L) 
	    			client.setAttack(false);
	    }*/

	}

    }

    

}
