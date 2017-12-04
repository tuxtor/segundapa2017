package gt.edu.url.segundaconvocatoria.test;

import gt.edu.url.segundaconvocatoria.DoubleStack;
import gt.edu.url.segundaconvocatoria.impl.ImplDoubleStack;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tuxtor
 */
public class DoubleStackTest {
    DoubleStack<Integer> laLista = new ImplDoubleStack<>();
    public DoubleStackTest() {
        laLista.redPush(1);
        laLista.redPush(2);
        laLista.redPush(3);
        laLista.redPush(4);
        laLista.redPush(5);
        
        laLista.bluePush(6);
        laLista.bluePush(7);
        laLista.bluePush(8);
        laLista.bluePush(9);
        laLista.bluePush(10);
        
    }

    
    @Test
    public void testRedStack() {
        Assert.assertEquals(Integer.valueOf(laLista.redTop()), Integer.valueOf(5));
        laLista.redPop();
        Assert.assertEquals(Integer.valueOf(laLista.redTop()), Integer.valueOf(4));
    }
    
    @Test
    public void testBlueStack() {
        Assert.assertEquals(Integer.valueOf(laLista.blueTop()), Integer.valueOf(10));
        laLista.bluePop();
        Assert.assertEquals(Integer.valueOf(laLista.bluePop()), Integer.valueOf(9));
    
    }
    
    @Test
    public void testSize() {
        Assert.assertFalse(laLista.isEmpty());
    }
    
    
    
    
}
