package ru.yandex.algo5.football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// B. Футбольный комментатор
// https://contest.yandex.ru/contest/59539/problems/B/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    public void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line1 = reader.readLine();
            String[] res1 = line1.split(":");

            String line2 = reader.readLine();
            String[] res2 = line2.split(":");

            int place = Integer.parseInt(reader.readLine());

            Stat stat = new Stat();
            stat.addGame(Position.FIRST, new Game(place == 1 ? Place.HOME : Place.GUEST, Integer.parseInt(res1[0]), Integer.parseInt(res1[1])));
            stat.addGame(Position.SECOND, new Game(place == 1 ? Place.GUEST : Place.HOME, Integer.parseInt(res2[0]), Integer.parseInt(res2[1])));

//            stat.addGame(Position.FIRST, new Game(Place.GUEST, 0, 2));
//            stat.addGame(Position.SECOND, new Game(Place.HOME, 0, 3));

            int shouldRun = stat.getShouldRun();
            System.out.println(shouldRun);
        }
    }
}

class Stat {
    Map<Position, Game> games = new HashMap<>();

    public void addGame(Position position, Game game) {
        games.put(position, game);
    }

    public int getTotal() {
        return games.get(Position.FIRST).getDifference() + games.get(Position.SECOND).getDifference();
    }

    public int getRunInGuest() {
        return games.values().stream()
                .filter(game -> game.getPlace() == Place.GUEST)
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getRun();
    }

    public int getFailInGuest() {
        return games.values().stream()
                .filter(game -> game.getPlace() == Place.HOME)
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getFail();
    }

    public int getShouldRun() {
        int totalGoals = getTotal();
        int runInGuest = getRunInGuest();
        int failInGuest = getFailInGuest();

        if (totalGoals > 0) {
            return 0;
        } else {
            if (games.get(Position.SECOND).getPlace() == Place.GUEST) {
                runInGuest += Math.abs(totalGoals);
            }
            return Math.abs(totalGoals) + (runInGuest > failInGuest ? 0 : 1);
        }
    }
}

enum Position {
    FIRST,
    SECOND
}

enum Place {
    HOME,
    GUEST
}

class Game {
    private final int run;
    private final int fail;
    private final Place place;

    public Game(Place place, int run, int fail) {
        this.place = place;
        this.run = run;
        this.fail = fail;
    }

    public int getDifference() {
        return run - fail;
    }

    public Place getPlace() {
        return place;
    }

    public int getRun() {
        return run;
    }

    public int getFail() {
        return fail;
    }
}
