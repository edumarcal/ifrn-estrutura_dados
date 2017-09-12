// Agradeço a DEUS pelo dom do conhecimento

package aula10.arvore_binaria_pesquisa;

import aula06.arvore_generica.No;

/**
 *
 * @author papejajr
 */
public interface IBinarySearchTree {
    public No search(No position, No element);
    public void insert(No position, No element);
    public No remove(No element);
    
}
