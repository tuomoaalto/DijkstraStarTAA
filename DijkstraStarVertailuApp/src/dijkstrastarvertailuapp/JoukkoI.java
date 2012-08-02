/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrastarvertailuapp;

/**
 *
 * @author aaltotuo
 */
public interface JoukkoI<T>
{
    public final static long CAPACITY = 50;          
    public final static long RESIZE   = CAPACITY*2;  

    public void    add(T type);
    public boolean remove(T Type);
    public boolean contains(T type);
    public long    size();
    
}
