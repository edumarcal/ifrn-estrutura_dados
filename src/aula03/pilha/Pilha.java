// Agradeço a DEUS pelo dom do conhecimento

package aula03.pilha;

import aula03.No;

/**
 *
 * @author papejajr
 */
public class Pilha implements IPilha
{
    private No root;
    private int length;

    public Pilha()
    {
        this.length = 0;
    }
    
    @Override
    public void inserirInicio(Object o)
    {
        if (this.root == null)
        {
            this.root = (No) o;
        }
        else
        {
           No no = (No) o;
           no.setElemento(this.root);
           this.root = no;
        }
        this.length++;
    }

    @Override
    public Object removerInicio() throws EPilha
    {
        No r = this.root;
        
        if (this.estaVazia())
            throw new EPilha("Pilha vazia");
        
        if (tamanho() == 1)
            this.root = null;
        else
            this.root = this.root.getProximo();
        
        this.length--;
        return r;
    }

    @Override
    public void inserirFim(Object o)
    {
        No current = this.root;
        
        if (this.root == null)
        {
            this.root = (No) o;
        }
        else
        {
            while(current.getProximo() != null)
                current = current.getProximo();
        
            current.setProximo((No) o);
        }
        this.length++;
    }

    @Override
    public Object removerFim() throws EPilha
    {
        No current = root;
        No r;
        
        if (estaVazia())
            throw new EPilha("PIlha esta vazia");
        
        System.out.println(tamanho());
        while(current.getProximo() != null)
        {
            System.err.println(current);
            current = current.getProximo();
        }
        r = current;
        current = null;
        
        this.length--;
        return r;
       
    }

    @Override
    public Object primeiro()
    {
        return this.root;
    }

    @Override
    public Object ultimo()
    {
        No current = root;
        
        while(current.getProximo() != null)
            current = current.getProximo();
        
        return current;
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
}