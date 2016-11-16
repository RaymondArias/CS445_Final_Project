/***************************************************************
* file: Vector3Float.java
* author: Justin Buth, Raymond Arias
* class: CS 445 Computer Graphics
*
* assignment: Final Project
* date last modified: 11/15/2016
*
* purpose: Sets the position of a cube
*
****************************************************************/ 

public class Vector3Float {
    private float x;
    private float y;
    private float z;
    
    // method: Vector3Float
    // purpose: Constructor. Initializes variables.
    public Vector3Float(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // method: getX
    // purpose: Returns x
    public float getX() {
        return x;
    }

    // method: setX
    // purpose: Sets x
    public void setX(float x) {
        this.x = x;
    }

    // method: getY
    // purpose: Gets y
    public float getY() {
        return y;
    }

    // method: setY
    // purpose: Sets y
    public void setY(float y) {
        this.y = y;
    }

    // method: getZ
    // purpose: Returns z
    public float getZ() {
        return z;
    }

    // method: setZ
    // purpose: Sets z
    public void setZ(float z) {
        this.z = z;
    }
}
