/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negoziazione;

import java.util.ArrayList;

/**
 *
 * @author g4solio
 */
public class ListaSpesa 
{
    /*ArrayList Nomi;
    ArrayList Volte; 
    ArrayV3 Lista;
    
    public ListaSpesa() {
        Nomi = new ArrayList();
        Volte = new ArrayList();
        Lista = new ArrayV3(Nomi,Volte);
    }*/
    ArrayList Volte;
    Array Lista;
    boolean carta;
    public ListaSpesa(boolean carta)
    {
        Volte=new ArrayList();
        Lista = new Array(Volte);
        this.carta=carta;
    }
    public void add(String Nome, Integer quantita)
    {
        Lista.add(Nome, quantita);
    }
    public int getVolte (int i)
    {
        return (int) Lista.get(i);
    }
        public Object getNome (int i)
    {
        return  Lista.get(i);
    }
    
}
