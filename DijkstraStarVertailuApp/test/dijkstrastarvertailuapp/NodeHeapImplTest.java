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
public class NodeHeapImplTest {
    
    public NodeHeapImplTest() {
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
     * Test of minimum method, of class NodeHeapImpl.
     */
    @Test
    public void testMinimum1() 
    {

        System.out.println("minimum1");
        NodeHeapImpl instance = new NodeHeapImpl();

        Node node5 = new Node(4,-4);
        Node node4 = new Node(3,-3);
        Node node3 = new Node(2,-2);
        Node node2 = new Node(1,-1);
        Node node1 = new Node(0,0);

        instance.insert(node5);
        instance.insert(node4);
        instance.insert(node3);
        instance.insert(node2);
        instance.insert(node1);

        Node expResult = new Node(0,0);
        Node result = instance.minimum();
        assertEquals(expResult, result);
    }

    @Test
    public void testMinimum2() 
    {

        System.out.println("minimum2");
        NodeHeapImpl instance = new NodeHeapImpl();
        
        Node node1 = new Node(0,0);
        Node node2 = new Node(1,-1);
        Node node3 = new Node(2,-2);
        Node node4 = new Node(3,-3);
        Node node5 = new Node(4,-4);
                
        instance.insert(node1);
        instance.insert(node2);
        instance.insert(node3);
        instance.insert(node4);
        instance.insert(node5);

        Node expResult = new Node(0,0);
        Node result = instance.minimum();
        assertEquals(expResult, result);
    }    
    

    /**
     * Test of extractMin method, of class NodeHeapImpl.
     */
    @Test
    public void testExtractMin1()
    {
        System.out.println("extractMin");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node expResult1 = new Node(0,0);
        Node expResult2 = new Node(1,-1);
        
        Node node4 = new Node(3,-3);
        Node node5 = new Node(4,-4);
        Node node1 = new Node(0,0);
        Node node2 = new Node(1,-1);
        Node node3 = new Node(2,-2);
        
        instance.insert(node5);
        instance.insert(node4);
        instance.insert(node3);
        instance.insert(node2);
        instance.insert(node1);        
        
        
        Node result1 = instance.extractMin();
        assertEquals(expResult1, result1);

        Node result2 = instance.extractMin();
        assertEquals(expResult2, result2);
    }

    @Test
    public void testExtractMin2()
    {
        System.out.println("extractMin2");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node expResult1  = new Node(0,0);
        Node expResult2  = new Node(1,-1);
        Node expResult3  = new Node(2,-2);
        Node expResult4  = new Node(3,-3);
        Node expResult5  = new Node(4,-4);
        Node expResult6  = new Node(5,-5);
        Node expResult7  = new Node(6,-6);
        Node expResult8  = new Node(7,-7);
        Node expResult9  = new Node(8,-8);
        Node expResult10 = new Node(9,-9);
        Node expResult11 = new Node(10,-10);
        Node expResult12 = new Node(11,-11);
        Node expResult13 = new Node(12,-12);
        Node expResult14 = new Node(13,-13);
        Node expResult15 = new Node(14,-14);
        Node expResult16 = new Node(15,-15);
        Node expResult17 = new Node(16,-16);
        Node expResult18 = new Node(17,-17);
        Node expResult19 = new Node(18,-18);
        Node expResult20 = new Node(19,-19);
        
        Node node1 = new Node(0,0);
        Node node2 = new Node(1,-1);
        Node node3 = new Node(2,-2);
        Node node4 = new Node(3,-3);
        Node node5 = new Node(4,-4);
        Node node6 = new Node(5,-5);
        Node node7 = new Node(6,-6);
        Node node8 = new Node(7,-7);
        Node node9 = new Node(8,-8);
        Node node10 = new Node(9,-9);
        Node node11 = new Node(10,-10);
        Node node12 = new Node(11,-11);
        Node node13 = new Node(12,-12);
        Node node14 = new Node(13,-13);
        Node node15 = new Node(14,-14);
        Node node16 = new Node(15,-15);
        Node node17 = new Node(16,-16);
        Node node18 = new Node(17,-17);
        Node node19 = new Node(18,-18);
        Node node20 = new Node(19,-19);

        instance.insert(node2);
        instance.insert(node11);
        instance.insert(node3);
        instance.insert(node12);
        instance.insert(node4);
        instance.insert(node13);
        instance.insert(node5);
        instance.insert(node14);
        instance.insert(node6);
        instance.insert(node16);
        instance.insert(node1);
        instance.insert(node10);
        instance.insert(node7);
        instance.insert(node15);
        instance.insert(node8);
        instance.insert(node18);
        instance.insert(node9);      
        instance.insert(node17);
        instance.insert(node19);
        instance.insert(node20);         

        Node result1  = instance.extractMin(); assertEquals(expResult1,  result1);
        Node result2  = instance.extractMin(); assertEquals(expResult2,  result2);     
        Node result3  = instance.extractMin(); assertEquals(expResult3,  result3);
        Node result4  = instance.extractMin(); assertEquals(expResult4,  result4);
        Node result5  = instance.extractMin(); assertEquals(expResult5,  result5);
        Node result6  = instance.extractMin(); assertEquals(expResult6,  result6);
        Node result7  = instance.extractMin(); assertEquals(expResult7,  result7);
        Node result8  = instance.extractMin(); assertEquals(expResult8,  result8);
        Node result9  = instance.extractMin(); assertEquals(expResult9,  result9);
        Node result10 = instance.extractMin(); assertEquals(expResult10, result10);
        Node result11 = instance.extractMin(); assertEquals(expResult11, result11);
        Node result12 = instance.extractMin(); assertEquals(expResult12, result12);
        Node result13 = instance.extractMin(); assertEquals(expResult13, result13);
        Node result14 = instance.extractMin(); assertEquals(expResult14, result14);
        Node result15 = instance.extractMin(); assertEquals(expResult15, result15);
        Node result16 = instance.extractMin(); assertEquals(expResult16, result16);
        Node result17 = instance.extractMin(); assertEquals(expResult17, result17);
        Node result18 = instance.extractMin(); assertEquals(expResult18, result18);
        Node result19 = instance.extractMin(); assertEquals(expResult19, result19);
        Node result20 = instance.extractMin(); assertEquals(expResult20, result20); 

    }    
    
//
//
//    /**
//     * Test of insert method, of class NodeHeapImpl.
//     */
//    @Test
//    public void testInsert() {
//        System.out.println("insert");
//        Node key = null;
//        NodeHeapImpl instance = new NodeHeapImpl();
//        instance.insert(key);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
    /**
     * Test of toString method, of class NodeHeapImpl.
     */
    @Test
    public void testToString1() 
    {
        System.out.println("toString1");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node node1 = new Node(0,0);
        Node node2 = new Node(1,-1);
        Node node3 = new Node(2,-2);
        Node node4 = new Node(3,-3);
        Node node5 = new Node(4,-4);
        
        instance.insert(node1);
        instance.insert(node2);
        instance.insert(node3);
        instance.insert(node4);
        instance.insert(node5);
        
        String expResult = "(x,y):0,0 (x,y):1,-1 (x,y):2,-2 (x,y):3,-3 (x,y):4,-4 ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

   /**
     * Test of toString method, of class NodeHeapImpl.
     */
    @Test
    public void testToString2() 
    {
        System.out.println("toString2");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node node1 = new Node(0,0);
        Node node2 = new Node(1,-1);
        Node node3 = new Node(2,-2);
        Node node4 = new Node(3,-3);
        Node node5 = new Node(4,-4);
        
        instance.insert(node5);
        instance.insert(node4);
        instance.insert(node3);
        instance.insert(node2);
        instance.insert(node1);
        
        String expResult = "(x,y):0,0 (x,y):1,-1 (x,y):2,-2 (x,y):3,-3 (x,y):4,-4 ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
