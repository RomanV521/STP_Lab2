package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Vykhodets Roman, #1
 */
public class Main {
    static Random random = new Random();

    private static void Start() {
        System.out.println("\nCompleted by student AT-212 \nOdessa Polytechnic University \nVykhodets Roman \n\nVariant 1 \n\n");
    }

    /**
     * В массиве хранится информация о численности книг в каждом из 35 разделов библиотеки.
     * Выяснить, верно ли, что общее число книг в библиотеке есть шестизначное число.
     */
    private static void task_23() {
        System.out.println("Task 23:\nВ массиве хранится информация о численности книг в каждом из 35 разделов библиотеки.\nВыяснить, верно ли, что общее число книг в библиотеке есть шестизначное число.\n");

        final int NUMBER = 35;
        int[] books = new int[NUMBER];
        int sum = 0;

        for (int i = 0; i < NUMBER; i++) {
            books[i] = random.nextInt(9000) + 90; //(90..9090) (90..6090)
            System.out.println("Количетво книг в " + (i + 1) + "-ом разделе: " + books[i]);
            sum += books[i];
        }

        if (sum > 99999 && sum < 1000000) {
            System.out.println("\nКоличество книг: " + sum + " - шестизначное число");
        } else {
            System.out.println("\nКоличество книг: " + sum + " - не шестизначное число");
        }
    }

    /**
     * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются:
     * а) простыми числами;
     * б) числами Фибоначчи.
     */
    private static void task_48() {
        System.out.println("\n\nTask 48:\nЗадана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются:\n\tа) простыми числами;\n\tб) числами Фибоначчи.\n");

        final int N = random.nextInt(45) + 15;
        double[] arrays = new double[N];
        double sumF = 0, sumPN = 0;

        System.out.println("Количество N: " + N + "\n\nPN  |Fib.|\nSum:|Sum:|Значения:");


        for (int i = 0; i < N; i++) {
            arrays[i] = Math.round((random.nextDouble(14) + 3) * 100.0) / 100.0;// (3..17), ограничение до сотых

            //A)
            if (i == 2 || i == 4 || i <= 1 || (i + 1) % 2 != 0 && (i + 1) % 3 != 0 && (i + 1) % 5 != 0) {
                System.out.print("\'+\' ");
                sumPN += arrays[i];
            } else {
                System.out.print(" \t");
            }

            //Б) Fibonacci
            if (Math.sqrt(5 * (i + 1) * (i + 1) - 4) - (int) Math.sqrt(5 * (i + 1) * (i + 1) - 4) == 0 || Math.sqrt(5 * (i + 1) * (i + 1) + 4) - (int) Math.sqrt(5 * (i + 1) * (i + 1) + 4) == 0) {
                System.out.print("|\'+\' | ");
                sumF += arrays[i];
            } else {
                System.out.print("|\t | ");
            }
            System.out.println(" " + (i + 1) + " = " + arrays[i]);
        }

        System.out.println("\nA) Сумму чисел, порядковые номера которых являются простыми числами: " + String.format("%.2f", sumPN));
        //Числа Фибоначчи: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
        System.out.println("Б) Сумму чисел, порядковые номера которых являются числами Фибоначчи: " + String.format("%.2f", sumF + arrays[0]));

    }

