// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_binaria;

import aula06.arvore_generica.No;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author papejajr
 */
public class ArvoreBinariaTest
{

    @Test
    public void testAddNoRootArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No() {};
        noRoot.setElement(10);
        
        ab.addChild(null, noRoot);
        
        assertTrue(ab.isRoot(noRoot));
    }
    
    @Test
    public void testAddNoLeftArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No() {};
        noRoot.setElement(10);
        
        ab.addChild(null, noRoot);
        
        assertEquals(noRoot, ab.root());
        
        // Add no Left Tree
        No noLeft = new No();
        noLeft.setElement(5);
        
        ab.addChild(noRoot, noLeft);
        
        assertEquals(new Integer(2), ab.size());
        assertEquals(noLeft, ab.leftChild(noRoot));
    }
    
     @Test
    public void testAddNoLeftCompareRightArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        
        ab.addChild(null, noRoot);
        
        assertEquals(noRoot, ab.root());
        
        // Add no Left Tree
        No noLeft = new No();
        noLeft.setElement(5);
        
        ab.addChild(noRoot, noLeft);
        
        assertEquals(new Integer(2), ab.size());
        assertNotEquals(noLeft, ab.rightChild(noRoot));
    }
    
    @Test
    public void testAddNoRightArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        
        ab.addChild(null, noRoot);
        
        assertEquals(noRoot, ab.root());
        
        // Add no Right Tree
        No noRight = new No();
        noRight.setElement(15);
        
        ab.addChild(noRoot, noRight);
        
        assertEquals(new Integer(2), ab.size());
        assertEquals(noRight, ab.rightChild(noRoot));
    }
    
    @Test
    public void testAddNoRightCompareLeftArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        
        ab.addChild(null, noRoot);
        
        assertEquals(noRoot, ab.root());
        
        // Add no Right Tree
        No noRight = new No();
        noRight.setElement(15);
        
        ab.addChild(noRoot, noRight);
        
        assertEquals(new Integer(2), ab.size());
        assertNotEquals(noRight, ab.leftChild(noRoot));
    }
    
     @Test
    public void testAddNosLeftArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        
        No noRoot = new No();
        noRoot.setElement(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No();
        no0.setElement(9);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.leftChild(noRoot));
        
        No no1 = new No();
        no1.setElement(2);
        ab.addChild(noRoot, no1); //Add Child 3
        assertEquals(no1, ab.leftChild(no0));
        
        No no2 = new No();
        no2.setElement(1);
        ab.addChild(noRoot, no2); //Add Child 4
        assertEquals(no2, ab.leftChild(no1));
        
        //System.out.println("PreOrder");
        //ab.posOrder(noRoot);
        
        //System.out.println("InOrder");
        //ab.inOrder(noRoot);
        
        //System.out.println("PosOrder");
        //ab.posOrder(noRoot);
                
        assertEquals(new Integer(4), ab.size());
        
    }
    
    public void testAddNosRightArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        
        No noRoot = new No();
        noRoot.setElement(1);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No();
        no0.setElement(2);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.rightChild(noRoot));
        
        No no1 = new No();
        no1.setElement(3);
        ab.addChild(noRoot, no1); //Add Child 3
        assertEquals(no1, ab.rightChild(no0));
                
        assertEquals(new Integer(3), ab.size());
        
    }

    @Test
    public void testAddNosArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        
        No noRoot = new No();
        noRoot.setElement(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No();
        no0.setElement(8);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.leftChild(noRoot));
        
        No no1 = new No();
        no1.setElement(12);
        ab.addChild(noRoot, no1); //Add Child 3
        assertEquals(no1, ab.rightChild(noRoot));

        No no2 = new No();
        no2.setElement(9);
        ab.addChild(noRoot, no2); //Add Child 4
        assertEquals(no2, ab.rightChild(no0));

        No no3 = new No();
        no3.setElement(7);
        ab.addChild(noRoot, no3); //Add Child 5
        assertEquals(no3, ab.leftChild(no0));
        
        No no4 = new No();
        no4.setElement(11);
        ab.addChild(noRoot, no4); //Add Child 6
        assertEquals(no4, ab.leftChild(no1));
        
        No no5 = new No();
        no5.setElement(13);
        ab.addChild(noRoot, no5); //Add Child 7
        assertEquals(no5, ab.rightChild(no1));
        
        //ab.inOrder(noRoot);
        
        assertEquals(new Integer(7), ab.size());
    }
    
    @Test
    public void testDropNodeCase1()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No();
        no0.setElement(8);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.leftChild(noRoot));
        
        assertEquals(no0, ab.dropChild(no0));
        assertEquals(new Integer(1), ab.size());
    }

    @Test
    public void testDropNodeCase2Left()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No();
        no0.setElement(8);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.leftChild(noRoot));
        
        No no1 = new No();
        no1.setElement(7);
        ab.addChild(noRoot, no1); //Add Child 3
               
        assertEquals(no0, ab.dropChild(no0)); // Drop Child (8)
        assertEquals(new Integer(2), ab.size());
        //ab.inOrder(noRoot);
    }
    
    @Test
    public void testDropNodeCase2Right()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No();
        no0.setElement(11);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.rightChild(noRoot));
        
        No no1 = new No();
        no1.setElement(12);
        ab.addChild(noRoot, no1); //Add Child 3
        assertEquals(no1, ab.rightChild(no0));
               
        assertEquals(no0, ab.dropChild(no0)); // Drop Child (11)
        assertEquals(new Integer(2), ab.size());
        //ab.inOrder(noRoot);
    }

    @Test
    public void testDropNodeCase3()
    {
        ArvoreBinaria ab = new ArvoreBinaria();

        No noRoot = new No(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        No no0 = new No(8);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.leftChild(noRoot));
        
        No no1 = new No();
        no1.setElement(12);
        ab.addChild(noRoot, no1); //Add Child 3
        assertEquals(no1, ab.rightChild(noRoot));
        
        ab.addChild(noRoot, new No(11)); //Add Child 4
        ab.addChild(noRoot, new No(9)); //Add Child 5
        ab.addChild(noRoot, new No(7)); //Add Child 6
        ab.addChild(noRoot, new No(13)); //Add Child 7

        assertEquals(no0, ab.dropChild(no0));       
        assertEquals(no1, ab.dropChild(no1));
        
        //System.out.println("-----------------------------------------------------");
        //ab.inOrder(noRoot);
        //System.out.println("-----------------------------------------------------");
        
        assertEquals(new Integer(5), ab.size());
    }

}

