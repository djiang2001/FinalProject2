public class Camera{
    private float x,y;

    public Camera(float x, float y){
	this.x = y;
	this.y = y;
    }


    public void tick(GamePiece piece){
	//camera movement
	x+= ((piece.getX() - x) - 1000/2) * 0.05f;
	y+= ((piece.getY() - y) - 563/2) * 0.05f;

	//collision camera
	if(x<= 0) x = 0;
	if(x >= 1100) x = 1100;
	if(y <= 0) y = 0;
	if(y >= 663) y = 663;
    }

    public float getX(){
	return x;
    }

    public void setX(float x){
	this.x = x;
    }

    public float getY(){
	return y;
    }

    public void setY(float y){
	this.y = y;
    }
}
