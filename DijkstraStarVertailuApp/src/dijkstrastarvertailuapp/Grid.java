/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

import java.util.Random;

    
/**
 *
 * @author aaltotuo
 */
public class Grid 
{
    private int rows;
    private int columns;
    private Node[][] nodes;
    
    private Node start;
    private Node goal;
        
    private NodeHeapImpl openset   = new NodeHeapImpl();
    private boolean doDebugPrint = false;
    
    public Grid(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.nodes = new Node[rows][columns];
        
        for (int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                nodes[i][j] = new Node(i, j, true);
            }
        } 
    }
    
    public void createInpassables()
    {
        Random random = new Random();
        
        for (int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if (random.nextDouble() <= 0.2 && nodes[i][j].isStart() == false && nodes[i][j].isGoal() == false)
                {
                    nodes[i][j].setAsPassable(false);
                }
            }
        }        
    }
    
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        
        for (int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if (nodes[i][j].isPassable() == false)
                {
                    str.append("#");
                }
                else if (nodes[i][j].isGoal())
                {
                    str.append("O");
                }
                else if (nodes[i][j].isStart())
                {
                    str.append("X");
                }
                else if (nodes[i][j].isOnThePath())
                {
                    str.append("*");
                }
                else if (nodes[i][j].isVisited())
                {
                    str.append("o");
                }
                else if (nodes[i][j].hasParent())
                {
                    str.append("@");
                }
                else
                {
                    str.append(".");
                }
            }
            str.append("\n");
        }
        str.append("\n");
        
        return str.toString();
    }
    
    public void setStart(int x, int y)
    {
        nodes[x][y].setAsStart(true);
        nodes[x][y].setAsPassable(true);
        nodes[x][y].setParent(null);
        start = nodes[x][y];
    }

    public Node getStart()
    {
        return start;
    }
        
    public void setGoal(int x, int y)
    {
        nodes[x][y].setAsGoal(true);
        nodes[x][y].setAsPassable(true);
        goal = nodes[x][y];
    }

    public Node getGoal() {
        return goal;
    }

    
    public void setImpassable(int x, int y)
    {
        nodes[x][y].setAsPassable(false);
    }
    
    public Node[] findNeighborsToNode(Node node)
    {
        Node[] neighbors = new Node[8];
        int neighborIndex=0;
        int x = node.getxCoord();
        int y = node.getyCoord();
        
        Node upLeft;
        Node up;
        Node upRight;
        Node left;
        Node right;
        Node downLeft;
        Node down;
        Node downRight;
        
        //Up left
        if (x-1 < 0 || y + 1 >= columns)
        {
            upLeft = null; 
        }
        else
        {
            upLeft = nodes[x-1][y+1];
        }
        
        //Up
        if (x < 0 || y+1 >= columns)
        {
            up = null; 
        }
        else
        {
            up = nodes[x][y+1];
        }
        
        //Up right
        if (x+1 >= rows || y+1 >= columns)
        {
            upRight = null;
        }
        else
        {
            upRight = nodes[x+1][y+1];
        }
        
        //Left
        if( x-1 < 0 || y < 0)
        {
            left = null;
        }
        else
        {
            left = nodes[x-1][y];
        }
        
        //Right
        if (x+1 >= rows || y < 0)
        {
            right = null;
        }
        else
        {
            right = nodes[x+1][y];
        }
        
        //Down left
        if (x-1 < 0 || y-1 < 0)
        {
            downLeft = null;
        }
        else
        {
            downLeft  = nodes[x-1][y-1];
        }
        
        //Down
        if (x < 0 || y-1 < 0)
        {
            down = null;
        }
        else
        {
            down = nodes[x][y-1];
        }
        
        //Down right
        if (x+1 >= rows || y-1 < 0)
        {
            downRight = null;
        }
        else
        {
            downRight = nodes[x+1][y-1];
        }

        
        
        if (upLeft != null && upLeft.isPassable())
        {
            neighbors[neighborIndex] = nodes[x-1][y+1]; 
            neighborIndex++;         
        }
        
        if (up != null && up.isPassable())
        {
            neighbors[neighborIndex] = nodes[x][y+1];
            neighborIndex++;         
        }
        
        if (upRight != null && upRight.isPassable())
        {
            neighbors[neighborIndex] = nodes[x+1][y+1];
            neighborIndex++;
        }
        
        if (left != null && left.isPassable())
        {
            neighbors[neighborIndex] = nodes[x-1][y];
            neighborIndex++;         
        }
        
        if (right != null && right.isPassable())
        {
            neighbors[neighborIndex] = nodes[x+1][y];
            neighborIndex++;
        }
        
        if (downLeft != null && downLeft.isPassable())
        {
            neighbors[neighborIndex] = nodes[x-1][y-1]; 
            neighborIndex++;         
        }
        
        if (down != null && down.isPassable())
        {
            neighbors[neighborIndex] = nodes[x][y-1];   
            neighborIndex++;             
        }
        
        if (downRight != null && downRight.isPassable())
        {
            neighbors[neighborIndex] = nodes[x+1][y-1]; 
            neighborIndex++;             
        }
        
        return neighbors;
    }
    
    public Node getNode(int x, int y)
    {
        return nodes[x][y];
    }
 
    public void findShortestPathAStar()
    {
        Node current;
        
        start.setAsVisited(true);
        openset.insert(start);
        start.setgScore(0);
        start.sethScore(calculateManhattanDistance(start, goal));
        start.setfScore(start.getgScore() + start.gethScore());
        
        while (openset.minimum() != null)
        {
            String prev = this.toString();
            
            current = openset.extractMin();
            current.setAsVisited(true);
//            System.out.println("");
//            System.out.println("Current: " + current.toString());
//            System.out.println(openset.contains(current));
//            System.out.println("Scores g: " + current.getgScore() + " h: " + current.gethScore() + " f: " + current.getfScore());

            if (current.compareTo(goal) == 0)
            {
                //Maalissa ollaan, mitäs sitten?
                //System.out.println("Maalissa, current on: " + current.toString());
                markPath(goal);
                return;
            }
            
            //closedset.insert(current);
            Node[] neighbors = this.findNeighborsToNode(current);
            for (Node neighbor : neighbors)
            {           
                //if (neighbor == null || closedset.contains(neighbor) || neighbor.isIsPassable() == false)'
                if (neighbor == null || neighbor.isVisited() == true || neighbor.isPassable() == false)
                {
                    continue;
                }
                
                double potentialgScore = current.getgScore() + calculateEuclideanDistance(current, neighbor);
//                System.out.println("Neighbor: " + neighbor.toString());
//                System.out.println("potentialgScore.: " + potentialgScore);
//                System.out.println("neighborgScore..: " + neighbor.getgScore());
                
                if(openset.contains(neighbor) == false || potentialgScore < neighbor.getgScore())
                {                    
                    if (neighbor.hasParent() == false)
                    {
                        neighbor.setParent(current);
                    }
                    
                    neighbor.setgScore(potentialgScore);
                    neighbor.sethScore(calculateManhattanDistance(neighbor, goal));
                    neighbor.setfScore(neighbor.getgScore() + neighbor.gethScore());
                    openset.insert(neighbor);
//                    System.out.println("Neighbor scores g: " + neighbor.getgScore() + " h: " + neighbor.gethScore() + " f: " + neighbor.getfScore());
                }
            }
            String curr = this.toString(); 
            
            if (doDebugPrint)
            {
                if (prev.compareTo(curr) != 0)
                {
                    System.out.println(this.toString());
                }
            }
            
        }
        System.out.println("Ei löytynyt!");
        
    }   

    public void findShortestPathDijkstra()
    {
        Node current;
        
        start.setAsVisited(true);
        openset.insert(start);
        start.setgScore(0);
        start.sethScore(0);
        start.setfScore(start.getgScore() + start.gethScore());
        
        while (openset.minimum() != null)
        {
            String prev = this.toString();
            
            current = openset.extractMin();
            current.setAsVisited(true);
//            System.out.println("");
//            System.out.println("Current: " + current.toString());
//            System.out.println(openset.contains(current));
//            System.out.println("Scores g: " + current.getgScore() + " h: " + current.gethScore() + " f: " + current.getfScore());

            if (current.compareTo(goal) == 0)
            {
                //Maalissa ollaan, mitäs sitten?
                //System.out.println("Maalissa, current on: " + current.toString());
                markPath(goal);
                return;
            }
            
            //closedset.insert(current);
            Node[] neighbors = this.findNeighborsToNode(current);
            for (Node neighbor : neighbors)
            {           
                //if (neighbor == null || closedset.contains(neighbor) || neighbor.isIsPassable() == false)'
                if (neighbor == null || neighbor.isVisited() == true || neighbor.isPassable() == false)
                {
                    continue;
                }
                
                double potentialgScore = current.getgScore() + calculateEuclideanDistance(current, neighbor);
//                System.out.println("Neighbor: " + neighbor.toString());
//                System.out.println("potentialgScore.: " + potentialgScore);
//                System.out.println("neighborgScore..: " + neighbor.getgScore());
                
                if(openset.contains(neighbor) == false || potentialgScore < neighbor.getgScore())
                {                    
                    if (neighbor.hasParent() == false)
                    {
                        neighbor.setParent(current);
                    }
                    
                    neighbor.setgScore(potentialgScore);
                    neighbor.sethScore(0);
                    neighbor.setfScore(neighbor.getgScore() + neighbor.gethScore());
                    openset.insert(neighbor);
//                    System.out.println("Neighbor scores g: " + neighbor.getgScore() + " h: " + neighbor.gethScore() + " f: " + neighbor.getfScore());
                }
            }
            String curr = this.toString();
            
            if (doDebugPrint)
            {
                if (prev.compareTo(curr) != 0)
                {
                    System.out.println(this.toString());
                }
            }
        }
        System.out.println("Ei löytynyt!");
    }
    
    public int calculateManhattanDistance(Node start, Node goal) 
    {
        int x1 = start.getxCoord();
        int x2 = goal.getxCoord();
        
        int y1 = start.getyCoord();
        int y2 = goal.getyCoord();
        
        int result = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        
        return result;
    }
    
    public double calculateEuclideanDistance(Node start, Node goal)
    {
        int x1 = start.getxCoord();
        int x2 = goal.getxCoord();
        
        int y1 = start.getyCoord();
        int y2 = goal.getyCoord();
        
        double result = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        
        return result;
    }

    public void markPath(Node goal)
    {
        Node temp = goal;
        while (temp.hasParent())
        {
            temp.setOnThePath(true);
            temp = temp.getParent();
        }
    }

    public void resetGrid()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++) 
            {
                nodes[i][j].sethScore(0);
                nodes[i][j].setgScore(0);
                nodes[i][j].setfScore(0);
                nodes[i][j].setParent(null);
                nodes[i][j].setNeighbors(null);
                
                nodes[i][j].setAsVisited(false);
                nodes[i][j].setAsParent(false);
                nodes[i][j].setOnThePath(false);
            }
        }
        openset.resetHeap();
    }

}
