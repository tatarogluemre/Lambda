package Denemelerim;

import Lambda_Practice.Lambda01;

import java.util.stream.IntStream;

public class Deneme03 {

    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println(ciftlerTopla(8));
        System.out.println(ilkXPozCiftSayTop(4));
        System.out.println(ilkXTekSayTop(3));
        print2Kuvvetleri(4);
        System.out.println();
        usYaz(2,3);
        System.out.println();
        faktoriyel(5);


    }

    //Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    public static int topla(int x){

        return IntStream.rangeClosed(1,x).sum();

    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int ciftlerTopla(int x){

        return IntStream.rangeClosed(1,x).filter(t-> t%2==0).sum();


    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkXPozCiftSayTop(int x){

        return IntStream.iterate(2,t->t+2).limit(x).sum();

    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int ilkXTekSayTop(int x){

        return IntStream.iterate(1,t->t+2).limit(x).sum();

    }
//TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi create ediniz.

    public static void print2Kuvvetleri(int x){

        IntStream.iterate(2,t-> t*2).limit(x).forEach(t-> System.out.print(t+" "));

    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void usYaz(int sayi , int us){

        IntStream.iterate(sayi,t-> t*sayi).limit(us).forEach(t-> System.out.print(t + " "));

    }

//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi create ediniz.

    public static void faktoriyel(int x){

        System.out.println(IntStream.rangeClosed(1, x).reduce(1, (a, b) -> a * b));

    }


}
