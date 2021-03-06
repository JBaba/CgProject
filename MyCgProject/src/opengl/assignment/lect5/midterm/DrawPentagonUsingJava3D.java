package opengl.assignment.lect5.midterm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawPentagonUsingJava3D extends JComponent {

	/**
	 * This Class is example of drawing circle using points. And Also draw pentagon inside circle
	 * 
	 * Draw Pentagon by getting polar coordinates for 5 diff angel which can be calculated by (360/5 = 72).
	 * 
	 * Drawing point : we can achieve drawing point by drawing line to same point.
	 * Problem : Drawing circle using points in Java3D creates problem because int is argument for drawing line so if we calculate polar coordinates 
	 * 			 for 0-360 angels we have to convert them into int.
	 * 			 And after drawing this circle you can see empty gapes between 2 points which can not be filled.
	 * Solution : Draw line between two polar coordinates for angel. 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1.5f));
		
		drawPentagonUsingPolygon(g);
		
		g2d.setColor(Color.red);
		drawPentagon(g2d, 650, 300, 200, 0);
		g2d.setColor(Color.green);
		drawCircle(g2d, 650, 300, 160);
	}

	


	/**
	 * draws pentagon using polygon
	 * @param g
	 */

	private void drawPentagonUsingPolygon(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.setColor(Color.blue);
		
		Polygon p = new Polygon();
		p.addPoint(50, 10);
		p.addPoint(25, 25);
		p.addPoint(30, 50);
		p.addPoint(70, 50);
		p.addPoint(75, 25);
		
		g2d.drawPolygon(p);
	}

	
	
	/**
	 * draw pentagon
	 * @param g2d
	 * @param x1
	 * @param y1
	 * @param r
	 * @param start
	 */
	public void drawPentagon(Graphics2D g2d,int x1,int y1,int r,int start){
		int pentConstant = (360/5);
		for(int i = 0; i <= 5; i++){
			g2d.drawLine(
					((int) (r * Math.sin(Math.toRadians(pentConstant*i)))) + x1,
					((int) (r * Math.cos(Math.toRadians(pentConstant*i)))) + y1,
					((int) (r * Math.sin(Math.toRadians(pentConstant*(i+1))))) + x1,
					((int) (r * Math.cos(Math.toRadians(pentConstant*(i+1))))) + y1);
		}
	}
	
	/**
	 * draw circle
	 * @param g2d
	 * @param x1
	 * @param y1
	 * @param r
	 */
	public void drawCircle(Graphics2D g2d,int x1,int y1,int r){
		for (int i = 1; i < 360; i++) {
			g2d.drawLine(
					((int) (r * Math.sin(Math.toRadians(i)))) + x1,
					((int) (r * Math.cos(Math.toRadians(i)))) + y1,
					((int) (r * Math.sin(Math.toRadians((i+1))))) + x1,
					((int) (r * Math.cos(Math.toRadians((i+1))))) + y1);
		}
	}

	/**
	 * draw squere
	 * @param g
	 */
	public void drawSquere(Graphics g) {
		g.draw3DRect(200, 200, 100, 100, true);
	}

	/**
	 * draw triangle
	 * @param g
	 */
	public void drawTriangle(Graphics g) {
		Polygon polygon = new Polygon();
		polygon.addPoint(100, 50);
		polygon.addPoint(300, 150);
		polygon.addPoint(50, 150);
		// polygon.addPoint(25, 100);
		g.drawPolygon(polygon);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("Draw Pentagon inside Cirlce using Java 3D");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 900, 900);
		window.getContentPane().add(new DrawPentagonUsingJava3D());
		window.setVisible(true);
	}

}
