package com.example.athleticsgymapp;

public class Trening {

    private String imeTreninga;
    private String kratkiOpis;
    private String sveVezbe;
    private String urlSlike;
    private boolean prosireno;

    public Trening(String imeTreninga, String kratkiOpis, String sveVezbe, String urlSlike) {
        this.imeTreninga = imeTreninga;
        this.kratkiOpis = kratkiOpis;
        this.sveVezbe = sveVezbe;
        this.urlSlike = urlSlike;
        prosireno=false;
    }


    public String getImeTreninga() {
        return imeTreninga;
    }

    public void setImeTreninga(String imeTreninga) {
        this.imeTreninga = imeTreninga;
    }

    public String getKratkiOpis() {
        return kratkiOpis;
    }

    public void setKratkiOpis(String kratkiOpis) {
        this.kratkiOpis = kratkiOpis;
    }

    public String getSveVezbe() {
        return sveVezbe;
    }

    public void setSveVezbe(String sveVezbe) {
        this.sveVezbe = sveVezbe;
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
    }

    public boolean isProsireno() {
        return prosireno;
    }

    public void setProsireno(boolean prosireno) {
        this.prosireno = prosireno;
    }
}
