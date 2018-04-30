/*
 * Vector3.java
 * ============
 * A general purpose class to define 3D vetor
 *  AUTHOR: SEUNG CHAN KIM (withksc@gmail.com)
 * CREATED: 2018-02-14
 * UPDATED: 2018-02-17
 */
package chan;

public class Vector3 {
    
    // member variables
    public float x;
    public float y;
    public float z;
    
    // default constructor
    public Vector3() {
        set(0, 0, 0);
    }
    
    // construct an instance of Vector3 setting the value x, y, and z
    public Vector3(float x, float y, float z) {
        set(x, y, z);
    }
    
    // construct an instance of Vector3 with Vector3 argument
    public Vector3(Vector3 v) {
        set(v);
    }
    
    // setter with a coordinate
    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // setter with vector
    public void set(Vector3 v) {
        set(v.x, v.y, v.z);
    }
    
    // override toString()
    @Override
    public String toString() {
        return "Vector3(" + x + ", " + y + ", " + z +")";
    }
    
    // make a deep copy and return it
    public Vector3 copy() {
        return new Vector3(x, y, z);
    }
    
    // add the coordinates of the instance of Vector3 'v' and the one of 'this'
    public Vector3 add (Vector3 v) {
        x += v.x; // <==> x = x + v.x
        y += v.y; // <==> y = y + v.y
        z += v.z; // <==> z = z + v.z        
        return this;
    }
    
    // subtract the coordinates of the instance of Vector2 'v' and the one of 'this'
    public Vector3 subtract (Vector3 v) {
        x -= v.x; // <==> x = x - v.x
        y -= v.y; // <==> y = y - v.y
        z -= v.z; // <==> z = z - v.z 
        return this;
    }
    
    // scale product to the coordinates of 'this' and return it
    public Vector3 scale (float scalar) {
        x *= scalar; // <==> x = x * v.x
        y *= scalar; // <==> y = y * v.y
        z *= scalar; // <==> z = z * v.z 
        return this;
    }
    
    // dot product between the instances of 'this' and 'rhs'
    public float dot (Vector3 rhs) {
        return this.x * rhs.x + this.y * rhs.y + this.z * rhs.z;
    }
    
    // cross product between the instances of 'this' and 'rhs'
    public Vector3 cross (Vector3 rhs) {
        return new Vector3(y * rhs.z - z * rhs.y, z * rhs.x - x * rhs.z, x * rhs.y - y * rhs.x);
    }
    
    // get length of the line of 'this' using Pythagorean Theorem
    public float getLength() {
        return (float)(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) + Math.pow(z, 2));
    }
    
    // normalize, make its length to 1
    public Vector3 normalize() {
        x = (float)(x /(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(this.z, 2))));
        y = (float)(y /(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(this.z, 2))));
        z = (float)(z /(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(this.z, 2))));
        return this;
    }
}
