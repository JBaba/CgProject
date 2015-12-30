package opengl.assignment.lect4.test;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL2.*;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

/**
 *
 * This Class is example of drawing circle using points. And Also draw pentagon
 * inside circle.
 * 
 * Draw Pentagon by getting polar coordinates for 5 diff angel which can be
 * calculated by (360/5 = 72).
 * 
 * 
 * Note : Drawing circle using points in OpenGL is removes problem that we had 
 * 			 when we used Java3D. Because we calculate polar coordinates for 0-360
 *           angels which is floating point values. And after drawing point which takes
 *           floating point arguments.
 * 
 * @author nviradia
 *
 */

public class RotateRectUsingOpenGL extends JFrame implements GLEventListener {

	private static final long serialVersionUID = 1L;

	private GLCapabilities caps;;
	private GLCanvas canvas;
	private GLProfile glp;
	public static final int width = 1028;
	public static final int height = 900;

	public RotateRectUsingOpenGL() {

		setTitle("Draw Pentagon insde crircle using OpenGL-JOGL binidng.");

		glp = GLProfile.getDefault();

		caps = new GLCapabilities(glp);
		caps.setDoubleBuffered(false);

		System.out.println(caps.toString());

		canvas = new GLCanvas(caps);
		canvas.addGLEventListener(this);
		//
		getContentPane().add(canvas);
	}

	public void drawRect(GL2 gl) {
		
		gl.glBegin(GL_LINE_LOOP);
			gl.glVertex2f(100, 100);
			gl.glVertex2f(100, 200);
			gl.glVertex2f(300, 200);
			gl.glVertex2f(300, 100);
		gl.glEnd();
		
	}
	
	public void rotateRect(GL2 gl,int angel,int startX,int startY,int width,int height) {
		float x,y;
		float pivotx, pivoty;
		pivotx = startX;
		pivoty = startY;
		
		gl.glBegin(GL_LINE_LOOP);
			x=startX;
			y=startY;
			x = giveMeRotatedXCoordinate(x,y,angel,pivotx,pivoty);
			y = giveMeRotatedYCoordinate(x,y,angel,pivotx,pivoty);
			gl.glVertex2f(x, y);
			
			x=startX;
			y=startY+height;
			x = giveMeRotatedXCoordinate(x,y,angel,pivotx,pivoty);
			y = giveMeRotatedYCoordinate(x,y,angel,pivotx,pivoty);
			gl.glVertex2f(x, y);
			
			x=startX+width;
			y=startY+height;
			x = giveMeRotatedXCoordinate(x,y,angel,pivotx,pivoty);
			y = giveMeRotatedYCoordinate(x,y,angel,pivotx,pivoty);
			gl.glVertex2f(x, y);
			
			x=startX+width;
			y=startY;
			x = giveMeRotatedXCoordinate(x,y,angel,pivotx,pivoty);
			y = giveMeRotatedYCoordinate(x,y,angel,pivotx,pivoty);
			gl.glVertex2f(x, y);
			
		gl.glEnd();
		
	}
	
	private float giveMeRotatedXCoordinate(float x,float y,int angel,float pivotx,float pivoty) {
		x = (float) (pivotx +( (x-pivotx) * Math.cos(Math.toRadians(angel)) ) - ((y-pivoty)*Math.sin(Math.toRadians(angel))) ) ;
		return x;
	}

	private float giveMeRotatedYCoordinate(float x,float y,int angel,float pivotx,float pivoty) {
		y = (float) (pivoty +( (x-pivotx) * Math.sin(Math.toRadians(angel)) ) + ((y-pivoty)*Math.cos(Math.toRadians(angel))) ) ;
		return y;
	}
	
	private void drawCircle(GL2 gl, int r, int x, int y) {
		for (int i = 0; i <= 360; i++) {
			for (int j = 0; j < 4; j++) {
				float x1, y1;
				x1 = (float) (r * Math.sin(Math.toRadians(i + (j * .25)))) + x;
				y1 = (float) (r * Math.cos(Math.toRadians(i + (j * .25)))) + y;
				drawPoint(gl, x1, y1);
			}
		}

	}
	
