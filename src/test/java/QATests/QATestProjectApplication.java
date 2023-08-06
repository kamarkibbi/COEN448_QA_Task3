package QATests;

import com.softwaretesting.robotsimulator.project.DIRECTION;
import com.softwaretesting.robotsimulator.project.PEN_POSITION;
import com.softwaretesting.robotsimulator.project.ProjectApplication;
import com.softwaretesting.robotsimulator.project.ROTATION;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QATestProjectApplication {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    public void testR1()
    {
        ProjectApplication.processFirstCommand("i 6");
        ProjectApplication.processCommands("m 3");
        Assertions.assertEquals(3,ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(0,ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP , ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.processFirstCommand("I 8");
        ProjectApplication.processCommands("R");
        ProjectApplication.processCommands("d");
        ProjectApplication.processCommands("m 2");
        Assertions.assertEquals(0,ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(2,ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(DIRECTION.EAST, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.DOWN , ProjectApplication.getMatrix().getPenPosition());
    }

    @Test
    public void testR2()
    {
        ProjectApplication.processFirstCommand("I 8");
        ProjectApplication.getMatrix().show();
        assertNotNull(testOut.toString().trim());
    }


    @Test
    public void testR4ValidInputs1() {
        ProjectApplication.processFirstCommand("I 10");
        Assertions.assertEquals(10, ProjectApplication.getMatrix().getSize());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.processFirstCommand("i 10");
        Assertions.assertEquals(10, ProjectApplication.getMatrix().getSize());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("L");
        Assertions.assertEquals(DIRECTION.WEST, ProjectApplication.getMatrix().getDirection());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("l");
        Assertions.assertEquals(DIRECTION.WEST, ProjectApplication.getMatrix().getDirection());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("R");
        Assertions.assertEquals(DIRECTION.EAST, ProjectApplication.getMatrix().getDirection());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("r");
        Assertions.assertEquals(DIRECTION.EAST, ProjectApplication.getMatrix().getDirection());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("M 4");
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(4, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("m 5");
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(5, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("c");
        String correctOutput = "Position: (0, 0) - Pen: up - Facing: north";
        Assertions.assertEquals(correctOutput, testOut.toString().trim());

        /*
        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("C");
        String correctOutput2="Position: (0, 0) - Pen: up - Facing: north";
        Assertions.assertEquals(correctOutput2,testOut.toString().trim());*/

        ProjectApplication.processCommands("d");
        Assertions.assertEquals(PEN_POSITION.DOWN, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.processCommands("D");
        Assertions.assertEquals(PEN_POSITION.DOWN, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.processCommands("u");
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.processCommands("U");
        Assertions.assertEquals(PEN_POSITION.UP, ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.getMatrix().initializeMatrix(7);
        ProjectApplication.processCommands("P");
        assertNotNull(testOut.toString().trim());

        ProjectApplication.getMatrix().initializeMatrix(5);
        ProjectApplication.processCommands("p");
        assertNotNull(testOut.toString().trim());

        /*ProjectApplication.processFirstCommand("I 8");
        ProjectApplication.processCommands("d");
        ProjectApplication.processCommands("m 3");
        ProjectApplication.processCommands("u");
        ProjectApplication.processCommands("M 2");
        ProjectApplication.processCommands("R");
        ProjectApplication.processCommands("M 1");
        ProjectApplication.processCommands("L");
        ProjectApplication.processCommands("m 2");
        ProjectApplication.processCommands("p");

        String expectedOutput = """
                 Position: (0, 0) - Pen: up - Facing: north
                  7|                        \s
                  6|                        \s
                  5|                        \s
                  4|                        \s
                  3| *                      \s
                  2| *                      \s
                  1| *                      \s
                  0| *                      \s
                  ------------------------
                     0  1  2  3  4  5  6  7
                """;


        Assertions.assertEquals(expectedOutput.trim(), testOut.toString().trim(),
                "Output should match the expected matrix showing the robot's path as asterisks");*/

        
/*
        ProjectApplication.processCommands("Q");
        String expectedOutputQ = "Bye";
        Assertions.assertTrue(testOut.toString().contains(expectedOutputQ),
                "Output should contain 'Bye' indicating that the program has quit");

      
        ProjectApplication.processCommands("q");
        String expectedOutputSmallQ = "Bye";
        Assertions.assertTrue(testOut.toString().contains(expectedOutputSmallQ),
                "Output should contain 'Bye' indicating that the program has quit");*/
   }
}