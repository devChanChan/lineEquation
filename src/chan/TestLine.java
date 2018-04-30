/*
 * TestLine.java
 * ============
 * A class to test two lines are intersectd or not using Vector2 and Line class.
 * You can enter two coordinates of some points or slope and intercept 
 * to define line
 *  AUTHOR: SEUNG CHAN KIM (withksc@gmail.com)
 * CREATED: 2018-02-02
 * UPDATED: 2018-02-17
 */

package chan;

import java.util.Scanner;
public class TestLine {

    public static void main(String[] args) {
        
        // Construct a scanner for user input
        Scanner in = new Scanner(System.in);
        char another = 'Y'; // allows loop to continue if user wants
        
        // create an instance of Line1 and Line2
        Line line1 = new Line();
        Line line2 = new Line();
        
        // keep asking line information until user wants to stop
        while(another == 'Y' || another == 'y') {
            
            // ask if user wants to enter vectors or slope with intercept
            System.out.println("Which information would you like to enter between"
                + " vectors(V) and slope/intercept(S)? (V/S)");
            char infoType = in.next().toUpperCase().charAt(0);

            // if user wants to use vectors
            if (infoType == 'V' || infoType == 'v') {
                
                float[][] vec = new float[2][6]; // store vectors of two lines

                // store Point vector and Direction vector of Line1 and Line2
                for(int i = 0; i < 2; i++) {
                    System.out.println("Please enter the Point(x1,y1,z1) and "
                        + "Direction vector(x2,y2,z2) of Line" + (i+1) 
                        + " in order:");
                    
                    // store Line1 in vec[0] and Line2 in vec[1]
                    for(int j = 0; j < vec[0].length; j++) {
                        vec[i][j] = in.nextFloat();
                    }
                }

                // define 2 lines with the information the user entered
                line1.set(vec[0][0], vec[0][1], vec[0][2], 
                        vec[0][3], vec[0][4], vec[0][5]);
                line2.set(vec[1][0], vec[1][1], vec[1][2], 
                        vec[1][3], vec[1][4], vec[1][5]);
            
            // if user wants to use slope with intercept
            } else if (infoType == 'S' || infoType == 's') {
                
                // store slope and intercept of two lines
                float[] slope = new float[2];
                float[] intercept = new float[2];
                
                // prompt the user to enter slope and intercept of each line
                for(int i = 0; i < slope.length; i++) {
                    System.out.print("Please enter the slope of the Line" + (i+1) + ":");
                    slope[i] = in.nextFloat();
                    System.out.print("Please enter the intercept of the Line" + (i+1) + ":");
                    intercept[i] = in.nextFloat();
                }

                // define 2 lines with information the user entered
                line1 = new Line(slope[0], intercept[0]);
                line2 = new Line(slope[1], intercept[1]);

            // if user enter an invalid character
            } else {
                System.out.println("Please enter valid character.");
                break;
            }

            System.out.println();  // new line
            
            // check if the two lines are intersected
            if(line1.isIntersected(line2)) {
                
                // print intersect point
                Vector3 point = line1.intersect(line2);
                System.out.println("Intersect Point: " + point);
                
            } else {
                System.out.println("Not intersected"); // print not intersected
            }
            
            // debugging
            System.out.println(line1);
            System.out.println(line2);

            // does the user want to do another one?
            System.out.println("Another Line? (Y/N)");
            another = in.next().toUpperCase().charAt(0);
            
            System.out.println(); // new line
        }
    }
}