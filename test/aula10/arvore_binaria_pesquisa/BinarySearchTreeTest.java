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
        bst.printTree();
        
        //bst.inOrder(root);
       
        assertEquals(new Integer(15), bst.size());
     }
//*/
    
/*   
       @Test
    public void insertNodesBST()
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
        bst.printTree();
        
        assertEquals(new Integer(5), bst.size());
        //bst.inOrder(root);
    }
    
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
        bst.inOrder(root);
    }
 /*   
    @Test
    public void removeNodesBSTCase1Root()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        bst.insert(null, root);
        bst.insert(root, new No(2));
        bst.insert(root, new No(9));
        assertEquals(root, bst.remove(root));
        assertEquals(new Integer(2), bst.size());
        //bst.inOrder(root);
    }
*/
}
