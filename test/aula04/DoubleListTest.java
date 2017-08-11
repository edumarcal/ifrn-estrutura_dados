// Agradeço a DEUS pelo dom do conhecimento

package aula04;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author papejajr
 */
public class DoubleListTest {
    
    @Test
    public void checandoListaVazia()
    {
        assertTrue(new DoubleList().isEmpty());
    }
    
    @Test
    public void checandoOTamanhoLista()
    {
        DoubleList doubleList = new DoubleList();
        doubleList.insertFirst(new No());
        doubleList.insertFirst(new No());
        doubleList.insertFirst(new No());
        assertTrue(3 == doubleList.size());
    }

    @Test
    public void checandoPrimeiro()
    {
        DoubleList doubleList = new DoubleList();
        No no = new No();
        doubleList.insertFirst(no);
        assertEquals(no, doubleList.frist());
    }
    
    @Test
    public void checandoUltimo()
    {
        DoubleList doubleList = new DoubleList();
        No no = new No();
        doubleList.insertFirst(no);
        assertEquals(no, doubleList.last());
    }
    
    @Test
    public void inserindoNoInicioLista()
    {
        DoubleList doubleList = new DoubleList();
        No no = new No();
        doubleList.insertFirst(new No());
        doubleList.insertFirst(new No());
        doubleList.insertFirst(no);
        assertEquals(no, doubleList.frist());
    }
    
    @Test
    public void inserindoNoFimLista()
    {
        DoubleList doubleList = new DoubleList();
        No no = new No();
        doubleList.insertLast(new No());
        doubleList.insertLast(new No());
        doubleList.insertLast(no);
        assertEquals(no, doubleList.last());
    }
    
    @Test
    public void inserindoAposInicioLista()
    {
        DoubleList doubleList = new DoubleList();
        No no_inicio = new No();
        No no_after = new No();
        doubleList.insertFirst(no_inicio);
        doubleList.insertLast(new No());
        doubleList.insertAfter(no_inicio, no_after);
        assertEquals(no_after, doubleList.after(no_inicio));
    }

     @Test
    public void inserindoAposInicioLista2()
    {
        DoubleList doubleList = new DoubleList();
        No no_inicio = new No();
        No no_after = new No();
        doubleList.insertFirst(no_inicio);
        doubleList.insertAfter(no_inicio, no_after);
        assertEquals(no_after, doubleList.after(no_inicio));
    }
    
    @Test
    public void inserindoAntesInicioLista()
    {
        DoubleList doubleList = new DoubleList();
        No no_inicio = new No();
        No no_before = new No();
        doubleList.insertFirst(no_inicio);
        doubleList.insertLast(new No());
        doubleList.insertBefore(no_inicio, no_before);
        assertEquals(no_before, doubleList.frist());
    }
    
    @Test
    public void alterarElementoRaiz() throws EDoubleList
    {
        DoubleList doubleList = new DoubleList();
        No no_inicio = new No();
        No no_atualizado = new No();
        doubleList.insertFirst(no_inicio);
        doubleList.replaceElement(no_inicio, no_atualizado);
        No element = (No) doubleList.frist();
        assertEquals(no_atualizado, element.getElement());
    }
    
    @Test
    public void removerRaiz() throws EDoubleList
    {
        DoubleList doubleList = new DoubleList();
        No no = new No();
        doubleList.insertFirst(no);
        doubleList.remove(no);
        assertEquals(0,doubleList.size());
    }
  
    @Test
    public void removerSegundoElemento() throws EDoubleList
    {
        DoubleList doubleList = new DoubleList();
        No no = new No();
        doubleList.insertFirst(new No());
        doubleList.insertLast(no);
        doubleList.remove(no);
        assertEquals(1,doubleList.size());
    }

    @Test
    public void removerSegundoElemento2() throws EDoubleList
    {
        DoubleList doubleList = new DoubleList();
        No no1 = new No();
        No no2 = new No();
        doubleList.insertLast(no1);
        doubleList.insertLast(no2);
        assertEquals(no2, doubleList.remove(no2));
    }
}
