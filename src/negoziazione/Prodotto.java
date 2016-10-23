/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negoziazione;

/**
 *
 * @author davide
 */
public abstract class Prodotto {
    private String CodiceABarre;
    private String Descrizione;
    private float PrezzoUnitario;
    //-------------Costruttore-----------//
    public Prodotto(String Codice,String Descrizione, float Prezzo)
    {
        setCodiceABarre(Codice);
        setDescrizione(Descrizione);
        setPrezzoUnitario(Prezzo);
    }
    public Prodotto(String Codice,float Prezzo)
    {
        setCodiceABarre(Codice);
        setPrezzoUnitario(Prezzo);
        setDescrizione("");
    }
    //------------------Setter&Getter---------------------//
    private void setCodiceABarre(String codice)
    {
        this.CodiceABarre=codice;
    }
    private void setDescrizione(String descrizione)
    {
        this.Descrizione=descrizione;
    }
    protected void setPrezzoUnitario(float prezzo)
    {
        this.PrezzoUnitario=prezzo;
    }

    public String getCodiceABarre() {
        return CodiceABarre;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public float getPrezzoUnitario() {
        return PrezzoUnitario;
    }
    
    //-------------------Metodi-------------------//
    public void applicaSconti()
    {
        this.setPrezzoUnitario((float) (this.getPrezzoUnitario()-this.getPrezzoUnitario()*0.05));
    }
    public boolean equals(Prodotto a)
    {
        return (
                (this.getCodiceABarre().equals(a.getCodiceABarre()))
                &&
                (this.getDescrizione().equals(a.getDescrizione()))
                &&
                (this.getPrezzoUnitario()==a.getPrezzoUnitario())
               ) ? 
                true : false ;
    }
    public String toString()
    {
        return "il prezzo unitario e: "+this.getPrezzoUnitario()+"\n"+
                "la descrizione e: "+
                ((!this.getDescrizione().equals(""))?" non esiste la descrizione":this.getDescrizione())+
                "\n"+
                "il codice a barre e: "+this.getCodiceABarre();
    }
    
    
    
 

}
