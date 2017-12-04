package gt.edu.url.segundaconvocatoria.impl;

import gt.edu.url.segundaconvocatoria.arraylist.ArrayList;
import gt.edu.url.segundaconvocatoria.arraylist.List;
import gt.edu.url.segundaconvocatoria.DoubleStack;

/**
 *
 * @author tuxtor
 */
public class ImplDoubleStack<E> implements DoubleStack<E> {
    
    public static final int CAPACITY = 16;
    
    
    List<E> redList;
    List<E> blueList;
       
    @Override
    public boolean isEmpty() {
        if(redList.size() > 0 || blueList.size() > 0)
            return false;
        else
            return true;
    }
    
    public ImplDoubleStack() {
        this(CAPACITY);
    }

    public ImplDoubleStack(int capacity) {
        redList = new ArrayList<>(capacity);
        blueList = new ArrayList<>(capacity);
    }

    @Override
    public int redSize() {
        return this.redList.size();
    }

    @Override
    public void redPush(E e) {
        this.redList.add(0, e);
    }

    @Override
    public E redTop() {
        return this.redList.get(0);
    }

    @Override
    public E redPop() {
        return this.redList.remove(0);
    }

    @Override
    public int blueSize() {
        return this.blueList.size();
    }

    @Override
    public void bluePush(E e) {
        this.blueList.add(0, e);
    }

    @Override
    public E blueTop() {
        return this.blueList.get(0);
    }

    @Override
    public E bluePop() {
        return this.blueList.remove(0);
    }
    
}
