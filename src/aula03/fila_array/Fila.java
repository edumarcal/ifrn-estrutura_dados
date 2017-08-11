// Agradeço a DEUS pelo dom do conhecimento

package aula03.fila_array;

/**
 *
 * @author papejajr
 */
public class Fila implements IFila
{
    private Object struct[]; // Implementação da fila do tipo array
    private int length;

    public Fila(int length) throws EFila
    {
        if(length <= 0)
            throw new EFila("Tamanho da lista não pode ser menor ou igual zero");
        
        // Iniciando os valores das variaveis
        this.length = 0;
        this.struct = new Object[length];
    }

    @Override
    public int tamanho()
    {
        return this.length;
    }

    @Override
    public boolean estaVazia()
    {
        return this.tamanho() == 0;
    }

    @Override
    public Object inicio() throws EFila
    {
        if (this.tamanho() >= 1)
            return this.struct[0];
        throw new EFila("Fila vazia");
    }

    @Override
    public void enfileirar(Object o) throws EFila
    {
        if (this.tamanho() < this.struct.length)
        {
            this.struct[this.length] = o;
            this.length++;
        }
        else
        {
            throw new EFila("Fila cheia");
        }
    }

    @Override
    public Object desenfileirar() throws EFila
    {
        if (this.tamanho() == 0)
            throw new EFila("Lista vazia");
        
        Object r = this.struct[0];
        
        // Realocação dos demais elementos
        for (int i = 0; i < this.tamanho()-1;) {
            this.struct[i] = this.struct[i++];
        }
        
        this.length--;
        return r;
    }
    
}