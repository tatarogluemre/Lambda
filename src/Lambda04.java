import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        Universite u01 = new Universite("Boğaziçi","Matematik",577,93.00);
        Universite u02 = new Universite("Çanakkale","Bilgisayar",54,99.00);
        Universite u03 = new Universite("Ktu","Hukuk",77,70.00);
        Universite u04 = new Universite("İstanbul","Tıp",345,66.00);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04));


        System.out.println(notOrt74BykUnv(unv));
        System.out.println(matBolumVarmi(unv));
        if(matBolumVarmi(unv)){
            System.out.println("Matematik bölüm var");
        }else System.out.println("Mat bölüm yok");

        System.out.println(ogrSayisiBykSirala(unv));
    }

//task 01--> Bütün Üniv.lerin notOrt'larinin 74' den buyuk old kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv){

        return unv.stream().allMatch(t-> t.getNotOrtalamasi()>74.00);

    }

//task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarmi(List<Universite> unv){

        return unv.stream().anyMatch(t-> t.getBolum().equalsIgnoreCase("matematik"));

    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                // universiteler öğrenci sayısına göre tersden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }
}



