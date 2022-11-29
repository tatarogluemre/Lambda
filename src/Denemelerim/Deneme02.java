package Denemelerim;

import java.util.*;
import java.util.stream.Collectors;

public class Deneme02 {

    public static void main(String[] args) {

        Universite u1 = new Universite("Çanakkale","Bilgisayar",120,88);
        Universite u2 = new Universite("KTU","Matematik",555,77);
        Universite u6 = new Universite("KTU","Matematik",780,77);
        Universite u3 = new Universite("Boğaziçi","Fizik",990,99);
        Universite u4 = new Universite("Boğaziçi","Bilgisayar",90,99);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u1,u2,u3,u4,u6));

        if(notOrt74Buyuk(unv)){
            System.out.println("74 den büyük not ortalaması var");
        }else System.out.println("74 den büyük not ortalaması yok");

        matVarmi(unv);
        System.out.println();

        System.out.println(lst(unv));

        matBolSay(unv);

        System.out.println(print550BykNotOrt(unv));

    }

    //task 01--> Bütün Üniv.lerin notOrt'larinin 74' den buyuk old kontrol eden pr create ediniz.

    public static boolean notOrt74Buyuk(List<Universite> unv){

        return  unv.stream().allMatch(t-> t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static void matVarmi(List<Universite> unv){

        System.out.println(unv.stream().anyMatch(t -> t.getBlm().toLowerCase().contains("bilg")));

        unv.
                stream().
                filter(t-> t.getBlm().toLowerCase().contains("bilg")).
                forEach(t-> System.out.print(t.getUnv()+" -> "+t.getBlm()+", "));


    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> lst(List<Universite> unv){

       return unv.stream().sorted(Comparator.comparing(Universite::getOgrSay).reversed()).collect(Collectors.toList());



    }

    // task 04 --> universitelerin matematik bölüm saysısı

    public static void matBolSay(List<Universite> unv){

        System.out.println(unv.stream().filter(t -> t.getBlm().toLowerCase().contains("mat")).count());
    }
//task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalInt print550BykNotOrt(List<Universite> unv){

        return unv.stream().filter(t-> t.getOgrSay()>550).mapToInt(t-> t.getNotOrt()).max();

    }
}
