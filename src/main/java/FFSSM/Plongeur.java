package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.*;

public class Plongeur extends Personne {
    public int niveau;

    public GroupeSanguin gs;
    public ArrayList<Licence> listeLicence;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin gs){
       super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
       this.niveau = niveau;
       this.gs = gs;
       this.listeLicence = new ArrayList<Licence>();
    }

    public void ajouterLicence(String numero, LocalDate delivrance, Club club ){
        this.listeLicence.add(new Licence(this,numero,delivrance,club));
    } 

    public ArrayList<Licence> getListeL(){
        return this.listeLicence;
    }

    

}
