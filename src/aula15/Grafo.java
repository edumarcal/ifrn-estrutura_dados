// Agradeço a DEUS pelo dom do conhecimento

package aula15;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author papejajr
 */

public class Grafo implements ITADGrafo
{
    private int qtdVertices;
    private Vector<Vertice> vertices;
    private Aresta matrizAdj[][];
    //private Vector<Aresta> matrizAdj[][];

    public Grafo()
    {
        this.qtdVertices = 0;
        this.vertices = new Vector();
    }
    
    /**
     * @param vertice vertice a ser removido
     * @status OK
     */
    @Override
    public void inserirVertice(Vertice vertice)
    {
        qtdVertices++;
        vertices.add(vertice);
        
        Aresta temp[][] = new Aresta[qtdVertices][qtdVertices];
        if (matrizAdj != null)
        {
            for (int i = 0; i < matrizAdj.length; i++)
            {
                for (int j = 0; j < matrizAdj.length; j++)
                {
                  if(matrizAdj[i][j] != null)
                  {
                      temp[i][j] = matrizAdj[i][j];
                  }  
                }
            }
        }
        matrizAdj = temp;
    }

    /**
     * @param vertice vertice a ser removido
     * @status OK
     */
    @Override
    public void removerVertice(Vertice vertice)
    {
        qtdVertices--;
        int indice = acharIndice(vertice.getChave()); // acha o indice do vertice
        vertices.remove(indice); // remove o vertice do vector
        
        //Remove linhas e colunas da matriz de adjacência
        Aresta tempMatrizAdj[][] = new Aresta[qtdVertices][qtdVertices];
        int f = 0, g;
        for (int i = 0; i < qtdVertices; i++)
        {
            g = 0;
            for (int j = 0; j < qtdVertices+1; j++)
            {
                if (i != indice && j != indice)
                {
                   tempMatrizAdj[f][g] = matrizAdj[i][j];
                   if (j != indice)
                       g++;
                }
            }
            if (i != indice)
                f++;
        }
        
        matrizAdj = tempMatrizAdj;
    }

        /**
     * @param v vertice A
     * @param w vertice B
     * @return retorna a Aresta
     * @status OK
     */
    @Override
    public Aresta insereAresta(Vertice v, Vertice w) // Nao orientado
    {
        Aresta a = new Aresta(v, w);
        int indiceV = acharIndice(v.getChave());
        int indeceW = acharIndice(w.getChave());
        matrizAdj[indiceV][indeceW] = matrizAdj[indeceW][indiceV] = a; // grafo nao orientado
        return a;
    }

    /**
     * @param v vertice A
     * @param w vertice B
     * @param valor valor da Aresta
     * @return retorna a Aresta
     * @status OK
     */
    @Override
    public Aresta insereAresta(Vertice v, Vertice w, double valor) // Nao orientado
    {
        Aresta a = new Aresta(v, w, valor);
        int indiceV = acharIndice(v.getChave());
        int indeceW = acharIndice(w.getChave());
        matrizAdj[indiceV][indeceW] = matrizAdj[indeceW][indiceV] = a; // grafo nao orientado
        return a;
    }

     /**
     * @param v vertice A
     * @param w vertice B
     * @param valor valor da Aresta
     * @param direcionar Aresta direcionada
     * @return retorna a Aresta
     * @status OK
     */
    @Override
    public Aresta insereAresta(Vertice v, Vertice w, double valor, boolean direcionar) // Orientado
    {
        Aresta a = new Aresta(v, w, valor, direcionar);
        int indiceV = acharIndice(v.getChave());
        int indeceW = acharIndice(w.getChave());
        matrizAdj[indiceV][indeceW] = matrizAdj[indeceW][indiceV] = a; // grafo nao orientado
        return a;
    }
    
    /**
     * @param a Aresta a ser removida
     * @status OK
     */
    @Override
    public void removeAresta(Aresta a)
    {
       int indiceArestaOrigem = acharIndice(a.getVerticeOrigem().getChave());
       int indiceArestaDestino = acharIndice(a.getVerticeDestino().getChave());
       matrizAdj[indiceArestaOrigem][indiceArestaDestino] = matrizAdj[indiceArestaDestino][indiceArestaOrigem] = null; // grafo nao orientado
    }

    /**
     * @param v vertice A
     * @param w vertice B
     * @return retorna a Aresta
     * @status OK
     */
    @Override
    public Aresta insereArco(Vertice v, Vertice w)
    {
        Aresta a = new Aresta(v, w);
        int indiceV = acharIndice(v.getChave());
        int indicdW = acharIndice(w.getChave());
        matrizAdj[indiceV][indicdW] = a;
        return a;
    }

