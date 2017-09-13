// Agradeço a DEUS pelo dom do conhecimento

package aula12.arvore_avl;

import aula06.arvore_generica.No;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author papejajr
 */
public class ArvoreAVLTest {
    
   @Test
   public void insertAVLTestFB()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No no1 = new No(1);
       No no2 = new No(2);
       No no3 = new No(3);
       No no4 = new No(4);
       No no5 = new No(5);
       No no6 = new No(6);
       No no7 = new No(7);
       No no0 = new No(0);
       
       avl.insert(no1);   // Add 1
       avl.insert(no2);   // Add 2
       avl.insert(no3);   // Add 3
       //avl.insert(new No(4)); // Add 4
       //avl.insert(new No(5)); // Add 5
       //avl.insert(new No(6)); // Add 6
       //avl.insert(new No(7)); // Add 7
       //avl.insert(new No(0)); // Add 8
       assertEquals(new Integer(3), avl.size());
       assertTrue(avl.isRoot(no2));
       //assertEquals(new Integer(8), avl.size());
       //assertEquals(0, avl.search(no, no));
       
       avl.preOrder(no1);
   }
}
