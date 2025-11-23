package ua.opnu;

import java.util.*;

public class Task {

    public static void main(String[] args) {
    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i + 1 < list.size(); i++) {
            String a = list.get(i);
            String b = list.get(i + 1);

            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i + 1 < list.size(); i += 2) {
            Collections.swap(list, i, i + 1);
        }
    }

    public void removeDuplicates(List<String> list) {
        int i = 0;
        while (i + 1 < list.size()) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) return true;

        int n = queue.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int x = queue.remove();
            queue.add(x);
            stack.push(x);
        }

        boolean ok = true;
        for (int i = 0; i < n; i++) {
            int x = queue.remove();
            int y = stack.pop();
            if (x != y) ok = false;
            queue.add(x);
        }

        return ok;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            int x = queue.remove();
            if (x < 0) {
                stack.push(x);
            } else {
                queue.add(x);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int positives = queue.size() - (n - positivesCount(queue));
        for (int i = 0; i < positives; i++) {
            queue.add(queue.remove());
        }
    }

    private int positivesCount(Queue<Integer> q) {
        int c = 0;
        for (int x : q) if (x >= 0) c++;
        return c;
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> odd = new ArrayDeque<>();
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            int x = queue.remove();
            if (x % 2 == 0) {
                queue.add(x);
            } else {
                odd.addLast(x);
            }
        }

        while (!odd.isEmpty()) {
            queue.add(odd.removeFirst());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s != null) max = Math.max(max, s.length());
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> a = new HashSet<>(list1);
        Set<Integer> b = new HashSet<>(list2);
        a.retainAll(b);
        return a.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> used = new HashSet<>();
        for (String v : map.values()) {
            if (!used.add(v)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> res = new HashMap<>();
        for (var e : map1.entrySet()) {
            String k = e.getKey();
            Integer v = e.getValue();
            if (map2.containsKey(k) && Objects.equals(map2.get(k), v)) {
                res.put(k, v);
            }
        }
        return res;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> res = new HashMap<>();
        for (var e : map.entrySet()) {
            res.putIfAbsent(e.getValue(), e.getKey());
        }
        return res;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : map.values()) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        int bestValue = Integer.MAX_VALUE;
        int bestFreq = Integer.MAX_VALUE;

        for (var e : freq.entrySet()) {
            int value = e.getKey();
            int count = e.getValue();
            if (count < bestFreq || (count == bestFreq && value < bestValue)) {
                bestFreq = count;
                bestValue = value;
            }
        }

        return bestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (int x : list) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > max) max = f;
        }
        return max;
    }
}

