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
    
    @Test
    public void insertNodesBST()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        bst.insert(null, root);
        bst.insert(root, new No(2));
        bst.insert(root, new No(9));
        bst.insert(root, new No(1));
        bst.insert(root, new No(4));
        bst.insert(root, new No(8));
        assertEquals(new Integer(6), bst.size());
        //bst.inOrder(root);
    }
    
    @Test
    public void searchNodesBST()
    {
        BinarySearchTree bst = new BinarySearchTree();
        No root = new No(6);
        bst.insert(null, root);
        bst.insert(root, new No(2));
        bst.insert(root, new No(9));
        No k = new No(1);
        bst.insert(root, k);
        bst.insert(root, new No(4));
        bst.insert(root, new No(8));
        assertEquals(k, bst.search(root, k));
        //bst.inOrder(root);
    }
    
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
}
