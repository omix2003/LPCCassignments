import java.util.Scanner;

public class ThreeAddressCodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String input = scanner.nextLine();

        String[] tokens = input.split(" ");
        char op = ' ';
        int tempCount = 1;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("=")) {
                op = '=';
            } else if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")) {
                op = tokens[i].charAt(0);
            } else {
                System.out.println("t" + tempCount + " = " + tokens[i].charAt(0) + " " + op + " " + tokens[i]);
                continue;
            }

            i++;
            if (i < tokens.length && tokens[i].charAt(0) != '=') {
                System.out.println("t" + (tempCount + 1) + " = t" + tempCount + " " + op + " " + tokens[i]);
                tempCount++;
            }
        }

        scanner.close();
    }
}