	private void drawPoint(GL2 gl, float x, float y) {
		gl.glBegin(GL.GL_POINTS);
		gl.glVertex3f(x, y, 0);
		gl.glEnd();
	}


	public static void main(String[] args) {
		RotateRectUsingOpenGL demo = new RotateRectUsingOpenGL();
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
		
	}

	void setup(GL2 gl2, int width, int height) {
		gl2.glMatrixMode(GL2.GL_PROJECTION);
		gl2.glLoadIdentity();

		// coordinate system origin at lower left with width and height same as
		// the window
		GLU glu = new GLU();
		glu.gluOrtho2D(0.0f, width, 0.0f, height);

		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glLoadIdentity();

		gl2.glViewport(0, 0, width, height);
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		drawRect(gl);
		
		// draw rect 1 to 20 angel
		for (int i = 1; i < 20; i++) {
			rotateRect(gl, i,100,100,200,100);
		}
		
		// draw rect 22 to 30 angel
		gl.glColor3f(0, 1, 0);
		for (int i = 22; i < 30; i++) {
			rotateRect(gl, i,100,100,200,100);
		}
		
		// draw rect 32 to 40 angel
		gl.glColor3f(0, 0, 1);
		for (int i = 32; i < 40; i++) {
			rotateRect(gl, i,100,100,200,100);
		}
		
		gl.glColor3f(1, 0, 0);
		rotateRect(gl, 0,400,500,200,100);
		// draw circle at x 
		drawCircle(gl, 200, 400, 500);
		
		// draw rect 1 to 20 angel
		gl.glColor3f(1, 1, 1);
		for (int i = 3; i < 20; i++) {
			rotateRect(gl, i,400,500,200,100);
		}
		
		// draw rect 1 to 20 angel
		gl.glColor3f(1, 1, 0);
		for (int i = 23; i < 30; i++) {
			rotateRect(gl, i,400,500,200,100);
		}
		
		// draw rect 1 to 20 angel
		gl.glColor3f(1, 0, 1);
		for (int i = 33; i < 90; i++) {
			rotateRect(gl, i,400,500,200,100);
		}
		
		// draw rect 1 to 20 angel
		gl.glColor3f(0, 1, 1);
		for (int i = 95; i < 360; i++) {
			rotateRect(gl, i,400,500,200,100);
		}
		
		gl.glColor3f(1, 0, 0);
		// draw circle at x 
		drawCircle(gl, 200, 400, 500);
		
		//gl.glLoadIdentity();
		//gl.glPushMatrix();

		gl.glPushMatrix();
		gl.glEnable(GL_CULL_FACE); //discards triangles facing away from the camera
		//gl.glDisable(GL_CULL_FACE); //default, two-sided rendering
		gl.glEnable(GL_TEXTURE_2D);
		gl.glTranslatef(600, 100, 0);
		gl.glRotatef(20, 0.0f, 0.0f, 1.0f);
		
		rotateRect(gl, 0,600,100,200,100);
		
		gl.glBegin(GL2.GL_QUADS);
		
		 	gl.glTexCoord3f(600, 100,0); 
		 	//gl.glVertex3f(-600, -100, 0.0f); 
		 	gl.glTexCoord3f(600, 300,0); 
		 	//gl.glVertex3f(-600, 300, 0.0f); 
		 	gl.glTexCoord3f(700, 300,0); 
		 	//gl.glVertex3f(700, 300, 0.0f);   
		 	gl.glTexCoord3f(700, 100,0); 
		 	//gl.glVertex3f(700, -100, 0.0f); 
		
		gl.glEnd();
		
		//gl.glRotatef(-20,0,0,1);
		//gl.glTranslatef(-600, -100, 0);	
		gl.glDisable(GL_TEXTURE_2D);
		gl.glPopMatrix();
	}


	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable glDrawable) {

		GL gl = glDrawable.getGL();
		// set color
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		setup(gl.getGL2(), width, height);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

}
