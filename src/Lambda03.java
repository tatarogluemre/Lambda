import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    // ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.



    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havuç dilim","künefe","güveç","kokoreç","arabaşı","waffle"));

        buyukTekrarsizSirala(menu);
        System.out.println();

        krkSayTekrarsizTersSirala(menu);
        System.out.println();

        krkSayKckBykSirala(menu);
        System.out.println();

        harfSayisi7denAzKntrl(menu);
        System.out.println();

        wİleBasalayaEl(menu);

        xIleBitenEl(menu);

        krSysEnbuyukEl(menu);

        ilkElHrcSonHrfSirliPrint(menu);


    }


    // Task -1 : List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz.

    public static void buyukTekrarsizSirala(List<String> str){


        str.stream().map(String::toUpperCase).sorted().distinct().forEach(t-> System.out.print(t + " "));


    }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void krkSayTekrarsizTersSirala(List<String> str){

        str.stream().map(t-> t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::print);


    }
    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..

    public static void krkSayKckBykSirala(List<String> str){

        str.stream().sorted(Comparator.comparing(String::length)).forEach(Lambda01::print);
    }

    // Task-4 : List elelmmalarinin tümünün karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKntrl(List<String> str){

        String s = str.stream().allMatch(t -> t.length() <= 7) ? "List elemanları 7 ve daha az elmandan oluşuyor" : "List elemanları 7 harfden büyük";
        System.out.println(s);

        boolean b = str.stream().allMatch(t -> t.length() <= 7);

        if(!b){

            str.stream().forEach(Lambda01::print);
        }

    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wİleBasalayaEl(List<String> str){

        System.out.println(str.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek var" : "w ile başlayan yemek yok");

    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenEl(List<String> str){

        System.out.println(str.stream().noneMatch(t -> t.endsWith("x")) ? "x ile biten yemek yok" : "x ile biten yemek var");
    }


    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void krSysEnbuyukEl(List<String> str){

       Stream<String> el = str.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                limit(1); // limit() metodu ile sadece ilk eleman alındı
        System.out.println(Arrays.toString(el.toArray()));

    }
// Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHrcSonHrfSirliPrint(List<String> str){

        str.
                stream().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).
                skip(1). //akıştaki ilk eleman hariç tutuldu skip() ile atladı
                forEach(Lambda01::print);

    }


}
