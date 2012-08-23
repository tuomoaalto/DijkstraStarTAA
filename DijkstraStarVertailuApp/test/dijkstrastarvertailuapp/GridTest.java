/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author aaltotuo
 */
public class GridTest {
    
    public GridTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createInpassables method, of class Grid.
     */
//    @Test
//    public void testCreateInpassables()
//    {
//        System.out.println("createInpassables");
//        Grid instance = null;
//        instance.createInpassables();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Grid.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Grid instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setStart method, of class Grid.
     */
    @Test
    public void testSetStart() {
        System.out.println("testSetStart");
        int x = 0;
        int y = 0;
        Grid instance = new Grid(10,10);
        instance.setStart(x, y);
        // TODO review the generated test code and remove the default call to fail.
        Node expResult = instance.getNode(0, 0);
        
        assertTrue(expResult.isStart());
    }
    
    @Test
    public void testGetStart()
    {
        System.out.println("testGetStart");
        int x = 0;
        int y = 0;
        Grid instance = new Grid(10,10);
        instance.setStart(x, y);

        Node expResult = instance.getStart();
        
        assertTrue(expResult.getxCoord() == 0);
        assertTrue(expResult.getyCoord() == 0);
        assertTrue(expResult.isStart());
    
    }

    /**
     * Test of setGoal method, of class Grid.
     */
    @Test
    public void testSetGoal() {
        System.out.println("setGoal");
        int x = 0;
        int y = 0;
        Grid instance = new Grid(10,10);
        instance.setGoal(x, y);

        Node expResult = instance.getNode(0, 0);
        assertTrue(expResult.isGoal());        
    
    }


    /**
     * Test of getGoal method, of class Grid.
     */
    @Test
    public void testGetGoal() {
        System.out.println("testGetGoal");        
        int x = 0;
        int y = 0;
        Grid instance = new Grid(10,10);
        instance.setGoal(x, y);

        Node expResult = instance.getGoal();
        
        assertTrue(expResult.getxCoord() == 0);
        assertTrue(expResult.getyCoord() == 0);
        assertTrue(expResult.isGoal());
    }    
    
    /**
     * Test of setImpassable method, of class Grid.
     */
    @Test
    public void testSetImpassable() {
        System.out.println("setImpassable");
        int x = 0;
        int y = 0;
        Grid instance = new Grid(10, 10);
        instance.setImpassable(x, y);

        assertFalse(instance.getNode(0, 0).isPassable());
    
    }

    /**
     * Test of findNeighborsToNode method, of class Grid.
     */
    @Test
    public void testFindNeighborsToNode() {
        System.out.println("findNeighborsToNode");
        Node node = new Node(5,5,true);
        Grid instance = new Grid(10, 10);
        Node[] expResult = new Node[8];
        
        expResult[0] = new Node(4,6, true);
        expResult[1] = new Node(5,6, true);
        expResult[2] = new Node(6,6, true);
        expResult[3] = new Node(4,5, true);
        expResult[4] = new Node(6,5, true);
        expResult[5] = new Node(4,4, true);
        expResult[6] = new Node(5,4, true);
        expResult[7] = new Node(6,4, true);
        
        
        
        Node[] result = instance.findNeighborsToNode(node);
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of getNode method, of class Grid.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        int x = 0;
        int y = 0;
        Grid instance = new Grid(10,10);
        Node expResult = new Node(0,0, true);
        Node result = instance.getNode(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of findShortestPathAStar method, of class Grid.
     */
//    @Test
//    public void testFindShortestPathAStar() {
//        System.out.println("findShortestPathAStar");
//        Grid instance = null;
//        instance.findShortestPathAStar();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findShortestPathDijkstra method, of class Grid.
     */
//    @Test
//    public void testFindShortestPathDijkstra() {
//        System.out.println("findShortestPathDijkstra");
//        Grid instance = null;
//        instance.findShortestPathDijkstra();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of calculateManhattanDistance method, of class Grid.
     */
//    @Test
//    public void testCalculateManhattanDistance() {
//        System.out.println("calculateManhattanDistance");
//        Node start = null;
//        Node goal = null;
//        Grid instance = null;
//        int expResult = 0;
//        int result = instance.calculateManhattanDistance(start, goal);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of calculateEuclideanDistance method, of class Grid.
     */
//    @Test
//    public void testCalculateEuclideanDistance() {
//        System.out.println("calculateEuclideanDistance");
//        Node start = null;
//        Node goal = null;
//        Grid instance = null;
//        double expResult = 0.0;
//        double result = instance.calculateEuclideanDistance(start, goal);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of markPath method, of class Grid.
     */
//    @Test
//    public void testMarkPath() {
//        System.out.println("markPath");
//        Node goal = null;
//        Grid instance = null;
//        instance.markPath(goal);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of printNodesWithParents method, of class Grid.
     */
//    @Test
//    public void testPrintNodesWithParents() {
//        System.out.println("printNodesWithParents");
//        Grid instance = null;
//        instance.printNodesWithParents();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
