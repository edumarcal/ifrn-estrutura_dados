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

///*
    // STATUS: OK => Inserindo elementos em ordem crescente (Rotação a esquerda)
   @Test
   public void insert_AVL_RotationLeft_0()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(1);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(2));
       
       avl.printLabelTree("3");
       avl.insert(new No(3));
       
       assertEquals(new Integer(3), avl.size());
       
       avl.printLabelTree("Final");
       avl.printTree();
       //avl.preOrder(root);
   }
//*/
   

/*
    // STATUS: OK => Inserindo elementos em ordem crescente (Rotação a esquerda)
   @Test
   public void insert_AVL_RotationLeft_1()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(1);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(2));
       
       avl.printLabelTree("3");
       avl.insert(new No(3));
       
       avl.printLabelTree("4");
       avl.insert(new No(4));
       
       avl.printLabelTree("5");
       avl.insert(new No(5));
       
       avl.printLabelTree("6");
       avl.insert(new No(6));
       
       avl.printLabelTree("7");
       avl.insert(new No(7));
       
       avl.printLabelTree("8");
       avl.insert(new No(8));
       
       assertEquals(new Integer(8), avl.size());
       
       avl.printLabelTree("Final");
       avl.printTree();
       //avl.preOrder(root);
   }
*/   
}
