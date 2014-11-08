import java.awt.Color;
import java.awt.Frame;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import model.Ball;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.opengl.util.FPSAnimator;

import controller.MasterController;
import view.BallView;

public class Startup implements GLEventListener {
	private static BallView ballView;
	private Ball ball;
	private static int width = 640;
	private static int height = 640;
	private long previousTime;
	private MasterController controller;
	
	
	
	public Startup(GLCanvas canvas) {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws Exception {
		//Creates window
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities capabilities = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(capabilities);
		Frame frame = new Frame("1_4");
		frame.setSize(width, height);
		frame.add(canvas);
		frame.setVisible(true);
		
		
		
//		frame.addWindowListener(new WindowAdapter() {
//	         public void windowClosing(WindowEvent windowEvent){
//	            System.exit(0);
//	         }        
//	      }); 
		
		canvas.addGLEventListener(new Startup(canvas));
//		FPSAnimator animator  = new FPSAnimator(canvas,60);
//		animator.start();
//		view = new BallView(width, height);
//		view.mCoordsToVisual(1,7);
		
	}
//	 public main(GLCanvas c) throws Exception {
//	    	model = new Model();
//	    	input = new Input();
//	    	ballView = new BallView(ball, width, height);
//	    	
//	    	controller = new MasterController(ball, ballView);
//	    }


	@Override
	public void display(GLAutoDrawable drawable) {
        long currentTime = System.currentTimeMillis();        
    	controller.update((float)((currentTime - previousTime) / 1000.0f), drawable);
        previousTime = currentTime;
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
				
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		reshape(drawable, 0, 0 , width, height);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		ballView.reshape(drawable, x, y, w, h);
    	previousTime = System.currentTimeMillis();
		
	}
}
