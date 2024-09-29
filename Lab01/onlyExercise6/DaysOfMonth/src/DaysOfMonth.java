import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int year;
        do {
            System.out.print("Enter the year: ");
            year = keyboard.nextInt();
        } while (year < 0);

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int day = 0;
        int month = 0;
        boolean isCorrect = false;

        keyboard.nextLine();

        do {
            System.out.print("Enter the month: ");
            String strName = keyboard.nextLine();

            switch (strName.toLowerCase()) {
                case "january": case "jan": case "1":
                    month = 1; isCorrect = true; break;
                case "february": case "feb": case "2":
                    month = 2; isCorrect = true; break;
                case "march": case "mar":  case "3":
                    month = 3; isCorrect = true; break;
                case "april": case "apr":  case "4":
                    month = 4; isCorrect = true; break;
                case "may": case "5":
                    month = 5; isCorrect = true; break;
                case "june": case "jun": case "6":
                    month = 6; isCorrect = true; break;
                case "july": case "jul":  case "7":
                    month = 7; isCorrect = true; break;
                case "august": case "aug":  case "8":
                    month = 8; isCorrect = true; break;
                case "september": case "sep":  case "9":
                    month = 9; isCorrect = true; break;
                case "october": case "oct":  case "10":
                    month = 10; isCorrect = true; break;
                case "november": case "nov":  case "11":
                    month = 11; isCorrect = true; break;
                case "december": case "dec":  case "12":
                    month = 12; isCorrect = true; break;
                default:
                    System.out.println("Invalid month! Please try again.");
            }
        } while (!isCorrect);

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                day = 31;
                break;
            case 4: case 6: case 9: case 11:
                day = 30;
                break;
            case 2:
                day = isLeapYear ? 29 : 28;
                break;
        }

        System.out.println("Days of the month: " + day);
    }
}
