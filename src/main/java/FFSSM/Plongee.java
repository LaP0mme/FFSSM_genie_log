/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;

	public ArrayList<Plongeur> listeP;

	public Club organisateur;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree, Club organisateur) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
		this.organisateur = organisateur;
		this.listeP = new ArrayList<Plongeur>();
	}

	public void setOrganisateur(Club C){
		this.organisateur.listePlongee.remove(this);
		this.organisateur = C;
		this.organisateur.listePlongee.add(this);
	}

	public void ajouteParticipant(Plongeur participant) {
		this.listeP.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		boolean flag = true;
		for(int i = 0; i < listeP.size() -1; i++){
			for(int t = 0; t < listeP.get(i).listeLicence.size()-1; t++){
			if(!(listeP.get(i).listeLicence.get(i).estValide(date)) || !(listeP.get(i).listeLicence.get(i).club == this.organisateur)){
				flag = false;
			}

			}
		}
		return flag;
	}

}
