/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negoziazione;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author davide
 */
public class Negoziazione {
       public Date adesso;
       public Alimentare AlimentareLocale;
       public NonAlimentare NonAlimentareLocale;
       public ArrayList ListaNomiProdotti = new ArrayList();
       public Array ListaProdotti = new Array(ListaNomiProdotti);
       public ListaSpesa ListaSpesa ;


     /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        ArrayList v = new ArrayList();
        System.out.println("n.elementi di v: "+v.size());
        v.add("albero");
        v.add("banana");
        v.add("denti");
        v.add("elevatore");
        v.add(2,"cuscino"); // inserisce “ccc” prima di “ddd”
        System.out.println("n. elementi di v: "+v.size());
        for (int i=0; i<v.size(); i++)
        System.out.println("elemento "+ i+": "+v.get(i));
        System.out.println("primo: "+v.get(0));
        System.out.println("ultimo: "+v.get(v.size()-1));
        String s = (String)v.get(0); // downcast obbligatorio
        */
        /*
        ArrayList ListaProdotti = new ArrayList();
        Date adesso=new Date();

        Alimentare banana;
        banana = new Alimentare("10201023",1.05f,adesso);
        ListaProdotti.add(banana);
        System.out.println(ListaProdotti.get(0));
        */    
        
        /*Date adesso=new Date();
        Alimentare banana = new Alimentare("10201023",1.05f,adesso);

        ArrayList ListaNomi=new ArrayList();
        Array Lista = new Array(ListaNomi);
        Lista.add(banana, "banana");
        Lista.add(0,banana,"kiwi");
        banana = new Alimentare("afsdfsaaw",1.05f,adesso);
        Lista.add(banana, "banana");

        System.out.println(Lista.get(0));
        System.out.println(Lista.get(1));
        System.out.println(Lista.get(2));
        */
        Scanner input = new Scanner(System.in);
        Negoziazione Negozio = new Negoziazione();
        Date adesso=new Date();

