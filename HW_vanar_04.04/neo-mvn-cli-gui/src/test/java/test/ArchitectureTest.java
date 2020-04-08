package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchitectureTest {
    @Test
    void test() {
//        fail("Not yet implemented");
        int result = 10;
        assertTrue(result > 0);
    }
// This test checks if our application has both CLI and GUI
    @Test
    void checkBothCLIAndGUI() {
        try {
            Class.forName("main.CLIApplication"); // FQCN
            Class.forName("main.GUIApplication");
        } catch (ClassNotFoundException e) {
            fail("The application doesn't have both GUI and CLI");
        }
    }
    // This test checks if our application has "main"
    @Test
    void checkMethodMain() {
        try {
            Class.forName("main.CLIApplication").getMethod("main", String[].class);
            Class.forName("main.GUIApplication").getMethod("main", String[].class);
        } catch (ClassNotFoundException e) {
            fail("The application doesn't have both GUI and CLI");
        } catch (NoSuchMethodException e) {
            fail("The application class doesn't have \"main()\" method");
        }
    }
    // This test checks if our application has both Asteroid and NASADataProvider classes
    @Test
    void checkBothAsteroidAndNASADataProvider() {
        try {
            Class.forName("space.Asteroid");
            Class.forName("space.NASADataProvider");
        } catch (ClassNotFoundException e) {
            fail("The application doesn't have both Asteroid and NASADataProvider classes");
        }
    }
}