import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Start with number of point = 0
        int n_pon = 0;
        // This method returns an integer that is the number of points in Shape s. iterate over all the points in the shape
        for (Point pon : s.getPoints()) {
            n_pon += 1;
        }
        return n_pon;
    }

    public double getAverageLength(Shape s) {
        double aveLen;
        // calculated average of all the sides’ lengths in the Shape S.
        int n_sides = getNumPoints(s);
        aveLen = getPerimeter(s) / n_sides;
        return aveLen;
    }

    public double getLargestSide(Shape s) {
        // Get the largest Side
        // initiate the largest side
        double largestSide = 0.0;
        // iterate each side to culculate and compare 
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update largest Side if bigger than curren largest
            if ( currDist > largestSide) {
                largestSide = currDist;
            } else {
                ;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // initiate the largest X value
        double largestX = 0.0;
        //iterate each point to get the X value and compare to find the largest
        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            // Update largest X value if bigger than current one
            if ( currX > largestX ) {
                largestX = currX;
            } else {
                ;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // creat new Directory Resource
        DirectoryResource dr = new DirectoryResource();
        // largest perimeter initiate
        double largestPeri = 0.0;
        // iterate over the selected files to compare Perimeter
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currlength = getPerimeter(s);
            if ( currlength > largestPeri) {
                largestPeri = currlength;
            } else {
                ;
            }
        }
        return largestPeri;
    }

    public String getFileWithLargestPerimeter() {
        // file name
        File temp = null;
        // largest peri
        double largestPeri = 0.0;
        // creat new Directory Resource
        DirectoryResource dr = new DirectoryResource();
        // largest perimeter initiate
        String largestPeriName;
        // iterate over the selected files to compare Perimeter
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currlength = getPerimeter(s);
            if ( currlength > largestPeri) {
                largestPeri = currlength;
                temp = f;
            } else {
                ;
            }
        }
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int n_pon = getNumPoints(s);
        double aveLen = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX (s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of point = " + n_pon);
        System.out.println("Average length = " + aveLen);
        System.out.println("Largest Side = " + largestSide);
        System.out.println("Largest X value = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPeri = getLargestPerimeterMultipleFiles();
        System.out.println(largestPeri);
    }

    public void testFileWithLargestPerimeter() {
        String Name = getFileWithLargestPerimeter();
        System.out.println(Name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
