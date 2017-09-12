// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_generica;

/**
 *
 * @author papejajr
 */
public class No
{
    protected Object element;
    protected No pai, filhoEsquerdo, filhoDireito;
    protected int FB = 0;

    public No() {
    }

    public No(Object element) {
        this.element = element;
    }

    
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }
    
    
/*
    @Override
    public String toString() {
        return element.toString();
    }
  */  

    public int getFB() {
        return FB;
    }
    
}
