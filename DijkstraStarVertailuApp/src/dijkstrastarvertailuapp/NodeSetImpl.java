/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 *
 * @author aaltotuo
 */
public class NodeSetImpl<T> implements NodeSetI
{
    private final static int DEFAULTCAPACITY = 50; // Default size of the set
    private final static int DEFAULTGROWTH   = 50; // New size for set when growing

    private Node[] nodearray;
    private int    growth;
    private int    elementCount;
    
    public NodeSetImpl()
    {
        this(DEFAULTCAPACITY, DEFAULTGROWTH);
    }

    public NodeSetImpl(int capacity)
    {
        this(capacity, DEFAULTGROWTH);
    }

    public NodeSetImpl(int capacity, int growth)
    {
        if(capacity < 0)
        {
            System.out.println("Capacity must be positive, using default " + DEFAULTCAPACITY + ".");
            capacity = DEFAULTCAPACITY;
        }
        
        if(growth < 0)
        {
            System.out.println("Growth must be positive, using default " + DEFAULTGROWTH + ".");
            growth = DEFAULTGROWTH;
        }

        nodearray = new Node[capacity];
        elementCount = 0;
        this.growth = growth;
    }    
    
    /**
     * Method to get the size of the set.
     * @return size of the set.
     */
    @Override
    public int size() 
    {
        return elementCount;
    }

    /**
     * Method to add a node into the set.
     * If the nodearray is full, this method will automatically resize it to hold more nodes
     * @return true if the addition was successfull
     * @return false if the node was was already in the set or the addition was unsuccessfull.
     */
    @Override
    public boolean add(Node node) 
    {        
        if(this.contains(node) == true)
        {
            return false;
        }

        if (nodearray.length == elementCount)
        {
            Node[] nodearrayNew = new Node[nodearray.length+growth];
            System.arraycopy(nodearray, 0, nodearrayNew, 0, nodearray.length);
            nodearray = nodearrayNew;
            nodearrayNew = null;
        }

        nodearray[elementCount] = node;
        elementCount++;
        return true;
    }

    /**
     * Method to remove a node from the set.
     * @return true if the removal was successfull
     * @return false if the node wasn't found in the set or the removal was unsuccessfull.
     */    
    @Override
    public boolean remove(Node node) 
    {
        if(this.contains(node) == true)
        {
            for(int i=0; i<nodearray.length; i++)
            {
                if (nodearray[i] == node)
                {
                    for(int j=i;j<nodearray.length-1;j++)
                    {
                        nodearray[j] = nodearray[j+1];
                    }
                    elementCount--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to query the set for a specific node
     * @return true  if the node is in the set
     * @return false if the node is not in the set
     */
    @Override
    public boolean contains(Node node) 
    {
        int retval = binarySearch(nodearray, node);

        if (retval == -1) 
        {
            return false;
        }
        else 
        {
            return true;
        }
    }

    /**
     * Helper method to speed up searching through the node array with a binary search.
     * @return -1 if the node was not found in the nodearray
     * @return positive index where the node was found.
     */
    private static int binarySearch(Node[] nodearray, Node subject)
    {
        int left  = 0;
        int right = nodearray.length-1;
        int middle;

        while (left <= right)
        {
            middle = (left+right)/2;

            if (subject == nodearray[middle])
            {
                return middle;
            }

            if (subject.compareTo(nodearray[middle]) == 1 ) 
            {
                right = middle-1;
            }
            else 
            {
                left = middle+1;
            }
        }

        return -1;
    }    

}
