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
public class NodeTest {
    
    public NodeTest() {
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

//    /**
//     * Test of getxCoord method, of class Node.
//     */
//    @Test
//    public void testGetxCoord() {
//        System.out.println("getxCoord");
//        Node instance = new Node();
//        int expResult = 0;
//        int result = instance.getxCoord();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setxCoord method, of class Node.
//     */
//    @Test
//    public void testSetxCoord() {
//        System.out.println("setxCoord");
//        int xCoord = 0;
//        Node instance = new Node();
//        instance.setxCoord(xCoord);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getyCoord method, of class Node.
//     */
//    @Test
//    public void testGetyCoord() {
//        System.out.println("getyCoord");
//        Node instance = new Node();
//        int expResult = 0;
//        int result = instance.getyCoord();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setyCoord method, of class Node.
//     */
//    @Test
//    public void testSetyCoord() {
//        System.out.println("setyCoord");
//        int yCoord = 0;
//        Node instance = new Node();
//        instance.setyCoord(yCoord);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of resetCoord method, of class Node.
//     */
//    @Test
//    public void testResetCoord() {
//        System.out.println("resetCoord");
//        Node instance = new Node();
//        instance.resetCoord();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Node.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Node instance = new Node();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class Node.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Node instance = new Node();
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class Node.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Node instance = new Node();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of compareTo method, of class Node.
     */
    @Test
    public void testCompareToNull() 
    {
        System.out.println("compareInstanceToNull");
        Node n = null;
        Node instance = new Node();
        int expResult = 0;
        int result = instance.compareTo(n);
        assertEquals("Result", 1, result);
    }
    @Test
    public void testCompareToSelf() 
    {
        System.out.println("compareInstanceToSelf");
        Node n = new Node(10, 10);
        Node instance = new Node(10, 10);
        int expResult = 0;
        int result = instance.compareTo(n);
        assertEquals("Result", 0, result);
    }

    @Test
    public void testCompareToGreater() 
    {
        System.out.println("compareInstanceToGreater");
        Node n = new Node(0, 0);
        Node instance = new Node(0, 1);
        int expResult = 0;
        int result = instance.compareTo(n);
        assertEquals("Result", 1, result);
    }

    @Test
    public void testCompareToLesser() 
    {
        System.out.println("compareInstanceToLesser");
        Node n = new Node(0, 0);
        Node instance = new Node(-1, -1);
        int expResult = 0;
        int result = instance.compareTo(n);
        assertEquals("Result", -1, result);
    }     

}
