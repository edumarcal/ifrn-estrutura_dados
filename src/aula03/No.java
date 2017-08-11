// Agradeço a DEUS pelo dom do conhecimento

package aula03;

/**
 *
 * @author papejajr
 */
public class No
{
    private Object elemento;
    private No proximo;
    
    public Object getElemento()
    {
        return elemento;
    }
    
    public void setElemento(Object o)
    {
        this.elemento = o;
    }
    
    public No getProximo()
    {
        return this.proximo;
    }
    
    public void setProximo(No no)
    {
        this.proximo = no;
    }
}