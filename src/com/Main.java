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
        System.out.println("\n\nTask 48:\nЗадана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются:\n\tа) простыми числами;\n\tб) числами Фибоначчи.\n");

        int n=random.nextInt(45)+15;
        double[] arrays=new double[n];
        double sumF=0, sumPN=0;

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

    /**
     * Даны последовательность вещественных чисел а1, a2, ..., а15,
     * упорядоченная по возрастанию, и число n, не равное ни одному из чисел последовательности.
     * Найти элемент последовательности (его порядковый номер и значение), ближайший к n.
     */
    private static void task_73() {
        System.out.println("\n\nTask 73:\nДаны последовательность вещественных чисел а1, a2, ..., а15, упорядоченная по возрастанию, и число n, не равное ни одному из чисел последовательности. Найти элемент последовательности (его порядковый номер и значение), ближайший к n.\n");

        int k=15, n= random.nextInt(5)+5;
        double[] a = new double[k];

        System.out.println("Последовательность:");

        for (int i=0; i<k; i++){
            a[i]= Math.round((random.nextDouble(13)+2)*100.0)/100.0;//(2..15)
            System.out.println((i+1)+" = "+a[i]);
        }
        Arrays.sort(a);// сортировка по возрастанию

        System.out.println("\nЗначение N: "+n);

        for (int t=0; t<k-1; t++){
            if(n < a[t+1] && n > a[t]){
                if(n-a[t] < a[t+1]-n){
                    System.out.println("Число: "+a[t]+" - ближнее(A["+t+"])");
                }
                else {
                    if (n-a[t] > a[t+1]-n){
                        System.out.println("Число: "+a[t+1]+" - ближнее(A["+(t+1)+"])");
                    }
                    else {
                        System.out.println("Число: "+a[t+1]+" - ближнее(A["+t+"], А["+t+1+"])");
                    }
                }
            }
        }

        System.out.println("\nПоученый массив по возрастанию:\n"+Arrays.toString(a));// быстрый вывод массива на экран

    }


    public static void main(String[] args) {
        Start();
        //task_23();
        //task_48();
        task_73();
    }
}