    /**
     * Даны последовательность вещественных чисел а1, a2, ..., а15,
     * упорядоченная по возрастанию, и число n, не равное ни одному из чисел последовательности.
     * Найти элемент последовательности (его порядковый номер и значение), ближайший к n.
     */
    private static void task_73() {
        System.out.println("\n\nTask 73:\nДаны последовательность вещественных чисел а1, a2, ..., а15, упорядоченная по возрастанию, и число n, не равное ни одному из чисел последовательности. Найти элемент последовательности (его порядковый номер и значение), ближайший к n.\n");

        final int K = 15, N = random.nextInt(5) + 5;
        double[] a = new double[K];
        boolean ans = false;

        System.out.println("Последовательность:");

        for (int i = 0; i < K; i++) {
            a[i] = Math.round((random.nextDouble(13) + 2) * 100.0) / 100.0;//(2..15)
            System.out.println((i + 1) + " = " + a[i]);
        }
        Arrays.sort(a);// сортировка по возрастанию

        System.out.println("\nЗначение N: " + N);

        for (int t = 0; t < K - 1; t++) {
            if (N < a[t + 1] && N > a[t]) {

                if (N - a[t] < a[t + 1] - N) {
                    System.out.println("Число: " + a[t] + " - ближайшее(A[" + t + "])");
                    ans = true;
                } else {
                    if (N - a[t] > a[t + 1] - N) {
                        System.out.println("Число: " + a[t + 1] + " - ближайшее(A[" + (t + 1) + "])");
                        ans = true;
                    } else {
                        if (N - a[t] == a[t + 1] - N) {
                            System.out.println("Число: " + a[t + 1] + " - ближайшее(A[" + t + "], А[" + t + 1 + "])");
                            ans = true;
                        }
                    }
                }
            }
        }
        if (!ans) {
            System.out.println("Нет ближайших чисел");
        }

        System.out.println("\nПолученный массив по возрастанию:\n" + Arrays.toString(a));// быстрый вывод массива на экран

    }

    /**
     * Удалить элемент массива целых чисел, кратный 3 и 7.
     * Если таких элементов нет, выдать сообщение «элементы для удаления не найдены», иначе удалить первый найденный элемент.
     */
    private static void task_98() {
        System.out.println("\n\nTask 98:\nУдалить элемент массива целых чисел, кратный 3 и 7. Если таких элементов нет, выдать сообщение «элементы для удаления не найдены», иначе удалить первый найденный элемент.\n");

        final int N = random.nextInt(10) + 5;
        int realSize = N, ElemPos;
        int[] a = new int[N], a1 = new int[N - 1];

        System.out.println("Массив:");
        for (int i = 0; i < N; i++) {
            a[i] = Math.round(random.nextInt(33) + 2);//(2..35)
//            a[2]=21;
//            a[1]=0;
//            a[4]=21;
            System.out.println((i + 1) + " = " + a[i]);
        }


        for (int i = 0; i < N; i++) {
            if (a[i] != 0 && a[i] % 3 == 0 && a[i] % 7 == 0) {
                removeElement(a, (i + 1));
                realSize--;
                break;
            }
        }
        if (realSize != N) {
            a = Arrays.copyOf(a, realSize);
            System.out.println("\nПолученный массив:\n" + Arrays.toString(a));
        } else {
            System.out.println("\nЭлементы для удаления не найдены");
        }

    }

    /**
     * Дана последовательность целых положительных чисел. Найти произведение только тех из них, которые больше заданного числа М.
     * Если таких чисел нет, то выдать сообщение об этом.
     */
    private static void task_123() {
        System.out.println("\n\nTask 123:\nДана последовательность целых положительных чисел. Найти произведение только тех из них, которые больше заданного числа М. Если таких чисел нет, то выдать сообщение об этом.\n");

        final int N = random.nextInt(10) + 5, M = random.nextInt(15) + 7;
        int[] a = new int[N];
        int sum = 0;

        System.out.println("Значение М: " + M + "\nМассив:");
        for (int i = 0; i < N; i++) {
            a[i] = Math.round(random.nextInt(29) + 1);//(1..30)
            System.out.println((i + 1) + " = " + a[i]);
            if (a[i] > M) {
                sum += a[i];
            }
        }
        if (sum > 0) {
            System.out.println("\nСумма чисел, которые больше заданного числа М: " + sum);
        } else {
            System.out.println("\nНет чисел, которые больше заданного числа М");
        }
    }

    private static void removeElement(int[] a, int ElemPos) {
        java.lang.System.arraycopy(a, ElemPos, a, (ElemPos - 1), ((a.length) - ElemPos));
        a[(a.length) - 1] = 0;
    }

    public static void main(String[] args) {
        Start();
//        task_23();
        //task_48();
//        task_73();
        task_98();
//        task_123();
    }
}
