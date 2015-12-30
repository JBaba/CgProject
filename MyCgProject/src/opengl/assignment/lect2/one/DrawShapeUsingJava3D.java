package opengl.assignment.lect2.one;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawShapeUsingJava3D extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawSquere(g);
		drawTriangle(g);
	}
	
	public void drawSquere(Graphics g){
		g.draw3DRect(200, 200, 100, 100, true);
	}
	
	public void drawTriangle(Graphics g){
		Polygon polygon = new Polygon();
		polygon.addPoint(100, 50);
		polygon.addPoint(300, 150);
		polygon.addPoint(50, 150);
		//polygon.addPoint(25, 100);
		g.drawPolygon(polygon);
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(30, 30, 500, 500);
	    window.getContentPane().add(new DrawShapeUsingJava3D());
	    window.setVisible(true);
	}
	
}
