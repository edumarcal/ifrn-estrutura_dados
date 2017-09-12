// Agradeço a DEUS pelo dom do conhecimento

package aula12.arvore_avl;

import aula06.arvore_generica.No;
import aula10.arvore_binaria_pesquisa.BinarySearchTree;

/**
 *
 * @author papejajr
 */
public class ArvoreAVL extends BinarySearchTree implements IArvoreAVL
{
    @Override
    public void rotacaoSimplesEsquerda(No no) {
        No a = no.getFilhoDireito();
        a.setPai(no.getPai());
        if (no.getPai() != null) {
            if (no.getPai().getFilhoDireito()== no) {
                no.getPai().setFilhoDireito(a);
            } else {
                no.getPai().setFilhoEsquerdo(a);
            }
        }
        no.setPai(a);
        if (a.getFilhoEsquerdo()!= null) {
            a.getFilhoEsquerdo().setPai(no);
            a.setFilhoEsquerdo(no);
        } else {
            a.setFilhoEsquerdo(no);
            a.getFilhoEsquerdo().setPai(a);
            no.setFilhoDireito(null);
            
        }
        this.root = a;        
        a.setFB(a.getFB() + 1);
        a.getFilhoEsquerdo().setFB(a.getFilhoEsquerdo().getFB() + 2);
    }

    @Override
    public void rotacaoSimplesDireita(No no) 
    {
        No a = no.getFilhoEsquerdo();
        a.setPai(no.getPai());
        if (no.getPai() != null) {
            if (no.getPai().getFilhoEsquerdo()== no) {
                no.getPai().setFilhoEsquerdo(a);
            } else {
                no.getPai().setFilhoDireito(a);
            }
        }
        no.setPai(a);
        if (a.getFilhoDireito()!= null) {
            a.getFilhoDireito().setPai(no);
            a.setFilhoDireito(no);
        } else {
            a.setFilhoDireito(no);
            a.getFilhoDireito().setPai(a);
            no.setFilhoEsquerdo(null);
        }
        super.root = a;
        a.setFB(a.getFB() - 1);
        a.getFilhoDireito().setFB(a.getFilhoDireito().getFB() - 2);
    }

    @Override
    public void rotacaoDuplaEsquerda(No no) {
        rotacaoSimplesDireita(no);
        rotacaoSimplesEsquerda(no);
    }

    @Override
    public void rotacaoDuplaDireita(No no) {
        rotacaoSimplesEsquerda(no);
        rotacaoSimplesDireita(no);
    }
    
    public void atualizaFB(int valor, boolean in)
    {
        // atualizando FB pelo retorno da busca do nó informado.
        No no = search(root, root);
        atualizaFB(no, in);
    }
    
    private void atualizaFB(No no, boolean in){
        
        if (in) {
            if (no.getPai() != null) {
                //  sub-arvore esquerda
                if (no.getPai().getFilhoEsquerdo()== no){

                    no.getPai().setFB(no.getPai().getFB() + 1);
                    atualizaFB(no.getPai(), true);

                    if (no.getPai().getFB() >= 2) {
                        if (no.getFilhoDireito()!= null) {
                            if (no.getFilhoDireito().getFB() == -1) {
                                System.out.println("rotação simples a direita");
//                                rotacaoDuplaDireita(no.getPai());
                            }
                        } else {
                            System.out.println("rotação simples a direita");
//                            rotacaoSimplesDireita(no.getPai());
                        }
                    }
                //  sub-arvore direita
                } else {

                    no.getPai().setFB(no.getPai().getFB() - 1);
                    atualizaFB(no.getPai(), true);
                    
                    if (no.getPai().getFB() <= -2) {
                        if (no.getFilhoEsquerdo()!= null) {
                            if (no.getFilhoEsquerdo().getFB() == -1) {
                                System.out.println("rotação dupla a esquerda");
//                                rotacaoDuplaEsquerda(no.getPai());
                            }
                        } else {
                            System.out.println("rotação simples a esquerda");
//                            rotacaoSimplesEsquerda(no.getPai());
                        }
                    }
                }
            }
        // remoção
        } else {
            if (no.getPai() != null) {
                if (no.getPai().getFilhoEsquerdo()== no){

                    no.getPai().setFB(no.getPai().getFB() - 1);
                    atualizaFB(no.getPai(), false);
                } else {

                    no.getPai().setFB(no.getPai().getFB() + 1);
                    atualizaFB(no.getPai(), false);
                }
            }
        }
    }
    
    @Override
    public No remove(No element)
    {
        atualizaFB(root, false);
        return super.remove(element);
    }

    @Override
    public void insert(No position, No element) {
        super.insert(position, element);
        atualizaFB((int)element.getElement(), true);
    }
    
    
}
