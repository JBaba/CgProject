package opengl.assignment.lect4.test;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class Renderer extends JFrame implements GLEventListener {

	private float rquad = 50f;
    private float rtri = 90f;
	
    private static final long serialVersionUID = 1L;

	private GLCapabilities caps;;
	private GLCanvas canvas;
	private GLProfile glp;
	public static final int width = 1028;
	public static final int height = 900;
    
    public Renderer() {

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
    
    public static void main(String[] args) {
    	Renderer demo = new Renderer();
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
		
	}
    
	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		final GL2 gl = arg0.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        gl.glRotatef(rtri, 0.0f, 0.0f, 1.0f);
        gl.glBegin(GL.GL_TRIANGLES);        // Drawing Using Triangles
	        gl.glColor3f(1.0f, 0.0f, 0.0f);   // Set the current drawing color to red
	        gl.glVertex3f(0.0f, 1.0f, 0.0f);  // Top
	        gl.glColor3f(0.0f, 1.0f, 0.0f);   // Set the current drawing color to green
	        gl.glVertex3f(-1.0f, -1.0f, 0.0f);  // Bottom Left
	        gl.glColor3f(0.0f, 0.0f, 1.0f);   // Set the current drawing color to blue
	        gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
        gl.glEnd();        // Finished Drawing The Triangle
        gl.glLoadIdentity();
        gl.glTranslatef(1.5f, 0.0f, -6.0f);
        gl.glRotatef(rquad, 0.0f, 0.0f, 1.0f);
        gl.glBegin(GL2.GL_QUADS);             // Draw A Quad
	        gl.glColor3f(0.5f, 0.5f, 1.0f);   // Set the current drawing color to light blue
	        gl.glVertex3f(-1.0f, 1.0f, 0.0f);  // Top Left
	        gl.glVertex3f(1.0f, 1.0f, 0.0f);  // Top Right
	        gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
	        gl.glVertex3f(-1.0f, -1.0f, 0.0f);  // Bottom Left
        gl.glEnd();        // Done Drawing The Quad
        gl.glFlush();
        rtri += 0.2f;
        rquad += 0.15f;
        
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
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);              // Enable Smooth Shading
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    // Black Background
        gl.glClearDepth(1.0f);                      // Depth Buffer Setup
        gl.glEnable(GL.GL_DEPTH_TEST);        // Enables Depth Testing
        gl.glDepthFunc(GL.GL_LEQUAL);        // The Type Of Depth Testing To Do
         
        // Really Nice Perspective Calculations
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST); 
        //gl.glViewport(0, 0, width, height);
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int x, int y, int width, 
            int height) {
		// TODO Auto-generated method stub
		final GL2 gl = arg0.getGL().getGL2();
        final GLU glu = new GLU();
 
        if (height <= 0) // avoid a divide by zero error!
            height = 1;
        final float h = (float) width / (float) height;
        // don't need to call this according to jogl docs
        // gl.glViewport(0, 0, width, height);  
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
	}

}
