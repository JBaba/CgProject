package inter.kitchen;

import com.sun.j3d.utils.geometry.Box;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

/**
 * A re-usable Java3D {@link com.sun.j3d.utils.geometry.Primitive} shape resembling a full sized chair
 * <p/>
 * {@link Chair} is a {@link com.sun.j3d.utils.geometry.Primitive} which inherits from {@link BasicSeat}, and adds on a back support.
 *
 * @author Cormac Redmond -- credmond85 /at/ gmail
 */
public class Chair extends BasicSeat {

    /**
     * Default constructor to constructs a chair with predefined {@link Appearance} objects
     */
    public Chair() {
        // Calls super class' constructor
        super();
    }

    /**
     * Constructor taking two defined {@link Appearance} parameters
     *
     * @param chairStructure the structure {@link Appearance}
     * @param chairSeat      the seat {@link Appearance}
     */
    public Chair(Material chairStructure, Material chairSeat) {
        super(chairStructure, chairSeat);
    }

    /**
     * Constructor taking two defined {@link Appearance} parameters
     *
     * @param chairStructure the structure {@link Appearance}
     * @param chairSeat      the seat {@link Appearance}
     */
    public Chair(Appearance chairStructure, Appearance chairSeat) {
        super(chairStructure, chairSeat);
    }

    /**
     * Creates the scene graph
     */
    protected void createSceneGraph() {
        Transform3D chairT3D = null;
        TransformGroup chairTG = null;
        TransformGroup chairBack = null;
        chairBack = new TransformGroup();

        // To create the chair, we create the back of it, and then create the rest using a BasicSeat
        chairBack.addChild(new Box(0.35f, 0.08f, 0.01f, super.getSAppearance()));

        // The middle support piece of the back of seat
        chairT3D = new Transform3D();
        chairT3D.setTranslation(new Vector3f(0f, -0.240f, 0f));
        chairTG = new TransformGroup(chairT3D);
        chairTG.addChild(new Box(0.35f, 0.04f, 0.01f, super.getSAppearance()));
        chairBack.addChild(chairTG);

        // The lower support piece of the back of seat
        chairT3D = new Transform3D();
        chairT3D.setTranslation(new Vector3f(0f, -0.480f, 0f));
        chairTG = new TransformGroup(chairT3D);
        chairTG.addChild(new Box(0.35f, 0.04f, 0.01f, super.getSAppearance()));
        chairBack.addChild(chairTG);

        // The left back panel element
        chairT3D = new Transform3D();
        chairT3D.setTranslation(new Vector3f(-0.26f, -0.460f, 0.04f));
        chairTG = new TransformGroup(chairT3D);
        // size is: 20 x 20 x 500 mm³
        chairTG.addChild(new Box(0.03f, 0.5f, 0.03f, super.getCAppearance()));
        chairBack.addChild(chairTG);

        // The right back panel element
        chairT3D = new Transform3D();
        chairT3D.setTranslation(new Vector3f(0.26f, -0.460f, 0.04f));
        chairTG = new TransformGroup(chairT3D);
        chairTG.addChild(new Box(0.03f, 0.5f, 0.03f, super.getCAppearance()));
        chairBack.addChild(chairTG);

        // Tilt the back of the chair slightly, as most real chairs would be
        chairT3D = new Transform3D();
        chairT3D.rotX(5f / 180f * Math.PI);
        chairT3D.setTranslation(new Vector3f(0.0f, 1.66f, 0.35f));
        chairBack.setTransform(chairT3D);

        // Call the BasicSeat (superclass) createSceneGraph() method to create and add the BasicSeat
        super.createSceneGraph();

        // Then add the chairBack
        this.addChild(chairBack);
    }
}