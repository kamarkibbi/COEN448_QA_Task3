package QATests;

import com.softwaretesting.robotsimulator.project.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class testInit {

    @Test
    public void testMatrixInitialization(){
        //To initialize the matrix, the program should
        //prompt the user to enter an integer greater than
        //zero which will also determine the size of the matrix

        ProjectApplication proj = new ProjectApplication();
        proj.processFirstCommand("i 8");
        //setup test matrix
        int size = 8;
        Matrix matrix = new Matrix();
        matrix.initializeMatrix(size);

        //Assertion
        Assertions.assertEquals(8, ProjectApplication.getMatrix().getSize());

    }

    @Test
    public void testInitialPosition(){
        //initial position of the robot should be [0,0],
        //facing north with the pen up

        ProjectApplication proj = new ProjectApplication();
        proj.processFirstCommand("i 4");

        //Assertions
        //pos y = 0, pos x = 0
        //pen up, direction north
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
    }

    @Test
    public void MoveOncoordoutofBounds(){
        //We create a matrix and set the Xposition to a certain point and try to move the object beyond the array size
        //it should return false
        ProjectApplication proj = new ProjectApplication();
        proj.processFirstCommand("i 8");
        Matrix mat = new Matrix();
        mat.setSize(8);
        mat.setXPosition(4);
        mat.setDirection(DIRECTION.WEST);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class , () -> mat.move(5));
        Assertions.assertEquals("Robot exceeding the matrix boundaries" , exception.getMessage());

        mat.setXPosition(4);
        mat.setDirection(DIRECTION.EAST);

        exception = Assertions.assertThrows(IllegalArgumentException.class , () -> mat.move(5));
        Assertions.assertEquals("Robot exceeding the matrix boundaries" , exception.getMessage());

    }

    @Test
    public void MoveOnYcoordoutofBounds(){
        //We create a matrix and set the Xposition to a certain point and try to move the object beyond the array size
        //it should return false
        ProjectApplication proj = new ProjectApplication();
        proj.processFirstCommand("i 8");
        Matrix mat = new Matrix();
        mat.setSize(8);
        mat.setYPosition(4);
        mat.setDirection(DIRECTION.NORTH);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class , () -> mat.move(5));
        Assertions.assertEquals("Robot exceeding the matrix boundaries" , exception.getMessage());

        mat.setYPosition(4);
        mat.setDirection(DIRECTION.SOUTH);

        exception = Assertions.assertThrows(IllegalArgumentException.class , () -> mat.move(5));
        Assertions.assertEquals("Robot exceeding the matrix boundaries" , exception.getMessage());
    }

    @Test
    public void SetXcoordoutofBounds(){
        ProjectApplication proj = new ProjectApplication();
        proj.processFirstCommand("i 8");
        Matrix mat = new Matrix();
        mat.setSize(8);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> mat.setXPosition(9));
        Assertions.assertEquals("Illegal value for X position." , exception.getMessage());
    }

    @Test
    public void SetYcoordoutofBounds(){
        ProjectApplication proj = new ProjectApplication();
        proj.processFirstCommand("i 8");
        Matrix mat = new Matrix();
        mat.setSize(8);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> mat.setYPosition(9));
        Assertions.assertEquals("Illegal value for Y position." , exception.getMessage());
    }

    //Right Rotation Section
    //Trying all the various Rotation Combination that Could be done on the Right Side
    @Test
    public void TurnRightToEast(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.NORTH);
        mat.rotate(ROTATION.RIGHT);

        Assertions.assertEquals(DIRECTION.EAST, mat.getDirection());
    }
    @Test
    public void TurnRightToSouth(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.EAST);
        mat.rotate(ROTATION.RIGHT);

        Assertions.assertEquals(DIRECTION.SOUTH, mat.getDirection());
    }
    @Test
    public void TurnRightToWest(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.SOUTH);
        mat.rotate(ROTATION.RIGHT);

        Assertions.assertEquals(DIRECTION.WEST, mat.getDirection());
    }
    @Test
    public void TurnRightToNorth(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.WEST);
        mat.rotate(ROTATION.RIGHT);

        Assertions.assertEquals(DIRECTION.NORTH, mat.getDirection());
    }

    //Left Rotation Section
    //Trying all the various Rotation Combination that Could be done on the Left Side

    @Test
    public void TurnLeftToEast(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.NORTH);
        mat.rotate(ROTATION.LEFT);

        Assertions.assertEquals(DIRECTION.WEST, mat.getDirection());
    }
    @Test
    public void TurnLeftToSouth(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.WEST);
        mat.rotate(ROTATION.LEFT);

        Assertions.assertEquals(DIRECTION.SOUTH, mat.getDirection());
    }
    @Test
    public void TurnLeftToWest(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.SOUTH);
        mat.rotate(ROTATION.LEFT);

        Assertions.assertEquals(DIRECTION.EAST, mat.getDirection());
    }
    @Test
    public void TurnLeftToNorth(){
        Matrix mat = new Matrix();
        mat.setDirection(DIRECTION.EAST);
        mat.rotate(ROTATION.LEFT);

        Assertions.assertEquals(DIRECTION.NORTH, mat.getDirection());
    }
}
