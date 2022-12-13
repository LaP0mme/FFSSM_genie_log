package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Plongeur extends Personne {
    public int niveau;

    public String numeroINSEE;

    public String nom;

    public String prenom;

    public String adresse;

    public String telephone;

    public LocalDate naissance;

    public GroupeSanguin gs;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin gs){
       super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
       this.niveau = niveau;
       this.gs = gs;
    }

    public void ajouterLicence(String numero, LocalDate delivrance ){

    } 
}
