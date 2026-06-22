package A_Fundamentals;

import java.util.Scanner;

public class BasicProblems_02 {

    public static void main(String args[]){
        //13 - milk vendor buys milk at price 20 per litre, he adds 1 litre of water for every 4 litre of milk.
        //     he sells at rate of 25rs. print the gain by taking number of litres he bought.

        Scanner input = new Scanner(System.in);

        System.out.println("enter the no of litres of milk, vendor bought");
        float litresBuy = input.nextFloat();

        float totalLitres = litresBuy + (litresBuy/4);

        System.out.println("total budget he spent is :" + litresBuy * 20);

        System.out.println("total sale :" + totalLitres * 25);

        System.out.println("profit gain is :" + ((totalLitres * 25) - (litresBuy * 20)));
    }

    

}
