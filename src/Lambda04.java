import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.

     */
    public static void main(String[] args) {

        Universite u01 = new Universite("Boğaziçi", "Matematik", 577, 93.00);
        Universite u05 = new Universite("Atatürk", "Matematik", 233, 33.00);
        Universite u02 = new Universite("Çanakkale", "Bilgisayar", 54, 99.00);
        Universite u03 = new Universite("Ktu", "Hukuk", 770, 70.00);
        Universite u04 = new Universite("İstanbul", "Tıp", 650, 66.00);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04,u05));


        System.out.println(notOrt74BykUnv(unv));
        System.out.println(matBolumVarmi(unv));
        if (matBolumVarmi(unv)) {
            System.out.println("Matematik bölüm var");
        } else System.out.println("Mat bölüm yok");

        System.out.println(ogrSayisiBykSirala(unv));

        System.out.println(matBolSay(unv));

        unvOgrSAy550FzlNotOrt(unv);

        System.out.println(unvOgrSAy550FzlNotOrtalamasi(unv));

        System.out.println(ogrsay1050azEnkckNotOrt(unv));

    }

    //task 01--> Bütün Üniv.lerin notOrt'larinin 74' den buyuk old kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.stream().allMatch(t -> t.getNotOrtalamasi() > 74.00);

    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarmi(List<Universite> unv) {

        return unv.stream().anyMatch(t -> t.getBolum().equalsIgnoreCase("matematik"));

    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                // universiteler öğrenci sayısına göre tersden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }

// task 04 --> universitelerin matematik bölüm saysısı
    public static int matBolSay(List<Universite> unv){

        return (int) unv.stream().filter(t -> t.getBolum().toLowerCase().contains("mat")).count();


    }
//task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static void unvOgrSAy550FzlNotOrt(List<Universite> unv){

       unv.
               stream().
               filter(t -> t.getOgrSayisi() > 550).
               sorted(Comparator.comparing(Universite::getNotOrtalamasi).reversed()).
               limit(1).
               forEach(t-> System.out.println(t));


    }

    public static OptionalDouble unvOgrSAy550FzlNotOrtalamasi(List<Universite> unv){

       return unv.
               stream().
               filter(t-> t.getOgrSayisi()>550).
               mapToDouble(t->t.getNotOrtalamasi()).//max methodunu kullanmak için maptoInt() veya mapToDouble data type göre kullandık
               max();// nullPointerException atmaması için max() return type OptionalInt veya OptıonalDouble dır data type göre


    }

    public static OptionalDouble ogrsay1050azEnkckNotOrt(List<Universite> unv){


       return unv.stream().filter(t-> t.getOgrSayisi()<1050).mapToDouble(t-> t.getNotOrtalamasi()).min();

    }

}



