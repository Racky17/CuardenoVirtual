package Lab_4_LeetCode;

import java.util.TreeMap;

public class Cola {

    //problema 1. N°933. Number of Recent Calls.

    public class RecentCounter {

        TreeMap<Integer, Integer> tm;

        public RecentCounter() {
            tm = new TreeMap<>();
        }

        public int ping(int t) {
            tm.put(t, 1 + tm.size());
            return tm.tailMap(t - 3000).size();
        }
    }

    // problema 2. N°2073. Time Needed to Buy Tickets.

    

}