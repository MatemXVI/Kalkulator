import java.util.Scanner;

public class Kalkulator  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isActive = false;
        while(!isActive){
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
            switch(operacja) {
                case "+":
                    wynik = a + b;
                    System.out.println(dzialanie + wynik);
                    break;
                case "-":
                    wynik = a - b;
                    System.out.println(dzialanie + wynik);
                    break;
                case "*":
                    wynik = a * b;
                    System.out.println(dzialanie + wynik);
                    break;
                case "/":
                    if (b != 0) {
                        wynikDzielenia = (double) a / b;
                        System.out.println(dzialanie + wynikDzielenia);
                    } else {
                        System.out.println("Nie wolno dzielić przez 0!");
                    }
                    break;
                default:
                    System.out.println("Nieznany znak");
            }
            System.out.println("Wciśnij 'T' jeżeli chcesz wyjść z programu");
            System.out.println("Wciśnij dowolny klawisz jeżeli chcesz zostać ");
            String wyjscie = scanner.nextLine();
            if(wyjscie.equals("T") || wyjscie.equals("t"))
                isActive = true;
        }

    }
}