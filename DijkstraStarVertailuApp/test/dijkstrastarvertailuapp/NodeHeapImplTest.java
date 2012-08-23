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

        Node node1 = new Node(0,0, true);
        Node node2 = new Node(1,-1, true);
        Node node3 = new Node(2,-2, true);
        Node node4 = new Node(3,-3, true);
        Node node5 = new Node(4,-4, true);

        node1.setfScore(5);
        node2.setfScore(4);
        node3.setfScore(3);
        node4.setfScore(2);
        node5.setfScore(1);
        
        instance.insert(node5);
        instance.insert(node4);
        instance.insert(node3);
        instance.insert(node2);
        instance.insert(node1);

        double expResult = 1;
        double result = instance.minimum().getfScore();
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testMinimum2() 
    {

        System.out.println("minimum2");
        NodeHeapImpl instance = new NodeHeapImpl();
        
        Node node1 = new Node(0,0, true);
        Node node2 = new Node(1,-1, true);
        Node node3 = new Node(2,-2, true);
        Node node4 = new Node(3,-3, true);
        Node node5 = new Node(4,-4, true);

        node1.setfScore(5567);
        node2.setfScore(41);
        node3.setfScore(0.3);
        node4.setfScore(201111);
        node5.setfScore(1.7);                
        
        instance.insert(node1);
        instance.insert(node2);
        instance.insert(node3);
        instance.insert(node4);
        instance.insert(node5);

        
        Node expResult = new Node(0,0, true);
        expResult.setfScore(0.3);
        Node result = instance.minimum();
        assertEquals(expResult.getfScore(), result.getfScore(), 0.01);
    }    

    /**
     * Test of minimum method, of class NodeHeapImpl.
     */
    @Test
    public void testMinimum3() 
    {
        System.out.println("testMinimum3");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node expResult = null;
        Node result = instance.minimum();
        assertEquals(expResult, result);
    }

    /**
     * Test of minimum method, of class NodeHeapImpl.
     */    
    @Test
    public void testMinimum4() 
    {
        System.out.println("testMinimum4");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node expResult1 = new Node(0,0,true); expResult1.setfScore(1);
        Node expResult2 = new Node(0,2,true); expResult1.setfScore(2);
        Node expResult3 = new Node(0,4,true); expResult1.setfScore(3);
        Node expResult4 = new Node(0,3,true); expResult1.setfScore(4);
        Node expResult5 = new Node(0,1,true); expResult1.setfScore(5);
        Node expResult6 = null;
        
        Node node1 = new Node(0,0, true); node1.setfScore(1); instance.insert(node1);
        Node node2 = new Node(0,1, true); node2.setfScore(5); instance.insert(node2);
        Node node3 = new Node(0,2, true); node3.setfScore(2); instance.insert(node3);
        Node node4 = new Node(0,3, true); node4.setfScore(4); instance.insert(node4);
        Node node5 = new Node(0,4, true); node5.setfScore(3); instance.insert(node5);
        
        Node result1 = instance.extractMin();
        assertEquals(expResult1, result1); 
        
        Node result2 = instance.extractMin();
        assertEquals(expResult2, result2);
        
        Node result3 = instance.extractMin();
        assertEquals(expResult3, result3);
        
        Node result4 = instance.extractMin();
        assertEquals(expResult4, result4);
        
        Node result5 = instance.extractMin();
        assertEquals(expResult5, result5);
        
        Node result6 = instance.minimum();
        assertEquals(expResult6, result6);
    }     
    

    /**
     * Test of extractMin method, of class NodeHeapImpl.
     */
    @Test
    public void testExtractMin1()
    {
        System.out.println("extractMin");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node expResult1 = new Node(0,0,  true);
        Node expResult2 = new Node(1,-1, true);
        
        expResult1.setfScore(0.1);
        expResult2.setfScore(0.2);
        
        Node node4 = new Node(3,-3, true);
        Node node5 = new Node(4,-4, true);
        Node node1 = new Node(0,0,  true);
        Node node2 = new Node(1,-1, true);
        Node node3 = new Node(2,-2, true);
        
        node1.setfScore(56.1);
        node2.setfScore(0.1);
        node3.setfScore(1234);
        node4.setfScore(78911);
        node5.setfScore(0.2);
        
        instance.insert(node5);
        instance.insert(node4);
        instance.insert(node3);
        instance.insert(node2);
        instance.insert(node1);        
        
        
        Node result1 = instance.extractMin();
        assertEquals(expResult1.getfScore(), result1.getfScore(), 0.01);

        Node result2 = instance.extractMin();
        assertEquals(expResult2.getfScore(), result2.getfScore(), 0.01);
    }

    @Test
    public void testExtractMin2()
    {
        System.out.println("extractMin2");
        NodeHeapImpl instance = new NodeHeapImpl();
        Node expResult1  = new Node(0,1,  true); expResult1.setfScore(0.00002);        //
        Node expResult2  = new Node(0,2,  true); expResult2.setfScore(0.0003);         //
        Node expResult3  = new Node(0,3,  true); expResult3.setfScore(1.23);           //
        Node expResult4  = new Node(0,4,  true); expResult4.setfScore(2.56);           //
        Node expResult5  = new Node(0,5,  true); expResult5.setfScore(3.6);            //
        Node expResult6  = new Node(0,6,  true); expResult6.setfScore(44.789);         //
        Node expResult7  = new Node(0,7,  true); expResult7.setfScore(50.4);           //
        Node expResult8  = new Node(0,8,  true); expResult8.setfScore(76.1);           //
        Node expResult9  = new Node(0,9,  true); expResult9.setfScore(100);            //
        Node expResult10 = new Node(0,10, true); expResult10.setfScore(134.11);        //
        Node expResult11 = new Node(0,11, true); expResult11.setfScore(150.678900);    //
        Node expResult12 = new Node(0,12, true); expResult12.setfScore(211.0);         //
        Node expResult13 = new Node(0,13, true); expResult13.setfScore(1370.14);       //
        Node expResult14 = new Node(0,14, true); expResult14.setfScore(5672.46454323); //
        Node expResult15 = new Node(0,15, true); expResult15.setfScore(10000.8);       //
        
        Node node1  = new Node(1,1,   true); node1.setfScore(44.789); 
        Node node2  = new Node(2,2,   true); node2.setfScore(2.56);
        Node node3  = new Node(3,3,   true); node3.setfScore(76.1); 
        Node node4  = new Node(4,4,   true); node4.setfScore(211.0); 
        Node node5  = new Node(5,5,   true); node5.setfScore(0.00002);
        Node node6  = new Node(6,6,   true); node6.setfScore(1370.14);
        Node node7  = new Node(7,7,   true); node7.setfScore(10000.8);
        Node node8  = new Node(8,8,   true); node8.setfScore(5672.46454323);
        Node node9  = new Node(9,9,   true); node9.setfScore(134.11);
        Node node10 = new Node(10,10, true); node10.setfScore(150.678900);
        Node node11 = new Node(11,11, true); node11.setfScore(100);
        Node node12 = new Node(12,12, true); node12.setfScore(50.4); 
        Node node13 = new Node(13,13, true); node13.setfScore(3.6);
        Node node14 = new Node(14,14, true); node14.setfScore(1.23);
        Node node15 = new Node(15,15, true); node15.setfScore(0.0003);

        instance.insert(node2);
        instance.insert(node11);
        instance.insert(node3);
        instance.insert(node12);
        instance.insert(node4);
        instance.insert(node13);
        instance.insert(node5);
        instance.insert(node14);
        instance.insert(node6);
        instance.insert(node1);
        instance.insert(node10);
        instance.insert(node7);
        instance.insert(node15);
        instance.insert(node8);
        instance.insert(node9);      

        Node result1  = instance.extractMin(); assertEquals(expResult1.getfScore(),  result1.getfScore(), 0.000000001);
        Node result2  = instance.extractMin(); assertEquals(expResult2.getfScore(),  result2.getfScore(), 0.000000001);
        Node result3  = instance.extractMin(); assertEquals(expResult3.getfScore(),  result3.getfScore(), 0.000000001);
        Node result4  = instance.extractMin(); assertEquals(expResult4.getfScore(),  result4.getfScore(), 0.000000001);
        Node result5  = instance.extractMin(); assertEquals(expResult5.getfScore(),  result5.getfScore(), 0.000000001);
        Node result6  = instance.extractMin(); assertEquals(expResult6.getfScore(),  result6.getfScore(), 0.000000001);
        Node result7  = instance.extractMin(); assertEquals(expResult7.getfScore(),  result7.getfScore(), 0.000000001);
        Node result8  = instance.extractMin(); assertEquals(expResult8.getfScore(),  result8.getfScore(), 0.000000001);
        Node result9  = instance.extractMin(); assertEquals(expResult9.getfScore(),  result9.getfScore(), 0.000000001);
        Node result10 = instance.extractMin(); assertEquals(expResult10.getfScore(), result10.getfScore(), 0.000000001);
        Node result11 = instance.extractMin(); assertEquals(expResult11.getfScore(), result11.getfScore(), 0.000000001);
        Node result12 = instance.extractMin(); assertEquals(expResult12.getfScore(), result12.getfScore(), 0.000000001);
        Node result13 = instance.extractMin(); assertEquals(expResult13.getfScore(), result13.getfScore(), 0.000000001);
        Node result14 = instance.extractMin(); assertEquals(expResult14.getfScore(), result14.getfScore(), 0.000000001);
        Node result15 = instance.extractMin(); assertEquals(expResult15.getfScore(), result15.getfScore(), 0.000000001);

    }    
    


    /**
     * Test of insert method, of class NodeHeapImpl.
     */
    @Test
    public void testInsert()
    {
        System.out.println("testInsert begins");
        Node key1 = new Node(0,0, true);
        Node key2 = new Node(0,0, true);
        key1.setfScore(10.0);
        key2.setfScore(11.0);
        
        NodeHeapImpl instance = new NodeHeapImpl();

        assertTrue(instance.insert(key1));
        assertTrue(instance.contains(key1));
        assertFalse(instance.insert(key2));
    }

   
    
    

    /**
     * Test of decreaseKey method, of class NodeHeapImpl.
     */
//    @Test
//    public void testDecreaseKey() {
//        System.out.println("decreaseKey");
//        int index = 0;
//        double fScore = 0.0;
//        NodeHeapImpl instance = new NodeHeapImpl();
//        instance.decreaseKey(index, fScore);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of contains method, of class NodeHeapImpl.
     */
    @Test
    public void testContains1() 
    {
        System.out.println("testContains1 begins");
        Node node = null;
        NodeHeapImpl instance = new NodeHeapImpl();
        boolean expResult = false;
        boolean result = instance.contains(node);
        assertEquals(expResult, result);
    }

    @Test
    public void testContains3() 
    {
        System.out.println("testContains3 begins");
        Node node = new Node(0,0, true);
        node.setfScore(0);
        NodeHeapImpl instance = new NodeHeapImpl();
        
        instance.insert(node);
                
        Node temp = instance.extractMin();

        assertFalse(instance.contains(node));
    }

    
}
