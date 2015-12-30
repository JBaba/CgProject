package opengl.assignment.lect2.one;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.text.GlyphView.GlyphPainter;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class HelloWorldDemo extends JFrame {

    public static void main(String[] args) {
        HelloWorldDemo demo = new HelloWorldDemo();
        
    	
        
        GLProfile glp = GLProfile.getDefault();
    	GLCapabilities glc = new GLCapabilities(glp);
    	GLCanvas canvas = new GLCanvas(glc);
    	

    	
    	demo.add(canvas);
    	demo.setSize(500, 500);
    	demo.setVisible(true);
    	demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
