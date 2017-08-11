// Agradeço a DEUS pelo dom do conhecimento

package aula03.fila_array;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author papejajr
 */
public class FilaTest
{

    @Test(expected = EFila.class)
    public void TamanhoDaFilaIgualAZero() throws EFila
    {
        Fila fila = new Fila(0);
    }
    
    @Test(expected = EFila.class)
    public void TamanhoDaFilaMenorDoQueZero() throws EFila
    {
        Fila fila = new Fila(-1);
    }
    
    @Test
    public void TamanhoDaFilaMaiorQueZero() throws EFila
    {
        assertSame(Fila.class, new Fila(1).getClass());
    }
    
    @Test
    public void FilaVazia() throws EFila
    {
        assertEquals(true, new Fila(10).estaVazia());
    }
    
    @Test
    public void QuantidadeDeElementoNaFilaAntesDaInsercao() throws EFila
    {
        assertEquals(0, new Fila(1).tamanho());
    }
    
    @Test
    public void QuantidadeDeElementoNaFilaAposInsercao() throws EFila
    {
        Fila fila = new Fila(10);
        fila.enfileirar(new Object()); // Add 1
        fila.enfileirar(new Object()); // Add 2
        fila.enfileirar(new Object()); // Add 3
        fila.enfileirar(new Object()); // Add 4
        assertEquals(4, fila.tamanho());
    }
    
    @Test(expected = EFila.class)
    public void FilaCheiaAposInsersaoMaisElemento() throws EFila
    {
        Fila fila = new Fila(4);
        fila.enfileirar(new Object()); // Add 1
        fila.enfileirar(new Object()); // Add 2
        fila.enfileirar(new Object()); // Add 3
        fila.enfileirar(new Object()); // Add 4
        fila.enfileirar(new Object()); // Add 5        
    }
    
    @Test
    public void InsersaoIgualAQuatidadeSuportadaPelaFila() throws EFila
    {
        Fila fila = new Fila(4);
        fila.enfileirar(new Object()); // Add 1
        fila.enfileirar(new Object()); // Add 2
        fila.enfileirar(new Object()); // Add 3
        fila.enfileirar(new Object()); // Add 4
        assertEquals(4, fila.tamanho());
    }
    
    @Test(expected = EFila.class)
    public void InicioDaFilaCasoSejaVazia() throws EFila
    {
        new Fila(10).inicio();
    }
    
    @Test
    public void InicioDaFila() throws EFila
    {
        Fila fila = new Fila(2);
        fila.enfileirar(new Object());
        assertTrue(fila.inicio() instanceof Object);
    }
    
    @Test(expected = EFila.class)
    public void DesenfileirarFilaVazia() throws EFila
    {
        new Fila(5).desenfileirar();
    }
    
    @Test
    public void DesenfileirarFilaDoisElementos() throws EFila
    {
        Fila fila = new Fila(2);
        fila.enfileirar(new Object());
        fila.enfileirar(new Object());
        fila.desenfileirar();
        assertTrue(fila.tamanho() == 1);
    }
    
    @Test
    public void DesenfileirarFila() throws EFila
    {
        Fila fila = new Fila(1);
        Object obj = new Object();
        fila.enfileirar(obj);
        assertSame(obj, fila.desenfileirar()); // Verificando se a instancia do objeto foi removido
    }
    
    @Test
    public void DesenfileirarFilaVariosElementos() throws EFila
    {
        Fila fila = new Fila(10);
        fila.enfileirar(new Object()); // Add 1
        fila.enfileirar(new Object()); // Add 2
        fila.desenfileirar();          // Rem 1
        fila.enfileirar(new Object()); // Add 3
        fila.enfileirar(new Object()); // Add 4
        fila.enfileirar(new Object()); // Add 5
        fila.desenfileirar();          // Rem 2
        fila.desenfileirar();          // Rem 3
        assertTrue(fila.tamanho() == 2);
    }
}