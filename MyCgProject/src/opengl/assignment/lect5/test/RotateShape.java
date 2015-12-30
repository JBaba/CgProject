package opengl.assignment.lect5.test;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.xml.crypto.dsig.Transform;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class RotateShape extends JFrame{

	public static final int width = 1028;
	public static final int height = 900;
	
	public RotateShape() {
		setLayout(new BorderLayout());
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas3d= new Canvas3D(config);
		add("Center",canvas3d);
		
		BranchGroup scene = createScene();
		
		SimpleUniverse simpleu = new SimpleUniverse(canvas3d);
		simpleu.getViewingPlatform().setNominalViewingTransform();
		
		simpleu.addBranchGraph(scene);
		
	}
	
	private BranchGroup createScene() {
		BranchGroup bg = new BranchGroup();
		TransformGroup tg = new TransformGroup();
		
		ColorCube cube = new ColorCube(0.4);
		
		Transform3D transform3d = new Transform3D();
		transform3d.rotZ(15);
		
		tg.addChild(cube);
		tg.setTransform(transform3d);
		
		bg.addChild(tg);
		
		return bg;
	}

	public static void main(String[] args) {
		RotateShape demo = new RotateShape();
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}
