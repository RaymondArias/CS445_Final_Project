import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

public class MainDriver {
    //Method: start
    //Purpose: Intitiliazes the gui window and calls 
    //render to draw shapes 
    public void start() {
        try {
            createWindow();
            initGL();
            render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Method: createWindow
    Purpose: Creates the gui window with initial size and title
    */
    private void createWindow() throws Exception {
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(640, 480));
        Display.setTitle("CS445 Final Project");
        Display.create();
    }
    /*
    Method: initGL
    Purpose: set openGL with intitial values
    */
    private void initGL() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 0, 480, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
    /*
    Method: render
    Purpose: reads shape data from file and draws them to screen
    */
    private void render() {
        while (!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            
                
                Display.update();
                Display.sync(60);
            
        }
        Display.destroy();
    }
    public static void main(String []args)
    {
        MainDriver md = new MainDriver();
        md.start();
    }
    
}
