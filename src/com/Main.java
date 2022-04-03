package com;


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


    public static void main(String[] args) {
        Start();
        task_23();
    }
}
