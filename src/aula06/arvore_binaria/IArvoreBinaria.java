// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_binaria;

import aula06.arvore_generica.No;

/**
 *
 * @author papejajr
 */
interface IArvoreBinaria
{
    public No leftChild(No no);
    public No rightChild(No no);
    public boolean hasLeft(No no);
    public boolean hasright(No no);
    
     // Complementos dos Métodos de atualização
    public void addChild(No position, No no);
    public No dropChild(No no);
}
