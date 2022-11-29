package Denemelerim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Deneme02 {

    public static void main(String[] args) {

        Universite u1 = new Universite("Çanakkale","Bilgisayar",120,88);
        Universite u2 = new Universite("KTU","Matematik",100,77);
        Universite u3 = new Universite("Boğaziçi","Fizik",90,99);
        Universite u4 = new Universite("Boğaziçi","Bilgisayar",90,99);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u1,u2,u3,u4));

        if(notOrt74Buyuk(unv)){
            System.out.println("74 den büyük not ortalaması var");
        }else System.out.println("74 den büyük not ortalaması yok");

        matVarmi(unv);
        System.out.println();

        System.out.println(lst(unv));

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

}
