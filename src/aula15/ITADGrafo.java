// Agradeço a DEUS pelo dom do conhecimento

package aula15;

import java.util.Vector;

/**
 *
 * @author papejajr
 */

public interface ITADGrafo
{
    public abstract void inserirVertice(Vertice vertice);

    public abstract void removerVertice(Vertice vertice);

    public abstract Aresta insereAresta(Vertice v, Vertice w); // grafo nao orientado

    public abstract Aresta insereAresta(Vertice v, Vertice w, double valor); // grafo nao orientado

    public abstract Aresta insereAresta(Vertice v, Vertice w, double valor, boolean direcionar); // grafo orientado

    public abstract void removeAresta(Aresta aresta);

    public abstract Aresta insereArco(Vertice v, Vertice w);
   
    public abstract Aresta insereArco(Vertice v, Vertice w, double valor);

    public abstract Aresta insereArco(Vertice v, Vertice w, double valor, boolean direcionar);
    
    public abstract void removeArco(Aresta a);

    public abstract int grau(Vertice v);

    public abstract int ordem();

    public abstract Vector vertices();

    public abstract Vector arestas();

    public abstract Vector arestasIncidentes(Vertice vertice);

    public abstract Vector finalVertice(Aresta a);

    public abstract Vertice oposto(Vertice v, Aresta a) throws OpostoError;

    public abstract boolean éAdjacente(Vertice v, Vertice w);
    
    public abstract Aresta getAresta(Vertice v, Vertice w);
}
