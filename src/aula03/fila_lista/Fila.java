// Agradeço a DEUS pelo dom do conhecimento

package aula03.fila_lista;

import aula03.No;
import aula03.fila_array.EFila;
import aula03.fila_array.IFila;

/**
 *
 * @author papejajr
 */
public class Fila implements IFila
{
    private No root;
    private int length;
    
    public Fila()
    {
        this.length = 0;
    }
    
    @Override
    public int tamanho()
    {
        return this.length;
    }

    @Override
    public boolean estaVazia()
    {
        return this.root == null;
    }

    @Override
    public Object inicio() throws EFila
    {
        return this.root;
    }

    @Override
    public void enfileirar(Object o)
    {    
        if (estaVazia())
            this.root = (No) o;
        else
            this.root.setProximo((No) o);
        
        this.length++;
    }

    @Override
    public Object desenfileirar() throws EFila
    {
        if (this.estaVazia())
            throw new EFila("Fila vazia");
        
        No no = this.root;
        this.root = this.root.getProximo();
        
        this.length--;
        return no;
    }
    
}