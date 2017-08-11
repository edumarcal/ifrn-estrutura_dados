// Agradeço a DEUS pelo dom do conhecimento

package aula03.pilha;

/**
 *
 * @author papejajr
 */
public interface IPilha
{
    // Principais operações
    public void inserirInicio(Object o);
    public Object removerInicio() throws EPilha;
    public void inserirFim(Object o);
    public Object removerFim() throws EPilha;
    
    // Operações auxiliares
    public Object primeiro();
    public Object ultimo();
    public int tamanho();
    public boolean estaVazia();
    
}