package inter.kitchen;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import javax.imageio.ImageIO;
import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A runnable class which creates a lighted scene resembling a kitchen
 *
 * @author Cormac Redmond -- credmond85 /at/ gmail
 */
public class Kitchen extends Applet {

    // Material for the floor
    private final static Material floorMat = (new Material(
            new Color3f(ColourConstants.grey),
            new Color3f(ColourConstants.darkred),
            new Color3f(.2f, 0.2f, 0.2f),
            new Color3f(.1f, .1f, .1f),
            4.0f));

    // Material definition for the walls
    private final static Material wallMat = (new Material(
            new Color3f(ColourConstants.green),
            new Color3f(ColourConstants.darkred),
            new Color3f(.2f, 0.2f, 0.2f),
            new Color3f(.1f, .1f, .1f),
            4.0f));

    SimpleUniverse universe = null;
    OrbitBehavior orbitBehaviour = null;
    BoundingSphere boundingSphere = null;

    /**
     * Creates and places all the objects in the scene
     *
     * @return the {@link Group} with all added children
     * @throws Exception 
     */
    protected Group createSceneGraph() throws Exception {

        // The overall scene
        TransformGroup sceneTG = new TransformGroup();

        Transform3D kitchenTG3D = null;
        TransformGroup kitchenTG = null;

        // Load the carpet JPEG
        // Get current classloader ... loading resources this way is neccessary when the application is JAR'd
        ClassLoader cl = this.getClass().getClassLoader();
        BufferedImage imgcarpet = ImageIO.read(new File("C:\\Data\\EWorkspace\\CgProject\\src\\inter\\kitchen\\carpet.jpg"));
        
        TextureLoader loadercarpet = new TextureLoader(imgcarpet);

        // Create a TextureAttributes to control how the texture is displayed
        TextureAttributes textureAttrib = new TextureAttributes();
        Transform3D textureTransform = new Transform3D();

        // Rescale the texture, so it tiles
        textureTransform.setScale(new Vector3d(4.0f, 4.0, 1.0f));

        // Use 'REPLACE', as carpets reflect very little light, and are not see through
        textureAttrib.setTextureMode(TextureAttributes.REPLACE);
        textureAttrib.setTextureTransform(textureTransform);

        // Create an Appearance and set the texture, attributes and material
        Appearance floorAppearance = new Appearance();
        floorAppearance.setTexture(loadercarpet.getTexture());
        floorAppearance.setTextureAttributes(textureAttrib);
        floorAppearance.setMaterial(floorMat);

        // Add a box to the overall scene to act as the floor, using floorAppearance
        sceneTG.addChild(new Box(2f, 0.015f, 2f, Box.GENERATE_TEXTURE_COORDS, floorAppearance));

        // Read in the wall GIF
        BufferedImage imgwall = ImageIO.read(new File("C:\\Data\\EWorkspace\\CgProject\\src\\inter\\kitchen\\wall.gif"));
        TextureLoader loaderwall = new TextureLoader(imgwall);

        // Create a TextureAttributes
        textureAttrib = new TextureAttributes();
        textureTransform = new Transform3D();
        // Scale so the texture tiles
        textureTransform.setScale(new Vector3d(6.0f, 6.0, 1.0f));

        // User 'MODULATE' as we want lighting enabled
        textureAttrib.setTextureMode(TextureAttributes.MODULATE);

        textureAttrib.setTextureTransform(textureTransform);

        //Create an Appearance and specify that it be slightly transparant (so we can see into the room!)
        Appearance wallAppearance = new Appearance();
        wallAppearance.setTransparencyAttributes(new TransparencyAttributes(TransparencyAttributes.BLENDED, 0.5f));
        wallAppearance.setMaterial(wallMat);
        wallAppearance.setTexture(loaderwall.getTexture());
        wallAppearance.setTextureAttributes(textureAttrib);

        // Create a Box to act as the wall
        Box wall = new Box(2f, 0.015f, 2f, Box.GENERATE_TEXTURE_COORDS, wallAppearance);

        // Creat a SharedGroup, to use for the other 3 walls
        // Hence sharing materials, appearances, and saving space, etc
        SharedGroup wallShared = new SharedGroup();
        wallShared.addChild(wall);

        // Translate and add the first wall to kitchenTG
        kitchenTG3D = new Transform3D();
        kitchenTG3D.setTranslation(new Vector3f(0f, 4.0f, 0f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(wallShared));
        sceneTG.addChild(kitchenTG);

        // Translate and add the second wall to kitchenTG
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotZ(Math.PI / 2); // Rotate around Z by 90 degrees
        kitchenTG3D.setTranslation(new Vector3f(-2.f, 2.0f, 0f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(wallShared));
        sceneTG.addChild(kitchenTG);

        // Translate and add the third wall to kitchenTG
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotZ(Math.PI / 2); // Rotate around Z by 90 degrees
        kitchenTG3D.setTranslation(new Vector3f(2.f, 2.0f, 0f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(wallShared));

        // Translate and add the fourth wall to kitchenTG
        sceneTG.addChild(kitchenTG);
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotX(Math.PI / 2); // Rotate around X by 90 degrees
        kitchenTG3D.setTranslation(new Vector3f(0.f, 2.0f, -2.0f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(wallShared));
        sceneTG.addChild(kitchenTG);

        // Creates and places a LightShade in the scene
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotX(Math.PI / 2); // Rotate around X by 90 degrees
        kitchenTG3D.setTranslation(new Vector3f(0f, 4.0f, 0f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new LightShade());
        sceneTG.addChild(kitchenTG);

        // Creates and places a Table in the scene
        sceneTG.addChild(new Table());

        // Translate and add a Picture to the scene
        kitchenTG3D = new Transform3D();
        kitchenTG3D.setTranslation(new Vector3f(-.75f, 2.5f, -1.84f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Picture("picture.jpg"));
        sceneTG.addChild(kitchenTG);

        // Create a SharedGroup and add a Chair to it, to be used over and over.
        SharedGroup singleChair = new SharedGroup();
        singleChair.addChild(new Chair());

        // Create transforms and add the first Chair
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotY(-0.03f * Math.PI);
        kitchenTG3D.setTranslation(new Vector3f(0f, 0f, 1.5f));
        kitchenTG = new TransformGroup(kitchenTG3D);

        // Add a reference to the Chair SharedGroup
        kitchenTG.addChild(new Link(singleChair));

        // Add add to scene
        sceneTG.addChild(kitchenTG);

        // Create transforms and add the second Chair
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotY(-0.167f * Math.PI);
        kitchenTG3D.setTranslation(new Vector3f(-1.3f, 0f, 1.5f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(singleChair));
        sceneTG.addChild(kitchenTG);

        // Create transforms and add the third Chair
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotY(0.22f * Math.PI);
        kitchenTG3D.setTranslation(new Vector3f(1.5f, 0f, 1.55f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(singleChair));
        sceneTG.addChild(kitchenTG);

        // Create transforms and add the fourth Chair
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotY(1.0001f * Math.PI);
        kitchenTG3D.setTranslation(new Vector3f(0f, 0f, -1.25f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(singleChair));
        sceneTG.addChild(kitchenTG);

        // Create transforms and add the fifth Chair
        kitchenTG3D = new Transform3D();
        kitchenTG3D.rotY(1.5f * Math.PI);
        kitchenTG3D.setTranslation(new Vector3f(-0.95f, 0f, 0f));
        kitchenTG = new TransformGroup(kitchenTG3D);
        kitchenTG.addChild(new Link(singleChair));
        sceneTG.addChild(kitchenTG);

        // Move the whole scene down 1.5
        kitchenTG3D = new Transform3D();
        kitchenTG3D.setTranslation(new Vector3f(0f, -1.5f, 0f));
        sceneTG.setTransform(kitchenTG3D);

        // Create new BranchGroup, and add the newly created scene 'sceneTG' to it
        Group objRoot = new BranchGroup();
        objRoot.addChild(sceneTG);

        // Return the created scene to calling method
        return objRoot;
    }

    /**
     * Calls createSceneGraph(), then adds lighting to the returned scene
     *
     * @return the {@link Group} with all added children
     * @throws Exception 
     */
    protected Group createLightedScene() throws Exception {

        Light lightSrc;

        // The root node of the scene
        Group objRootBG = new BranchGroup();

        // Adds the unlit scene to objRootBG
        objRootBG.addChild(createSceneGraph());

        // Creates and places a DirectionalLight that shines from the the bottom left upwards into the scene
        Vector3f direction = new Vector3f(1.5f, 1.5f, -1.0f);
        direction.normalize();
        lightSrc = new DirectionalLight(new Color3f(0.9f, 0.9f, 0.9f), direction);
        lightSrc.setInfluencingBounds(boundingSphere);
        objRootBG.addChild(lightSrc);

        // Create ambient lighting
        lightSrc = new AmbientLight(new Color3f(0.3f, 0.3f, 0.3f));
        lightSrc.setInfluencingBounds(boundingSphere);
        objRootBG.addChild(lightSrc);

        // Creates a SpotLight, and places it inside the LightShade - acts as a light bulb 
        SpotLight sl = new SpotLight();
        sl.setInfluencingBounds(boundingSphere);
        sl.setPosition(0f, 1.9f, 0f);

        // Set a spread angle of 100 degrees
        sl.setSpreadAngle((float) Math.toRadians(100));

        // Make the light fairly strong
        sl.setConcentration(25f);

        // Point downwards
        sl.setDirection(0.0f, -1.0f, 0f);

        // Add SpotLight
        objRootBG.addChild(sl);

        //TODO: REMOVE - just a test
        Sphere test = new Sphere(.1f);
        TransformGroup test1 = new TransformGroup();
        test1.addChild(test);
        Transform3D SphereMove = new Transform3D();
        SphereMove.setTranslation(new Vector3f(0.0f, 3.5f, 0.0f));
        test1.setTransform(SphereMove);
        objRootBG.addChild(test1);

        // Return the light scene
        return objRootBG;
    }

    public void init() {

        // Creates and sets up a canvas
        Canvas3D canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        setLayout(new BorderLayout());
        add("Center", canvas);

        universe = new SimpleUniverse(canvas);
        ViewingPlatform viewPlatform = universe.getViewingPlatform();

        // Limit the viewable sphere to a radius of 100.0f
        boundingSphere = new BoundingSphere(new Point3d(0f, 0f, 0f), 100f);

        // Create sceneRootBG, the root BranchGroup of the universe
        BranchGroup sceneRootBG = new BranchGroup();

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
			sceneTG.addChild(createLightedScene());
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

        // Add a behaviour to viewPlatform, allowing the user to rotate, zoom, and straff the scene
        orbitBehaviour = new OrbitBehavior(canvas, OrbitBehavior.REVERSE_ALL | OrbitBehavior.STOP_ZOOM);
        orbitBehaviour.setSchedulingBounds(boundingSphere);
        viewPlatform.setViewPlatformBehavior(orbitBehaviour);
    }

    public void destroy() {
        universe.removeAllLocales();
    }

    public static void main(String[] args) {
        new MainFrame(new Kitchen(), 800, 600);
    }
}