// Agradeço a DEUS pelo dom do conhecimento

package aula15;

/**
 *
 * @author papejajr
 */

public class Aresta
{
    private Vertice verticeOrigem;
    private Vertice verticeDestino;
    private double valor;
    private boolean direcionda;

   /**
     * @param verticeOrigem setar o verticeOrigem
     * @param verticeDestino setar o verticeDestino.
     */
    public Aresta(Vertice verticeOrigem, Vertice verticeDestino) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
    }

   /**
     * @param verticeOrigem setar o verticeOrigem
     * @param verticeDestino setar o verticeDestino.
     * @param valor valor da resta
     */
    public Aresta(Vertice verticeOrigem, Vertice verticeDestino, double valor) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
    }

    /**
     * @param verticeOrigem setar o verticeOrigem
     * @param verticeDestino setar o verticeDestino.
     * @param valor valor da resta
     * @param direcionda setar o direcionamento da aresta
     */
    public Aresta(Vertice verticeOrigem, Vertice verticeDestino, double valor, boolean direcionda) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
        this.direcionda = direcionda;
    }

    /**
     * @return o Vertice de Origem
     */
    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    /**
     * @param verticeOrigem setar o verticeOrigem.
     */
    public void setVerticeOrigem(Vertice verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    /**
     * @return o Vertice de Destino
     */
    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    /**
     * @param verticeDestino setar o verticeDestino.
     */
    public void setVerticeDestino(Vertice verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    /**
     * @return o valor da Aresta
     */
    public double getValor() {
        return valor;
    }
    
    /**
     * @param valor setar o valor da aresta.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return se a Aresta é direcionada
     */
    public boolean isDirecionda() {
        return direcionda;
    }
    
    /**
     * @param direcionda setar o direcionamento da aresta.
     */
    public void setDirecionda(boolean direcionda) {
        this.direcionda = direcionda;
    }

    @Override
    public String toString()
    {
        return "( " + verticeOrigem + "," + verticeDestino + " )";
    }
}