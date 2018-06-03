import java.awt.*;
import java.awt.image.*;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private Client client;
    private BufferedImage level = null;
    
    
    public Game(){
	new Window(1200, 763,"PlayersUnknownMaze", this);
	start();

	client = new Client();

	this.addKeyListener(new KeyInput(client));

	Loader loader = new Loader();
	level = loader.loadImage("/Level1.png");

	loadLevel(level);
    }
    
    private void start() {
	isRunning = true;
	thread = new Thread(this);
	thread.start();
    }

    private void stop() {
	isRunning = false;
	try {
	    thread.join();
	} catch (InterruptedException e) {
	}
    }

    public void run() {
	this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				// updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				// updates = 0;
			}
		}
		stop();
    }

    public void tick(){

    }

    public void render(){
	BufferStrategy b = this.getBufferStrategy();
	if (b == null){
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics g = b.getDrawGraphics();
	Graphics2D g2 = (Graphics2D) g;
	//////////////////////////////
	g.setColor(Color.red);
	g.fillRect(0, 0, 1200, 763);

	

      	//////////////////////////////
	g.dispose();
	b.show();

    }

    
    // loading the level
    private void loadLevel(BufferedImage image) {
	int w = image.getWidth();
	int h = image.getHeight();

	for (int xx = 0; xx < w; xx++) {
	    for (int yy = 0; yy < h; yy++) {
		int pixel = image.getRGB(xx, yy);
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;

		if (red == 255)
		    client.addPiece(new Block(xx * 32, yy * 32, ID.Block));

		if (blue == 255)
		    client.addPiece(new Adventurer(xx * 32, yy * 32, ID.Player, client));
	    }
	}
    }
    
    public static void main(String[]args){
	new Game();
    }
}
