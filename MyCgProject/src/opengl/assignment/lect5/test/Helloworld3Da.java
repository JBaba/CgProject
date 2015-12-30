package opengl.assignment.lect5.test;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Helloworld3Da extends JFrame{

	public static final int width = 1028;
	public static final int height = 900;
	
	public Helloworld3Da() {
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
		
		bg.addChild(new ColorCube(0.4));
		
		return bg;
	}

	public static void main(String[] args) {
		Helloworld3Da demo = new Helloworld3Da();
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}
