package Denemelerim;

import Lambda_Practice.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Deneme01 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havuç dilim","künefe","güveç","kokoreç","arabaşı","waffle"));
        alfSirala(menu);
        System.out.println();

        krkSayTrsSrl(menu);
        System.out.println();
        krdSaySrlElKcktoByk(menu);
        System.out.println();
        System.out.println(krksay7Byk(menu));
        System.out.println(wBasla(menu));
        xileBiten(menu);
        krSayEnBykEl(menu);

        listElSrlSonhrfIlkHrcPrt(menu);



    }

public static void alfSirala(List<String> str){

        str.stream().sorted().forEach(t-> System.out.print(t + " "));

}
    public static void krkSayTrsSrl(List<String> str){

        str.stream().sorted(Comparator.comparing(t-> t.length())).forEach(t-> System.out.print(t.length() + " "));
    }
    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..

    public static void krdSaySrlElKcktoByk(List<String> str){

        str.stream().sorted(Comparator.comparing(String::length)).forEach(t-> System.out.print(t + " "));

    }

    // Task-4 : List elelmmalarinin tümünün karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static String krksay7Byk(List<String> str){

       String s = str.stream().allMatch(t-> t.length()<=7) ?  "Karakter sayısı 7 den küçük eleman var" :  "Karakter sayısı 7 den küçük eleman yok";

         return s;
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static boolean wBasla(List<String> str){

        return str.stream().noneMatch(t-> t.startsWith("w"));

    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xileBiten(List<String> str){

        System.out.println(str.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten var" : "x ile biten yok");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void krSayEnBykEl(List<String> str){

        str.stream().sorted(Comparator.comparing(String::length).reversed()).limit(1).forEach(t-> System.out.println(t));
    }
// Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void listElSrlSonhrfIlkHrcPrt(List<String> str){
        str.stream().sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).skip(1).forEach(t-> System.out.print(t+ " "));

    }

}
