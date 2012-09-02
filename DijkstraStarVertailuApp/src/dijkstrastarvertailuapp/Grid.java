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
        
    private NodeHeapImpl openset = new NodeHeapImpl();
    private boolean doDebugPrint = false;
    
    /**
     * Constructor for Grid.
     * @param rows    the number of rows in the grid. Indexing starts from 0, so use at maximum rows-1 when indexing.
     * @param columns the number of columns in the grid. Indexing starts from 0, so use at maximum columns-1 when indexing.
     * @return a new Grid
     */
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
    
    /*Setters, getters and toString*/
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public void setStart(int x, int y)
    {
        nodes[x][y].setIsStart(true);
        nodes[x][y].setIsPassable(true);
        nodes[x][y].setParent(null);
        start = nodes[x][y];
    }

    public Node getStart()
    {
        return start;
    }
        
    public void setGoal(int x, int y)
    {
        nodes[x][y].setIsGoal(true);
        nodes[x][y].setIsPassable(true);
        goal = nodes[x][y];
    }

    public Node getGoal() 
    {
        return goal;
    }
    
    public void setImpassable(int x, int y)
    {
        nodes[x][y].setIsPassable(false);
    }

    public Node getNode(int x, int y)
    {
        return nodes[x][y];
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
                    str.append("o");
                }
                else if (nodes[i][j].isVisited())
                {
                    str.append(" ");
                }
                else if (nodes[i][j].hasParent())
                {
                    str.append("H");
                }
                else
                {
                    str.append(".");
                }
            }
            str.append("\n");
        }

        str.deleteCharAt(str.length()-1);
        
        return str.toString();
    }

    
    
    
    
    /**
     * Method for creating random inpassable Nodes in the Grid.
     * The method goes through every Node in the grid, and sets the node as inpassable 20% of the time, 
     * if the node isn't already set as the starting point or as the goal.
     */
    public void createInpassables()
    {
        Random random = new Random();
        
        for (int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if (random.nextDouble() <= 0.2 && nodes[i][j].isStart() == false && nodes[i][j].isGoal() == false)
                {
                    nodes[i][j].setIsPassable(false);
                }
            }
        }        
    }

    /**
     * Method for finding neighbors to a Node.
     * The method assumes that we're working in a grid where movement to all directions is allowed and 
     * that there are no parts of the grid lacking nodes. If a neighbor is searched beyond the bounds 
     * of the grid or the neighbor is set as impassable, it is left out of the list of neighbors.
     * @param node node to which neighbors need to be found
     * @return list of neighbors for the given Node
     */
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
    
    /**
     * Method for finding the shortest path through the Grid.
     * @param algorithm the algorithm to be used in the search. Allowed values are "A" for A* -algorithm, and "D" for Dijkstra's algorithm. If no value or an invalid value is given, the method defaults to A* -algorithm.
     * @param heuristic the heuristic to be used with A* -algorithm. Allowed values are "M" for Manhattan -heuristic and "E" for Euclidean -heuristic. This parameter has no effect if the algorithm used is Dijkstra. If parameter is left empty while A* -algorithm is selected, the method defaults to using Euclidean heuristic.
     */
    public void findShortestPath(String algorithm, String heuristic)
    {
        Node current;
        
        start.setgScore(0); 
        if (algorithm.matches("D"))
        {
            start.sethScore(0);
        }
        else
        {
            if(heuristic.matches("M"))
            {
                start.sethScore(calculateManhattanDistance(start, goal));
            }
            else
            {
                start.sethScore(calculateEuclideanDistance(start, goal));
            }
        }
        start.setfScore(start.getgScore() + start.gethScore());
        
        openset.insert(start);
        
        while (openset.minimum() != null)
        {   
            current = openset.extractMin();
            current.setIsVisited(true);

            if (current.compareTo(goal) == 0)
            {
                markPath(goal);
                return;
            }

            Node[] neighbors = this.findNeighborsToNode(current);
            for (Node neighbor : neighbors)
            {           
                if (neighbor == null || neighbor.isVisited() == true || neighbor.isPassable() == false)
                {
                    continue;
                }
                
                double potentialgScore = current.getgScore() + calculateEuclideanDistance(current, neighbor);
                                
                if(openset.contains(neighbor) == false || potentialgScore < neighbor.getgScore())
                {                    
                    neighbor.setParent(current);

                    neighbor.setgScore(potentialgScore);
  
                    if(algorithm.matches("D"))
                    {
                        neighbor.sethScore(0);
                    }
                    else
                    {
                        if(heuristic.matches("M"))
                        {
                            neighbor.sethScore(calculateManhattanDistance(neighbor, goal));
                        }
                        else
                        {
                            neighbor.sethScore(calculateEuclideanDistance(neighbor, goal));
                        }
                    }
		    
                    neighbor.setfScore(neighbor.getgScore() + neighbor.gethScore());
                    openset.insert(neighbor);
                }
            }
        }
        System.out.println("Ei löytynyt!");
        return;
        
    }   
    
    /**
     * Method for calculating distance between two Nodes in the Grid using Manhattan -heuristic.
     * @return distance from start node to goal node.
     */
    public int calculateManhattanDistance(Node start, Node goal) 
    {
        int x1 = start.getxCoord();
        int x2 = goal.getxCoord();
        
        int y1 = start.getyCoord();
        int y2 = goal.getyCoord();
        
        int result = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        
        return result;
    }

    /**
     * Method for calculating distance between two Nodes in the Grid using Euclidean -heuristic.
     * @return distance from start node to goal node.
     */    
    public double calculateEuclideanDistance(Node start, Node goal)
    {
        int x1 = start.getxCoord();
        int x2 = goal.getxCoord();
        
        int y1 = start.getyCoord();
        int y2 = goal.getyCoord();
        
        double result = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        
        return result;
    }

    /**
     * Method for marking the shorteat path in the Grid.
     * Method uses the parent value of each subsequent Node to 'walk' back to the starting point. The path is marked by setting the isOnThePath -value of each Node to true.
     * @param goal the goal Node of the path.
     */
    public void markPath(Node goal)
    {
        Node temp = goal;
        while (temp.hasParent())
        {
            temp.setIsOnThePath(true);
            temp = temp.getParent();
            if (temp.isStart())
            {
                break;
            }
        }
    }

    /**
     * Method for resetting the grid to its start state, or to a even further state of where the inpassables are not set.
     * @param resetInpassables if this flag is set to true, this method also resets all the nodes marked inpassable.
     */
    public void resetGrid(boolean resetInpassables)
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
                
                nodes[i][j].setIsVisited(false);
                nodes[i][j].setHasParent(false);
                nodes[i][j].setIsOnThePath(false);
                if (resetInpassables == true)
                {
                    nodes[i][j].setIsPassable(true);
                }
            }
        }
        openset.resetHeap();
    }

    /**
     * Method for generating random start and goal Nodes in the grid.
     */
    public void setRandomStartAndGoal()
    {
        Random coord = new Random();
        
        int startX = 0;
        int startY = 0;
        int goalX  = 0;
        int goalY  = 0;
    
        while (startX == goalX && startY == goalY)
        {
            startX = coord.nextInt(rows);
            startY = coord.nextInt(columns);
            goalX  = coord.nextInt(rows);
            goalY  = coord.nextInt(columns);
        }
        
        this.setStart(startX, startY);
        this.setGoal(goalX, goalY);
    }

}
