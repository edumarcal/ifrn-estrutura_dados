// Agradeço a DEUS pelo dom do conhecimento

package aula03.fila_array;

/**
 *
 * @author papejajr
 */
public interface IFila
{
    public int tamanho();
    public boolean estaVazia();
    public Object inicio() throws EFila;
    public void enfileirar(Object o) throws EFila;
    public Object desenfileirar() throws EFila;
}
