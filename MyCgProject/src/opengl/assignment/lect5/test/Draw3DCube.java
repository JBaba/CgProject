package opengl.assignment.lect5.test;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.universe.SimpleUniverse;

@SuppressWarnings("serial")
public class Draw3DCube extends JFrame{

	public static final int width = 1028;
	public static final int height = 900;
	
	public Draw3DCube() {
		setLayout(new BorderLayout());
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas3d= new Canvas3D(config);
		add("Center",canvas3d);
		
		BranchGroup scene = createScene();
		createScene2(scene);
		createCube(scene);
		
		SimpleUniverse simpleu = new SimpleUniverse(canvas3d);
		simpleu.getViewingPlatform().setNominalViewingTransform();
		simpleu.addBranchGraph(scene);
	}
	
	private void createCube(BranchGroup bg) {
		ColorCube cube =new ColorCube(0.02);
		
		Transform3D rotate = new Transform3D();
		Transform3D tempRotate = new Transform3D();
		
		rotate.rotX(Math.PI/4.0d);
		tempRotate.rotY(Math.PI/18.0d);
		rotate.mul(tempRotate);
		
		Vector3f vector = new Vector3f(.5f, 0.8f, .0f);
		tempRotate.setTranslation(vector);
		
		
		TransformGroup tbg = new TransformGroup();
		tbg.setTransform(rotate);
		
		tbg.addChild(cube);
		bg.addChild(tbg);
	}

	private BranchGroup createScene() {
		BranchGroup bg = new BranchGroup();
		ColorCube cube =new ColorCube(0.2);
		
		Transform3D rotate = new Transform3D();
		Transform3D tempRotate = new Transform3D();
		
		rotate.rotX(Math.PI/4.0d);
		tempRotate.rotY(Math.PI/18.0d);
		rotate.mul(tempRotate);
		
		TransformGroup tbg = new TransformGroup();
		tbg.setTransform(rotate);
		tbg.addChild(cube);
		
		bg.addChild(tbg);
		// this is old technique which professor demonstrates in class
		//bg.addChild(new ColorCube(0.4));
		return bg;
	}
	
	private void createScene2(BranchGroup bg) {
		for (float y = -1.0f; y <= 1.0f; y = y + 0.1f)
		{
			TransformGroup tg = new TransformGroup();
			Transform3D transform = new Transform3D();
			Cone cone = new Cone(0.05f, 0.1f);

			Vector3f vector = new Vector3f(.0f, y, .0f);
			transform.setTranslation(vector);
			tg.setTransform(transform);

			tg.addChild(cone);
			bg.addChild(tg);
		}
		
		Color3f light1Color = new Color3f(.1f, 1.4f, .1f); // green light
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds);
		bg.addChild(light1);
	}

	public static void main(String[] args) {
		Draw3DCube demo = new Draw3DCube();
		demo.setTitle("Drawing 3D cube");
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}
