// Agradeço a DEUS pelo dom do conhecimento

package aula15;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author papejajr
 */

public class GrafoTest
{
   // STATUS: OK => Removendo elemento
   @Test
   public void addElements()
   {
       Grafo grafo = new Grafo();
       Vertice v1 = new Vertice(1);
       Vertice v2 = new Vertice(2);
       Vertice v3 = new Vertice(3);
       Vertice v4 = new Vertice(4);
       Vertice v5 = new Vertice(5);
       grafo.inserirVertice(v1);
       grafo.inserirVertice(v2);
       grafo.inserirVertice(v3);
       grafo.inserirVertice(v4);
       grafo.inserirVertice(v5);

       // Inserindo Aresta
       grafo.insereAresta(v1, v2);
       grafo.insereAresta(v2, v3);
       grafo.insereAresta(v3, v4);
       grafo.insereAresta(v5, v5);
       
       grafo.removeArco(grafo.getAresta(v5, v5));
       
       // Imprimindo a Matriz de arestas
       grafo.mostraMatriz();
       
       // Impriminndo os vertices
       grafo.mostaVertices();
       assertEquals(5,grafo.ordem());
   }    
}
