package opengl.assignment.lect5.midterm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class GUI extends JFrame{
	  int res;//store screen resolution here
	  static final int ds = 72;//default scale, 72 units/inch
	  
	  GUI(){//constructor
	    this.setSize(1028,900);
	    this.setVisible(true);
	    this.setTitle("Copyright 1999, R.G.Baldwin");
	       
	    //Window listener to terminate program.
	    this.addWindowListener(new WindowAdapter(){
	      public void windowClosing(WindowEvent e){
	        System.exit(0);}});
	  }//end constructor
	  
	  public void paint(Graphics g){
	    //Downcast the Graphics object to a Graphics2D object
	    Graphics2D g2 = (Graphics2D)g;
	    
	    int radius = 70;
	    int centerX = 200, centerY = 200;
	    Ellipse2D circle = new Ellipse2D.Double();
	    circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);

	    g2.draw(circle);
	    
	    g2.setColor(Color.blue);
	    g2.drawLine(200, 270, 200, 400);
	    
	    g2.setColor(Color.red);
	    AffineTransform t = new AffineTransform();
	    t.rotate(Math.toRadians(50),200,280);
	    g2.draw(t.createTransformedShape(new Line2D.Double(200, 280, 200, 380)));

	    AffineTransform t2 = new AffineTransform();
	    t2.rotate(Math.toRadians(315),200,280);
	    g2.draw(t2.createTransformedShape(new Line2D.Double(200, 280, 200, 380)));

	    
	    AffineTransform t1 = new AffineTransform();
	    t1.rotate(Math.toRadians(50),200,400);
	    g2.draw(t1.createTransformedShape(new Line2D.Double(200, 400, 200, 500)));
	    
	    AffineTransform t3 = new AffineTransform();
	    t3.rotate(Math.toRadians(315),200,400);
	    g2.draw(t3.createTransformedShape(new Line2D.Double(200, 400, 200, 500)));
	   
	    
	    drawManShape(g2);
	  }
	  
	  public void drawManShape(Graphics2D g2){
		  int radius = 70;
		  int centerX = 200, centerY = 200;
		  Ellipse2D circle = new Ellipse2D.Double();
		  circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		  Shape bodyLine = new Line2D.Double(200, 270, 200, 400);
		  
		  Shape leftHand = giveTrasformedLine(50, new Line2D.Double(200, 280, 200, 380));
		  Shape rightHand = giveTrasformedLine(315, new Line2D.Double(200, 280, 200, 380));
		  
		  Shape leftLeg = giveTrasformedLine(50, new Line2D.Double(200, 400, 200, 500));
		  Shape rightLeg = giveTrasformedLine(315, new Line2D.Double(200, 400, 200, 500));
		  
		  AffineTransform t = new AffineTransform();
		  t.translate(300, 300);
		  t.rotate(Math.toRadians(50),300,300);
		  
		  g2.draw(t.createTransformedShape(circle));
		  g2.draw(t.createTransformedShape(bodyLine));
		  g2.draw(t.createTransformedShape(leftHand));
		  g2.draw(t.createTransformedShape(rightHand));
		  g2.draw(t.createTransformedShape(leftLeg));
		  g2.draw(t.createTransformedShape(rightLeg));
	  }
	  
	  public Shape giveTrasformedLine(int angle,Line2D.Double line){
		  AffineTransform t = new AffineTransform();
		  t.rotate(Math.toRadians(angle),line.getX1(),line.getY1());
		  return t.createTransformedShape(line);
	  }
	  
	  public static void main(String[] args){
		    GUI guiObj = new GUI();
	  }
	}//end class GUI