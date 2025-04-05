import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator  {
    public static void wykonajDzialanie(String dzialanie, int wynik, ArrayList wyniki){
        String wykonaneDzialanie = dzialanie + wynik;
        wyniki.add(wykonaneDzialanie);
        System.out.println(wykonaneDzialanie);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wyniki = new ArrayList<>();
        boolean czyWyjscie = false;
        while(!czyWyjscie){
            try{
                System.out.print("Podaj pierwszą liczbę: ");
                int a = scanner.nextInt();
                System.out.print("Podaj drugą liczbę: ");
                int b = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Jaka operację chcesz wykonać? (+, -, *, /): ");
                String operacja = scanner.nextLine();
                String dzialanie = String.format("%d %s %d = ", a, operacja, b);
                int wynik;
                double wynikDzielenia;
                String wykonaneDzialanie;
                switch(operacja) {
                    case "+":
                        wynik = a + b;
                        wykonajDzialanie(dzialanie, wynik, wyniki);
                        break;
                    case "-":
                        wynik = a - b;
                        wykonaneDzialanie = dzialanie + wynik;
                        wyniki.add(wykonaneDzialanie);
                        System.out.println(wykonaneDzialanie);
                        break;
                    case "*":
                        wynik = a * b;
                        wykonaneDzialanie = dzialanie + wynik;
                        wyniki.add(wykonaneDzialanie);
                        System.out.println(wykonaneDzialanie);
                        break;
                    case "/":
                        if (b != 0) {
                            wynikDzielenia = (double) a / b;
                            wykonaneDzialanie = dzialanie + wynikDzielenia;
                            wyniki.add(wykonaneDzialanie);
                            System.out.println(wykonaneDzialanie);
                        } else {
                            System.out.println("Nie wolno dzielić przez 0!");
                        }
                        break;
                    default:
                        System.out.println("Nieznany znak");
                }
            }catch(InputMismatchException e){
                System.out.println("Podałeś niepoprawną liczbę!");
            }
            int wybor = scanner.nextInt();
            boolean czyWybranaCyfra = false;
            while(!czyWybranaCyfra){
                System.out.println("Wybierz '1' jeżeli chcesz sprawdzić ostatnie działania'");
                System.out.println("Wybierz '2' jeżeli chcesz wyjść z programu");
                System.out.println("Wybierz '0' jeżeli chcesz wykonać kolejne działanie...");
                switch (wybor) {
                    case 0:
                        czyWybranaCyfra = true;
                    case 1:

                    case 2:
                        czyWyjscie = true;
                    default:
                }
            }
        }
    }
}