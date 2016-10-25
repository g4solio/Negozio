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
public class ArrayV3 extends ArrayList {

    ArrayList ListaNomi;
    ArrayList ListaVolte;
    public ArrayV3(ArrayList nomi, ArrayList volte )
    {
        ListaNomi=nomi;
        ListaVolte=volte;
    }
    public void add(Object Oggetto, String NomeOggetto, int volte)
    {
        super.add(Oggetto);
        ListaNomi.add(NomeOggetto);
        ListaVolte.add(volte);
    }
    public void add(int index,Object Oggetto, String NomeOggetto, int volte)
    {
        super.add(index,Oggetto);
        ListaNomi.add(index,NomeOggetto);
        ListaVolte.add(index,volte);
    }
    public Object getNome(int i)
    {
        return ListaNomi.get(i);
    }
    public Object getVolte(int i)
    {
        return ListaVolte.get(i);
    }
    public Object getObject(int i)
    {
        return super.get(i);
    }
}
