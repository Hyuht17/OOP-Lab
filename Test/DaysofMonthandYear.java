import java.util.Scanner;
public class DaysofMonthandYear {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int year;
        do{
        System.out.print("Enter the year: ");
        year = keyboard.nextInt();
        }while(year < 0);

        int Leapyear = 0;
        if((year % 4) == 0 & (year % 100) != 0){
            Leapyear = 1;
        }

        int day = 0;
        int month = 0;
        int isCorrect = 0;

        do{
        System.out.print("Enter the month: ");
        String strName = keyboard.next();

        switch (strName) {
            case "January":
                isCorrect = 1;
                month = 1;
                break;
            case "Jan":
                isCorrect = 1;
                month = 1;
                break;
            case "Jan.":
                isCorrect = 1;
                month = 1;
                break;
            case "1":
                isCorrect = 1;
                month = 1;
                break;
            case "Febuary":
                isCorrect = 1;
                month = 2;
                break;
            case "Feb":
                isCorrect = 1;
                month = 2;
                break;
            case "Feb.":
                isCorrect = 1;
                month = 2;
                break;
            case "2":
                isCorrect = 1;
                month = 2;
                break;
            case "March":
                isCorrect = 1;
                month = 3;
                break;
            case "Mar":
                isCorrect = 1;
                month = 3;
                break;
            case "Mar.":
                isCorrect = 1;
                month = 3;
                break;
            case "3":
                isCorrect = 1;
                month = 3;
                break;
            case "April":
                isCorrect = 1;
                month = 4;
                break;
            case "Apr":
                isCorrect = 1;
                month = 4;
                break;
            case "Apr.":
                isCorrect = 1;
                month = 4;
                break;
            case "4":
                isCorrect = 1;
                month = 4;
                break; 
            case "May":
                isCorrect = 1;
                month = 5;
                break;
            case "May.":
                isCorrect = 1;
                month = 5;
                break;
            case "5":
                isCorrect = 1;
                month = 5;
                break;
            case "June":
                isCorrect = 1;
                month = 6;
                break;
            case "Jun":
                isCorrect = 1;
                month = 6;
                break;
            case "Jun.":
                isCorrect = 1;
                month = 6;
                break;
            case "6":
                isCorrect = 1;
                month = 6;
                break;
            case "July":
                isCorrect = 1;
                month = 7;
                break;
            case "Jul":
                isCorrect = 1;
                month = 7;
                break;
            case "Jul.":
                isCorrect = 1;
                month = 7;
                break;
            case "7":
                isCorrect = 1;
                month = 7;
                break;
            case "August":
                isCorrect = 1;
                month = 8;
                break;
            case "Aug":
                isCorrect = 1;
                month = 8;
                break;
            case "Aug.":
                isCorrect = 1;
                month = 8;
                break;
            case "8":
                isCorrect = 1;
                month = 8;
                break;
            case "September":
                isCorrect = 1;
                month = 9;
                break;
            case "Sep":
                isCorrect = 1;
                month = 9;
                break;
            case "Sep.":
                isCorrect = 1;
                month = 9;
                break;
            case "9":
                isCorrect = 1;
                month = 9;
                break;
            case "October":
                isCorrect = 1;
                month = 10;
                break;
            case "Oct":
                isCorrect = 1;
                month = 10;
                break;
            case "Oct.":
                isCorrect = 1;
                month = 10;
                break;
            case "10":
                isCorrect = 1;
                month = 10;
                break;
            case "November":
                isCorrect = 1;
                month = 11;
                break;
            case "Nov":
                isCorrect = 1;
                month = 11;
                break;
            case "Nov.":
                isCorrect = 1;
                month = 11;
                break;
            case "11":
                isCorrect = 1;
                month = 11;
                break;
            case "December":
                isCorrect = 1;
                month = 12;
                break;
            case "Dec":
                isCorrect = 1;
                month = 12;
                break;
            case "Dec.":
                isCorrect = 1;
                month = 12;
                break;
            case "12":
                isCorrect = 1;
                month = 12;
                break;
        }
    }while(isCorrect == 0);

      
        switch (month) {
            case 1:
                day = 31;
                break;
            case 2:
                if(Leapyear == 1) day = 29;
                else day = 28;
                break;
            case 3:
                day = 31;
                break;
            case 4:
                day = 30;
                break;
            case 5: 
                day = 31;
                break;
            case 6:
                day = 30;
                break;
            case 7:
                day = 31;
                break;
            case 8:
                day = 31;
                break;
            case 9:
                day = 30;
                break;
            case 10:
                day = 31;
                break;
            case 11:
                day = 30;
                break;
            case 12:
                day = 31;
                break;    
        }
        System.out.println("Days of the month: " + day);
    }

}
