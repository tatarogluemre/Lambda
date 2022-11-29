package Denemelerim;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda_Deneme {

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(12, -4, 22, 54, 90, 43, -21, -10, 5, 12, 34, 16,54,90,93,58,58));

        elSiralaKucukBuyuk(lst);
        System.out.println();

        elSiralaBuyukKucuk(lst);
        System.out.println();

        tekrarsiz50denBuyukElKare(lst);


        System.out.println(yeniList(lst));
        System.out.println();

        elTop(lst);
    }


    public static void elSiralaKucukBuyuk(List<Integer> sayi) {

        sayi.stream().sorted().forEach(t -> System.out.print(t + " "));


    }

    public static void elSiralaBuyukKucuk(List<Integer> sayi) {

        sayi.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));


    }

    public static void tekrarsiz50denBuyukElKare(List<Integer> sayi){
        sayi.stream().filter(t-> t>50).map(t-> t*t).distinct().forEach(t-> System.out.print(t+" "));
    }

    //list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> yeniList(List<Integer> sayi){

        List<Integer> yeni=  sayi.stream().filter(t-> t>0).map(t-> t*t).filter(t->t%10!=5).collect(Collectors.toList());
        return yeni;

    }
  //list elemanlarini toplamini bulalim

    public static void elTop(List<Integer> sayi){

        System.out.println(sayi.stream().reduce(Integer::sum));

    }

}