        File Memory = new File("Negozio.txt");
        ReadFile FileInput = new ReadFile();
        String MemoryString = "";
        while(true)
        {
            System.out.println("Benvenuto in MPM: My Personal Market");
            if(Memory.exists())
            {
                System.out.println("trovato un file in memoria, desidera caricarlo ? (Y/n)");
                if(input.nextLine().equalsIgnoreCase("y"))
                {
                    MemoryString = FileInput.readFile("Negozio.txt");
                    Negozio.inputDaFile(MemoryString);
                    System.out.println("vuoi aggiungere elementi?(Y/n) ");
                    if(input.nextLine().equalsIgnoreCase("Y"))
                    {
                        Negozio.allocazioneAlimenti();
                    }
                    break;
                }
                else if(input.nextLine().equalsIgnoreCase("n"))
                {
                    Negozio.allocazioneAlimenti();
                    break;
                }
                
            } 
            else 
            {
                Negozio.allocazioneAlimenti();
                break;
            }
        }
        Negozio.IniziallizzaSpesa();
        float totale = Negozio.CostoTotale();
       
}

    public Negoziazione() {
        this.adesso = new Date();
    }
    // tipo codice descrizione prezzo altro nome
    //es. Alimentare 12B3123B1 10.5 102321093012 banana
    //es. NonAlimentare 2131313YH1 10.7 Metallo coltello
    public void inputDaFile(String Memory)
    {
        
        String[] MemorySplitted = Memory.split(" ");
        for(int i = 0; i<=MemorySplitted.length;i+=6)
        {
            if (MemorySplitted[i].equalsIgnoreCase("alimentare"))
            {
                adesso.setTime(Long.parseLong(MemorySplitted[i+4]));
                
                ListaProdotti.add(new Alimentare(MemorySplitted[i+1],MemorySplitted[i+2],Float.valueOf(MemorySplitted[i+3]),adesso), MemorySplitted[i+5]);
            }
            else if(MemorySplitted[i].equalsIgnoreCase("nonalimentare"))
            {
                ListaProdotti.add(new NonAlimentare(MemorySplitted[i+1],MemorySplitted[i+2],Float.valueOf(MemorySplitted[i+3]),MemorySplitted[i+4]), MemorySplitted[i+5]);
            }
                   
        }
        
    }
    //nome codice AlimentareONo prezzo altro
    public void allocazioneAlimenti()
    {
        Scanner input = new Scanner(System.in);

        String[] ArrayForConstruct = new String[120];
        boolean succes= true;
        ArrayForConstruct[0]="new";
        while((ArrayForConstruct[0].equals("exit"))!=true)
        {
            if(succes==false)
            {
                System.out.println("La digitazione era sbagliata, ritenta");
                succes=true;
            }
            System.out.println("Che alimento desidera inserire? exit per uscire ");
            ArrayForConstruct[0]=input.nextLine();
            if(ArrayForConstruct[0].equals("exit"))
            {
                break;
            }
            System.out.println("Codice? ");
            ArrayForConstruct[1]=input.nextLine();
            System.out.println("Alimentare o nonalimentare? ");
            ArrayForConstruct[2]=input.nextLine();
            System.out.println("Costo per unita? ");
            ArrayForConstruct[3]=input.nextLine();
            if(ArrayForConstruct[2].equalsIgnoreCase("alimentare"))
            {
               System.out.println("inserire data di scadenza");
               ArrayForConstruct[4]=input.nextLine();
               adesso.setTime(Long.parseLong(ArrayForConstruct[4]));
            }////////////////////////////////////////////////////////////////FIXXXXX//////////////////////////////////////////////
            else if (ArrayForConstruct[2].equalsIgnoreCase("nonalimentare"))
            {
                System.out.println("Inserire materiale");
                ArrayForConstruct[4]=input.nextLine();

            }
            else
            {
                  System.out.println("non capisco cosa "+ArrayForConstruct[2]+ " voglia dire");
                  succes=false;
            }


            System.out.println("Descrizione: ");
            ArrayForConstruct[5]=input.nextLine();

            if(ArrayForConstruct[2].equalsIgnoreCase("alimentare")&&succes==true) 
            {
                try
                {
                    //public Alimentare(String Codice,String Descrizione, float Prezzo, Date data)
                    ListaProdotti.add(new Alimentare(ArrayForConstruct[1],ArrayForConstruct[5],Float.parseFloat(ArrayForConstruct[3]),adesso), ArrayForConstruct[0]);

                }
                catch(Exception ex)
                {
                    succes=false;
                }
            }
            else if(succes==true)
            {
                try
                {
                    //public NonAlimentare(String Codice, String Descrizione, float Prezzo, String Materiale) {
                    ListaProdotti.add(new NonAlimentare(ArrayForConstruct[1],ArrayForConstruct[5],Float.parseFloat(ArrayForConstruct[3]),ArrayForConstruct[4]), ArrayForConstruct[0]);

                }
                catch(Exception ex)
                {
                    succes=false;
                }
            }
        }
    }
    public void IniziallizzaSpesa()
    {
        boolean PossessoCarta = false;
        Scanner input = new Scanner(System.in);

        System.out.println("hai la carta? (Y/n)");
        if(input.nextLine().equalsIgnoreCase("Y")){
            PossessoCarta = true;
        } 
        else
        {
            PossessoCarta = false;
        }
        ListaSpesa = new ListaSpesa(PossessoCarta);
        String[] ArrayForConstruct = new String[120];
        boolean succes= true;
        while(true)
        {
            if(succes==false)
            {
                System.out.println("input non riuscito");
                succes=true;
            }
            System.out.println("Inserire Prootto da comprare: exit per uscire");
            ArrayForConstruct[0]=input.nextLine();
            if(ArrayForConstruct[0].equals("exit"))
            {
                break;
            }
            System.out.append("inserire quantita: ");
            ArrayForConstruct[1]=input.nextLine();
            if(ListaNomiProdotti.contains(ArrayForConstruct[0]))
            {
                try
                {
                    ListaSpesa.add(ArrayForConstruct[0],Integer.parseInt(ArrayForConstruct[1]));
                }
                catch(Exception ex)
                {
                    succes=false;
                }
            }
            else
            {
                succes=false;
               
            }
        }   
    }

    public float CostoTotale ()
    {   float totale=0;
        for(int i=0;i<ListaSpesa.Volte.size();i++)
        {
            System.out.println("dentro");
            if(ListaNomiProdotti.contains(ListaSpesa.getNome(i)))
            {
               // totale+=ListaProdotti.getObject(ListaNomiProdotti.indexOf(ListaSpesa.getNome(i)));
                System.out.println(ListaProdotti.getObject(ListaNomiProdotti.indexOf(ListaSpesa.getNome(i))));
            }
        }
        return totale;
    }
}
    

