package ru.yandex.sprint4.slowabstract;

import java.util.ArrayList;
import java.util.List;


public class Solution {


}

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Map<K, V> {
    private List<Pair<K, V>> pairs;

    public Map() {
        pairs = new ArrayList<>();
    }

    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null; // Если пара не найдена, вернем null
    }

    public void set(K key, V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }
        // Если пара с заданным ключом не найдена, добавим новую пару
        Pair<K, V> newPair = new Pair<>(key, value);
        pairs.add(newPair);
    }
}