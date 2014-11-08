package view;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

public class Core {
	
	void drawQuad(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(1, 1, 1);
//		gl.glBindTexture(GL.GL_TEXTURE0, texture.getTarget());
		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(x,      y);
		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(x + w, y);
		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(x + w, y + h);
		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(x,      y + h);
	
		gl.glEnd();
		gl.glDisable(GL.GL_TEXTURE_2D);
	}
	void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
   	 	GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();
        
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity(); // reset
        glu.gluOrtho2D (0.0, w, h, 0);  // define drawing area
        
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
        
        
   }
}
