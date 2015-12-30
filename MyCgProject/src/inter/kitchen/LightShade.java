package inter.kitchen;

import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Stripifier;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Shape3D;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

/**
 * A re-usable Java3D {@link Shape3D} shape representing a light shade.
 * <p/>
 * {@link LightShade} extends {@link Shape3D} and uses a {@link javax.media.j3d.TriangleFanArray} to create the light shade.
 *
 * @author Cormac Redmond -- credmond85 /at/ gmail
 */
public class LightShade extends Shape3D {

    // Default Material for light shade
    private final static Material lightShadeMaterial = (new Material(
            new Color3f(ColourConstants.red),
            new Color3f(ColourConstants.darkred),
            new Color3f(ColourConstants.black),
            new Color3f(ColourConstants.blue),
            1f));

    private Appearance lightShadeAppearance;

    public void createShape3D() {

        // Variables used in creating the coordinates of the Shape3D
        int N = 17;
        int totalN = (N + 1);
        Point3f coords[] = new Point3f[totalN];
        int stripCounts[] = {N + 1};
        float width = .4f;
        float height = 0.5f;
        int n;
        double a;
        float x, y;
        int counter;

        // Create and initialise an array of points, representing the coordinates of the Shape3D
        coords[0] = new Point3f(0.0f, 0.0f, 0.0f);

        /*
         * Set the coordinates of the Shape3D, using N triangles.
         * Note: This for loop was adapted from Sun's Java3D Tutorials,
         * and not entirely my own.
         */
        for (a = 0, n = 0, counter = 1; n < N; a = 2.0 * Math.PI / (N - 1) * ++n, counter++) {
            x = (float) (width * Math.cos(a));
            y = (float) (width * Math.sin(a));
            coords[n + 1] = new Point3f(x, y, height);
        }

        // Setup the PolygonAttributes so the Shape3D will render on all sides and reflect light from all sides
        PolygonAttributes pa = new PolygonAttributes();
        pa.setCullFace(PolygonAttributes.CULL_NONE);
        pa.setBackFaceNormalFlip(true);
        lightShadeAppearance.setPolygonAttributes(pa);
        this.lightShadeAppearance.setMaterial(lightShadeMaterial);

        // Use GeometryInfo to create the geometry
        GeometryInfo gi = new GeometryInfo(GeometryInfo.TRIANGLE_FAN_ARRAY);

        // It needs the coordinates and the amount of strips
        gi.setCoordinates(coords);
        gi.setStripCounts(stripCounts);

        // Use NormalGenerator to automagically create normals
        NormalGenerator ng = new NormalGenerator();
        ng.generateNormals(gi);

        //Change the primitive of the GeometryInfo object to Triangle Strips
        Stripifier st = new Stripifier();
        st.stripify(gi);

        // Finally, set the appearance of the lightshade, and the geometry
        this.setAppearance(lightShadeAppearance);
        this.setGeometry(gi.getGeometryArray());

        // Adds a little sphere on top of the light shade for decoration
        this.addGeometry((((new Sphere(.04f)).getShape()).getGeometry()));
    }

    /**
     * Default constructor with a default {@link Material} and {@link Appearance}.
     */
    public LightShade() {

        // Set default appearances with default materials
        this.lightShadeAppearance = new Appearance();
        this.lightShadeAppearance.setMaterial(lightShadeMaterial);

        this.createShape3D();
    }

    /**
     * Constructor taking a predefined {@link Material}
     *
     * @param material the predefined {@link Material} object
     */
    public LightShade(Material material) {
        this.lightShadeAppearance = new Appearance();
        this.lightShadeAppearance.setMaterial(material);
        this.createShape3D();
    }

    /**
     * Constructor taking a predefined {@link Appearance}
     *
     * @param appearance the predefined {@link Appearance} object
     */
    public LightShade(Appearance appearance) {
        this.lightShadeAppearance = appearance;
        this.createShape3D();
    }
}
   

