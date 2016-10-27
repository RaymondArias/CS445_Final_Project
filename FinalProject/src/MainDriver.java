
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;

public class MainDriver {
    private FPCameraController fp;
    private DisplayMode displayMode;
    //Method: start
    //Purpose: Intitiliazes the gui window and calls 
    //render to draw shapes 

    public void start() {
        fp = new FPCameraController(0f, 0f, 0f);
        try {
            createWindow();
            initGL();
            fp.gameLoop();
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
        DisplayMode d[]
                = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 640
                    && d[i].getHeight() == 480
                    && d[i].getBitsPerPixel() == 32) {
                displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(displayMode);
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
        GLU.gluPerspective(100.0f, 
                (float) displayMode.getWidth()/(float)displayMode.getHeight(),
                0.1f, 300.0f);
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

    public static void main(String[] args) {
        MainDriver md = new MainDriver();
        md.start();
    }

}
