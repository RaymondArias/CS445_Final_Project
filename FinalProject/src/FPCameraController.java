
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.Vector3f;

public class FPCameraController {

    private Vector3f position;
    private Vector3f lPosition;
    private float yaw;
    private float pitch;
    private Vector3Float me;

    public FPCameraController(float x, float y, float z) {
        this.position = new Vector3f(x, y, z);
        this.lPosition = new Vector3f(x, y, z);
        lPosition.x = 0f;
        lPosition.y = 15.0f;
        lPosition.z = 0.0f;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getlPosition() {
        return lPosition;
    }

    public void setlPosition(Vector3f lPosition) {
        this.lPosition = lPosition;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public Vector3Float getMe() {
        return me;
    }

    public void setMe(Vector3Float me) {
        this.me = me;
    }

    public void yaw(float amount) {
        this.yaw += amount;
    }

    public void pitch(float amount) {
        this.pitch -= amount;
    }

    public void walkForward(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(yaw));
        float zOffset = distance * (float) Math.cos(Math.toRadians(yaw));
        position.x -= xOffset;
        position.z += zOffset;
    }

    public void walkBackwards(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(yaw));
        float zOffset = distance * (float) Math.cos(Math.toRadians(yaw));
        position.x += xOffset;
        position.z -= zOffset;
    }

    public void strafeLeft(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(yaw - 90));
        float zOffset = distance * (float) Math.cos(Math.toRadians(yaw - 90));
        position.x -= xOffset;
        position.z += zOffset;
    }

    public void strafeRight(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(yaw + 90));
        float zOffset = distance * (float) Math.cos(Math.toRadians(yaw + 90));
        position.x -= xOffset;
        position.z += zOffset;
    }

    public void moveUp(float distance) {
        position.y -= distance;
    }

    public void moveDown(float distance) {
        position.y += distance;
    }

    public void lookThrough() {
        glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        glTranslatef(position.x, position.y, position.z);
    }

    public void gameLoop() {
        FPCameraController camera = new FPCameraController(0, 0, -10);
        float dx = 0f;
        float dy = 0f;
        float dt = 0f;
        float lastTime = 0f;
        long time = 0;
        float mouseSensitivity = 0.09f;
        float movementSpeed = 0.35f;
        Mouse.setGrabbed(true);
        while (!Display.isCloseRequested()
                && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            time = Sys.getTime();
            lastTime = time;

            dx = Mouse.getDX();
            dy = Mouse.getDY();
            camera.yaw(dx * mouseSensitivity);
            camera.pitch(dy * mouseSensitivity);
            if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
                camera.walkForward(movementSpeed);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
                camera.walkBackwards(movementSpeed);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
                camera.strafeLeft(movementSpeed);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
                camera.strafeRight(movementSpeed);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
                camera.moveUp(movementSpeed);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                camera.moveDown(movementSpeed);
            }
            glLoadIdentity();
            camera.lookThrough();
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            render();
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }

    public void render() {
        try {
            
            glEnable(GL_DEPTH_TEST);
            
            glBegin(GL_QUADS);
            
            // Top 
            glColor3f(0.2f, 0.2f, 0.3f);
            glVertex3f(2.0f, 2.0f, -2.0f);
            glVertex3f(-2.0f, 2.0f, -2.0f);
            glVertex3f(-2.0f, 2.0f, 2.0f);
            glVertex3f(2.0f, 2.0f, 2.0f);
            
            // Bottom
            glColor3f(0.2f, 0.3f, 0.6f);
            glVertex3f(2.0f, -2.0f, 2.0f);
            glVertex3f(-2.0f, -2.0f, 2.0f);
            glVertex3f(-2.0f, -2.0f, -2.0f);
            glVertex3f(2.0f, -2.0f, -2.0f);
            
            // Front
            glColor3f(0.0f, 0.1f, 0.4f);
            glVertex3f(2.0f, 2.0f, 2.0f);
            glVertex3f(-2.0f, 2.0f, 2.0f);
            glVertex3f(-2.0f, -2.0f, 2.0f);
            glVertex3f(2.0f, -2.0f, 2.0f);
            
            // Back
            glColor3f(0.0f, 0.3f, 0.3f);
            glVertex3f(2.0f, -2.0f, -2.0f);
            glVertex3f(-2.0f, -2.0f, -2.0f);
            glVertex3f(-2.0f, 2.0f, -2.0f);
            glVertex3f(2.0f, 2.0f, -2.0f);
            
            // Left
            glColor3f(0.0f, 0.6f, 0.3f);
            glVertex3f(-2.0f, 2.0f, 2.0f);
            glVertex3f(-2.0f, 2.0f, -2.0f);
            glVertex3f(-2.0f, -2.0f, -2.0f);
            glVertex3f(-2.0f, -2.0f, 2.0f);
            
            // Right
            glColor3f(0.0f, 0.1f, 0.2f);
            glVertex3f(2.0f, 2.0f, -2.0f);
            glVertex3f(2.0f, 2.0f, 2.0f);
            glVertex3f(2.0f, -2.0f, 2.0f);
            glVertex3f(2.0f, -2.0f, -2.0f);
            
            glEnd();

            glColor3f(0,0,0);
            glLineWidth(2);
            // Top
            glBegin(GL_LINE_LOOP);
            glVertex3f(2.0f, 2.0f, -2.0f);
            glVertex3f(-2.0f, 2.0f, -2.0f);
            glVertex3f(-2.0f, 2.0f, 2.0f);
            glVertex3f(2.0f, 2.0f, 2.0f);
            glEnd();
            
            // Bottom
            glBegin(GL_LINE_LOOP);
            glVertex3f(2.0f, -2.0f, 2.0f);
            glVertex3f(-2.0f, -2.0f, 2.0f);
            glVertex3f(-2.0f, -2.0f, -2.0f);
            glVertex3f(2.0f, -2.0f, -2.0f);
            glEnd();
            
            // Front
            glBegin(GL_LINE_LOOP);
            glVertex3f(2.0f, 2.0f, 2.0f);
            glVertex3f(-2.0f, 2.0f, 2.0f);
            glVertex3f(-2.0f, -2.0f, 2.0f);
            glVertex3f(2.0f, -2.0f, 2.0f);
            glEnd();
            
            // Back
            glBegin(GL_LINE_LOOP);
            glVertex3f(2.0f, -2.0f, -2.0f);
            glVertex3f(-2.0f, -2.0f, -2.0f);
            glVertex3f(-2.0f, 2.0f, -2.0f);
            glVertex3f(2.0f, 2.0f, -2.0f);
            glEnd();
            
            // Left
            glBegin(GL_LINE_LOOP);
            glVertex3f(-2.0f, 2.0f, 2.0f);
            glVertex3f(-2.0f, 2.0f, -2.0f);
            glVertex3f(-2.0f, -2.0f, -2.0f);
            glVertex3f(-2.0f, -2.0f, 2.0f);
            glEnd();
            
            // Right
            glBegin(GL_LINE_LOOP);
            glVertex3f(2.0f, 2.0f, -2.0f);
            glVertex3f(2.0f, 2.0f, 2.0f);
            glVertex3f(2.0f, -2.0f, 2.0f);
            glVertex3f(2.0f, -2.0f, -2.0f);
            glEnd();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

