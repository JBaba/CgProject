package inter.kitchen;

import com.sun.j3d.utils.geometry.Box;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

/**
 * A re-usable Java3D Primitive shape resembling a basic seat (like a stool).
 * <p/>
 * {@link BasicSeat} is a {@link com.sun.j3d.utils.geometry.Primitive}, that uses other {@link com.sun.j3d.utils.geometry.Primitive}s in a {@link SharedGroup} to create the seat without a back.
 * All that is used therefore, is a {@link Box} for the legs, and a {@link Box} for a support, hence using minimal memory.
 *
 * @author Cormac Redmond -- credmond85 /at/ gmail
 */
public class BasicSeat extends Group {

    // Default Material for seat legs, support, etc
    private final static Material chairStructureMaterial = (new Material(
            new Color3f(ColourConstants.darkBlue),
            new Color3f(ColourConstants.darkGreen),
            new Color3f(ColourConstants.white),
            new Color3f(ColourConstants.darkred),
            2f));

    // Default Material for seat top
    private final static Material chairSeatMaterial = (new Material(
            new Color3f(ColourConstants.red),
            new Color3f(ColourConstants.darkBrown),
            new Color3f(ColourConstants.darkred),
            new Color3f(ColourConstants.darkYellow),
            64f));

    private Appearance structureAppear;
    private Appearance seatAppearance;

    /**
     * Default constructor
     */
    public BasicSeat() {
        // Set default appearances with default materials
        this.structureAppear = new Appearance();
        this.structureAppear.setMaterial(chairStructureMaterial);
        this.seatAppearance = new Appearance();
        this.seatAppearance.setMaterial(chairSeatMaterial);

        this.createSceneGraph();
    }

    /**
     * Constructor taking two defined {@link Material} parameters
     *
     * @param structure the structure {@link Appearance}
     * @param seat      the seat {@link Appearance}
     */
    public BasicSeat(Material structure, Material seat) {
        this.structureAppear = new Appearance();
        this.structureAppear.setMaterial(structure);
        this.seatAppearance = new Appearance();
        this.seatAppearance.setMaterial(seat);
        this.createSceneGraph();
    }

    /**
     * Constructor taking two defined {@link Appearance} parameters
     *
     * @param structure the structure {@link Appearance}
     * @param seat      the seat {@link Appearance}
     */
    public BasicSeat(Appearance structure, Appearance seat) {
        // set the appearances with the defined values
        this.structureAppear = structure;
        this.seatAppearance = seat;
        this.createSceneGraph();
    }

    /**
     * Creates the scene graph
     */
    protected void createSceneGraph() {
        Transform3D basicSeatT3D = null;
        TransformGroup basicSeatTG = null;

        Box legAndSupportShape = new Box(0.03f, 0.42f, 0.03f, structureAppear);

        // Create a SharedGroup that will contain one leg and support to be used over and over
        SharedGroup legAndSupport = new SharedGroup();

        // Add the leg of the seat to the SharedGroup
        legAndSupport.addChild(legAndSupportShape);

        basicSeatT3D = new Transform3D();

        // Translate support the upper right corner of the first leg
        basicSeatT3D.setTranslation(new Vector3f(0.28f, 0.350f, -0.05f));
        basicSeatTG = new TransformGroup(basicSeatT3D);

        // Create the support
        basicSeatTG.addChild(new Box(0.31f, 0.09f, 0.02f, structureAppear));

        // Add to SharedGroup legAndSupport
        legAndSupport.addChild(basicSeatTG);

        // We now have the construction part (legAndSupport)
        // Add the first leg and support
        basicSeatT3D = new Transform3D();
        basicSeatT3D.setTranslation(new Vector3f(-0.26f, 0.43f, -0.26f));
        basicSeatTG = new TransformGroup(basicSeatT3D);

        // Use the SharedGroup legAndSupport
        basicSeatTG.addChild(new Link(legAndSupport));
        this.addChild(basicSeatTG);

        // Add the second leg and support and rotate around Y
        basicSeatT3D = new Transform3D();
        basicSeatT3D.rotY(0.5f * Math.PI);
        basicSeatT3D.setTranslation(new Vector3f(-0.26f, 0.43f, 0.26f));
        basicSeatTG = new TransformGroup(basicSeatT3D);
        basicSeatTG.addChild(new Link(legAndSupport));
        this.addChild(basicSeatTG);

        // Add the third leg and support and rotate around Y
        basicSeatT3D = new Transform3D();
        basicSeatT3D.rotY(Math.PI);
        basicSeatT3D.setTranslation(new Vector3f(0.26f, 0.43f, 0.26f));
        basicSeatTG = new TransformGroup(basicSeatT3D);
        basicSeatTG.addChild(new Link(legAndSupport));
        this.addChild(basicSeatTG);

        // Add the fourth leg and support and rotate around Y
        basicSeatT3D = new Transform3D();
        basicSeatT3D.rotY(1.5f * Math.PI);
        basicSeatT3D.setTranslation(new Vector3f(0.26f, 0.43f, -0.26f));
        basicSeatTG = new TransformGroup(basicSeatT3D);
        basicSeatTG.addChild(new Link(legAndSupport));
        this.addChild(basicSeatTG);

        // Create and add a seat/top to the seat
        basicSeatT3D = new Transform3D();
        basicSeatT3D.setTranslation(new Vector3f(0f, 0.87f, 0f));
        basicSeatTG = new TransformGroup(basicSeatT3D);
        // Generate normals and texture coordinates
        basicSeatTG.addChild(new Box(0.35f, 0.01f, 0.35f, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, seatAppearance));

        // Add the overall seat
        this.addChild(basicSeatTG);
    }

    /**
     * Allows easy changing of the seat's {@link Appearance} objects
     *
     * @param structure the structure {@link Appearance}
     * @param seat      the seat {@link Appearance}
     */
    public void setAppearance(Appearance structure, Appearance seat) {
        // set the appearances with the defined values
        this.structureAppear = structure;
        this.seatAppearance = seat;
    }

    /**
     * Gets the structure {@link Appearance}
     */
    public Appearance getCAppearance() {
        return this.structureAppear;
    }

    /**
     * Gets the seat/top {@link Appearance}
     */
    public Appearance getSAppearance() {
        return this.seatAppearance;
    }
}