class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqByChar = new HashMap<>();

        Queue<Character> maxHeap = new PriorityQueue<>( 
            (a, b) -> Integer.compare(freqByChar.get(b), freqByChar.get(a))
        );
        Deque<Character> waitedKeys = new ArrayDeque<>(n+1);

        for (char c : tasks) {
            freqByChar.merge(c, 1, Integer::sum);
        }

        for (Character c : freqByChar.keySet()) {
            maxHeap.add(c);
        }

        int cnt = 0;

        while (!freqByChar.isEmpty()) {
            if (!maxHeap.isEmpty()) {
                Character el = maxHeap.poll();
                freqByChar.put(el, freqByChar.get(el) - 1);

                if (freqByChar.get(el) == 0) {
                    freqByChar.remove(el);
                    waitedKeys.add('?');
                }
                else {
                    waitedKeys.add(el);
                }
            }
            else {
                waitedKeys.add('?');
            }

            if (waitedKeys.size() == n+1) {
                Character key = waitedKeys.poll();
                if (key != '?') {
                    maxHeap.add(key);
                }
            }

            cnt++;
        }
        return cnt;
    }
}

// n logn

// Map freqByChar
// custom Comparator
// maxHeap по freq

// достаем элемент из maxHeap и кладем на проц (cnt++)
// freqByChar(el)--
// если 0, удаляем ключ
// если >0, кладем в очередь капасити n

// если очередь сейчас размера n

// приоритет по встречаемости, т.е. нужна maxHeap по встречаемости
// первой обрабатываем наиболее встречаемую задачу
// да


// этот ключ нужно вернуть в maxHeap не раньше чем через n операций
// то есть
// после каждой операции смотрим в очередь
// если там 