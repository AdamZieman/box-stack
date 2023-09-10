/**
 * Name: Adam Zieman (zieman)
 * Course: CSCI 241 - Computer Science I
 * Section: 1
 * Assignment: 10
 *
 * Project/Class Description:
 * Read a file converting the data into an array
 * counts the amount of lids, height, and printing a summary
 *
 * Known bugs:
 * Line 179: void merge() incomplete function
 */

// import statements
import java.io.*;
import java.util.*;

public class BoxStack
{
    // instance variables
    private Box[] boxes;  // all Boxes in BoxStack

    // constructor
    public BoxStack() throws IOException {
        printIntroduction();
        readBoxFile();
    }

    // void printIntroduction()
    private void printIntroduction() {
        // line 1: asterisks
        for (int i = 0; i < 19; i++) {
            System.out.print("*");
            if (i < 18)
                System.out.print(" ");
        }
        System.out.println();

        // line 2: title
        for (int i = 0; i < 8; i++)
            System.out.print(" ");
        System.out.println("Box Stack Program");

        // line 3: prompt
        System.out.println("Have your Box data file name ready.");

        // line 4: asterisks
        for (int i = 0; i < 19; i++) {
            System.out.print("*");
            if (i < 18)
                System.out.print(" ");
        }
        System.out.println();
    }

    // void readBoxFile()
    private void readBoxFile() throws IOException {
        // associates a variable to the scanner object
        Scanner keyboard = new Scanner(System.in);

        // prompt the user for a filename
        System.out.print("Enter the box filename: ");   // prompt message
        String fileName = keyboard.nextLine();              // prompt input

        // read the file
        //String prefix = "/home/student/zieman/Cs241/Assignments/Assignment10/Assign10Boxes/";  // directory path

        Scanner file;   // box file variable
        // initialize variables for object input
        double width;
        double height;
        double depth;
        String lid;
        boolean isLid;

        file = new Scanner (new File(fileName));   // searches file
        int arrayIndex = file.nextInt();        // array size (first number in file)
        boxes = new Box [arrayIndex];    // initialize array

        int i = 0;
        while (file.hasNext()) {
            // assign values from file
            width = file.nextDouble();
            height = file.nextDouble();
            depth = file.nextDouble();
            lid = file.next();

            // assign boolean value from string value
            if (lid.equals("y") || lid.equals("Y"))
                isLid = true;
            else
                isLid = false;

            // create a box object
            Box boxFromStack = new Box(width, height, depth, isLid);

            // place object in array
            //for (int i = 0; i < arrayIndex; i++)
            boxes[i] = boxFromStack;
            i++;

        }

        // instantiate the array
    }

    // int countLids()
    public int countLids() {
        // initialize environment variable
        int count = 0;

        // search through array
        for (int i = 0; i < boxes.length; i++) {
            // increment environment variable if a box has a lid
            if (boxes[i].getHasLid() == true) {
                count++;
            }
        }

        return count;
    }

    // double calculateStackHeight()
    public double calculateStackHeight() {
        // initialize environment variable
        double height = 0;

        // search through array
        for (int i = 0; i < boxes.length; i++) {
            // increment environment variable if a box has a lid
            height += boxes[i].getHeight();
        }

        return height;
    }

    // void printStackSummary
    public void printStackSummary() {
        // line 1: double lines
        for (int i = 0; i < 46; i++) {
            System.out.print("=");
        }
        System.out.println();

        // line 2: Title
        System.out.print("=====");  // 5 ='s
        System.out.print(" Stack of Boxes Summary ");
        System.out.println("=================");    // 17 ='s

        // line 3: column heading
        System.out.println("Box  Width/Height/Depth  Details");

        // line 4: double lines
        for (int i = 0; i < 46; i++) {
            System.out.print("=");
        }
        System.out.println();

        // table body
        for (int row = 0; row < boxes.length; row++) {
            // table
            System.out.printf("%5s%2d%2s%43s%n", "Box #", row+1, ": ", boxes[row].toString());
        }

        // new line
        System.out.println();

        // total stack height
        System.out.println("Total stack height: " + calculateStackHeight() + " inches.");

        // amount of lids
        System.out.println("This stack has " + countLids() + " visible lids.");
    }

    public void merge() {
        //public static Box combine(Box boxA, Box boxB)

        for (int boxNum = 0; boxNum < boxes.length - 1; boxNum++) {
            // create box objects
            Box firstBox = new Box(boxes[boxNum].getWidth(), boxes[boxNum].getHeight(),
                    boxes[boxNum].getDepth(), boxes[boxNum].getHasLid());
            Box secondBox = new Box(boxes[boxNum + 1].getWidth(), boxes[boxNum + 1].getHeight(),
                    boxes[boxNum + 1].getDepth(), boxes[boxNum + 1].getHasLid());

            // send objects to combine()

        }
    }
}
