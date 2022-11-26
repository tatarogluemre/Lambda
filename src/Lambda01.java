import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    /*
          1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
              Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
          2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
              "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
          3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
              ve hatasiz code yazma acilarindan cok faydalidir.
          4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

    */
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        System.out.println("\n Structured Programing kullanarak oluşturduk");
        printElStructured(sayi);

        System.out.println("\n Functional Programing kullanarak oluşturduk");
        printElFunctional(sayi);

        System.out.println("\n Lambda Expression kullanarak oluşturduk");
        printElFunctional1(sayi); // bu methodda istediğimiz şekilde task vermedi bunun printElFunctional2 methodunu oluşturduk.

        System.out.println("\n Method Referance kullanarak oluşturduk");
        printElFunctional2(sayi);// bu methodda istenilen şekilde task vermesi için ek method yazdık.

        System.out.println("\n lambda ile çift elemanları yazdırdık");
        printCiftElFunctional(sayi);

        System.out.println("\n lambda method referance ile çift elemanları yazdırdık");
        printCiftElFunctional2(sayi);

        System.out.println("\n Structured ile çift elemanları yazdırdık");
        printCiftElStructured(sayi);

        System.out.println();
        printCift34KucukFunctional(sayi);

        System.out.println();
        printCiftOr34BuyukFunctional(sayi);


    }
    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
// aralarında bosluk olacak sekilde print ediniz.

    public static void printElStructured(List<Integer> sayi) {

        for (Integer w : sayi) {

            System.out.print(w + " ");
        }

    }
//TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde
//         print ediniz.

    public static void printElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                forEach((t) -> System.out.print(t + " "));//lambda expression ile lambda ya ne yapılacağını söylüyoruz.
    }

    public static void printElFunctional1(List<Integer> sayi) {

        sayi.
                stream().
                forEach(System.out::print); //method referance (for each loop her elemanı alıp print eder)
        //kod okunurluğu açısından method referance tercih edilmelidir
        // Bu yöntemde nasıl yapılacağı değil ne yapılacağı söylenir .
    }

    //--> kendimiz bir method oluşturalım

    public static void print(int a) {

        System.out.print(a + " ");

    }

    public static void printElFunctional2(List<Integer> sayi) {

        sayi.
                stream().                  // istenilen task vermesi stream() de olmadığından  ek method oluşturduk.
                forEach(Lambda01::print); // stream() metodu içinde bir method çağıracaksak
        //    önce methodun geçtiği class yazılır sonra method  çağırılır.
    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0). //Lambda expression
                forEach(Lambda01::print);

    }

    //Yukardaki functional yapıdaki filter methodunun içini method referance ile yapalım

    public static void printCiftElFunctional2(List<Integer> sayi) {

        sayi.
                stream().filter(Lambda01::cift).forEach(Lambda01::print);

    }
    public static boolean cift(int a){

        return a % 2==0;
    }


    // "Structured Programming" kullanaraklist elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructured(List<Integer> sayi) {

        for (Integer w : sayi) {

            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }

    }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCift34KucukFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0 && t < 34).
                forEach(Lambda01::print);

        //2.Yol :
        //sayi.stream().filter(t->t%2==0).filter(t-> t<34).forEach(Lambda01::print);

    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOr34BuyukFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0 || t > 34).
                forEach(Lambda01::print);     //forEach((t)-> System.out.println(t + " "));


    }
}
