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
    private int xCoord;
    private int yCoord;

    public Node() 
    {
        ;
    }
    
    public Node(int xCoord, int yCoord) 
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
    public void resetCoord()
    {
        this.xCoord=0;
        this.yCoord=0;
    }
    
    @Override
    public String toString()
    {
        return ("(x,y):" + xCoord + "," + yCoord + " ");
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
    
}