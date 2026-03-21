package stepik.greedy.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
https://stepik.org/lesson/1105114/step/7?unit=1116299

Задача «Бои профессоров»
Дана лекционная аудитория, в которой несколько профессоров хотят прочесть свои лекции. Для составления расписания профессора подали заявки, вида
[si,fi) - время начала и конца лекции. Лекция считается открытым полуинтервалом, то есть какая-то лекция может начаться в момент окончания другой, без перерыва. Составьте расписание занятий так, чтобы выполнить максимальное количество заявок.

Формат входных данных
В первой строке вводится натуральное число
N≤1000 - общее количество заявок. Затем вводится
N строк с описаниями заявок - по два числа в каждом.

Гарантируется, что
si<fi
  Время начала и окончания лекции - натуральное число, не превышает
1440
1440 (в минутах с начала суток).

Формат выходных данных
Выведите одно число - максимальное количество заявок, которые можно выполнить.

Комментарий по тестам
Тест №1: Очевидно, что можно провести одну конференцию.
Тест №2: Можем провести максимум две конференции:
[2;3) и [3;5).

Sample Input 1:

1
5 10
Sample Output 1:

1
Sample Input 2:

3
1 5
2 3
3 5
Sample Output 2:

2
 */
class Lesson {
    int startTime;
    int endTime;

    Lesson(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int N = Integer.parseInt(line1);

        Comparator<Lesson> comparator = new Comparator<Lesson>() {
            @Override
            public int compare(Lesson o1, Lesson o2) {
                return o1.endTime - o2.endTime;
            }
        };

        List<Lesson> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            String line2 = br.readLine();
            String[] tokens = line2.split(" ");
            int startTime = Integer.parseInt(tokens[0]);
            int endTime = Integer.parseInt(tokens[1]);

            list.add(new Lesson(startTime, endTime));
        }

        list.sort(comparator);
        int count = countLesson(list);

        System.out.println(count);
    }

    private static int countLesson(List<Lesson> lessons) {

        int count = 0;
        int lastTime = -1;
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).startTime >=lastTime) {
                count++;
                lastTime = lessons.get(i).endTime;
            }
        }
        return count;
    }


}
