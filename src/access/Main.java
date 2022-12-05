package access;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int command = 0;
        Scanner scanner = new Scanner(System.in);
        Query query = new Query();

        do {
            System.out.println("Marine Transport ===========");
            System.out.println("1. find           2. desc");
            System.out.println("3. insert         4. delete");
            System.out.println("5. update         6. 직접 입력");
            System.out.println("7. join           99. 종료");
            System.out.println("============================");
            System.out.print("command >> ");

            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input!");
                continue;
            }

            switch (command) {
                case 1:
                    query.find();
                    break;
                case 2:
                    query.desc();
                    break;
                case 3:
                    query.insert();
                    break;
                case 4:
                    query.delete();
                    break;
                case 5:
                    query.update();
                    break;
                case 6:
                    query.custom();
                    break;
                case 7:
                    query.join();
                    break;
                case 99:
                    System.out.println("프로그램 종료...");
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }

        } while (command != 99);
    }
}
