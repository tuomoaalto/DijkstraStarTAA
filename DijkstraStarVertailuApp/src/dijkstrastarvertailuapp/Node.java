/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 * A class to store nodes of a graph, with x and y coordinates.
 * @author aaltotuo
 */

public class Node implements Comparable<Node>
{
    private int    xCoord;
    private int    yCoord;
    
    private double hScore;
    private double gScore;
    private double fScore;
    
    private Node   parent;
    private Node[] neighbors;
            
    private boolean isStart;
    private boolean isGoal;
    private boolean isPassable;
    private boolean isVisited;
    private boolean hasParent;
    private boolean isOnThePath;

    
    /**
     * Default constructor for Node
     * @return a new Node object
     */
    public Node() 
    {
        super();
    }
    
    /**
     * A more usefull constructor for Node, to set coordinates and passability during construction
     * @return a new Node object with coordinates and passability value
     */
    public Node(int xCoord, int yCoord, boolean isPassable)
    {
        this.xCoord     = xCoord;
        this.yCoord     = yCoord;
        this.isPassable = isPassable;
        this.isStart    = false;
        this.isGoal     = false;
    }

    /*Getters, setters and toString*/
    public int getxCoord() 
    {
        return xCoord;
    }

    public void setxCoord(int xCoord) 
    {
        this.xCoord = xCoord;
    }

    public int getyCoord() 
    {
        return yCoord;
    }

    public void setyCoord(int yCoord) 
    {
        this.yCoord = yCoord;
    }

    public double gethScore()
    {
        return hScore;
    }

    public void sethScore(double hScore) 
    {
        this.hScore = hScore;
    }
    
    public double getgScore() 
    {
        return gScore;
    }

    public void setgScore(double gScore) 
    {
        this.gScore = gScore;
    }

    public double getfScore() 
    {
        return fScore;
    }

    public void setfScore(double fScore) 
    {
        this.fScore = fScore;
    }
    
    public Node getParent() 
    {
        return parent;
    }

    public void setParent(Node parent) 
    {
        this.parent = parent;
        if (parent != null)
        {
            this.hasParent = true;
        }
    }

    public Node[] getNeighbors() 
    {
        return neighbors;
    }

    public void setNeighbors(Node[] neighbors) 
    {
        this.neighbors = neighbors;
    }

    public boolean isStart()
    {
        return isStart;
    }

    public void setIsStart(boolean isStart) 
    {
        this.isStart = isStart;
    }

    public boolean isGoal() 
    {
        return isGoal;
    }

    public void setIsGoal(boolean isGoal) 
    {
        this.isGoal = isGoal;
    }

    public boolean isPassable() 
    {
        return isPassable;
    }

    public void setIsPassable(boolean isPassable) 
    {
        this.isPassable = isPassable;
    }

    public boolean isVisited() 
    {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) 
    {
        this.isVisited = isVisited;
    }

    public boolean hasParent() 
    {
        return hasParent;
    }

    public void setHasParent(boolean hasParent) 
    {
        this.hasParent = hasParent;
    }
    
    public boolean isOnThePath() 
    {
        return isOnThePath;
    }

    public void setIsOnThePath(boolean isOnThePath) 
    {
        this.isOnThePath = isOnThePath;
    }

    @Override
    public String toString()
    {
        return "(x,y):" + this.xCoord + "," + this.yCoord;
    }



    /*
     * Debug method for printing the neighbors of a Node
     * @return String representation of the neighbors of a Node
     */
    public String printNeighbors()
    {
        Node dummy;
        StringBuilder str = new StringBuilder();
        
        for (int i=0; i < neighbors.length; i++)
        {
            dummy = neighbors[i];
            if (dummy == null)
            {
                continue;
            }
            str.append(dummy.toString());
        }
        return str.toString();
    }

    /*
     * Method for testing equality of this node to a given Object. The input Object is deemed equal to this Node, 
     * if it is a Node and has the same coordinates than this Node.
     * @return equality of Object to Node
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        
        final Node other = (Node) obj;
        if (this.xCoord != other.xCoord) 
        {    
            return false;
        }
        if (this.yCoord != other.yCoord) 
        {
            return false;
        }
        return true;
    }

    /**
     * Method for calculating a hash code for a Node
     * @return hash code for Node
     */
    @Override
    public int hashCode() 
    {
        int hash = 13 * xCoord + 13 * yCoord;
        return hash;
    }

    /**
     * Method to compare two nodes.
     * First comparison is done with x -coordinates
     * @return  0 if nodes are equal
     *          1 if this node is greater (i.e. closer to the top left corner of the grid) than the node compared to.
     *         -1 if this node is lesser  (i.e. closer to the bottom right corner of the grid) than the node compared to.
     */
    @Override
    public int compareTo(Node n) 
    {
        int retval=0;
        
        if (n == null)
        {
            retval = 1;
        }
        else if (this.xCoord > n.xCoord)
        {
            retval = 1;
        }
        else if(this.xCoord < n.xCoord)
        {
            retval = -1;
        }
        else if (this.xCoord == n.xCoord)
        {
            if(this.yCoord > n.yCoord)
            {
                retval = 1;
            }
            else if (this.yCoord < n.yCoord)
            {
                retval = -1;
            }
            else if (this.yCoord == n.yCoord)
            {
                retval = 0;
            }
        }
        return retval;
    }

    /**
     * Method of comparing this Node to a given Node by their fScores
     * @return  0 if the fScores are equal
     *          1 if this node has a greater fScore
     *         -1 if this node has a lesser fScore
     */
    public int compareFScores(Node n)
    {
        int retval=0;
        
        if (n == null)
        {
            retval = 1;
        }
        else if (this.fScore > n.fScore)
        {
            retval = 1;
        }
        else if (this.fScore < n.fScore)
        {
            retval = -1;
        }
        else if (this.fScore == n.fScore)
        {
            retval = 0;
        }        
        return retval;
    }
}