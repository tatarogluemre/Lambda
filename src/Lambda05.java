import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        System.out.println(topla(10));
        System.out.println(toplaFunc(10));
        System.out.println(toplaCift(10));
        System.out.println(toplaCift(6));
        System.out.println(ilkXTekTopla(6));
        print2Kuvveti(4);
        System.out.println();
        usYaz(2,4);
        System.out.println();
        System.out.println(faktoriyel(5));
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan
    //            bir program create ediniz.

    //Structured

    public static int topla(int x){

        int topla = 0;

        for(int i = 0 ; i<=x ; i++){

            topla += i;

        }

        return topla;
    }

//functional

    public static int toplaFunc(int x){

        return IntStream. //Lambda da List olmayan primitiv int data ların akışını sağlamak için IntStream kullanılır
                range(1,x+1). //range(a,b) metodu  a dan b ye kadar(b dahil değil) olan değer leri akışa alır.
                sum(); //akıştaki elemanları toplar.



    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x){

        return
                IntStream.
                rangeClosed(1,x).//rangeClosed methodu(a,b) adan b dahil olmak üzere akışa alır.
                filter(Lambda01::cift).
                sum();

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkXCiftTopla(int x){

        return IntStream.
                iterate(2,t-> t+2).//2 den sonsuza kadar elemanları 2 artırarak akışa alır.> 2,4,6,8,....
                limit(x).//sonsuza kadar gitmemesi için x e kadar sınırlıyoruz
                sum();

    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int ilkXTekTopla(int x){

        return IntStream.iterate(1,t-> t+2).limit(x).sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi create ediniz.

    public static void print2Kuvveti(int x){

        IntStream.iterate(2,t->t*2).limit(x).forEach(t-> System.out.print(t+" "));

    }
//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void usYaz(int sayi ,int us){

        IntStream.iterate(sayi,t-> t*sayi).limit(us).forEach(Lambda01::print);

    }
//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi create ediniz.

    public static int faktoriyel(int x ){

       return IntStream.rangeClosed(1,x).reduce(1,(a,b)-> a*b);


    }
}
