/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.locationvideos.controller;

/**
 *
 * @author stagjava
 */
public class EpisodeSerie extends Support{
    // Attributes
    private String titreEpisode;
    int noEpisode;

    public EpisodeSerie() {
    }

    @Override
    public String toString() {
        String base = super.toString();
        return  base + " EpisodeSerie{" + "titreEpisode=" + titreEpisode + ", noEpisode=" + noEpisode + '}';
    }

    public EpisodeSerie(String titreEpisode, int noEpisode, String code, String titre, String nomRealisateur, String prenomRealisateur, int anneeSortie, int nbExemplaires) {
        super(code, titre, nomRealisateur, prenomRealisateur, anneeSortie, nbExemplaires);
        this.titreEpisode = titreEpisode;
        this.noEpisode = noEpisode;
    }

    public String getTitreEpisode() {
        return titreEpisode;
    }

    public void setTitreEpisode(String titreEpisode) {
        this.titreEpisode = titreEpisode;
    }

    public int getNoEpisode() {
        return noEpisode;
    }

    public void setNoEpisode(int noEpisode) {
        this.noEpisode = noEpisode;
    }
    
}
