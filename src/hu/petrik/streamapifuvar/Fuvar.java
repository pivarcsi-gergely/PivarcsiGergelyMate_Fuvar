package hu.petrik.streamapifuvar;

import java.sql.Timestamp;

public class Fuvar {
    private int taxi_id;
    private Timestamp indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetes_modja;

    public Fuvar(String s) {
        String[] singleLine = s.split(";");
        this.taxi_id = Integer.parseInt(singleLine[0]);
        this.indulas = Timestamp.valueOf(singleLine[1]);
        this.idotartam = Integer.parseInt(singleLine[2]);
        this.tavolsag = Double.parseDouble(singleLine[3].replace(',', '.'));
        this.viteldij = Double.parseDouble(singleLine[4].replace(',', '.'));
        this.borravalo = Double.parseDouble(singleLine[5].replace(',', '.'));
        this.fizetes_modja = singleLine[6];
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }

    public Timestamp getIndulas() {
        return indulas;
    }

    public void setIndulas(Timestamp indulas) {
        this.indulas = indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public void setViteldij(double viteldij) {
        this.viteldij = viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public void setFizetes_modja(String fizetes_modja) {
        this.fizetes_modja = fizetes_modja;
    }

    public double getBevetel() {
        return this.viteldij + this.borravalo;
    }

    public double getBokezuseg() {
        return this.borravalo/this.getBevetel();
    }

    public double getTavolsagKm() {
        return this.tavolsag * 1.6;
    }

    @Override
    public String toString() {
        return String.format("%-15d %-10s %10d mp %10.1f mérfőld %10.2f$ (%.2f$ borravaló) %18s",
                taxi_id, indulas, idotartam, tavolsag, viteldij, borravalo, fizetes_modja);
    }
}
