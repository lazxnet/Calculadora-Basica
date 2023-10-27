package org.example;
import java.util.Scanner;
public class TestCalculadora{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do{

            String numero1;
            do {
                System.out.println("\n Por favor, dame el primer número de la operación. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {
                System.out.println("\n ¿Que operación desea hacer? (Solo coloque un signo)");
                System.out.println("Teniendo en cuenta que: \n + = sumar \n - = restar \n"
                        + " x = multiplicar \n / = dividir \n * = elevar primer número al segundo numero."
                        + "\n % = residuo");
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x") ||
                        operacion.equals("X") || operacion.equals("/") || operacion.equals("%") ||
                        operacion.equals("*")) {
                    comprobar = true;
                }else { comprobar = false; }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.println("\n Por favor, dame el segundo número.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

            do{
                comprobar = true;
                switch(operacion){
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":

                        while(n2 == 0){
                            do {
                                System.err.println(" En el denominador se encuentra \n"
                                        + "un cero, para evitar errores coloca otro número.");
                                numero2 = sc.nextLine();
                            }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while(n2 == 0){
                            do {
                                System.err.println(" En el denominador se encuentra \n"
                                        + "un cero, para evitar errores coloca otro número.");
                                numero2 = sc.nextLine();
                            }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            }while(comprobar != true);

            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n ¿Desea hacer alguna otra operación? \n");
            System.out.println(" [s/n]");
            do{
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, ponga un literal valido. \n");
                        comprobar = false;
                }
            }while(comprobar != true);
        }while(operacion.equals("s") || operacion.equals("S"));
    }
}