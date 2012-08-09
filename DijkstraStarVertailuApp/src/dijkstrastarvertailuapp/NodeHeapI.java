/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 * Interface definition for Minimikeko data structure
 * @author aaltotuo
 */
public interface NodeHeapI<T> 
{
    public Node minimum();
    public Node extractMin();
    public void insert(Node key);
}
