import java.util.Arrays;
import java.util.Scanner;

public class SmartBanking {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    final String clear = "\033[H\033[2J";
    final String bold = "\033[;1m";
    final String reset = "\033[0m";
    final String blue = "\033[034m";
    final String red_bold = "\033[31;1m";

    final String DASHBOARD = "💰" + " Welcome to Smart Banking App";
    final String OPEN_NEW_ACCOUNT = "💸" + " Open New Account";
    final String DEPOSITS = "Deposit Money";
    final String WITHDRAW = "Withdraw Money";
    final String TRANSFER = "Transfer Money";
    final String CHECK_BALANCE = "Check Account Balance";
    final String DELETE = "Drop Existing Account";
    final String EXIT = "Exit";

    String screen = DASHBOARD;
    String[] accountNames = new String[0];
    int[] deposits = new int[0];
    String[] idArray = new String[0];

    do {
      final String APP_TITLE = String.format(
        "%s%s%s%s",
        bold,
        blue,
        screen,
        reset
      );
      System.out.println(clear);
      System.out.println("-".repeat(50));
      System.out.println(
        " ".repeat((50 - APP_TITLE.length() + 7) / 2).concat(APP_TITLE)
      );

      System.out.println("-".repeat(50));

      switch (screen) {
        case DASHBOARD:
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

          switch (option) {
            case 1:
              screen = OPEN_NEW_ACCOUNT;
              break;
            case 2:
              screen = DEPOSITS;
              break;
            case 3:
              screen = WITHDRAW;
              break;
            case 4:
              screen = TRANSFER;
              break;
            case 5:
              screen = CHECK_BALANCE;
              break;
            case 6:
              screen = DELETE;
              break;
            case 7:
              screen = EXIT;
              break;
            default:
              continue;
          }

          break;
        case OPEN_NEW_ACCOUNT:
          System.out.printf(
            "\nNew Account Holder's ID: SDB-%05d \n",
            (accountNames.length + 1)
          );

          String[] newIDArray = new String[idArray.length+1];

          for (int i = 0; i < idArray.length; i++) {
            newIDArray[i] = idArray[i];
          }

          newIDArray[newIDArray.length-1] = String.format("SDB-%05d",(accountNames.length+1));
          idArray=newIDArray;

          boolean valid;
          String name;
          do {
            valid = true;
            System.out.print("Enter Account Holder's Name: ");
            name = scanner.nextLine().strip();
            if (name.isBlank()) {
              System.out.printf("%sName can't be empty%s\n", red_bold, reset);
              valid = false;
              continue;
            }
            for (int i = 0; i < name.length(); i++) {
              if (
                !(
                  Character.isLetter(name.charAt(i)) ||
                  Character.isSpaceChar(name.charAt(i))
                )
              ) {
                System.out.printf("%sInvalid Name%s\n", red_bold, reset);
                valid = false;
                break;
              }
            }
          } while (!valid);

          String[] newAccountNames = new String[accountNames.length + 1];
          for (int i = 0; i < accountNames.length; i++) {
            newAccountNames[i] = accountNames[i];
          }
          newAccountNames[newAccountNames.length - 1] = name;
          accountNames = newAccountNames;

          int deposit;
          do {
            valid = true;
            System.out.print("Enter Initial Deposit Value: ");
            deposit = scanner.nextInt();
            scanner.nextLine();
            if (!(deposit > 5000)) {
              System.out.printf("%sInsufficient Amount%s\n", red_bold, reset);
              valid = false;
              continue;
            }
          } while (!valid);

          int[] newDeposits = new int[deposits.length + 1];
          for (int i = 0; i < deposits.length; i++) {
            newDeposits[i] = deposits[i];
          }
          newDeposits[newDeposits.length - 1] = deposit;
          deposits = newDeposits;

          System.out.println();
          System.out.printf(
            "SDB-%05d : %s added sucessfully.\nDo you want to add new student (Y/n)? ",
            (accountNames.length),
            name
          );
          if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
          screen = DASHBOARD;
          break;

          case DEPOSITS:


        default:
          System.exit(0);
      }
    } while (true);
  }
}
