package ru.yandex.sprint4.finaltz.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

// Номер посылки: 103733072
// Посылка: https://contest.yandex.ru/contest/24414/run-report/103733072/
// A. Поисковая система
// https://contest.yandex.ru/contest/24414/problems/A/
/*
-- ПРИНЦИП РАБОТЫ --
Составляем Поисковый индекс:
Слова-> {Слово->{документ, релевантность}}

Создаем Set с запросами:
Запросы->{Запрос}

Перебираем Запросы -> В поисковом индексе находим документ и его релевантность -> Сортируем по релевантности и документу
Получается отсортированная структура
Запрос -> {документ, релевантность}

При выводе ограничиваем документы

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 n - количество документов, m -число запросов.
 Построение индекса - О(n).
 Построение запросов - О(m).
 Поиск - O(m)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для построения поискового индекса и хранения запросов требуется О(n+m) памяти
 */

public class Solution {

    private static final int DOCUMENTS_LIMIT = 5;

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }


    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int documentCount = Integer.parseInt(reader.readLine());
            String[] documents = new String[documentCount];
            for (int i = 0; i < documentCount; i++) {
                documents[i] = reader.readLine();
            }

            int requestCount = Integer.parseInt(reader.readLine());
            String[] requests = new String[requestCount];
            for (int i = 0; i < requestCount; i++) {
                requests[i] = reader.readLine();
            }

            runSearch(documents, requests);
        }
    }

    private void runSearch(String[] documents, String[] reqs) {
        // Поисковый индекс
        SearchIndex searchIndex = new SearchIndex();
        for (int i = 0; i < documents.length; i++) {
            StringTokenizer stz = new StringTokenizer(documents[i]);
            while (stz.hasMoreTokens()) {
                searchIndex.addWord(stz.nextToken(), i);
            }
        }

        // Запросы
        Request request = new Request();
        int i = 0;
        for (String req : reqs) {
            StringTokenizer stz = new StringTokenizer(req);
            while (stz.hasMoreTokens()) {
                request.addRequest(i, stz.nextToken());
            }
            i++;
        }

        // Поиск по строкам запросов
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < request.getSize(); j++) {
            // Релевантность документа для всех запросов в строке
            DocumentRelevanceStorage documentRelevanceStorage = new DocumentRelevanceStorage();
            request.getRowRequests(j).forEach((searchWord) -> {
                Map<Integer, Integer> docs = searchIndex.search(searchWord);
                docs.forEach(documentRelevanceStorage::addRelevance);
            });
            sb.append(documentRelevanceStorage.getDocRelevance(DOCUMENTS_LIMIT)).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}

class Request {

    Map<Integer, Set<String>> requests;

    public Request() {
        requests = new HashMap<>();
    }

    public int getSize() {
        return requests.size();
    }

    public Set<String> getRowRequests(int key) {
        return requests.getOrDefault(key, null);
    }

    public void addRequest(int row, String word) {
        Set<String> rowRequests = requests.getOrDefault(row, new HashSet<>() {{
            add(word);
        }});
        rowRequests.add(word);
        requests.put(row, rowRequests);
    }
}

class SearchIndex {
    private final Map<String, Map<Integer, Integer>> index;

    public SearchIndex() {
        index = new HashMap<>();
    }

    public void addWord(String word, int documentId) {
        Map<Integer, Integer> documentList = index.getOrDefault(word, new HashMap<>());
        int count = documentList.getOrDefault(documentId, 0);
        documentList.put(documentId, ++count);
        index.put(word, documentList);
    }

    public Map<Integer, Integer> search(String word) {
        return index.getOrDefault(word, new HashMap<>());
    }
}

class DocumentRelevanceStorage {
    private final Map<Integer, Integer> mapDocRelevance;

    Comparator<DocRelevance> comparator = (dr1, dr2) -> {
        if (dr1.getRelevance() == dr2.getRelevance()) {
            return dr1.docId - dr2.docId;
        } else {
            return dr2.getRelevance() - dr1.getRelevance();
        }
    };

    public DocumentRelevanceStorage() {
        mapDocRelevance = new TreeMap<>();
    }

    public void addRelevance(int documentId, int count) {
        int relevance = mapDocRelevance.getOrDefault(documentId, 0);
        mapDocRelevance.put(documentId, relevance + count);
    }

    public StringBuilder getDocRelevance(int limit) {
        SortedSet<DocRelevance> docRelevances = new TreeSet<>(comparator);
        mapDocRelevance.forEach((docId, relevance) -> docRelevances.add(new DocRelevance(docId + 1, relevance)));

        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (DocRelevance docRelevance : docRelevances) {
            if (++k > limit) {
                break;
            }
            sb.append(docRelevance.getDocId()).append(" ");
        }
        return sb;
    }
}

class DocRelevance {
    int docId;
    int relevance;

    public DocRelevance(int docId, int relevance) {
        this.docId = docId;
        this.relevance = relevance;
    }

    public int getDocId() {
        return docId;
    }

    public int getRelevance() {
        return relevance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocRelevance)) return false;
        DocRelevance that = (DocRelevance) o;
        return getDocId() == that.getDocId() && getRelevance() == that.getRelevance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocId(), getRelevance());
    }
}
