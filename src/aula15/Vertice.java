// Agradeço a DEUS pelo dom do conhecimento

package aula15;

/**
 *
 * @author papejajr
 */

public class Vertice
{
    private int chave;
    private int valor;

    /**
     * @param chave seta chave do Vertices
     */
    public Vertice(int chave) {
        this.chave = chave;
    }
    /**
     * @param chave seta chave do Vertices
     * @param valor seta valor do Vertices
     */
    public Vertice(int chave, int valor) {
        this.chave = chave;
        this.valor = valor;
    }

    /**
     * @return a chave
     */
    public int getChave() {
        return chave;
    }

    /**
     * @param chave seta a chave do Vertice
     */
    public void setChave(int chave) {
        this.chave = chave;
    }
    
    /**
     * @return o valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor seta o valor do vertice
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[ " + chave + " ]";
    }
}
