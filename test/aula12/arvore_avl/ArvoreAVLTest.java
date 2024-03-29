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

/*
   // STATUS: OK => Inserindo elementos em ordem crescente (Rotação simples a esquerda)
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
       
       avl.printLabelTree("4");
       avl.insert(new No(4));
       
       avl.printLabelTree("5");
       avl.insert(new No(5));
       
       avl.printLabelTree("6");
       avl.insert(new No(6));
       
       assertEquals(new Integer(6), avl.size());
       
       avl.printLabelTree("Final");
       avl.printTree();

   }
//*/
   
/*
   // STATUS: OK => Inserindo elementos em ordem crescente (Rotação simples a esquerda)
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
   }
//*/

/*
   // STATUS: OK => Validando o criterio de parada
   @Test
   public void insert_AVL_StopUpdateFB()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(10);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(9));
       
       avl.printLabelTree("3");
       avl.insert(new No(15));
       
       avl.printLabelTree("4");
       avl.insert(new No(16));
       
       avl.printLabelTree("5");
       avl.insert(new No(12));
       
       assertEquals(new Integer(5), avl.size());
       assertEquals(root.getFilhoDireito().getElement(), 15);
       
       avl.printLabelTree("Final");
       avl.printTree();
   }
//*/

/*
   // STATUS: OK => Inserindo elementos em ordem decrescente (Rotação simples a direita)
   @Test
   public void insert_AVL_RotationRight_0()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(6);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(5));
       
       avl.printLabelTree("3");
       avl.insert(new No(4));
       
       avl.printLabelTree("4");
       avl.insert(new No(3));
       
       avl.printLabelTree("5");
       avl.insert(new No(2));
       
       avl.printLabelTree("6");
       avl.insert(new No(1));
       
       assertEquals(new Integer(6), avl.size());
       
       avl.printLabelTree("Final");
       avl.printTree();
   }
//*/
   
/*
   // STATUS: OK => Inserindo elementos em ordem decrescente (Rotação simples a direita)
   @Test
   public void insert_AVL_RotationRight_1()
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
   }
//*/

/*
   // STATUS: OK => Rotação dupla a esquerda
   @Test
   public void remove_AVL_RDE_RotationRightLeft_0()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(50);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(20));
       
       avl.printLabelTree("3");
       avl.insert(new No(80));
       
       avl.printLabelTree("4");
       avl.insert(new No(90));
       
       avl.printLabelTree("5");
       avl.insert(new No(70));
       
       avl.printLabelTree("6");
       avl.insert(new No(60));
       
       assertEquals(new Integer(6), avl.size());
       
       avl.printLabelTree("Final");
       avl.printTree();
   }
//*/

/*
   // STATUS: OK => Rotação dupla a direita
   @Test
   public void remove_AVL_RDD_RotationLeftRight_0()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(50);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(20));
       
       avl.printLabelTree("3");
       avl.insert(new No(90));
       
       avl.printLabelTree("4");
       avl.insert(new No(10));
       
       avl.printLabelTree("5");
       avl.insert(new No(40));
       
       avl.printLabelTree("6");
       avl.insert(new No(30));
       
       assertEquals(new Integer(6), avl.size());
       
       avl.printLabelTree("Final");
       avl.printTree();
   }
//*/
   
///*
   // STATUS: OK => Removendo elemento
   @Test
   public void remove_AVL_0()
   {
       ArvoreAVL avl = new ArvoreAVL();
       No root = new No(8);
       No rem0 = new No(22);
       No rem1 = new No(31);
       No rem2 = new No(12);
       No rem3 = new No(7);
       No rem4 = new No(20);
       
       avl.printLabelTree("1");
       avl.insert(root);
       
       avl.printLabelTree("2");
       avl.insert(new No(6));
       
       avl.printLabelTree("3");
       avl.insert(rem4);
       
       avl.printLabelTree("4");
       avl.insert(new No(2));
       
       avl.printLabelTree("5");
       avl.insert(new No(11));
       
       avl.printLabelTree("6");
       avl.insert(rem3);
       
       avl.printLabelTree("7");
       avl.insert(new No(29));
       
       avl.printLabelTree("8");
       avl.insert(new No(3));
       
       avl.printLabelTree("9");
       avl.insert(new No(10));
       
       avl.printLabelTree("10");
       avl.insert(rem2);
       
       avl.printLabelTree("11");
       avl.insert(new No(24));
       
       avl.printLabelTree("12");
       avl.insert(new No(32));
       
       avl.printLabelTree("13");
       avl.insert(rem0);
       
       avl.printLabelTree("14");
       avl.insert(new No(9));
       
       avl.printLabelTree("15");
       avl.insert(rem1);
       
       assertEquals(new Integer(15), avl.size());
       
       avl.printLabelTree("Remoção: 1");
       avl.remove(rem0);
       
       avl.printLabelTree("Remoção: 2");
       avl.remove(rem1);
       
       avl.printLabelTree("Remoção: 3");
       avl.remove(rem2);
       
       avl.printLabelTree("Remoção: 4");
       avl.remove(rem3);
       
       avl.printLabelTree("Remoção: 5");
       avl.remove(rem4);
       
       avl.printLabelTree("Final");
       avl.printTree();
   }
//*/
}