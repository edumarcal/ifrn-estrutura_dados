// Agradeço a DEUS pelo dom do conhecimento

package aula05;

/**
 *
 * @author papejajr
 */

//TODO: Verificar a implementação do TAD Sequencia
public interface ISequencia
{
    // Métodos de Vetor
    public void elementAtRank(int r);
    public void replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public void removeAtRank(int r);
    
    // Método "ponte"
    public Object atRank(int r);
    public int rankOf(Object o);
}
