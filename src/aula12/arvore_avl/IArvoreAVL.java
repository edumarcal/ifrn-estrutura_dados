// Agradeço a DEUS pelo dom do conhecimento

package aula12.arvore_avl;

import aula06.arvore_generica.No;

/**
 *
 * @author papejajr
 */
interface IArvoreAVL
{
    public void rotacaoSimplesEsquerda(No no);
    public void rotacaoSimplesDireita(No no);
    public void rotacaoDuplaEsquerda(No no);
    public void rotacaoDuplaDireita(No no);
    public void atualizarFB(No no, boolean operacao); 
    
    // Metodos da Arvore Binária de Pesquisa
    public void insert(No no);
    public No remove(No no);
    public No search(No no);
    
    // Método adicional
    public boolean hasParent(No no);
}
