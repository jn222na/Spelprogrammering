package view;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;

import model.Ball;
import model.Level;
import view.Camera;
import controller.MasterController;


public class BallView {
private Camera camera;
private Core core;
private Level level;
private Ball ball;
	public BallView(Ball ball, int width, int height){
		camera = new Camera();
		camera.setScale(width, height);
	}
	
	public void mCoordsToVisual(int x, int y){
		camera.Vcoords(x, y);
	}

	public void render(GLAutoDrawable drawable) {
		
		drawLevel(drawable);
		drawBall(drawable, ball);
		
	}
	private void drawBall(GLAutoDrawable drawable, Ball ball) {
		 float vx = camera.getVisualX(ball.centerX);
		 float vy = camera.getVisualY(ball.centerY);
		 float vBallSize = (ball.diameter * camera.getScale());
		 
		 core.drawQuad(drawable, vx - vBallSize / 2.0f, vy - vBallSize / 2.0f, vBallSize, vBallSize);
	}
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setScale(w, h);    
	}
	private void drawLevel(GLAutoDrawable drawable) {
		
				float w = camera.getScale();
				float h = camera.getScale();
					float vx = camera.getVisualX(w);
					float vy = camera.getVisualY(h);
					
					core.drawQuad(drawable, vx, vy, w, h);
			
		
	}
	
}
