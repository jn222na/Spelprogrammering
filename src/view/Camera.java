package view;
import view.BallView;

public class Camera {
	private int width;
	private int height;
	private int visualX;
	private int visualY;
	private static int lvlWidth = 8;
	private static int lvlHeight = 8;
	private static int scale;
	private int borderSize;
	
	Camera(){
	}
	
	
	public void Vcoords(int x, int y){
		visualX = x*scale+borderSize;
		visualY = y*scale+borderSize;
	}
	
	public void setScale(int width, int height){
		this.width = width;
		this.height = height;
		
		borderSize = height/10;
		if(this.width<this.height)
		{
			borderSize = width/10;
		}

		int scaleX = (this.width-borderSize*2) / lvlWidth;
		int scaleY = (this.height-borderSize*2) / lvlHeight;
		
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}
	}
	  public float getScale()
      {
          return scale;
      }
		
		public int getVisualY(){
			return visualY;
		}


		public float getVisualX(float centerX) {
			return visualX;
		}
		public float getVisualY(float centerX) {
			return visualY;
		}

}
