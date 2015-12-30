package opengl.assignment.lect5.midterm;

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

public class DrawManOpenGl extends JFrame implements GLEventListener {

	private float rquad = 50f;
    private float rtri = 90f;
	
    private static final long serialVersionUID = 1L;

	private GLCapabilities caps;;
	private GLCanvas canvas;
	private GLProfile glp;
	public static final int width = 500;
	public static final int height = 500;
    
    public DrawManOpenGl() {

		setTitle("Draw Man using OpenGL-JOGL binidng.");

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
    	DrawManOpenGl demo = new DrawManOpenGl();
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
		
	}
    
    void drawCircle(GL2 gl,float radius,float cx,float cy)
    {
       //gl.glLoadIdentity();
       gl.glColor3f(1.0f, 1.0f, 1.0f);
       gl.glBegin(GL.GL_LINE_LOOP);
     
       for (int i = 0; i <= 360; i++) {
				float x1, y1;
				x1 = (float) (radius * Math.sin(Math.toRadians(i))) + cx;
				y1 = (float) (radius * Math.cos(Math.toRadians(i))) + cy;
				gl.glVertex2d(x1,y1);
		}
     
       gl.glEnd();
    }
    
	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		final GL2 gl = arg0.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        
        //drawTriangle(gl);
        
        /*for (int i = 0; i < 360; i+=5) {
        	rotateRect(gl,200,200,50,50,i);
		}*/
        
        //gl.glPushMatrix();
        gl.glRotatef(45, 0, 0, 1);
        gl.glPushMatrix();
        
        drwaMan(gl);
        
        gl.glPopMatrix();
        //gl.glPopMatrix();
        
        
        gl.glFlush();
       
	}
	
	private void drwaMan(GL2 gl) {
		
		float radius = 50;
        float cx = 100, cy = 400; // center of circle
        int bodyAngel = 180; // draw line at angel
        float bodyLineLength = 150;
        int lineAngel = 270;

        // calculate first point of line 
        float px = (float) (radius * Math.sin(Math.toRadians(bodyAngel))) + cx;
        float py = (float) (radius * Math.cos(Math.toRadians(bodyAngel))) + cy;
        
        // draw head
        drawCircle(gl,radius,cx,cy);
        // draw line
        drawBoadyLine(gl,px,py,bodyLineLength,lineAngel);
        
        // drawhands
        drawHands(gl,px,py-50,225,315,100);
        
        // lags
        drawHands(gl,px,py-150,225,315,100);
	}

	private void drawHands(GL2 gl, float x, float y, int a1, int a2,int l) {

		//gl.glLoadIdentity();
		gl.glTranslatef(x, y, 0);
		gl.glRotatef(a1, 0, 0, 1);
		
		gl.glBegin(GL.GL_LINE_LOOP);
			gl.glVertex2f(0, 0);
			gl.glVertex2f(l, 0);
		gl.glEnd();
		
		//gl.glLoadIdentity();
		gl.glTranslatef(x, y, 0);
		gl.glRotatef(a2, 0, 0, 1);
		gl.glBegin(GL.GL_LINE_LOOP);
			gl.glVertex2f(0, 0);
			gl.glVertex2f(l, 0);
		gl.glEnd();
	}

	private void rotateLine(GL2 gl,int i, int j, int k, int l) {
		gl.glLoadIdentity();
		gl.glTranslatef(i, j, 0); // this will move our drawing and center is 0,0 now
        gl.glRotatef(l, 0f, 0f, 1.0f);
		gl.glBegin(GL.GL_LINE_LOOP);
			gl.glVertex2f(0, 0);
			gl.glVertex2f(k, 0);
		gl.glEnd();
	}

	private void drawBoadyLine(GL2 gl, float x, float y, float bodyLineLength, int bodyAngel) {
		//gl.glLoadIdentity();
		gl.glTranslatef(x, y, 0);
        gl.glRotatef(bodyAngel, 0f, 0f, 1.0f);
        
        gl.glBegin(GL.GL_LINE_LOOP);
        	gl.glVertex2f(0, 0);
        	gl.glVertex2f(bodyLineLength, 0);
        gl.glEnd();
        
	}

	private void rotateRect(GL2 gl,float x,float y,float width,float height,float angel) {
		//gl.glLoadIdentity();
        
		gl.glTranslatef(x, y, 0);
        gl.glRotatef(angel, 0f, 0f, 1.0f);
        
        gl.glBegin(GL.GL_LINE_LOOP);
	 	gl.glVertex2f(0, 0); // Bottom left
	 	gl.glVertex2f(0, height); // top left
	 	gl.glVertex2f(width, height); // top right
	 	gl.glVertex2f(width, 0); // bottom right
	 	gl.glEnd();
	 	
	}
	
	private void rotateRectAtZeroZero(GL2 gl,float x,float y,float width,float height,float angel) {
		gl.glLoadIdentity();
        gl.glRotatef(angel, 0.0f, 0.0f, 1.0f);
		 gl.glBegin(GL.GL_LINE_LOOP);
		 	gl.glVertex2f(x, y); // Bottom left
		 	gl.glVertex2f(x, y+height); // top left
		 	gl.glVertex2f(x+width, y+height); // top right
		 	gl.glVertex2f(x+width, y); // bottom right
		 gl.glEnd();
	}

	private void drawNewRect(GL2 gl,float x,float y,float width,float height) {
		gl.glLoadIdentity();
		 gl.glBegin(GL2.GL_LINE_LOOP);
		 	/*gl.glVertex3f(x, y, 0.0f); // Bottom left
		 	gl.glVertex3f(x, y+height, 0.0f); // top left
		 	gl.glVertex3f(x+width, y+height, 0.0f); // top right
		 	gl.glVertex3f(x+width, y, 0.0f); // bottom right*/
		 	gl.glVertex2f(x, y); // Bottom left
		 	gl.glVertex2f(x, y+height); // top left
		 	gl.glVertex2f(x+width, y+height); // top right
		 	gl.glVertex2f(x+width, y); // bottom right
		 gl.glEnd();
	}

	private void drawRectangle(GL2 gl) {
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
	}

	private void drawTriangle(GL2 gl) {
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
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);              // Enable Smooth Shading
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.1f);    // Black Background
        gl.glClearDepth(1.0f);                      // Depth Buffer Setup
        gl.glEnable(GL.GL_DEPTH_TEST);        // Enables Depth Testing
        gl.glDepthFunc(GL.GL_LEQUAL);        // The Type Of Depth Testing To Do
         
        // Really Nice Perspective Calculations
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST); 
        gl.glViewport(0, 0, width, height);
		
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
        System.out.println("H:"+height+" W:"+width+ " ratio:"+h);
        // don't need to call this according to jogl docs
        // gl.glViewport(0, 0, width, height);  
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        //glu.gluPerspective(45.0f, h, 1.0, 20.0);
        glu.gluOrtho2D(0.0f, width, 0.0f, height);
        
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
	}

}
