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

public class RotatePentagonUsingOpenGL extends JFrame implements GLEventListener {

	private static final long serialVersionUID = 1L;

	private GLCapabilities caps;;
	private GLCanvas canvas;
	private GLProfile glp;
	public static final int width = 1028;
	public static final int height = 900;

	public RotatePentagonUsingOpenGL() {

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

	public void drawSquere(Graphics g) {
	}

	public void drawTriangle(Graphics g) {

	}

	public static void main(String[] args) {
		RotatePentagonUsingOpenGL demo = new RotatePentagonUsingOpenGL();
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
		rotatePentagone(arg0);
	}

	private void rotatePentagone(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		
		drawPentagon(gl, 150, 500, 600);
		for (int i = 31; i < 35; i++) {
			drawPentagonAtAngel(gl,i,150,500,600);
		}

	}

	private void drawPentagonAtAngel(GL2 gl,int angel,int r,int x,int y) {
		
		for (int i = 0; i < 6; i++) {
			float x1, y1, x2, y2;
			x1 = (float) (r * Math.sin(Math.toRadians(i * 72))) + x;
			y1 = (float) (r * Math.cos(Math.toRadians(i * 72))) + y;
			
			x2 = (float) (r * Math.sin(Math.toRadians((i + 1) * 72))) + x;
			y2 = (float) (r * Math.cos(Math.toRadians((i + 1) * 72))) + y;
			
			rotatePentagon(gl,x1,y1,x2,y2,angel,x,y);
		}
	}

	private void rotatePentagon(GL2 gl,float x1, float y1,float x2, float y2, int angel, int x, int y) {
		x1 = giveMeRotatedXCoordinate(x1,y1,angel,x,y);
		y1 = giveMeRotatedYCoordinate(x1,y1,angel,x,y);
		
		x2 = giveMeRotatedXCoordinate(x2,y2,angel,x,y);
		y2 = giveMeRotatedYCoordinate(x2,y2,angel,x,y);
		
		drawLine(gl, x1, y1, x2, y2);
	}

	private float giveMeRotatedXCoordinate(float x,float y,int angel,int pivotx,int pivoty) {
		x = (float) (pivotx +( (x-pivotx) * Math.cos(Math.toRadians(angel)) ) - ((y-pivoty)*Math.sin(Math.toRadians(angel))) ) ;
		return x;
	}

	private float giveMeRotatedYCoordinate(float x,float y,int angel,int pivotx,int pivoty) {
		y = (float) (pivoty +( (x-pivotx) * Math.sin(Math.toRadians(angel)) ) + ((y-pivoty)*Math.cos(Math.toRadians(angel))) ) ;
		return y;
	}


	/**
	 * draw pentagon using polar coordinates
	 * 
	 * @param gl
	 * @param r
	 * @param x
	 * @param y
	 */
	private void drawPentagon(GL2 gl, int r, int x, int y) {
		for (int i = 0; i < 6; i++) {
			float x1, y1, x2, y2;
			x1 = (float) (r * Math.sin(Math.toRadians(i * 72))) + x;
			y1 = (float) (r * Math.cos(Math.toRadians(i * 72))) + y;
			x2 = (float) (r * Math.sin(Math.toRadians((i + 1) * 72))) + x;
			y2 = (float) (r * Math.cos(Math.toRadians((i + 1) * 72))) + y;
			drawLine(gl, x1, y1, x2, y2);
		}
	}

	/**
	 * method to draw line between to points
	 * 
	 * @param gl
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	private void drawLine(GL2 gl, float x1, float y1, float x2, float y2) {
		gl.glBegin(GL.GL_LINES);
		gl.glVertex2f(x1, y1);
		gl.glVertex2f(x2, y2);
		gl.glEnd();
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
