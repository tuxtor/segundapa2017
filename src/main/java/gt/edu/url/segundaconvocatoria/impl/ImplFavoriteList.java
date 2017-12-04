package gt.edu.url.segundaconvocatoria.impl;

import gt.edu.url.segundaconvocatoria.FavoriteList;
import gt.edu.url.segundaconvocatoria.arraylist.ArrayList;
import gt.edu.url.segundaconvocatoria.arraylist.List;
import gt.edu.url.segundaconvocatoria.positional.LinkedPositionalList;
import gt.edu.url.segundaconvocatoria.positional.Position;
import gt.edu.url.segundaconvocatoria.positional.PositionalList;

/**
 *
 * @author tuxtor
 */
public class ImplFavoriteList<E> implements FavoriteList<E> {
    protected static class Item<E> {
        private E value;
        private int count = 0;

        public Item(E val) {
            value = val;
        }
        
        public int getCount() { 
            return count; 
        }
        public E getValue() { 
            return value; 
        }
        public void increment() { 
            count++; 
        }
    }
    
    PositionalList<Item<E>> list = new LinkedPositionalList<>();
    
    protected E value(Position<Item<E>> p) { 
        return p.getElement().getValue(); 
    }
    
    protected int count(Position<Item<E>> p) {
        return p.getElement( ).getCount( );
    }
    
    protected Position<Item<E>> findPosition(E e) {
        Position<Item<E>> walk = list.first();
        while (walk != null && !e.equals(value(walk)))
        walk = list.after(walk);
        return walk;
    }
    
    protected void moveUp(Position<Item<E>> p) {
        int cnt = count(p);
        Position<Item<E>> walk = p;
        while (walk != list.first() && count(list.before(walk)) < cnt)
            walk = list.before(walk);
        if (walk != p)
            list.addBefore(walk, list.remove(p));
    }
    
    public int size( ) {
        return list.size( );
    }
    
    public boolean isEmpty( ) { 
        return list.isEmpty( ); 
    }
    
    @Override
    public void access(E e) {
        Position<Item<E>> p = findPosition(e); if (p == null)
        p = list.addLast(new Item<E>(e)); p.getElement().increment(); moveUp(p);    
    }

    @Override
    public void remove(E e) {
        Position<Item<E>> p = findPosition(e);
        if (p != null)
            list.remove(p);
    }

    @Override
    public Iterable<E> getFavorites(int k) {
        if (k < 0 || k > size())
            throw new IllegalArgumentException("Invalid k");
        List<E> result = new ArrayList<>();
        
        Position<Item<E>> firstElement = list.first();

        result.add(0, firstElement.getElement().getValue());
        
        for (int j=1; j < k; j++){
            // = list
            Position<Item<E>> pivot = list.after(firstElement);
            result.add(0, pivot.getElement().getValue());
        }
        return result;
    }
    
}
