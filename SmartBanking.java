import java.util.Scanner;

public class SmartBanking{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final String clear = "\033[H\033[2J";
        final String bold = "\033[;1m";
        final String reset = "\033[0m";
        final String blue = "\033[034m";
        final String red_bold = "\033[31;1m";

        final String DASHBOARD = "💰"+" Welcome to Smart Banking App";
        final String OPEN_NEW_ACCOUNT = "💸"+" Open New Account";
        final String DEPOSITS = "Deposit Money";
        final String WITHDRAW = "Withdraw Money";
        final String TRANSFER = "Transfer Money";
        final String CHECK_BALANCE = "Check Account Balance";
        final String DELETE = "Drop Existing Account";
        final String EXIT = "Exit";

        String screen = DASHBOARD;
        String[] names = new String[0];


        do{
            final String APP_TITLE = String.format("%s%s%s%s",bold,
                                blue, screen, reset);
            System.out.println(clear);
            System.out.println("-".repeat(50));
            System.out.println(" ".repeat((50 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));

            System.out.println("-".repeat(50));

            switch(screen){
                case DASHBOARD :
                    System.out.println("\n[1]. Open New Account");
                    System.out.println("[2]. Deposit Money");
                    System.out.println("[3]. Withdraw Money");
                    System.out.println("[4]. Transfer Money");
                    System.out.println("[5]. Check Account Balance");
                    System.out.println("[6]. Drop Existing Account");
                    System.out.println("[7]. Exit\n");                   
                    System.out.print("Enter an option to continue > ");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch(option){
                        case 1: screen = OPEN_NEW_ACCOUNT;break;
                        case 2: screen = DEPOSITS;break;
                        case 3: screen = WITHDRAW;break;
                        case 4: screen = TRANSFER;break;
                        case 5: screen = CHECK_BALANCE;break;
                        case 6: screen = DELETE;break;
                        case 7: screen = EXIT;break;
                        default: continue;
                    }

                    break;

                

                }

        }while(true);
    }
}