/*
 * Line.java
 * ============
 * A class to define a 3D line and determine if two lines are intersected and
 * to return the intersected point if they are intersected.
 *  AUTHOR: SEUNG CHAN KIM (withksc@gmail.com)
 * CREATED: 2018-02-02
 * UPDATED: 2018-02-17
 */

package chan;

public class Line {
   
    // member or instance vars 
    private Vector3 point;      // a point on the line
    private Vector3 direction;  // direction vector
    
    // default constructor
    public Line() {
        point = new Vector3(0, 0, 0);
        direction = new Vector3(0, 0, 0);
    }
    
    // construct an instance with a point and a direction
    public Line(Vector3 point, Vector3 direction) {
        this.point = new Vector3(point.x, point.y, point.z);
        this.direction = new Vector3(direction.x, direction.y, direction.z);
    }
    
    // construct an instance with a slope and a intercept
    public Line(float slope, float intercept) {
        point = new Vector3(0, intercept, 0);
        direction = new Vector3(1, slope, 0);
    }
    
    // construct an instance with two coordinate pairs
    public Line(float x1, float y1, float z1, float x2, float y2, float z2) {
        point = new Vector3(x1, y1, z1);
        direction = new Vector3(x2 - x1, y2 - y1, z2 -z1);
    }    
    
    // setter with a point and a direction 
    public void set(Vector3 point, Vector3 direction) {
        this.point = point;
        this.direction = direction;
    }
    
    // setter with a slope and a intercept
    public void set(float slope, float intercept) {
        point.set(0, intercept, 0);
        direction.set(1, slope, 0);
    }
    
    // setter with two coordinate pairs
    public void set(float x1, float y1, float z1, float x2, float y2, float z2) {
        point.set(x1, y1, z1);
        direction.set(x2 - x1, y2 - y1, z2 - z1);
    }
    
    // return the Vector3 instance that the variable 'point' refers to
    public Vector3 getPoint() {
        return point;
    }

    // setter with point
    public void setPoint(Vector3 point) {
        this.point = point;
    }
    
    // return the Vector3 instance that the variable 'direction' refers to
    public Vector3 getDirection() {
        return direction;
    }

    // setter with direction
    public void setDirection(Vector3 direction) {
        this.direction = direction;
    }
    
    // override toString()
    @Override
    public String toString() {
        return "Line\n====\n    Point: (" + point.x + ", " + point.y + ", " 
            + point.z + ")\n" + "Direction: (" + direction.x + ", " 
            + direction.y + ", " + direction.z + ")\n";
    }
    
    /* 
    * find the intersection point with the other line
    * if there is no intersection, return a point with NAN in it
    * Line1 = p1 + aV1 (this)
    * Line2 = p2 + aV2 (other)
    * Intersect:
    * p1 + aV1 = p2 + bV2
    *      aV1 = (p2 - p1) + bV2
    * aV1 x V2 = (p2 - p1) x V2
    *        a = (p2 - p1) x V2 / (V1 x V2)
    */
    public Vector3 intersect(Line line) {
        
        // find Point vector and Direction vector of line2
        Vector3 p2 = new Vector3(line.getPoint());
        Vector3 v2 = new Vector3(line.getDirection());
        Vector3 result = new Vector3(Float.NaN, Float.NaN, Float.NaN);
        
        // find (p2 - p1) x V2 in the equation
        Vector3 v3 = new Vector3((p2.subtract(point)).cross(v2));
        
        // find (V1 x V2) in the equation
        Vector3 v4 = new Vector3(getDirection().cross(v2));
        
        // find a = (p2 - p1) x V2 / (V1 x V2)
        // if both Line1 and Line2 are same direction, return NAN point
        float alpha = 0;
        if(v4.x != 0)
            alpha = v3.x / v4.x;
        else if(v4.y != 0)
            alpha = v3.y / v4.y;
        else if(v4.z != 0)
            alpha = v3.z / v4.z;
        else
            return result;
        
        // find an intersect point
        result.x = point.x + (alpha * direction.x);
        result.y = point.y + (alpha * direction.y);
        result.z = point.z + (alpha * direction.z);
        
        // return the intersected point
        return result;
    }
    
    // determine if 'this' line intersects with the other line
    public boolean isIntersected(Line line) {
        
        // if two lines are same direction, the magnitude of cross product is 0
        Vector3 v = getDirection().cross(line.getDirection());
        
        // if all the determinants are 0, two lines are not intersected and return false
        return (v.x != 0 || v.y != 0 || v.z != 0);
    }
}
