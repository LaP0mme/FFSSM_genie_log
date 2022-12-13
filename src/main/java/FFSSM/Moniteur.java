/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.lang.StackWalker.Option;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    public ArrayList<Embauche> poste;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, GroupeSanguin gs, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, gs);
        this.numeroDiplome = numeroDiplome;
        this.poste = new ArrayList<Embauche>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        if(poste.isEmpty()) Optional.ofNullable(null);
        poste.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
        return Optional.ofNullable(poste.get(poste.size() - 1).getEmployeur());
        }
    
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche emb = new Embauche(debutNouvelle, this, employeur);
        this.poste.add(emb);	    
    }

    public List<Embauche> emplois() {
        return this.poste;
    }

    public void terminerEmbauche(LocalDate fin){
        poste.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
        this.poste.get(poste.size() - 1).terminer(fin);
    }

}
