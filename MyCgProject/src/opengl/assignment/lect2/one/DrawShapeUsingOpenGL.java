package opengl.assignment.lect2.one;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class DrawShapeUsingOpenGL extends JFrame implements GLEventListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GLCapabilities caps;;
	private GLCanvas canvas;
	private GLProfile glp;
	 
	  //
	  public DrawShapeUsingOpenGL()
	  {
		glp = GLProfile.getDefault();
		
	    caps = new GLCapabilities(glp);
	    caps.setDoubleBuffered(false);
	    
	    System.out.println(caps.toString());
	    
	    canvas = new GLCanvas(caps);
	    canvas.addGLEventListener(this);
	    //
	    getContentPane().add(canvas);
	  }
	
	
	public void drawSquere(Graphics g){
	}
	
	public void drawTriangle(Graphics g){
		
	}
	
	public static void main(String[] args) {
		DrawShapeUsingOpenGL demo = new DrawShapeUsingOpenGL();
    	demo.setSize(600, 600);
    	demo.setVisible(true);
    	demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		//GL gl = arg0.getGL();
		
		update();
	    render(arg0);
		
		
	}


	private void render(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		GL2 gl = arg0.getGL().getGL2();
		gl.glBegin(GL.GL_TRIANGLES);
	    gl.glColor3f(1, 0, 0);
	    gl.glVertex2f(-1, -1);
	    gl.glColor3f(0, 1, 0);
	    gl.glVertex2f(0, 1);
	    gl.glColor3f(0, 0, 1);
	    gl.glVertex2f(1, -1);
	    gl.glEnd();
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
		//set color
	    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}


	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}
	
}
