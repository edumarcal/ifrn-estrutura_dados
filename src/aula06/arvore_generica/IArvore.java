// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_generica;

/**
 *
 * @author papejajr
 */
public interface IArvore
{
    // Métodos genéricos
    public Integer size();
    public Integer height(No no);
    public boolean isEmpty();
    public Iterable elements();
    public Iterable nos();
    
    // Métodos de acesso
    public No root();
    public No parent(No no);
    public Iterable children(No no);
    
    // Métodos de consulta
    public boolean isInternal(No no);
    public boolean isExternal(No no);
    public boolean isRoot(No no);
    public Integer depth(No no);
    
    // Método de atualização
    public Object replace(No no, No obj);
    
    // Complementos dos Métodos de atualização
    //public void addChild(No position, No no);
    //public No dropChild(No no);
}
