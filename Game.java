import java.awt.*;
import java.awt.image.*;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private Client client;
    private BufferedImage level = null;
    private Camera camera;
    
    public Game(){
	new Window(1000, 563,"PlayersUnknownMaze", this);
	start();

	client = new Client();
	camera = new Camera(0,0);
	this.addKeyListener(new KeyInput(client));
	this.addMouseListener(new MouseInput(client,camera));

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
	for(int i = 0; i < client.piece.size(); i++){
	    if(client.piece.get(i).getId() == ID.Player){
		camera.tick(client.piece.get(i));
	    }
	}

	client.tick();
    }

    public void render(){
	BufferStrategy b = this.getBufferStrategy();
	if (b == null){
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics g = b.getDrawGraphics();
	Graphics2D g2d = (Graphics2D) g;
	//////////////////////////////
	g.setColor(Color.red);
	g.fillRect(0, 0, 1000, 563);

	g2d.translate(-camera.getX(),-camera.getY());

	client.render(g);

	g2d.translate(camera.getX(),-camera.getY());
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
		int yellow = (pixel);

		if (red == 255)
		    client.addPiece(new Block(xx * 32, yy * 32, ID.Block));

		if (blue == 255)
		    client.addPiece(new Adventurer(xx * 32, yy * 32, ID.Player, client));
	    
		if (green == 225)
		    client.addPiece(new Enemy(xx * 32, yy * 32, ID.Enemy, client));
	    }
	
	}
}
    
    public static void main(String[]args){

	new Game();
    
    }
}
