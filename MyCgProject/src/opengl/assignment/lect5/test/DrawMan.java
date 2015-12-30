package opengl.assignment.lect5.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import javax.xml.crypto.dsig.Transform;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class DrawMan extends JFrame{

	public static final int width = 1028;
	public static final int height = 900;
	
	public DrawMan() {
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
		
		Appearance app = new Appearance();
		Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
	    Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
		Color3f objColor = new Color3f(0.0f, 0.8f, 0.0f);
	    app.setMaterial(new Material(objColor, black, objColor, white,80.0f));
		
		Cylinder cy = new Cylinder(0.1f,0.2f, Primitive.GENERATE_NORMALS, app);
	    
		Transform3D rotate = new Transform3D();
		Transform3D tempRotate = new Transform3D();
		
		rotate.rotX(Math.PI/4.0d);
		tempRotate.rotY(Math.PI/18.0d);
		rotate.mul(tempRotate);
		
		tg.addChild(cy);
		tg.setTransform(rotate);
		
		bg.addChild(tg);
		
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		
		/*Color3f light1Color = new Color3f(.1f, 1.4f, .1f); // green light
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds);
		bg.addChild(light1);*/
		
		PointLight light = new PointLight();
        light.setColor(new Color3f(Color.WHITE));
        light.setPosition(0.0f,0.0f,0.0f);
        light.setInfluencingBounds(bounds);
		
		bg.addChild(light);
		
		return bg;
	}

	public static void main(String[] args) {
		DrawMan demo = new DrawMan();
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}
