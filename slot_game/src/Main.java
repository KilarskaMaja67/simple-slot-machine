import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to Java Slots! Let's Play!");

        int balance=100;
        int bet;
        int payout;
        String[] row;
        Boolean play=true;
        char ans;

        while(balance>0 && play)
        {
            System.out.println("Current balance: " + balance + "$");
            System.out.print("Enter bet amount: ");
            bet=scanner.nextInt();
            if(bet>balance)
            {
                System.out.println("Insufficient funds");
                continue;
            }
            else if(bet<=0)
            {
                System.out.println("Bet must be greater than 0");
                continue;
            }
            else
            {
                balance-=bet;

            }

            System.out.println("Spinning...");
            row=spin_row();
            System.out.println(String.join("|", row));
           payout=get_payout(bet, row);
           if(payout>0)
           {
               System.out.println("You won: " + payout + "$");
               balance+=payout;
           }
           else
           {
               System.out.println("Sorry you lost this round");
           }
           System.out.print("Do you want to play again? (y/n): ");
           ans=scanner.next().charAt(0);
           if(ans=='n')
           {
               play=false;
           }
        }
        System.out.println("Thank you for playing with us! Your final balance is: " + balance);

    scanner.close();
    }

    static String[] spin_row(){

        String[] symbols ={"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] row=new String[3];
        Random random=new Random();

        for(int i=0; i<3; i++)
        {
            row[i]=symbols[random.nextInt(symbols.length)];
        }


        return row;
    }
   static int get_payout(int bet, String[] row)
   {
       if(row[0]==row[1] && row[1]==row[2])
       {
           return switch(row[0])
           {
               case "🍒" -> bet * 3;
               case "🍉" -> bet * 4;
               case "🍋" -> bet * 5;
               case "🔔" -> bet * 10;
               case "⭐" -> bet * 20;
               default -> 0;
           };

       }
       if(row[0]==row[1])
       {
           return switch(row[0])
           {
               case "🍒" -> bet * 2;
               case "🍉" -> bet * 3;
               case "🍋" -> bet * 4;
               case "🔔" -> bet * 5;
               case "⭐" -> bet * 10;
               default -> 0;
           };

       }
       if(row[1]==row[2])
       {
           return switch(row[1])
           {
               case "🍒" -> bet * 2;
               case "🍉" -> bet * 3;
               case "🍋" -> bet * 4;
               case "🔔" -> bet * 5;
               case "⭐" -> bet * 10;
               default -> 0;
           };

       }
       if(row[0]==row[2])
       {
           return switch(row[0])
           {
               case "🍒" -> bet * 1;
               case "🍉" -> bet * 2;
               case "🍋" -> bet * 3;
               case "🔔" -> bet * 4;
               case "⭐" -> bet * 5;
               default -> 0;
           };

       }
       return 0;

   }
}