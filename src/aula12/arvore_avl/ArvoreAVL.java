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
    public void rotacaoSimplesEsquerda(No no)
    {
        //System.err.println(no.getElement());        
        No element = no.getFilhoDireito();
        no.setFilhoDireito(element.getFilhoEsquerdo());
        if (element.getFilhoEsquerdo() != null)
        {
            element.getFilhoEsquerdo().setPai(no);
        }
        
        element.setPai(no.getPai());
        if (!hasParent(no))
        {
            root = element;
        }
        else if (no == no.getPai().getFilhoEsquerdo())
        {
            no.getPai().setFilhoEsquerdo(element);
        }
        else
        {
            no.getPai().setFilhoDireito(element);
        }
        
        element.setFilhoEsquerdo(no);
        no.setPai(element);
    }

    @Override
    public void rotacaoSimplesDireita(No no)
    {
        System.err.println(no.getElement());
        No element = no.getFilhoEsquerdo();
        element.setPai(no.getPai());
        if (!hasParent(no))
        {
            if (no.getPai().getFilhoEsquerdo() == no)
            {
                no.getPai().setFilhoEsquerdo(element);
            }
            else
            {
                no.getPai().setFilhoDireito(element);
            }
        }
        
        no.setPai(element);
        if (element.getFilhoDireito() != null)
        {
            element.getFilhoDireito().setPai(no);
            element.setFilhoDireito(no);
        }
        else
        {
            element.setFilhoDireito(no);
            element.getFilhoDireito().setPai(element);
            no.setFilhoEsquerdo(null);
        }
        //root = element;
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
       
    @Override
    public void atualizarFB(No no, boolean operacao)
    {
        // operacao = TRUE => INSERT | FALSE => REMOVE
        if(operacao)
        {
            // Atualiza o fator de balanceamento
            no.setFB(calcFB(no));
            System.out.println("No [ " + no.getElement() + " ] => FB = " + no.getFB());
            
            // Critério de parada
            if(hasParent(no))
            {
                parent(no).setFB(calcFB(parent(no)));
                if(parent(no).getFB() == 0)
                    return;
            }
            
            if(no.getFB() == 2)
            {
                if(hasright(no))
                {
                    if(rightChild(no).getFB() == -1)
                    {
                        System.out.println("Tipo de rotação: RDD [ " + no.getElement() + " ]");
                        rotacaoDuplaDireita(no);
                        printTree();
                    }
                    else
                    {
                        System.out.println("Tipo de rotação: RDS [ " + no.getElement() + " ]");
                        rotacaoSimplesDireita(no);
                        printTree();
                    }
                }
                else
                {
                    System.out.println("Tipo de rotação: RDS [ " + no.getElement() + " ]");
                    rotacaoSimplesDireita(no);
                    printTree();
                }
            }
            else if(no.getFB() == -2)
            {
                if(hasLeft(no))
                {
                    if(leftChild(no).getFB() == -1)
                    {
                        System.out.println("Tipo de rotação: RDE [ " + no.getElement() + " ]");
                        rotacaoDuplaEsquerda(no);
                        printTree();
                    }
                    else
                    {
                        System.out.println("Tipo de rotação: RES [ " + no.getElement() + " ]");
                        rotacaoSimplesEsquerda(no);
                        printTree();
                    }
                }
                else
                {
                    System.out.println("Tipo de rotação: RES [ " + no.getElement() + " ]");
                    rotacaoSimplesEsquerda(no);
                    printTree();
                }
            }
            
            if(hasParent(no))
            {
                //System.err.println(no.getElement());
                atualizarFB(parent(no), operacao);
            }
            else
            {
                //System.err.println("- "+no.getElement());
                return;
            }
        }
        else // Case remoção
        {
  
        }
    }

    private int calcFB(No no)
    {
        return height(no.getFilhoEsquerdo()) - height(no.getFilhoDireito());        
    }
    
    @Override
    public void insert(No no) {
        super.insert(root, no);
        printTree();
        atualizarFB(no, true);
    }

    @Override
    public No search(No no) {
        return super.search(root, no);
    }

    @Override
    public No remove(No element) {
        No no = super.remove(element);
        
        if (no != null)
            atualizarFB(no, false);
        
        return no;
    } 

    @Override
    public boolean hasParent(No no)
    {
        return parent(no) != null;
    }
    
    private void balance(No no)
    {
        // operacao = TRUE => INSERT | FALSE => REMOVE
        if (hasParent(no))
        {
            // sub-arvore esquerda
            if(hasLeft(parent(no)))
            {
                if(parent(no).getFilhoEsquerdo().equals(no))
                {
                    if(parent(no).getFB() >= 2)
                    {
                        if(hasright(no))
                        {
                            if(rightChild(no).getFB() == -1)
                            {
                                System.out.println("Tipo de rotação: RDD [ " + parent(no).getElement() + " ]");
                                rotacaoDuplaDireita(parent(no));
                            }
                        }
                        else
                        {
                            System.out.println("Tipo de rotação: RDS [ " + parent(no).getElement() + " ]");
                            rotacaoSimplesEsquerda(parent(no));
                        }
                    }
                }
            }
            // sub-arvore direita
            else if(hasright(parent(no)))
            {
                if(parent(no).getFilhoDireito().equals(no))
                {
                    if(parent(no).getFB() <= -2)
                    {
                        if(hasLeft(no))
                        {
                            if(leftChild(no).getFB() == -1)
                            {
                                System.out.println("Tipo de rotação: RDE [ " + parent(no).getElement() + " ]");
                                rotacaoDuplaEsquerda(parent(no));
                            }
                        }
                        else
                        {
                            System.out.println("No [ " + parent(no).getElement() + " ] => FB = " + parent(no).getFB());
                            System.out.println("Tipo de rotação: RES [ " + parent(no).getElement() + " ]");
                            rotacaoSimplesEsquerda(parent(no));
                            printTree();
                        }
                    }
                }
            }
        }
    }


public void atualizarFBXXX(No no, boolean operacao)
    {
        // operacao = TRUE => INSERT | FALSE => REMOVE
        if(operacao)
        {
            if (hasParent(no))
            {
                System.out.println("No [ " + no.getElement() + " ] => FB = " + no.getFB());
                // sub-arvore esquerda
                if(hasLeft(parent(no)))
                {
                    if(parent(no).getFilhoEsquerdo().equals(no))
                    {
                        parent(no).setFB(parent(no).getFB() + 1); // Add Left Sum 1
                        if(parent(no).getFB() >= 2)
                        {
                            balance(no);
                            return;
                        }

                        atualizarFB(parent(no), operacao);
                    }
                }
                // sub-arvore direita
                else if(hasright(parent(no)))
                {                    
                    if(parent(no).getFilhoDireito().equals(no))
                    {
                        parent(no).setFB(parent(no).getFB() -1); // Add Left Sub 1                     
                        
                        if(parent(no).getFB() <= -2)
                        {
                            balance(no);
                            return;
                        }
                        atualizarFB(parent(no), operacao);
                    }
                }
                
            }
        }
        else // Case remoção
        {
        }
        
        //System.out.println("No [ " + no.getElement() + " ] => FB = " + no.getFB());
    }    
}
