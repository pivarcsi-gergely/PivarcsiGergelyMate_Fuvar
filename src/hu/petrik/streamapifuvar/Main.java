package hu.petrik.streamapifuvar;

public class Main {

    public static void main(String[] args) {
        Fuvarok fuvarokObject = new Fuvarok("fuvar.csv");
        System.out.println(fuvarokObject + "\n");
        System.out.println("Összes fuvar az állományban: " + fuvarokObject.sumFuvar());
        System.out.println();
        System.out.printf("A 6185-ös azonosítójú taxis bevétele: %2f. %d db fuvarból jött össze ez neki.%n",
                fuvarokObject.getFuvarBevetel(6185), fuvarokObject.getFuvarCount(6185));
        System.out.println();
        System.out.printf("Összesen %.2f mérföldöt tettek meg a taxisok.",
                fuvarokObject.getFuvarMegtettTavolsagSumMerfold());
        System.out.println("\n");
        System.out.printf("A leghosszabb fuvart levezetett sofőr adatai:\n%s", fuvarokObject.getLeghosszabbFuvar());
        System.out.println("\n");
        System.out.printf("A legbőkezűbb fuvar adatai: \n%s\n", fuvarokObject.getLegBokezubbFuvar());
        System.out.println("\n");
        System.out.printf("A 4261-es azonosítójú taxis %.2f kilométert tett meg.", fuvarokObject.getFuvarTavolsagKm(4261));
        System.out.println("\n");
        System.out.printf("Összesen %d db hibás fuvar van az állományban, %d másodpercnyi idő és %.2f$ bevételt 'hoztak a konyhára'.",
                          fuvarokObject.getHibasFuvarokOsszesen(), fuvarokObject.getHibasFuvarokIdotartam(), fuvarokObject.getHibasFuvarokBevetel());
        System.out.println("\n");
        System.out.println(fuvarokObject.hasId(1452) ? "Szerepel\n" : "Nem szerepel\n");
        System.out.printf("A 3 legrövidebb utazás adatai:\n%s", fuvarokObject.getSortedNonZeroDistancedRides());

    }
}
