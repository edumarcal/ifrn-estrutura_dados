// Agradeço a DEUS pelo dom do conhecimento

package aula04;

/**
 *
 * @author papejajr
 */
public interface IDoubleList
{
    // Métodos genéricos
    public int size();
    public boolean isEmpty();
    
    // Métodos de consulta
    public boolean isFirst(Object o);
    public boolean isLast(Object o);
    
    // Métodos de acesso
    public Object frist();
    public Object last();
    public Object before(Object o);
    public Object after(Object o);
    
    // Métodos de atualização
    public void replaceElement(Object p, Object o) throws EDoubleList;
    public void swapElements(Object p, Object o) throws EDoubleList;
    public void insertBefore(Object p, Object o);
    public void insertAfter(Object p, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(Object o) throws EDoubleList;
    
    // Add My
    public Object search(Object o);
}
