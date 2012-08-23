/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 *
 * @author aaltotuo
 */
public class DijkstraStarVertailuApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Grid gridi = new Grid(50, 50);        
        gridi.setStart(0, 0);
        gridi.setGoal(49, 49);
        gridi.createInpassables();
        long startTime=0;
        long endTime=0;
        
        System.out.println("====================================================================================");
        System.out.println("===================================Verkko===========================================");
        System.out.println("====================================================================================");        
        
        System.out.println(gridi.toString());
        
        System.out.println("====================================================================================");
        System.out.println("====================================A-star==========================================");
        System.out.println("====================================================================================");
        
        startTime = System.currentTimeMillis();
        gridi.findShortestPathAStar();
        endTime = System.currentTimeMillis();
        System.out.println(gridi.toString());
        
        System.out.println("Cost to goal:" + gridi.getGoal().getfScore());
        System.out.println("Processing time: " + (endTime - startTime) + "ms.");
        
        gridi.resetGrid();
        
        System.out.println("====================================================================================");
        System.out.println("===================================Dijkstra=========================================");
        System.out.println("====================================================================================");        
        
        startTime = System.currentTimeMillis();
        gridi.findShortestPathDijkstra();
        endTime = System.currentTimeMillis();
        System.out.println(gridi.toString());
     
        System.out.println("Cost to goal:" + gridi.getGoal().getfScore());
        System.out.println("Processing time: " + (endTime - startTime) + "ms.");
    }
}
