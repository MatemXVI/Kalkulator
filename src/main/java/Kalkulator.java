import java.io.FileWriter;
import java.io.IOException;
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
                int a = Integer.parseInt(scanner.nextLine());
                System.out.print("Podaj drugą liczbę: ");
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println("Jaka operację chcesz wykonać? (+, -, *, /): ");
                String operacja = scanner.nextLine();
                String dzialanie = String.format("%d %s %d = ", a, operacja, b);
                int wynik;
                double wynikDzielenia;
                String wykonaneDzialanie;
                switch(operacja) {
                    case "+":
                        wynik = a + b;
                        wykonaneDzialanie = dzialanie + wynik;
                        wyniki.add(wykonaneDzialanie);
                        System.out.println(wykonaneDzialanie);
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
            int wybor;
            boolean czyWybranaCyfra = false;
            while(!czyWybranaCyfra){
                System.out.println("Wybierz '1' jeżeli chcesz wykonać kolejne działanie...");
                System.out.println("Wybierz '2' jeżeli chcesz sprawdzić ostatnie działania'");
                System.out.println("Wybierz '0' jeżeli chcesz wyjść z programu");
                wybor = Integer.parseInt(scanner.nextLine());
                switch (wybor) {
                    case 1:
                        czyWybranaCyfra = true;
                        break;
                    case 2:
                        System.out.println("Wykonano następujące działania: ");
                        for (String wynik : wyniki) {
                            System.out.println(wynik);
                        }
                        System.out.println("Wciśnij '9' jeśli chcesz zapisać plik lub inny klawisz aby wrócić do menu ");
                        int zapisDoPliku = Integer.parseInt(scanner.nextLine());
                        if(zapisDoPliku == 9){
                            FileWriter fw = null;
                            try {
                                fw = new FileWriter("plik.txt");
                                for (String wynik : wyniki) {
                                    fw.append(wynik);
                                }
                                fw.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            };
                        }
                        break;
                    case 0:
                        czyWyjscie = true;
                        break;
                    default:
                        System.out.println("Wybrałeś niepoprawną cyfrę!");
                }
            }
        }
    }
}