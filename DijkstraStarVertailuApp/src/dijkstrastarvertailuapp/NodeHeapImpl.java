/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 *
 * @author aaltotuo
 */
public class NodeHeapImpl implements NodeHeapI
{
    private int heapSize=-1;
    private final int initialSize  = 10;
    private final int growthFactor = 2;
    Node[] nodearray = new Node[initialSize];
    
    
    /**
     * Method to return the smallest Node-object from the heap, without removing it from the heap.
     * @return Node-object, null if the heap is empty.
     */
    @Override
    public Node minimum() 
    {
        if (heapSize == -1)
        {
            return null;
        }
        return nodearray[0];
    }

    /**
     * Method to extract (get and remove) the minimum value from the heap.
     * @return smallest Node-object stored in the the heap.
     */    
    @Override
    public Node extractMin() 
    {
        Node temp;
        
        if (heapSize == -1) 
        {
             //No nodes in heap.
            return null;
        }
        else if (heapSize == 0)
        {
            heapSize--;
            temp = nodearray[0];
            nodearray[0] = null;
            return temp;
            
        }
        
        temp = nodearray[0];
        
        nodearray[0] = nodearray[heapSize];
        heapSize--;
        
        heapifyMin(0);
        
        return temp;
        
    }

    /**
     * Method to insert new Nodes to the heap.
     * Insert automatically moves the inserted Node to the correct position within the heap.
     * 
     */
    @Override
    public boolean insert(Node key)
    {        
        if (key == null)
        {
            return false;
        }

        if(heapSize == -1)
        {
            nodearray[0] = key;
            heapSize++;
            return true;
        }
        
        if (this.contains(key))
        {
            return false;
        }
        
        heapSize++;
        int index = heapSize;

        if (heapSize == nodearray.length)
        {
            grow();
        }
        
        //while(index > 0 && nodearray[parent(index)].compareTo(key) == 1)
        while(index > 0 && nodearray[parent(index)].compareFScores(key) == 1)
        {
            nodearray[index] = nodearray[parent(index)];
            index = parent(index);
        }
        nodearray[index] = key;
        return true;
        
    }

    
    /**
     * Method to get a String -representation of the heap
     * @return String
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        Node temp;
        for (int i = 0; i <= heapSize; i++) 
        {
            temp = nodearray[i];
            output.append(temp.toString());
        }
        return output.toString();
    }

    
    /**
     * Internal method for repairing the heap back to correct order after a Node is removed. 
     */
    private void heapifyMin(int index) 
    {
        int leftroot = left(index);
        int rightroot = right(index);
        int smallest;
        
        if (rightroot <= heapSize)
        {
            //if( nodearray[leftroot].compareTo(nodearray[rightroot]) == 1)
            if( nodearray[leftroot].compareFScores(nodearray[rightroot]) == 1)
            {
                smallest = rightroot;
            }
            else
            {
                smallest = leftroot;
            }
            
            //if(nodearray[index].compareTo(nodearray[smallest]) == 1)
            if(nodearray[index].compareFScores(nodearray[smallest]) == 1)
            {
                swapNodes(index, smallest);
                heapifyMin(smallest);
            }   
        }
    }

    /**
     * Internal method to get the index of the parent node of a given index
     * @return index where the parent node of the given index resides.
     */
    private int parent(int index)
    {
        return index/2;
    }

    /**
     * Internal method to get the index of the left child node of a given index
     * @return index of the left child node of the given index.
     */    
    private int left(int index)
    {
        return index*2;
    }

    /**
     * Internal method to get the index of the right child node of a given index
     * @return index of the right child node of the given index.
     */
    private int right(int index)
    {
        return (index*2)+1;
    }

    /**
     * Internal method to swap positions two Nodes in the heap.
     * 
     */    
    private void swapNodes(int index, int smallest) 
    {
        Node temp;
        temp = nodearray[index];
        nodearray[index] = nodearray[smallest];
        nodearray[smallest] = temp;
    }

    /**
     * Internal method to grow the size of the heap when it's running out of space.
     */
    private void grow()
    {
        Node[] nodearrayNew = new Node[nodearray.length*growthFactor];
        System.arraycopy(nodearray, 0, nodearrayNew, 0, nodearray.length);
        nodearray = nodearrayNew;
    }

    /**
     * Method to query the set for a specific node
     * @return true  if the node is in the set
     * @return false if the node is not in the set
     */
    public boolean contains(Node node) 
    {
        if (node == null)
        {
            return false;
        }
        
        if(nodearray[0] == null)
        {
            return false;
        }

        for (int i = 0; i < nodearray.length; i++) 
        {
            if (nodearray[i] != null)
            {
                if (nodearray[i].compareTo(node) == 0)
                {
                    return true;
                }
            }
            if (nodearray[i] == null)
            {
                break;
            }
        }
        return false;
        

    }

    /**
     * Method to reset (empty) the heap
     */
    public void resetHeap()
    {
        this.heapSize = -1;
        for (Node node : nodearray)
        {
            node = null;
        }     
    }
        
    
    


    
}
