import static org.junit.Assert.*;
// non-static imports

import asgoffering.ListADT;
import asgsupplements.IllegalGetException;
import org.junit.Test;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author
 * @version
 */
public class ListADTTest {

    @Test(expected = IllegalGetException.class)
    public void test() {
        ListADT l = new Attempt1();
        assertNotNull(l);
        l.getNumElts();
        l.getPosition();
        Character[] a = { 'a', 'b', 'c' };
        l.prev();
        l.remove();
        l.prev();
        l.next();
        l.toString();
        l.get();
        l.getElements();
        l.insert('x');
        l.next();
        l.next();
        l.next();
        l.next();
        l.prev();
        l.remove();
        l.moveToFirst();
        l.remove();
        l.remove();
        l.remove();
        l.get();
    }

}
