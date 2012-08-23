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

    public Node() 
    {
        super();
    }
    
    public Node(int xCoord, int yCoord, boolean isPassable)
    {
        this.xCoord     = xCoord;
        this.yCoord     = yCoord;
        this.isPassable = isPassable;
        this.isStart    = false;
        this.isGoal     = false;
    }

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

    public void setAsStart(boolean isStart) 
    {
        this.isStart = isStart;
    }

    public boolean isGoal() 
    {
        return isGoal;
    }

    public void setAsGoal(boolean isGoal) 
    {
        this.isGoal = isGoal;
    }

    public boolean isPassable() 
    {
        return isPassable;
    }

    public void setAsPassable(boolean isPassable) 
    {
        this.isPassable = isPassable;
    }

    public boolean isVisited() 
    {
        return isVisited;
    }

    public void setAsVisited(boolean isVisited) 
    {
        this.isVisited = isVisited;
    }

    public boolean hasParent() 
    {
        return hasParent;
    }

    public void setAsParent(boolean hasParent) 
    {
        this.hasParent = hasParent;
    }
    
    public boolean isOnThePath() 
    {
        return isOnThePath;
    }

    public void setOnThePath(boolean isOnThePath) 
    {
        this.isOnThePath = isOnThePath;
    }

    
    
    @Override
    public String toString()
    {
        return "(x,y):" + this.xCoord + "," + this.yCoord;
    }
    
    public String pathToString()
    {
        StringBuilder str = new StringBuilder();
        
        if (this.hasParent)
        {
            str.append("(x,y):").append(xCoord).append(",").append(yCoord);
            str.append(" Parent: (x,y): ").append(this.parent.getxCoord()).append(",").append(this.parent.getyCoord());
        }
        
        return str.toString();    
    }
    
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

    @Override
    public int hashCode() 
    {
        int hash = 13 * xCoord + 13 * yCoord;
        return hash;
    }

    /**
     * Method to compare two nodes.
     * First comparison is done with x -coordinates
     * @return 0  if nodes are equal
     * @return 1  if this node is greater (i.e. closer to the top left corner of the grid) than the node compared to.
     * @return -1 if this node is lesser  (i.e. closer to the bottom right corner of the grid) than the node compared to.
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