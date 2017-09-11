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
/*    
    @Test
    public void addNoRootArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        No noRoot = new No();
        noRoot.setElement(10);
        
        ab.addChild(null, noRoot);
        
        assertTrue(ab.isRoot(noRoot));
    }
    
    @Test
    public void addNoLeftArvoreBinaria()
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
        assertEquals(noLeft, ab.leftChild(noRoot));
    }
    
     @Test
    public void addNoLeftCompareRightArvoreBinaria()
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
    public void addNoRightArvoreBinaria()
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
    public void addNoRightCompareLeftArvoreBinaria()
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
    
 */
     @Test
    public void addNosArvoreBinaria()
    {
        ArvoreBinaria ab = new ArvoreBinaria();
        
        //System.out.println("Add 10");
        No noRoot = new No();
        noRoot.setElement(10);
        ab.addChild(null, noRoot); //Add Child 1
        
        //System.out.println("Add 9");
        No no0 = new No();
        no0.setElement(9);
        ab.addChild(noRoot, no0); //Add Child 2
        assertEquals(no0, ab.leftChild(noRoot));
        
        //System.out.println("Add 2");
        No no1 = new No();
        no1.setElement(2);
        ab.addChild(noRoot, no1); //Add Child 3
        assertEquals(no1, ab.leftChild(no0));
        
        //System.out.println("Add 1");
        No no2 = new No();
        no2.setElement(1);
        ab.addChild(noRoot, no2); //Add Child 4
        assertEquals(no2, ab.leftChild(no1));
        
        System.out.println("PreOrder");
        ab.posOrder(noRoot);
        
        //System.out.println("InOrder");
        //ab.inOrder(noRoot);
        
        //System.out.println("PosOrder");
        //ab.posOrder(noRoot);
        
        assertEquals(new Integer(7), ab.size());
        
    }
}
