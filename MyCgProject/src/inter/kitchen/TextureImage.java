package inter.kitchen;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.ImageIcon;
import javax.vecmath.Point3d;
 
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
 
public class TextureImage extends Applet {
 
  private java.net.URL texImage = null;
 
  private SimpleUniverse u = null;
 
  public BranchGroup createSceneGraph() throws Exception {
    // Create the root of the branch graph
    BranchGroup objRoot = new BranchGroup();
 
    // Create the transform group node and initialize it to the
    // identity. Enable the TRANSFORM_WRITE capability so that
    // our behavior code can modify it at runtime. Add it to the
    // root of the subgraph.
    TransformGroup objTrans = new TransformGroup();
    objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    objRoot.addChild(objTrans);
 
    // Create appearance object for textured cube
    Appearance app = new Appearance();
    
    final float FACTOR  = 4f;
    BufferedImage img = ImageIO.read(new File("C:\\Data\\EWorkspace\\CgProject\\src\\inter\\kitchen\\picture.jpg"));
    
    Texture tex = new TextureLoader(img, this).getTexture();
    app.setTexture(tex);
    TextureAttributes texAttr = new TextureAttributes();
    texAttr.setTextureMode(TextureAttributes.MODULATE);
    app.setTextureAttributes(texAttr);
 
    // Create textured cube and add it to the scene graph.
    Box textureCube = new Box(0.4f, 0.4f, 0.4f,
        Box.GENERATE_TEXTURE_COORDS, app);
    objTrans.addChild(textureCube);
 
    // Create a new Behavior object that will perform the desired
    // operation on the specified transform object and add it into
    // the scene graph.
    Transform3D yAxis = new Transform3D();
    Alpha rotationAlpha = new Alpha(-1, Alpha.INCREASING_ENABLE, 0, 0,
        4000, 0, 0, 0, 0, 0);
 
    RotationInterpolator rotator = new RotationInterpolator(rotationAlpha,
        objTrans, yAxis, 0.0f, (float) Math.PI * 2.0f);
    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
        100.0);
    rotator.setSchedulingBounds(bounds);
    objTrans.addChild(rotator);
 
    // Have Java 3D perform optimizations on this scene graph.
    objRoot.compile();
 
    return objRoot;
  }
 
  public TextureImage() {
  }
 
  public TextureImage(java.net.URL url) {
    texImage = url;
  }
 
  public void init() {
    if (texImage == null) {
      // the path to the image for an applet
      try {
        texImage = new java.net.URL("C:\\Data\\EWorkspace\\CgProject\\src\\inter\\kitchen\\wood.jpg");
      } catch (java.net.MalformedURLException ex) {
        System.out.println(ex.getMessage());
        System.exit(1);
      }
    }
    setLayout(new BorderLayout());
    GraphicsConfiguration config = SimpleUniverse
        .getPreferredConfiguration();
 
    Canvas3D c = new Canvas3D(config);
    add("Center", c);
 
    // Create a simple scene and attach it to the virtual universe
    BranchGroup scene = null;
	try {
		scene = createSceneGraph();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    u = new SimpleUniverse(c);
 
    // This will move the ViewPlatform back a bit so the
    // objects in the scene can be viewed.
    u.getViewingPlatform().setNominalViewingTransform();
 
    u.addBranchGraph(scene);
  }
 
  public void destroy() {
    u.cleanup();
  }
 
  //
  // The following allows TextureImage to be run as an application
  // as well as an applet
  //
  public static void main(String[] args) {
    java.net.URL url = null;
    if (args.length > 0) {
      try {
        url = new java.net.URL("file:" + args[0]);
      } catch (java.net.MalformedURLException ex) {
        System.out.println(ex.getMessage());
        System.exit(1);
      }
    } else {
      // the path to the image for an application
      try {
        url = new java.net.URL("file:wood.jpg");
      } catch (java.net.MalformedURLException ex) {
        System.out.println(ex.getMessage());
        System.exit(1);
      }
    }
    new MainFrame(new TextureImage(url), 256, 256);
  }
 
}