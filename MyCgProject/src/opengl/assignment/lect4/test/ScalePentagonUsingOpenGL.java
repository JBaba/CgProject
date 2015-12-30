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

public class ScalePentagonUsingOpenGL extends JFrame implements GLEventListener {

	private static final long serialVersionUID = 1L;

	private GLCapabilities caps;;
	private GLCanvas canvas;
	private GLProfile glp;
	public static final int width = 1028;
	public static final int height = 900;

	public ScalePentagonUsingOpenGL() {

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
		ScalePentagonUsingOpenGL demo = new ScalePentagonUsingOpenGL();
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
		
		drawPentagon(gl, 150, 150, 600);
		scalePentagon(gl,0.9f,150,150,600);
		scalePentagon(gl,0.8f,150,150,600);
		scalePentagon(gl,0.7f,150,150,600);
		scalePentagon(gl,0.6f,150,150,600);
		scalePentagon(gl,0.5f,150,150,600);
	}
	
	
	private void scalePentagon(GL2 gl,float d, int r, int x, int y) {
		for (int i = 0; i < 6; i++) {
			float x1, y1, x2, y2;
			x1 = (float) (r * Math.sin(Math.toRadians(i * 72))) + x;
			y1 = (float) (r * Math.cos(Math.toRadians(i * 72))) + y;
			
			x2 = (float) (r * Math.sin(Math.toRadians((i + 1) * 72))) + x;
			y2 = (float) (r * Math.cos(Math.toRadians((i + 1) * 72))) + y;
			
			scale(gl,x1,y1,x2,y2,d,x,y);
		}
	}

	private void scale(GL2 gl, float x1, float y1, float x2, float y2, float d, int x, int y) {
	
		x1 = x + ((x1 - x) * d);
		y1 = y + ((y1 - y) * d);
		x2 = x + ((x2 - x) * d);
		y2 = y + ((y2 - y) * d);
		
		drawLine(gl, x1, y1, x2, y2);
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

	private void render(GLAutoDrawable arg0) {
		// drawTriangle(arg0);
		GL2 gl = arg0.getGL().getGL2();
		gl.glColor3f(0, 1, 0);
		drawCircle(gl, 200, 400, 200);
		gl.glColor3f(0, 1, 1);
		drawPentagon(gl, 200, 400, 200);
		gl.glColor3f(1, 1, 0);
		//drawPentagon(gl, 150, 400, 600);
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

	/**
	 * draw Circle using polar cordinates.
	 * 
	 * @param gl
	 * @param r
	 * @param x
	 * @param y
	 */
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

	/**
	 * draw point at given coordinates
	 * 
	 * @param gl
	 * @param x
	 * @param y
	 */
	private void drawPoint(GL2 gl, float x, float y) {
		gl.glBegin(GL.GL_POINTS);
		gl.glVertex3f(x, y, 0);
		gl.glEnd();
	}

	/**
	 * draw triangle
	 * 
	 * @param arg0
	 */
	private void drawTriangle(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		GL2 gl2 = arg0.getGL().getGL2();
		gl2.glClear(GL.GL_COLOR_BUFFER_BIT);

		// draw a triangle filling the window
		gl2.glLoadIdentity();
		gl2.glBegin(GL.GL_TRIANGLES);
		gl2.glColor3f(1, 0, 0);
		gl2.glVertex2f(0, 0);
		gl2.glColor3f(0, 1, 0);
		gl2.glVertex2f(width, 0);
		gl2.glColor3f(0, 0, 1);
		gl2.glVertex2f(width / 2, height);
		gl2.glEnd();
	}

	private void update() {
		// TODO Auto-generated method stub

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
