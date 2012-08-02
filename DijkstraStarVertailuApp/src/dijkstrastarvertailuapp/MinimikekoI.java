/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 * Interface definition for Minimikeko data structure
 * @author aaltotuo
 */
public interface MinimikekoI<T> 
{
    public T minimum();
    public T extractMin();
    public void decreaseKey(T type, Long position, Long key);
    public void insert(T type, Long key);
}
