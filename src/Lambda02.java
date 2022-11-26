import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayilar = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        System.out.println("\n Çift sayıların Karesi");
        ciftKarePrint(sayilar);

        System.out.println("\n Tek sayıların küpünün bi fazlası");
        printTekKupBirFazla(sayilar);

        System.out.println("\n Çift elemanların kare kökü");
        ciftElemanKarekokPrint(sayilar);

        System.out.println("\n En büyük eleman");
        printEnbuyukEleman(sayilar);

        System.out.println("\n Enbüyük Eleman Structured Yöntem");
        printEnbuyukElemanStructured(sayilar);

        System.out.println("\n Tüm elemanların Toplamı");
        printTumElemanlarToplam(sayilar);

        System.out.println(" Çift Elemanları Çarp");
        printCiftElemanlarCarp(sayilar);

        System.out.println(" En Küçük Eleman");
        printEnKucukEleman(sayilar);

        System.out.println(" Beşten Büyük En Küçük Tek Eleman");
        printBestenBuyukEnKucukTekSayi(sayilar);

        System.out.println(" \n Cift Elemanlarin Karelerini Kucukten Buyuge Sirala");
        printCiftElemanlarinKareleriniKucuktenBuyugeSirala(sayilar);

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::cift). // akışdaki çift sayıları filtreledik , 4,2,6
                map((t) -> t * t). // stream içindeki elemanlar filter ile değiştiği için map() kullanarak bu elemanlar ile işleme devam ettik.
                forEach(Lambda01::print);
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda
    //        aralarina bosluk birakarak print ediniz


    public static void printTekKupBirFazla(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 != 0).
                map(t -> (t * t * t) + 1).
                forEach(Lambda01::print);

    }
    // Task-3 : Functional Programming ile listin cift elemanlarinin
    //          karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void ciftElemanKarekokPrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::cift).
                map(Math::sqrt).//double return eder Lambda01 deki yazdır metodu int return ettiği için kullanamadık
                forEach(t -> System.out.print(t + " - "));

    }

    // Task- 4: List in en büyük elemanını yazdırınız
    public static void printEnbuyukEleman(List<Integer> sayi) {

        Optional<Integer> maxSayi = sayi.//nullpointer exception atmaması için int değeri veremedik Optional kullandık
                stream().
                reduce(Math::max);//Eğer tek bir değer result edeceksek reduce() terminal operatorünü kullanıyoruz.
        System.out.print(maxSayi);
    }
    //Structured yöntem
    public static void printEnbuyukElemanStructured(List<Integer> sayi) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < sayi.size(); i++) {

            if (sayi.get(i) > max) {

                max = sayi.get(i);
            }

        }
        System.out.print("Enbüyük sayı = " + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftSayiEnBuyuk(List<Integer> sayi){

        System.out.print(sayi.
                stream().
                filter(Lambda01::cift).
                map(t -> t * t).
                reduce(Integer::max));// Math::max'a göre daha hızlı çalışır..

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void printTumElemanlarToplam(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                reduce(0, (a, b) -> a + b));
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void printCiftElemanlarCarp(List<Integer> sayi){

        System.out.println(
                sayi.stream().
                        filter(Lambda01::cift).
                        reduce(1, (a, b) -> (a * b))); //lambda expression

        //2.Yol
        System.out.println(sayi.
                                stream().
                                filter(Lambda01::cift).
                                reduce(Math::multiplyExact));// method referance



    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

    public static  void printEnKucukEleman(List<Integer> sayi){

        System.out.println(sayi.
                            stream().
                            reduce(Integer::min));

        //2.Yol

        System.out.println(sayi.
                            stream().
                            reduce(Lambda02::enKucuk));

    }
    public static int enKucuk(int a, int b){

        return a<b ? a : b ;

}

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void printBestenBuyukEnKucukTekSayi(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(t -> (t > 5) && (t % 2 != 0)).
                reduce(Lambda02::enKucuk));


    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void  printCiftElemanlarinKareleriniKucuktenBuyugeSirala(List<Integer> sayi){

        sayi.
                stream().                        //akışı başlattık
                filter(Lambda01::cift).         //akıştaki çift sayıları aldık
                map(t->t*t).                   // akıştaki çift sayıların karelerini aldık
                sorted().                     // akıştaki çift sayıların karelerini sıralama yaptık.
                forEach(Lambda01::print);    // akıştaki sayıları yazdırdık

    }

}
