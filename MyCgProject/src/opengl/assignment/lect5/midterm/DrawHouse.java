package opengl.assignment.lect5.midterm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class DrawHouse extends JFrame{
	  int res;//store screen resolution here
	  static final int ds = 72;//default scale, 72 units/inch
	  int mx,my;
	  DrawHouse(){//constructor
	    this.setSize(1028,900);
	    this.setVisible(true);
	    this.setTitle("Copyright 1999, R.G.Baldwin");
	       
	    //Window listener to terminate program.
	    this.addWindowListener(new WindowAdapter(){
	      public void windowClosing(WindowEvent e){
	        System.exit(0);}});
	    
	    this.addMouseMotionListener(new MouseMotionAdapter() {
	    	@Override
	    	public void mouseMoved(java.awt.event.MouseEvent e) {
	    		//super.mouseMoved(e);
	    		
	    	}
	    	
		});
	    
	    this.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			mx=e.getX();
    		my=e.getY();
    		System.out.println("("+mx+","+my+")");
    		validate();
    		repaint();	
		}
	    
	    });
	  }//end constructor
	  
	  @Override
	  public void paint(Graphics g){
	    //Downcast the Graphics object to a Graphics2D object
	    Graphics2D g2 = (Graphics2D)g;
	    
	    g2.drawRect(10, 300, 310, 200);
	    g2.drawRect(105, 400, 60, 100);
	    g2.drawLine(10, 300, 165, 200);
	    g2.drawLine(320, 300, 165, 200);
	    g2.drawLine(69, 256, 69, 150);
	    g2.drawLine(86, 255, 86, 150);
	    g2.drawLine(69, 150, 86, 150);
	    
	    g2.draw(new Arc2D.Double(150, 170, 200, 200, 90, 180, Arc2D.OPEN));
	    QuadCurve2D q=new QuadCurve2D.Double(100, 100, 150, 150, 200, 100);
	    CubicCurve2D qc = new CubicCurve2D.Double(100, 100, 125, 125, 150, 50, 200, 100);
	    g2.draw(qc);
	    g2.draw(q);
	    
	    
	    g2.drawString("("+mx+","+my+")", mx, my);
	    drawHouseShape(g2);
	    
	    g2.setStroke(new BasicStroke(3f));
	    Ellipse2D circle = new Ellipse2D.Double();
	    circle.setFrameFromCenter(500, 500, 500+100, 500+100);
	    g2.setColor(Color.yellow);
	    g2.fill(circle);
	    g2.setColor(Color.black);
	    g2.draw(circle);
	    g2.fill(new Ellipse2D.Double(450, 450, 30, 30));
	    g2.fill(new Ellipse2D.Double(520, 450, 30, 30));
	    QuadCurve2D q2=new QuadCurve2D.Double(450, 520, 500, 580, 520, 520);
	    g2.draw(q2);
	  }
	  
	  
	  
	  public void drawHouseShape(Graphics2D g2){
		  Shape rec1 = new Rectangle(10, 300, 310, 200);
		  Shape rec2 = new Rectangle(105, 400, 60, 100);
		  Shape line1 = new Line2D.Double(10, 300, 165, 200);
		  Shape line2 = new Line2D.Double(320, 300, 165, 200);
		  Shape line3 = new Line2D.Double(70, 261, 70, 150);
		  Shape line4 = new Line2D.Double(86, 255, 86, 150);
		  Shape line5 = new Line2D.Double(70, 150, 86, 150);
		  
		  AffineTransform t = new AffineTransform();
		  //t.scale(0.2f, 0.2f);
		  t.translate(300, 300);
		  t.rotate(Math.toRadians(50),500,300);
		  
		  g2.draw(t.createTransformedShape(rec1));
		  g2.draw(t.createTransformedShape(rec2));
		  g2.draw(t.createTransformedShape(line1));
		  g2.draw(t.createTransformedShape(line2));
		  g2.draw(t.createTransformedShape(line3));
		  g2.draw(t.createTransformedShape(line4));
		  g2.draw(t.createTransformedShape(line5));

	  }
	  
	  public Shape giveTrasformedLine(int angle,Line2D.Double line){
		  AffineTransform t = new AffineTransform();
		  t.rotate(Math.toRadians(angle),line.getX1(),line.getY1());
		  return t.createTransformedShape(line);
	  }
	  
	  public static void main(String[] args){
		    DrawHouse guiObj = new DrawHouse();
	  }

	}//end class GUI