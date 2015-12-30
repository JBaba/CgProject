package opengl.assignment.lect3.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawShapeUsingJava3D extends JComponent {

	/**
	 * Java 3D demonstration of drawing pentagon.
	 * I have used Polar Coordinates math to draw pentagon and circle
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawSquere(g);
		drawTriangle(g);
		drawCircleUsingPolarToCartesian(g);
		drawCircleWithLinesUsingPolarToCartesian(g);
	}

	/**
	 * This method is example of drawing circle using points.
	 * Drawing point : we can achieve drawing point by drawing line to same point.
	 * Problem : Drawing circle using points in Java3D creates problem because int is argument for drawing line so if we calculate polar coordinates 
	 * 			 for 0-360 angels we have to convert them into int.
	 * 			 And after drawing this circle you can see empty gapes between 2 points which can not be filled.
	 * Solution : Draw line between two polar coordinates for angel. 
	 * @param g
	 */
	private void drawCircleWithLinesUsingPolarToCartesian(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.setColor(Color.red);

		int theta = 0;
		int r = 160;

		int x1 = 200;
		int y1 = 200;
		
		int xForStart = 0,xForMid = 0,yForStart = 0,yForMid = 0;

		for (int i = 1; i <= 360; i++) {

			int x, y;
			y = ((int) (r * Math.sin(Math.toRadians(i)))) + y1;
			x = ((int) (r * Math.cos(Math.toRadians(i)))) + x1;

			System.out.println("(" + x + "," + y + ")" + " :" + Math.toRadians(i));
			if(i == 1){
				xForStart = x;
				yForStart = y;
				xForMid = x;
				yForMid = y;
				g2d.drawLine(x, y, x, y);
			}else if( i == 360 ){
				g2d.drawLine(x, y, xForMid, yForMid);
				g2d.drawLine(x, y, xForStart, yForStart);
			}else{
				g2d.drawLine(x, y, xForMid, yForMid);
				xForMid = x;
				yForMid = y;
			}
		}
	}

	private void drawCircleUsingPolarToCartesian(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.red);

		int theta = 0;
		int r = 150;

		int x1 = 200;
		int y1 = 200;

		for (int i = 1; i < 360; i++) {

			int x, y;
			y = ((int) (r * Math.sin(Math.toRadians(i)))) + y1;
			x = ((int) (r * Math.cos(Math.toRadians(i)))) + x1;

			System.out.println("(" + x + "," + y + ")" + " :" + Math.toRadians(i));
			g2d.drawLine(x, y, x, y);
		}

		r = 280;
		int x,y;
		x = y = 200;
		x = x - (r / 2);
		y = y - (r / 2);
		g.fillOval(x, y, r, r);
	}

	public void drawSquere(Graphics g) {
		g.draw3DRect(200, 200, 100, 100, true);
	}

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
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 600, 500);
		window.getContentPane().add(new DrawShapeUsingJava3D());
		window.setVisible(true);
	}

}