    /**
     * @param v vertice A
     * @param w vertice B
     * @param valor valor da Aresta
     * @return retorna a Aresta
     * @status OK
     */
    @Override
    public Aresta insereArco(Vertice v, Vertice w, double valor)
    {
        Aresta a = new Aresta(v, w, valor);
        int indiceV = acharIndice(v.getChave());
        int indicdW = acharIndice(w.getChave());
        matrizAdj[indiceV][indicdW] = a;
        return a;
    }

    /**
     * @param v vertice A
     * @param w vertice B
     * @param valor valor da Aresta
     * @param direcionar Aresta direcionada
     * @return retorna a Aresta
     * @status OK
     */
    @Override
    public Aresta insereArco(Vertice v, Vertice w, double valor, boolean direcionar)
    {
        Aresta a = new Aresta(v, w, valor, direcionar);
        int indiceV = acharIndice(v.getChave());
        int indicdW = acharIndice(w.getChave());
        matrizAdj[indiceV][indicdW] = a;
        return a;
    }
    
    /**
     * @param a Aresta a ser removida
     * @status OK
     */
    @Override
    public void removeArco(Aresta a)
    {
        int indiceArestaOrigem = acharIndice(a.getVerticeOrigem().getChave());
        int indiceArestaDestino = acharIndice(a.getVerticeDestino().getChave());
        matrizAdj[indiceArestaOrigem][indiceArestaDestino] = null;
    }

    /**
     * @param v vertice A
     * @return o grau do vertice
     * @status OK
     */
    @Override
    public int grau(Vertice v)
    {
       return arestasIncidentes(v).size();
    }

    /**
     * @return retorna a ordem
     * @status OK
     */
    @Override
    public int ordem()
    {
        return qtdVertices;
    }

    /**
     * @return lista de vertices
     * @status OK
     */
    @Override
    public Vector vertices()
    {
        return vertices;
    }

    /**
     * @return Lista de Aresta
     * @status OK
     */
    @Override
    public Vector arestas()
    {
        Vector v = new Vector();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                v.add(matrizAdj[i][j]);
        return v;
    }

    @Override
    public Vector arestasIncidentes(Vertice vertice)
    {
        int indice = acharIndice(vertice.getChave());
        Vector vector = new Vector();
        int grau = 0;
        for (int i = 0; i < qtdVertices; i++)
        {
            for (int j = 0; j < qtdVertices; j++)
            {
                if(i == indice)
                {
                    if(matrizAdj[i][j].getVerticeOrigem() == vertice || matrizAdj[i][j].getVerticeDestino() == vertice)
                    {
                        vector.add(matrizAdj[i][j]);
                    }
                }
            }
        }
        return vector;
    }

    /**
     * @param a Aresta
     * @return retorna o vertice final
     * @status OK
     */
    @Override
    public Vector finalVertice(Aresta a)
    {
        Vector v = new Vector();
        v.add(a.getVerticeOrigem());
        v.add(a.getVerticeDestino());
        return v;
    }

    /**
     * @param v Vertice
     * @param a Aresta
     * @return retorna o vertice final
     * @throws aula15.OpostoError
     * @status OK
     */
    @Override
    public Vertice oposto(Vertice v, Aresta a) throws OpostoError
    {
        if (a.getVerticeOrigem() == v)
            return a.getVerticeDestino();
        else if(a.getVerticeDestino() == v)
            return a.getVerticeOrigem();
        else
            throw new OpostoError("Não é incidente");
    }

    /**
     * @param v Vertice de origem
     * @param w Vertice de destino
     * @return retorna a adjacencia entre os vertices V e W
     * @status OK
     */
    @Override
    public boolean éAdjacente(Vertice v, Vertice w)
    {
        int indiceV = acharIndice(v.getChave());
        int indiceW = acharIndice(w.getChave());
        return matrizAdj[indiceV][indiceW] != null; 
   }
    
    /**
     * @param chave chave do vertice
     * @return retorna o indice
     * @status OK
     */
    public int acharIndice(int chave)
    {
        Iterator iterator = vertices.iterator();
        int indice = 0;
        while(iterator.hasNext())
        {
            Vertice v = (Vertice) iterator.next();
            if (v.getChave() == chave) // Achei
                return indice;
            indice++;
        }
        return -1; // Não achei
    }

    /**
     * @status OK
     */    
    public void mostaVertices()
    {
        for(int i = 0; i < vertices.size(); i++)
            System.out.print(vertices.elementAt(i) + ", ");
        System.out.println();
    }
    
    /**
     * @status OK
     */
    public void mostraMatriz()
    {
        for(int i = 0; i < qtdVertices; i++)
        {
            for(int j = 0; j < qtdVertices; j++)
            {
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

   /**
     * @param v Vertice de origem
     * @param w Vertice de destino
     * @return retorna a Aresta correspondente
     * @status OK
     */
    @Override
    public Aresta getAresta(Vertice v, Vertice w)
    {
        int indiceV = acharIndice(v.getChave());
        int indiceW = acharIndice(w.getChave());
        return matrizAdj[indiceV][indiceW];        
    }
}
