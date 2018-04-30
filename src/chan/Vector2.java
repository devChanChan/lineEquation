/*
 * Vector2.java
 * ============
 * A general purpose class to define 2D vetor
 *  AUTHOR: SEUNG CHAN KIM (withksc@gmail.com)
 * CREATED: 2018-02-02
 * UPDATED: 2018-02-14
 */
package chan;

public class Vector2 {
    
    // member variables
    // for performace and small data size, declare with float
    public float x;
    public float y;
    
    // default constructor
    public Vector2() {
        set(0, 0);
    }
    
    // construct an instance of Vector2 setting the value x and y
    public Vector2(float x, float y) {
        set(x, y);
    }
    
    // setter with a coordinate
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    // setter with vector
    public void set(Vector2 v) {
        set(v.x, v.y);
    }
    
    // override toString()
    @Override
    public String toString() {
        return "Vector2(" + x + ", " + y + ")";
    }
    
    // make a deep copy and return it
    public Vector2 copy() {
        return new Vector2(x, y);
    }
    
    // add the coordinates of the instance of Vector2 'v' and the ones of 'this'
    public Vector2 add (Vector2 v) {
        x += v.x; // <==> x = x + v.x
        y += v.y; // <==> y = y + v.y
        return this;
    }
    
    // subtract the coordinates of the instance of Vector2 'v' and the ones of 'this'
    public Vector2 subtract (Vector2 v) {
        x -= v.x;
        y -= v.y;
        return this;
    }
    
    // scale product to the coordinates of 'this' and return it
    public Vector2 scale (float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }
    
    // dot product between the instances of 'this' and 'rhs'
    public float dot (Vector2 rhs) {
        return this.x * rhs.x + this.y * rhs.y;
    }
    
    // get length of the line of 'this' using Pythagorean Theorem
    public float getLength() {
        return (float)(Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)));
    }
    
    // normalize, make its length to 1
    public Vector2 normalize() {
        x = (float)(x /(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))));
        y = (float)(y /(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))));
        return this;
    }
}
