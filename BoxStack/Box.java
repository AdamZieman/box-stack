/**
 * Name: Adam Zieman (zieman)
 * Course: CSCI 241 - Computer Science I
 * Section: 1
 * Assignment: 10
 *
 * Project/Class Description:
 * Create an object (a box)
 * Able to compare two boxes to see if one will fit inside the other
 *
 * Known bugs:
 * Line 84:  static Box combine(Box boxA, Box boxB) may result in a logical error.
 *           Currently checks if boxA can hold boxB, may need to check if boxB can hold boxA.
 *           When this function is called, arguments can be placed in the reversed order as a workaround.
 *           To read the code more easily, should be rewritten if this is the case
 */
public class Box
{
    // instance variables
    private double width;           // box width dimension in inches
    private double height;          // box height dimension in inches
    private double depth;           // box depth dimension in inches
    private boolean hasLid;         // indicate whether the box has a fitted lid
    // otherwise, you close it by folding flaps of cardboard
    private boolean hasMoreInside;  // indicate whether the box has another box nested inside it

    // constructor
    public Box(double width, double height, double depth, boolean hasLid) {
        this.width = width;     // instance varible is set to the parameter value
        this.height = height;   // instance varible is set to the parameter value
        this.depth = depth;     // instance varible is set to the parameter value
        this.hasLid = hasLid;   // instance varible is set to the parameter value
        hasMoreInside = false;  // set to false when the Box object is created
    }

    // double getWidth()
    public double getWidth() {
        return width;
    }

    // double getHeight()
    public double getHeight() {
        return height;
    }

    // double getDepth()
    public double getDepth() {
        return depth;
    }

    // boolean getHasLid()
    public boolean getHasLid() {
        return hasLid;
    }

    // boolean getHasMoreInside()
    public boolean getHasMoreInside() {
        return hasMoreInside;
    }

    // String toString()
    public String toString() {
        // set String variables to hold null
        String lid = "";
        String inside = "";

        // adds a message if the box contains a lid
        if (hasLid == true)
            lid = " (with lid)";

        // adds a message if the box contains a box
        if (hasMoreInside == true)
            inside = " (more inside)";

        // format and return a prompt
        String formatted = String.format("%4.1f%-3s%4.1f%-3s%4.1f%-12s%-13s", width, " x", height, " x", depth, lid, inside);
        return formatted;
    }

    // static Box combine(Box, Box)
    public static Box combine(Box boxA, Box boxB) {
        // check if boxA can hold boxB
        if (boxA.getHasLid() == true) {
            if (boxB.getWidth() < boxA.getWidth()) {
                if (boxB.getHeight() < boxA.getHeight()) {
                    if (boxB.getDepth() < boxA.getDepth()) {
                        boxA.hasMoreInside = true;
                        return boxA;
                    }
                }
            }
        }

        // if boxA cannot hold boxB, return null
        return null;
    }

}
