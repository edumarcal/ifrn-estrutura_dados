// Agradeço a DEUS pelo dom do conhecimento

package aula03.fila_lista;

import aula03.No;
import aula03.fila_array.EFila;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author papejajr
 */
public class FilaTest {

        
    @Test
    public void ComparandoAsInstancias() throws EFila
    {
        assertSame(Fila.class, new Fila().getClass());
    }
    
    @Test
    public void FilaVazia() throws EFila
    {
        assertEquals(true, new Fila().estaVazia());
    }
    
    @Test
    public void QuantidadeDeElementoNaFilaAntesDaInsercao() throws EFila
    {
        assertEquals(0, new Fila().tamanho());
    }
 
    @Test
    public void QuantidadeDeElementoNaFilaAposInsercao() throws EFila
    {
        Fila fila = new Fila();
        fila.enfileirar(new No()); // Add 1
        fila.enfileirar(new No()); // Add 2
        fila.enfileirar(new No()); // Add 3
        fila.enfileirar(new No()); // Add 4
        assertEquals(4, fila.tamanho());
    }

    
    @Test
    public void InsersaoIgualAQuatidadeSuportadaPelaFila() throws EFila
    {
        Fila fila = new Fila();
        fila.enfileirar(new No()); // Add 1
        fila.enfileirar(new No()); // Add 2
        fila.enfileirar(new No()); // Add 3
        fila.enfileirar(new No()); // Add 4
        assertEquals(4, fila.tamanho());
    }
    
    @Test
    public void InicioDaFila() throws EFila
    {
        Fila fila = new Fila();
        fila.enfileirar(new No());
        assertTrue(fila.inicio() instanceof No);
    }
    
    @Test(expected = EFila.class)
    public void DesenfileirarFilaVazia() throws EFila
    {
        new Fila().desenfileirar();
    }
    
    @Test
    public void DesenfileirarFilaDoisElementos() throws EFila
    {
        Fila fila = new Fila();
        fila.enfileirar(new No());
        fila.enfileirar(new No());
        fila.desenfileirar();
        assertTrue(fila.tamanho() == 1);
    }
    
    @Test
    public void DesenfileirarFila() throws EFila
    {
        Fila fila = new Fila();
        No obj = new No();
        fila.enfileirar(obj);
        assertSame(obj, fila.desenfileirar()); // Verificando se a instancia do objeto foi removido
    }
    
    @Test
    public void DesenfileirarFilaVariosElementos() throws EFila
    {
        Fila fila = new Fila();
        fila.enfileirar(new No()); // Add 1
        fila.enfileirar(new No()); // Add 2
        fila.desenfileirar();          // Rem 1
        fila.enfileirar(new No()); // Add 3
        fila.enfileirar(new No()); // Add 4
        fila.enfileirar(new No()); // Add 5
        fila.desenfileirar();          // Rem 2
        fila.desenfileirar();          // Rem 3
        assertTrue(fila.tamanho() == 2);
    }
}