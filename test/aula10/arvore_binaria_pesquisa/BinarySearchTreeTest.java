// Agradeço a DEUS pelo dom do conhecimento

package aula10.arvore_binaria_pesquisa;

import aula06.arvore_generica.No;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author papejajr
 */
public class BinarySearchTreeTest
{
///*
    // STATUS: OK => Arvove só a direita
    @Test
    public void insert_BST_0_TreeNodesAllRight()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(1);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(4));
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        
        assertEquals(new Integer(5), bst.size());
     }
//*/
    
///*
    // STATUS: OK => Arvove só a esquerda
    @Test
    public void insert_BST_0_TreeNodesAllLeft()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(5);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(4));
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        assertEquals(new Integer(5), bst.size());
     }
//*/
    
///*
    // STATUS: OK => Arvore cheia
    @Test
    public void insert_BST_0_TreeFull()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(4);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        bst.insert(root, new No(6));
        //bst.printTree();
        
        bst.insert(root, new No(7));
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        
        //bst.inOrder(root);
        assertEquals(new Integer(7), bst.size());
     }
//*/

///*
    // STATUS: OK => Arvore cheia
    @Test
    public void insert_BST_1_TreeFull()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(8);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(4));
        //bst.printTree();
        
        bst.insert(root, new No(12));
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, new No(6));
        //bst.printTree();
        
        bst.insert(root, new No(10));
        //bst.printTree();
        
        bst.insert(root, new No(13));
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(9));
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        
        bst.insert(root, new No(7));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        bst.insert(root, new No(11));
        //bst.printTree();
        
        bst.insert(root, new No(14));
        //bst.printTree();
        
        bst.insert(root, new No(15));
        //bst.printTree();
        
        //bst.inOrder(root);
       
        assertEquals(new Integer(15), bst.size());
     }
//*/

///*
    // STATUS: OK => Busca na Arvore
    @Test
    public void searchNodesBST()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        bst.insert(root, root);
        bst.insert(root, new No(2));
        bst.insert(root, new No(9));
        No k = new No(1);
        bst.insert(root, k);
        bst.insert(root, new No(4));
        bst.insert(root, new No(8));
        assertEquals(k, bst.search(root, k));
        //bst.inOrder(root);
    }
//*/

///*
    // STATUS: OK => Remove o elemento raiz  
    @Test
    public void remove_BST_0_CaseRoot()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        bst.insert(null, root);
        bst.insert(root, new No(2));
        bst.insert(root, new No(9));
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(root, bst.remove(root));
        assertEquals(new Integer(2), bst.size());
        //bst.printTree();
    }
//*/
    
///*
    // STATUS: OK => Remove o elemento raiz  
    @Test
    public void remove_BST_0_CaseRootOneChildren()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(20);
        bst.insert(null, root);
        bst.insert(root, new No(10));
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(root, bst.remove(root));
        assertEquals(new Integer(1), bst.size());
        //bst.printTree();
    }
//*/
  
///*
    // STATUS: OK => Remove o elemento filho direito do root
    @Test
    public void remove_BST_0_CaseRootLeafLeft()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(2);
        No no = new No(1);
        
        bst.insert(root, root);
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(new Integer(2), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(1), bst.size());
        //bst.printTree();
    }
//*/
    
///*
    // STATUS: OK => Remove o elemento filho direito do root
    @Test
    public void remove_BST_0_CaseRootLeafRight()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(2);
        No no = new No(3);
        
        bst.insert(root, root);
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(new Integer(2), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(1), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o elemento folha a esquerda
    @Test
    public void remove_BST_1_CaseLeafLeft()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        No leaf = new No(2);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(9));
        //bst.printTree();
        
        bst.insert(root, leaf);
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(leaf, bst.remove(leaf));
        assertEquals(new Integer(2), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o elemento folha a direita  
    @Test
    public void remove_BST_1_CaseLeafRight()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        No leaf = new No(9);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, leaf);
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(leaf, bst.remove(leaf));
        assertEquals(new Integer(2), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o raiz que contém apenas um filho (esquerda)  
    @Test
    public void remove_BST_2_CaseOneChildrenLeft_0()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(4);
        No no = new No(2);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        //System.err.println();
        
        assertEquals(new Integer(2), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(1), bst.size());
        //bst.printTree();
    }
//*/
    
///*
    // STATUS: OK => Remove o elemento que contém apenas um filho (esquerda)  
    @Test
    public void remove_BST_2_CaseOneChildrenLeft_1()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(4);
        No no = new No(6);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        //System.err.println();
        
        assertEquals(new Integer(6), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(5), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o elemento que contém apenas um filho (esquerda)  
    @Test
    public void remove_BST_2_CaseOneChildrenLeft_2()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(4);
        No no = new No(2);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(6));
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        bst.insert(root, new No(7));
        //bst.printTree();
        //System.err.println();
        
        assertEquals(new Integer(6), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(5), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o root que contém apenas um filho (direita)  
    @Test
    public void remove_BST_2_CaseOneChildrenRight_0()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(2);
        No no = new No(3);
        
        bst.insert(root, root);
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        //System.err.println(); // Print[ERR] Devido a prioridade do buffer de impressao (out, err)
        
        assertEquals(new Integer(2), bst.size());
        assertEquals(no, bst.remove(no));
        //assertEquals(new Integer(1), bst.size());
        //bst.printTree();
    }
//*/
    
///*
    // STATUS: OK => Remove o children que contém apenas dois filho sub arvore (esquerda)  
    @Test
    public void remove_BST_3_CaseTwoChildrenLeft()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(4);
        No no = new No(2);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        bst.insert(root, new No(6));
        //bst.printTree();
        
        bst.insert(root, new No(7));
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        //System.err.println();
        
        //bst.inOrder(root);
        assertEquals(new Integer(7), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(6), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o children que contém apenas dois filho sub arvore (direita)  
    @Test
    public void remove_BST_3_CaseTwoChildrenRight()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(4);
        No no = new No(6);
        
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(2));
        //bst.printTree();
        
        bst.insert(root, new No(3));
        //bst.printTree();
        
        bst.insert(root, new No(1));
        //bst.printTree();
        
        bst.insert(root, no);
        //bst.printTree();
        
        bst.insert(root, new No(7));
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        //System.err.println();
        
        //bst.inOrder(root);
        assertEquals(new Integer(7), bst.size());
        assertEquals(no, bst.remove(no));
        assertEquals(new Integer(6), bst.size());
        //bst.printTree();
    }
//*/

///*
    // STATUS: OK => Remove o children que contém apenas dois filho sub arvore (esquerda)  
    @Test
    public void remove_BST_3_CaseTwoChildrenRoot()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(40);       
        bst.insert(null, root);
        //bst.printTree();
        
        bst.insert(root, new No(20));
        //bst.printTree();
        
        bst.insert(root, new No(30));
        //bst.printTree();
        
        bst.insert(root, new No(10));
        //bst.printTree();
        
        bst.insert(root, new No(5));
        //bst.printTree();
        
        bst.insert(root, new No(60));
        //bst.printTree();
        
        bst.insert(root, new No(50));
        //bst.printTree();
        
        bst.insert(root, new No(55));
        //bst.printTree();
        
        bst.insert(root, new No(70));
        //bst.printTree();
        
        //System.out.println();
        assertEquals(new Integer(9), bst.size());
        assertEquals(root, bst.remove(root));
        assertEquals(new Integer(8), bst.size());
        //bst.printTree();
    }
//*/



}
