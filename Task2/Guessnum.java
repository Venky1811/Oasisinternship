package Task2;

import java.util.Scanner;

public class Guessnum {
    
    public static void guess(){
        Scanner sc = new Scanner(System.in);

        int n = 1 +(int)(100 * Math.random());

        int chances = 5;
        int temp = chances;

        int i,guess;

        System.out.println("think of a number between 1 to 100." + " you are given 3 chances to guess that.");

        for(i=0;i<chances;i++){
            System.out.println("please enter your number");
            
            guess = sc.nextInt();
            int score  = 100 * (temp/chances);

            if(n == guess){
                System.out.println("congratulations you got the number correct" + "and your score is" + " "+score);
                break;
            }
            else if(n > guess && i != chances-1){
                System.out.println("here is the hint:" + " the number you got is lesser! try again!");
            }
            else if(n < guess && i!= chances-1){
                System.out.println("here is the hint :" + "the number you got is greater! try again!");
            }
            temp--;
        }

        if(i == chances){
            System.out.println("you have exhaused the chances");
            System.out.println("the number was :"+ n);
        }
        

    }

    public static void main(String[] args) {
        guess();
    }
}
