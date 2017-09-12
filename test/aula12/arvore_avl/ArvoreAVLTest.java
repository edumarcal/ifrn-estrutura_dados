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
   public void insertAVL()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No no = new No(31);
       avl.insert(null,no);        // Add 1
       avl.insert(no, new No(33)); // Add 2
       avl.insert(no, new No(35)); // Add 3
       avl.insert(no, new No(36)); // Add 4
       avl.insert(no, new No(38)); // Add 5
       avl.insert(no, new No(32)); // Add 6
       assertEquals(new Integer(6), avl.size());
       //avl.inOrder(no);
   }
   
   @Test
   public void insertAVLTestFB()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No no = new No(31);
       avl.insert(null,no);        // Add 1
       avl.insert(no, new No(33)); // Add 2
       No noFB = new No(35);
       avl.insert(no, noFB); // Add 3
       No noFB1 = new No(36);
       avl.insert(no, noFB1); // Add 4
       avl.insert(no, new No(38)); // Add 5
       avl.insert(no, new No(32)); // Add 6
       assertEquals(new Integer(6), avl.size());
       assertEquals(0, avl.search(no, noFB).getFB());
       assertEquals(-1, avl.search(no, noFB1).getFB());
       avl.inOrder(no);
   }
}
