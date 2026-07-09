import java.util.Scanner;

public class QuizGame {
    static Scanner input = new Scanner(System.in);
    static String [] questions = {"what is the capital of india?", "how many primitive data types in java?","CPU stands for."};
    static String key[] = {"delhi", "8","central processing unit"};
    static int score = 0, i = 0;

    public static void main(String args[]){
        System.out.println("welcome to quiz!\nDo you want to participate in quiz app ? (yes / no)");
        String userInput = input.nextLine().trim().toLowerCase();
        if(userInput.equals("yes")){
            System.out.println("Lets start!");
            question();
        }else
            System.out.println("Thanks for visiting!");
    }

    public static void question(){
        System.out.println((i+1) + ". " + questions[i]);
        String ans = input.nextLine().trim().toLowerCase();
        if(ans.equals(key[i])){
            System.out.println("correct answer");
            score++;
        }else
            System.out.println("wrong answer");
        i++;
        if(i < questions.length) 
            proceed();
        else
            System.out.println("Quiz completed.\nObtained score is :" + score);
    }

    public static void proceed(){
        System.out.println("Do you want to proceed with another question ? (yes/no)");
        String ans = input.nextLine().toLowerCase();
        
        if(ans.equals("yes"))
            question();
        else if(ans.equals("no"))
            System.out.println("Score obtained is :" + score);
        else{
            System.out.println("enter input correctly");
            proceed();
        }
    }

    


    /* public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to Quiz!");
        System.out.println("Do you want to participate in quiz app? (yes/no)");
        String userInput = input.nextLine().trim().toLowerCase();

        if(userInput.equals("yes")){
            System.out.println("What is the capital of India?");
            String ans = input.nextLine().trim().toLowerCase();

            if(ans.equals("delhi")){
                System.out.println("correct");
                score++;
            }else{
                System.out.println("wrong!");
            }

            System.out.println("Do you want to proceed? (yes/no)");
            userInput = input.nextLine().trim().toLowerCase();

            if(userInput.equals("yes")){
                System.out.println("How many primitive data types in java?");
                ans = input.nextLine().trim().toLowerCase();

                if(ans.equals("8")){
                    System.out.println("correct");
                    score++;
                }else{
                    System.out.println("wrong!");
                }

                System.out.println("Do you want to proceed? (yes/no)");
                userInput = input.nextLine().trim().toLowerCase();

                if(userInput.equals("yes")){
                    System.out.println("CPU stands for?");
                    ans = input.nextLine().trim().toLowerCase();

                    if(ans.equals("central processing unit")){
                        System.out.println("correct");
                        score++;
                    }else{
                        System.out.println("wrong!");
                    }
                }
            }

            System.out.println("quiz completed!");
            System.out.println("your score is : " + score);

        }else{
            System.out.println("Thanks for visiting!");
        }

        input.close();
    } */
}
