package stepik.recurse.hanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1073852/step/10?unit=1083924

Напишите рекурсивную функцию, которая будет решать задачу о Ханойских башнях.

Задача о Ханойской башне является классической задачей теории алгоритмов, представляющей собой головоломку, которая была придумана в 1883 году французским математиком Эдуардом Лукасом.

Представьте три стержня, на один из которых нанизаны N дисков разного размера в порядке возрастания к вершине (самый большой диск находится снизу). Задача состоит в том, чтобы переместить всю стопку дисков на другой стержень, соблюдая следующие правила:

За один ход можно переместить только один диск.
Ни в какой момент времени диск большего размера не может находиться поверх диска меньшего размера.

Входные данные
2

Выходные данные
Переместите диск с 1 на 2
Переместите диск с 1 на 3
Переместите диск с 2 на 3

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //# Использование: 3 диска, со стержня 1 на 3
        hanoi(n, 1, 3, 2);
    }

    private static void hanoi(int n, int source, int target, int helper){
        if (n == 1) {
            System.out.printf("Переместите диск с %d на %d\n", source, target);
            return;
        }

//     Шаг 1: N-1 дисков на вспомогательный стержень
        hanoi(n - 1, source, helper, target);

//      # Шаг 2: Самый большой диск на целевой
        System.out.printf("Переместите диск с %d на %d\n", source, target);

  //    # Шаг 3: N-1 дисков со вспомогательного на целевой
        hanoi(n - 1, helper, target, source);

    }

}
