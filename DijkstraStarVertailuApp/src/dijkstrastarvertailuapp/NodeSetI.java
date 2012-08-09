/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 *
 * @author aaltotuo
 */
public interface NodeSetI<T>
{
    public boolean add(Node node);
    public boolean remove(Node node);
    public boolean contains(Node node);
    public int     size();
 
    
}
