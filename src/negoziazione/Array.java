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
public class Array extends ArrayList 
{
    ArrayList derivato;
    
    public Array(ArrayList a)
    {
        super();
        derivato=a;
    }

    public void add(int pos,Object a, String nome)
     {
         super.add(pos,a);
        derivato.add(pos,nome);
     }    
    public void add(Object a, String nome)
     {
         super.add(a);
        derivato.add(nome);
     }
    void add(String Nome, Integer quantita) 
    {
        super.add(Nome);
        derivato.add(quantita);
    }
     public Object get(int i)
     {
         return derivato.get(i);
     }
     public Object getObject(int i)
     {
         return super.get(i);
     }
}
