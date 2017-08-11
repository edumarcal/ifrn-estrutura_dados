// Agradeço a DEUS pelo dom do conhecimento

package aula03.pilha;

import aula03.No;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author papejajr
 */
public class PilhaTest
{  
    @Test
    public void TamanhoDaPilha()
    {
        assertTrue(new Pilha().tamanho() == 0);
    }
    
    @Test
    public void InserirElementoNoInicioPilha()
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirInicio(no);
        assertSame(no, pilha.primeiro());
    }
    
    @Test
    public void InserirElementoNoInicioPilhaEVerificarOTamanho()
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirInicio(no);
        no = new No();
        pilha.inserirInicio(no);
        assertTrue(2  == pilha.tamanho());
    }
    
    @Test
    public void InserirVariosElementoNoInicioPilhaEChecandoRoot()
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirInicio(no);        // Add 1
        pilha.inserirInicio(new No());  // Add 2
        pilha.inserirInicio(new No());  // Add 3
        pilha.inserirInicio(new No());  // Add 4
        pilha.inserirInicio(new No());  // Add 5
        assertNotEquals(no, pilha.primeiro());
    }
    
    @Test
    public void RemoverInicioPilha() throws EPilha
    {
        Pilha pilha = new Pilha();
        pilha.inserirInicio(new No());  // Add 1
        pilha.inserirInicio(new No());  // Add 2
        No no = new No();
        pilha.inserirInicio(no);        // Add 3
        assertEquals(no, pilha.removerInicio());
    }
    
    @Test(expected = EPilha.class)
    public void RemoverInicioPilhaVazia()  throws EPilha
    {
        new Pilha().removerInicio();
    }
    
    @Test
    public void RemoverNoInicioPilhaRoot() throws EPilha
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirInicio(no);
        assertSame(no, pilha.removerInicio());
    }
    
    @Test
    public void InserirNoFimPilhaEVerificandoSeOPirmeiroInseridoEOUltimoElemento()
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirFim(no);       // Add 1
        pilha.inserirFim(new No()); // Add 2
        pilha.inserirFim(new No()); // Add 3
        assertNotEquals(no, pilha.ultimo());
    }

    @Test
    public void InserirNoFimPilha()
    {
        Pilha pilha = new Pilha();
        pilha.inserirFim(new No()); // Add 1
        pilha.inserirFim(new No()); // Add 2
        No no = new No();
        pilha.inserirFim(no);       // Add 3
        assertEquals(no, pilha.ultimo());
    }
    
    @Test(expected = EPilha.class)
    public void RemoverNoFimPilhaVazia() throws EPilha
    {
        new Pilha().removerFim();
    }
    
    @Test
    public void RemoverNoFimPilhaRoot() throws EPilha
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirFim(no);
        assertSame(no, pilha.removerFim());
    }

    @Test
    public void RemoverNoFimPilha() throws EPilha
    {
        Pilha pilha = new Pilha();
        pilha.inserirInicio(new No());  // Add 1
        pilha.inserirFim(new No());     // Add 2
        No no = new No();
        pilha.inserirFim(no);           // Add 3
        assertEquals(no, pilha.removerFim());
    }
    
    @Test
    public void RemoverNoFimPilhaEVericandoUltimoElemento() throws EPilha
    {
        Pilha pilha = new Pilha();
        No no = new No();
        pilha.inserirFim(no);       // Add 1
        pilha.inserirFim(new No()); // Add 2
        pilha.inserirFim(new No()); // Add 3
        System.out.println(no);
        assertNotEquals(no, pilha.removerFim());
    }
}
