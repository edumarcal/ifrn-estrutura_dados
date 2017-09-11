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
        
        No noLeft = new No();
        noLeft.setElement(5);
        ab.addChild(noRoot, noLeft);
        
        assertTrue(ab.size()==2);
        assertEquals(noLeft, ab.leftChild(noRoot));
    }
}
