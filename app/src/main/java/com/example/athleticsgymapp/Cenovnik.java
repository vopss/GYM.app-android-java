package com.example.athleticsgymapp;

public class Cenovnik {
    private String vrstaPaketaCenovnika;
    private String cena;
    private String url;
    private boolean isEsxpanded;

    public Cenovnik(String vrstaPaketaCenovnika, String cena, String url, boolean isEsxpanded) {
        this.vrstaPaketaCenovnika = vrstaPaketaCenovnika;
        this.cena = cena;
        this.url = url;
        this.isEsxpanded = isEsxpanded;
    }

    public String getVrstaPaketaCenovnika() {
        return vrstaPaketaCenovnika;
    }

    public void setVrstaPaketaCenovnika(String vrstaPaketaCenovnika) {
        this.vrstaPaketaCenovnika = vrstaPaketaCenovnika;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEsxpanded() {
        return isEsxpanded;
    }

    public void setEsxpanded(boolean esxpanded) {
        isEsxpanded = esxpanded;
    }
}
