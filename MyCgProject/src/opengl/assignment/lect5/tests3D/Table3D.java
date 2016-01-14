package opengl.assignment.lect5.tests3D;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Link;
import javax.media.j3d.Material;
import javax.media.j3d.Shape3D;
import javax.media.j3d.SharedGroup;
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
import com.sun.j3d.utils.image.TextureLoader;
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
			new Color3f(ColourConstants.white), 2f));
	
	private final static Material tableBottomMaterial = (new Material(new Color3f(ColourConstants.brown),
			new Color3f(ColourConstants.blue), new Color3f(ColourConstants.brown),
			new Color3f(ColourConstants.white), 10f));

	private final static Material chairStructureMaterial = (new Material(new Color3f(ColourConstants.darkBlue),
			new Color3f(ColourConstants.darkGreen), new Color3f(ColourConstants.white),
			new Color3f(ColourConstants.darkred), 2f));
	
	private final static Material floorMat = (new Material(
            new Color3f(ColourConstants.grey),
            new Color3f(ColourConstants.darkred),
            new Color3f(.2f, 0.2f, 0.2f),
            new Color3f(.1f, .1f, .1f),
            4.0f));

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
			//Table t=new Table();
			//t.createSceneGraph(new BasicSeat());
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

		Appearance cubeTopAppearance = new Appearance();
		cubeTopAppearance.setMaterial(tableTopMaterial);

		// table top box size
		Box tableTop = new Box(0.35f, 0.01f, 0.35f, cubeTopAppearance);

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
		Box tableBottom = new Box(0.35f, 0.1f, 0.35f, cubeBottomAppearance);
		tableTG.addChild(tableBottom);
		
		tableT3d = new Transform3D();
		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(3.5f,72f / 44f, 2f));
		tableT3d.setTranslation(new Vector3f(0.01f,-0.18f, 0.01f));
		tableTG.setTransform(tableT3d);
		
		// Add our table so far
		bg.addChild(tableTG);
		
        TransformGroup lagTG = new TransformGroup();

        // leg 1
        Appearance legAppearance = new Appearance();
        legAppearance.setMaterial(chairStructureMaterial);
        Box legAndSupportShape = new Box(0.03f, 0.42f, 0.03f, legAppearance);
        lagTG.addChild(legAndSupportShape);
        
        tableT3d = new Transform3D();
		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(2f,72f / 44f, 3f));
		tableT3d.setTranslation(new Vector3f(1.1f,-0.7f,0.6f));
		lagTG.setTransform(tableT3d);
		bg.addChild(lagTG);
		
		// leg 2
		lagTG = new TransformGroup();
		Box leg2 = new Box(0.03f, 0.42f, 0.03f, legAppearance);
		lagTG.addChild(leg2);
		tableT3d = new Transform3D();
		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(2f,72f / 44f, 3f));
		tableT3d.setTranslation(new Vector3f(1.1f,-0.7f,-0.58f));
		lagTG.setTransform(tableT3d);
		bg.addChild(lagTG);
		
		// leg 3
		lagTG = new TransformGroup();
		Box leg3 = new Box(0.03f, 0.42f, 0.03f, legAppearance);
		lagTG.addChild(leg3);
		tableT3d = new Transform3D();
		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(2f,72f / 44f, 3f));
		tableT3d.setTranslation(new Vector3f(-1.1f,-0.7f,-0.58f));
		lagTG.setTransform(tableT3d);
		bg.addChild(lagTG);
		
		// leg 4
		lagTG = new TransformGroup();
		Box leg4 = new Box(0.03f, 0.42f, 0.03f, legAppearance);
		lagTG.addChild(leg4);
		tableT3d = new Transform3D();
		// Scale BasicSeat to size of a table
		tableT3d.setScale(new Vector3d(2f,72f / 44f, 3f));
		tableT3d.setTranslation(new Vector3f(-1.1f,-0.7f,0.58f));
		lagTG.setTransform(tableT3d);
		bg.addChild(lagTG);
		
		// floor
		lagTG = new TransformGroup();
		
		BufferedImage imgcarpet = null;
		try {
			imgcarpet = ImageIO.read(new File("C:\\Data\\EWorkspace\\CgProject\\MyCgProject\\src\\inter\\kitchen\\carpet.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create a TextureAttributes to control how the texture is displayed
        TextureAttributes textureAttrib = new TextureAttributes();
        Transform3D textureTransform = new Transform3D();

        // Rescale the texture, so it tiles
        textureTransform.setScale(new Vector3d(14.0f, 14.0, 1.0f));

        // Use 'REPLACE', as carpets reflect very little light, and are not see through
        textureAttrib.setTextureMode(TextureAttributes.REPLACE);
        textureAttrib.setTextureTransform(textureTransform);
        TextureLoader loadercarpet = new TextureLoader(imgcarpet);
		Appearance floorAppearance = new Appearance();
		floorAppearance.setTexture(loadercarpet.getTexture());
        floorAppearance.setTextureAttributes(textureAttrib);
		floorAppearance.setMaterial(floorMat);
		
		Box floor = new Box(10f, 0.015f, 8f, Box.GENERATE_TEXTURE_COORDS, floorAppearance);
		lagTG.addChild(floor);
		
		tableT3d = new Transform3D();
		tableT3d.setTranslation(new Vector3f(-1.1f,-1.41f,0.58f));
		lagTG.setTransform(tableT3d);
		
		bg.addChild(lagTG);
		
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
