package opengl.assignment.lect5.tests3D;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import inter.kitchen.BasicSeat;
import inter.kitchen.ColourConstants;
import inter.kitchen.Table;

@SuppressWarnings("serial")
public class Table3D extends JFrame {

	OrbitBehavior orbitBehaviour = null;
	BoundingSphere boundingSphere = null;

	public static final int width = 1028;
	public static final int height = 900;

	private final static Material tableTopMaterial = (new Material(new Color3f(ColourConstants.brown),
			new Color3f(ColourConstants.darkBrown), new Color3f(ColourConstants.darkred),
			new Color3f(ColourConstants.white), 10f));
	
	private final static Material tableBottomMaterial = (new Material(new Color3f(ColourConstants.brown),
			new Color3f(ColourConstants.blue), new Color3f(ColourConstants.brown),
			new Color3f(ColourConstants.white), 10f));

	private final static Material chairStructureMaterial = (new Material(new Color3f(ColourConstants.darkBlue),
			new Color3f(ColourConstants.darkGreen), new Color3f(ColourConstants.white),
			new Color3f(ColourConstants.darkred), 2f));

	public Table3D() {
		setLayout(new BorderLayout());
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas3d = new Canvas3D(config);
		
		add("Center", canvas3d);

		BranchGroup scene = new BranchGroup();
		createCube(scene);

		SimpleUniverse universe = new SimpleUniverse(canvas3d);
		//simpleu.getViewingPlatform().setNominalViewingTransform();
		//simpleu.addBranchGraph(scene);

		Background background = new Background(new Color3f(1f,1,1));
		ViewingPlatform viewPlatform = universe.getViewingPlatform();
		
		// Limit the viewable sphere to a radius of 100.0f
		boundingSphere = new BoundingSphere(new Point3d(0f, 0f, 0f), 100f);
		background.setApplicationBounds(boundingSphere);
		
		
		// Create sceneRootBG, the root BranchGroup of the universe
		BranchGroup sceneRootBG = new BranchGroup();
		sceneRootBG.addChild(background);

		// A Transform3D which will apply to our whole scene
		Transform3D sceneT3d = new Transform3D();

		// Rotate scene for a nicer first angle
		sceneT3d.setEuler(new Vector3d(Math.toRadians(35), Math.toRadians(310), Math.toRadians(330)));

		// Scale whole scene down a bit
		sceneT3d.setScale(.3d);

		// Create a TransformGroup, apply sceneT3D it
		TransformGroup sceneTG = new TransformGroup();
		sceneTG.setTransform(sceneT3d);

		try {
			Table t=new Table();
			t.createSceneGraph(new BasicSeat());
			//sceneTG.addChild(t);
			sceneTG.addChild(scene);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Add our created scene sceneTG to root BranchGroup, sceneRootBG
		sceneRootBG.addChild(sceneTG);

		// Optimises the scene graph
		sceneRootBG.compile();

		// Add our root BranchGroup to universe
		universe.addBranchGraph(sceneRootBG);

		viewPlatform.setNominalViewingTransform();

		// Add a behaviour to viewPlatform, allowing the user to rotate, zoom,
		// and straff the scene
		orbitBehaviour = new OrbitBehavior(canvas3d, OrbitBehavior.REVERSE_ALL | OrbitBehavior.STOP_ZOOM);
		orbitBehaviour.setSchedulingBounds(boundingSphere);
		viewPlatform.setViewPlatformBehavior(orbitBehaviour);

	}

	private void createCube(BranchGroup bg) {

		// Setup TextureAttributes and create texture
		TextureAttributes textureAttrib = new TextureAttributes();
		Transform3D textureTransform = new Transform3D();
		textureTransform.setScale(new Vector3d(4.0f, 4.0, 1.0f));

		// User 'MODULATE' for realism, i.e. lighting and shading
		textureAttrib.setTextureMode(TextureAttributes.MODULATE);
		textureAttrib.setTextureTransform(textureTransform);

		Appearance cubeTopAppearance = new Appearance();
		cubeTopAppearance.setTextureAttributes(textureAttrib);
		cubeTopAppearance.setMaterial(tableTopMaterial);

		// table top box size
		Box tableTop = new Box(0.35f, 0.01f, 0.35f, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, cubeTopAppearance);
		// Sets the appearance of the top of table
		tableTop.setAppearance(cubeTopAppearance);

		TransformGroup tableTG = new TransformGroup();
		Transform3D tableT3d = new Transform3D();

		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(3.5f, 72f / 44f, 2f));
		tableTG.setTransform(tableT3d);
		tableTG.addChild(tableTop);

		// Add our table so far
		bg.addChild(tableTG);
		
		tableTG = new TransformGroup();
		
		Appearance cubeBottomAppearance = new Appearance();
		cubeBottomAppearance.setMaterial(tableBottomMaterial);
		Box tableBottom = new Box(0.30f, 0.009f, 0.34f, cubeBottomAppearance);
		tableTG.addChild(tableBottom);
		
		
		tableT3d = new Transform3D();
		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(3.5f, 10f, 2f));
		tableTG.setTransform(tableT3d);
		
		tableT3d = new Transform3D();
		tableT3d.setTranslation(new Vector3f(0.28f, 0.350f, -0.05f));
		tableTG.setTransform(tableT3d);
		
		// Add our table so far
		bg.addChild(tableTG);
		
		/*// Add a drawer to table
		tableTG = new TransformGroup();

		Appearance drawerAppearance = new Appearance();
		drawerAppearance.setMaterial(chairStructureMaterial);
		// Create the box
		tableTG.addChild(new Box(0.6f, 0.1f, 0.4f, drawerAppearance));

		// Add a front to the drawer, using basicSeats Appearance node
		tableT3d = new Transform3D();
		tableT3d.setTranslation(new Vector3f(0f, -0.01f, 0.41f));
		TransformGroup tg = new TransformGroup(tableT3d);

		tg.addChild(new Box(0.64f, 0.11f, 0.04f, drawerAppearance));
		tableTG.addChild(tg);

		// Translate the drawer
		tableT3d = new Transform3D();
		tableT3d.setTranslation(new Vector3f(0f, 1.3f, 0.22f));
		tableTG.setTransform(tableT3d);

		// Finally add our table
		bg.addChild(tableTG);*/

	}

	private void createScene2(BranchGroup bg) {
		for (float y = -1.0f; y <= 1.0f; y = y + 0.1f) {
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
		Table3D demo = new Table3D();
		demo.setTitle("Drawing 3D cube");
		demo.setSize(width, height);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}
