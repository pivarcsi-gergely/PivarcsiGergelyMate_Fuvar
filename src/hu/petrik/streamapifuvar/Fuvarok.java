package hu.petrik.streamapifuvar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fuvarok {
    private List<Fuvar> fuvarList;

    public Fuvarok(String fileName) {
        fuvarList = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            br.readLine();
            String line = br.readLine();
            while (line != null) {
                fuvarList.add(new Fuvar(line));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public Fuvarok(List<Fuvar> fuvarList) {
        this.fuvarList = fuvarList;
    }

    public long sumFuvar() {
        return fuvarList.stream().count();
    }

    public Stream<Fuvar> getFuvarById(int id) {
        return fuvarList.stream().filter(fuvar -> fuvar.getTaxi_id() == id);
    }

    public double getFuvarBevetel(int id) {
        return getFuvarById(id).mapToDouble(Fuvar::getBevetel).sum();
    }

    public long getFuvarCount(int id) {
        return getFuvarById(id).count();
    }

    public double getFuvarMegtettTavolsagSumMerfold() {
        return fuvarList.stream().mapToDouble(Fuvar::getTavolsag).sum();
    }

    public Fuvar getLeghosszabbFuvar() {
        return fuvarList.stream().max(Comparator.comparingInt(Fuvar::getIdotartam)).get();
    }

    public Fuvar getLegBokezubbFuvar() {
        return fuvarList.stream().max(Comparator.comparingDouble(Fuvar::getBokezuseg)).get();
    }

    public double getFuvarTavolsagKm(int id) {
        return getFuvarById(id).mapToDouble(Fuvar::getTavolsagKm).sum();
    }

    public Stream<Fuvar> getHibasFuvarok() {
        return fuvarList.stream().filter(fuvar -> fuvar.getIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getTavolsag() == 0.0);
    }

    public int getHibasFuvarokOsszesen() {
        return getHibasFuvarok().toList().size();
    }

    public int getHibasFuvarokIdotartam() {
        return getHibasFuvarok().mapToInt(Fuvar::getIdotartam).sum();
    }

    public double getHibasFuvarokBevetel() {
        return getHibasFuvarok().mapToDouble(Fuvar::getBevetel).sum();
    }

    public boolean hasId(int id) {
        return fuvarList.stream().anyMatch(fuvar -> fuvar.getTaxi_id() == id);
    }

    public Fuvarok getSortedNonZeroDistancedRides() {
        return new Fuvarok(
                fuvarList.stream().filter(fuvar -> fuvar.getIdotartam() != 0)
                        .sorted(Comparator.comparingInt(Fuvar::getIdotartam)).limit(3).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        String fuvarLine = "";
        for (Fuvar fuvar: fuvarList) {
            fuvarLine += fuvar + "\n";
        }
        return fuvarLine;
    }
}
