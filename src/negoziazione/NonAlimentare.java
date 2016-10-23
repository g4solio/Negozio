/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negoziazione;

/**
 *
 * @author g4solio
 */
public class NonAlimentare extends Prodotto {
    private String Materiale;

    public NonAlimentare(String Codice, String Descrizione, float Prezzo, String Materiale) {
        super(Codice, Descrizione, Prezzo);
        this.setMateriale(Materiale);
    }
    public NonAlimentare(String Codice, float Prezzo, String Materiale) {
        super(Codice, Prezzo);
        this.setMateriale(Materiale);
    }

    public String getMateriale() {
        return Materiale;
    }

    private void setMateriale(String Materiale) {
        this.Materiale = Materiale;
    }
    
    
    
    public void applicaSconti()
    {
        if(super.getPrezzoUnitario()>100)
        {
            super.setPrezzoUnitario((float) (super.getPrezzoUnitario()-super.getPrezzoUnitario()*0.10));
        }
        else
        {
            super.applicaSconti();
        }
    }
    public boolean equals(NonAlimentare a)
    {
        boolean out=false;
        if(super.equals(a)&&a.getMateriale().equals(this.getMateriale()))
        {
            out=true;
        }
        return out;
    }
    public String toString()
    {
        return super.toString()+"\n e il materiale e: "+this.getMateriale();
    }
    
    
}
