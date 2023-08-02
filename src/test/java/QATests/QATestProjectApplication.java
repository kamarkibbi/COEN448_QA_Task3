package QATests;

import com.softwaretesting.robotsimulator.project.DIRECTION;
import com.softwaretesting.robotsimulator.project.PEN_POSITION;
import com.softwaretesting.robotsimulator.project.ProjectApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QATestProjectApplication {


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
        ProjectApplication.processCommands("R");
        ProjectApplication.processCommands("d");
        ProjectApplication.processCommands("m 2");

    }

    @Test
    public void testR4ValidInputs()
    {
        ProjectApplication.processFirstCommand("I 10");
        Assertions.assertEquals(10, ProjectApplication.getMatrix().getSize());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP , ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.processFirstCommand("i 10");
        Assertions.assertEquals(10, ProjectApplication.getMatrix().getSize());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(0, ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH, ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP , ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("L");
        Assertions.assertEquals(DIRECTION.WEST , ProjectApplication.getMatrix().getDirection());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("l");
        Assertions.assertEquals(DIRECTION.WEST , ProjectApplication.getMatrix().getDirection());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("M 4");
        Assertions.assertEquals(0 , ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(4 , ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH , ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP , ProjectApplication.getMatrix().getPenPosition());

        ProjectApplication.getMatrix().initializeMatrix(8);
        ProjectApplication.processCommands("m 5");
        Assertions.assertEquals(0 , ProjectApplication.getMatrix().getXPosition());
        Assertions.assertEquals(5 , ProjectApplication.getMatrix().getYPosition());
        Assertions.assertEquals(DIRECTION.NORTH , ProjectApplication.getMatrix().getDirection());
        Assertions.assertEquals(PEN_POSITION.UP , ProjectApplication.getMatrix().getPenPosition());
    }



}
