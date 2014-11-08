package controller;


import javax.media.opengl.GLAutoDrawable;

import view.BallView;
import model.Ball;
public class MasterController {
	
	
	private Ball ball;
	private BallView ballView;

	public MasterController(Ball ball, BallView ballView) {
		this.ball = ball;
		this.ballView = ballView;
	}
	public void update(float timeElapsedSeconds, GLAutoDrawable drawable) {
		

		
		//Change model state
		ball.update(timeElapsedSeconds);
		
		//Generate output
		ballView.render(drawable);
	}
}
