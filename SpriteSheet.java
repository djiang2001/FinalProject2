import java.awt.image.*;

public class SpriteSheet{

    private BufferedImage image;

    public SpriteSheet(BufferedImage image){
	this.image = image;
    }

    public BufferedImage getImage(int col, int row, int width, int height){
	return image.getSubimage(col,row,width,height);
    }


}
