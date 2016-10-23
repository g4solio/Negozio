/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negoziazione;

import java.util.Date;

/**
 *
 * @author g4solio
 */
public class Alimentare extends Prodotto {
    
    private Date DataDiScadenza;
    /*public Alimentare()
    {
        
    }*/
    public Alimentare(String Codice,String Descrizione, float Prezzo, Date data)
    {
        super(Codice, Descrizione, Prezzo);
        setDataDiScadenza(data);
    }   
    public Alimentare(String Codice, float Prezzo, Date data)
    {
        super(Codice, Prezzo);
        setDataDiScadenza(data);
    }

    public void setDataDiScadenza(Date data) {
        this.DataDiScadenza=new Date(data.getTime());
    }

    public Date getDataDiScadenza() {
        return DataDiScadenza;
    }
    public  void applicaSconti()
    {
        Date adesso=new Date();
        if(this.getDataDiScadenza().getTime()-adesso.getTime()>86400000)
        {
            super.applicaSconti();
        }
        else
        {
            super.setPrezzoUnitario((float) (super.getPrezzoUnitario()-super.getPrezzoUnitario()*0.20));
        }
    }
    public boolean equals(Alimentare a)
    {
        boolean out=false;
        if (super.equals(a)&&a.getDataDiScadenza().equals(this.getDataDiScadenza()))
        {
            out=true;
        }
        return out;
    }
    public String toString()
    {
        return super.toString()+"\n e scadra il: "+this.getDataDiScadenza().toString();
    }
    

    
}
