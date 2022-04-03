package com;


import java.util.Arrays;
import java.util.Random;

/**
 *  Vykhodets Roman, #1
 */
public class Main {
    static Random random = new Random();

    private static void Start(){
        System.out.println("\nCompleted by student AT-212 \nOdessa Polytechnic University \nVykhodets Roman \n\nVariant 1 \n\n");
    }

    /**
     * В массиве хранится информация о численности книг в каждом из 35 разделов библиотеки.
     * Выяснить, верно ли, что общее число книг в библиотеке есть шестизначное число.
     */
    private static void task_23(){
        System.out.println("Task 23:\nВ массиве хранится информация о численности книг в каждом из 35 разделов библиотеки.\nВыяснить, верно ли, что общее число книг в библиотеке есть шестизначное число.\n");

        int number=35;
        int[] books = new int[number];
        int sum=0;

        for(int i=0; i<number; i++){
            books[i] = random.nextInt(9000)+90; //(90..9090) (90..6090)
            System.out.println("Количетво книг в "+(i+1)+"-ом разделе: "+books[i]);
            sum += books[i];
        }

        if(sum>99999 && sum<1000000){
            System.out.println("\nКоличество книг: "+sum+" - шестизначное число");
        }
        else{
            System.out.println("\nКоличество книг: "+sum+" - не шестизначное число");
        }
    }

    /**
     * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются:
     * а) простыми числами;
     * б) числами Фибоначчи.
     */
    private static void task_48(){
        System.out.println("Task 48:\nЗадана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются:\n\tа) простыми числами;\n\tб) числами Фибоначчи.\n");

        int n=random.nextInt(45)+15, j=0;
        double[] arrays=new double[n];
        double d,sumF=0, sumPN=0;

        System.out.println("Количество N: "+n+"\n\nPN  |Fib.|\nSum:|Sum:|Значения:");


        for (int i=0; i<n; i++){
            arrays[i]= Math.round((random.nextDouble(14)+3)*100.0)/100.0;// (3..17), ограничение до сотых

            //A)
            if(i<=1 || (i+1)%2!=0 && (i+1)%3!=0 && (i+1)%5!=0){
                System.out.print("\'+\' ");
                sumPN+=arrays[i];
            }

            else {
                System.out.print(" \t");
            }

            //Б) Fibonacci
            if(Math.sqrt(5*(i+1)*(i+1)-4) - (int)Math.sqrt(5*(i+1)*(i+1)-4) == 0 || Math.sqrt(5*(i+1)*(i+1)+4) - (int)Math.sqrt(5*(i+1)*(i+1)+4) == 0){
                System.out.print("|\'+\' | ");
                sumF += arrays[i];
            }
            else {
                System.out.print("|\t | ");
            }
            System.out.println(" "+(i+1)+" = "+arrays[i]);
        }

        System.out.println("\nA) Сумму чисел, порядковые номера которых являются простыми числами: "+ String.format("%.2f",sumPN));
        //Числа Фибоначчи: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
        System.out.println("Б) Сумму чисел, порядковые номера которых являются числами Фибоначчи: " + String.format("%.2f",sumF+arrays[0]));

    }


    public static void main(String[] args) {
        Start();
        task_23();
        task_48();
    }
}
