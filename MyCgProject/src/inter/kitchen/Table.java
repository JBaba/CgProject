package inter.kitchen;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;

import javax.imageio.ImageIO;
import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * A re-usable Java3D {@link com.sun.j3d.utils.geometry.Primitive} shape resembling a table.
 * <p/>
 * The table uses a scaled {@link BasicSeat} and adds a drawer.
 *
 * @author Cormac Redmond -- credmond85 /at/ gmail
 */
public class Table extends Group {

    // Default Material for the table legs, support, etc
    private final static Material tableStructureMaterial = (new Material(
            new Color3f(ColourConstants.brown),
            new Color3f(ColourConstants.darkBrown),
            new Color3f(ColourConstants.darkred),
            new Color3f(ColourConstants.white),
            2f));

    // Default Material for the table top
    private final static Material tableTopMaterial = (new Material(
            new Color3f(ColourConstants.brown),
            new Color3f(ColourConstants.darkred),
            new Color3f(ColourConstants.brown),
            new Color3f(ColourConstants.white),
            16f));

    public void createSceneGraph(BasicSeat basicSeat) throws Exception {
        Transform3D tableT3d = null;
        TransformGroup tg = null;
        TransformGroup tableTG = null;

        /*
         * To create a full table, I use a BasicSeat
         * and scale it to size.
         */

        // Read in JPEG for the table top
        ClassLoader cl = this.getClass().getClassLoader();
        //URL url = cl.getResource("wood.jpg");
        BufferedImage imgwood = ImageIO.read(new File("C:\\Data\\EWorkspace\\CgProject\\src\\inter\\kitchen\\wood.jpg"));
        TextureLoader loaderwood = new TextureLoader(imgwood);

        //ImageComponent2D image = loader.getImage();

        // Setup TextureAttributes and create texture
        TextureAttributes textureAttrib = new TextureAttributes();
        Transform3D textureTransform = new Transform3D();
        textureTransform.setScale(new Vector3d(4.0f, 4.0, 1.0f));

        // User 'MODULATE' for realism, i.e. lighting and shading
        textureAttrib.setTextureMode(TextureAttributes.MODULATE);
        textureAttrib.setTextureTransform(textureTransform);
        
        // Setup tableTopAppearance Appearance using the Texture and Material nodes
        Appearance tableTopAppearance = new Appearance();
        tableTopAppearance.setTextureAttributes(textureAttrib);
        tableTopAppearance.setMaterial(tableTopMaterial);
        tableTopAppearance.setTexture(loaderwood.getTexture());

        tableTG = new TransformGroup();
        tableT3d = new Transform3D();

        // Gets the node representing the top of the table from basicSeat
        TransformGroup tableTop = (TransformGroup) basicSeat.getChild(4);
        Box tableTopBox = (Box) tableTop.getChild(0);

        // Sets the appearance of the top of table
        tableTopBox.setAppearance(tableTopAppearance);

        // Scale BasicSeat to size of a table
        tableT3d.setScale(new Vector3d(3.5f, 72f / 44f, 2f));
        tableTG.setTransform(tableT3d);
        tableTG.addChild(basicSeat);

        // Add our table so far
        this.addChild(tableTG);

        // Add a drawer to  table

        tableTG = new TransformGroup();

        // Create the box
        tableTG.addChild(new Box(0.6f, 0.1f, 0.4f, basicSeat.getCAppearance()));

        // Create a knob and translate it to the correct place on drawer
        tableT3d = new Transform3D();
        tableT3d.setTranslation(new Vector3f(0f, -0.01f, 0.460f));
        tg = new TransformGroup(tableT3d);

        // Knob size: 40 mm
        tg.addChild(new Sphere(0.04f, basicSeat.getCAppearance()));
        tableTG.addChild(tg);

        // Add a front to the drawer, using basicSeats Appearance node
        tableT3d = new Transform3D();
        tableT3d.setTranslation(new Vector3f(0f, -0.01f, 0.41f));
        tg = new TransformGroup(tableT3d);

        tg.addChild(new Box(0.64f, 0.11f, 0.04f, basicSeat.getSAppearance()));
        tableTG.addChild(tg);

        // Translate the drawer
        tableT3d = new Transform3D();
        tableT3d.setTranslation(new Vector3f(0f, 1.3f, 0.22f));
        tableTG.setTransform(tableT3d);

        // Finally add our table
        this.addChild(tableTG);
    }

    /**
     * Default constructor that uses a default {@link Material} objects
     * @throws Exception 
     */
    public Table() throws Exception {
        this.createSceneGraph(new BasicSeat(tableStructureMaterial, tableTopMaterial));
    }

    /**
     * Constructor that accepts pre-defined {@link Material} objects.
     *
     * @param structure the {@link Material} for the table structure
     * @param top       the {@link Material} for the table structure
     */
    public Table(Material structure, Material top) throws Exception {
        this.createSceneGraph(new BasicSeat(structure, top));
    }

    /**
     * Constructor that accepts pre-defined {@link Appearance} objects.
     *
     * @param structure the {@link Appearance} for the table structure
     * @param top       the {@link Appearance} for the table structure
     */
    public Table(Appearance structure, Appearance top) throws Exception {
        this.createSceneGraph(new BasicSeat(structure, top));
    }
}