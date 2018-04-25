package search;

public class Search {

    public int longestWord(StringList a) {
        int pos = 0;
        int i = 1;
        String longest = a.get(pos);
        String current;

        /*
        Invariant: 1 ≤ i ≤ n, longest is longest word of a[0] ... a[i-1]
        and pos is the position of longest.
         */
        
        while (i < a.size()) {
            current = a.get(i);
            if (current.length() > longest.length()) {
                pos = i;
                longest = current;
            }
            i++;
        }
        return pos;
    }

    public int countUnique(StringList a) {
        String prev = a.get(0);
        String current;
        int unique = 1;
        int i = 1;

        /*
        Invariant: 0 ≤ i ≤ n and unique = number of unique elements
        from a[0] ... a[i-1]
         */
        
        while (i < a.size()) {
            current = a.get(i);
            if (!current.equals(prev)) {
                unique++;
            }
            i++;
            prev = current;
        }
        return unique;
    }

    public String mostFrequent(StringList a) {
        int i = 1;
        int freq = 1;
        int mostFrequentIndex = 0;
        int mostFrequent = 0;

        String popular;
        String current;
        String prev = a.get(i - 1);
        
        /*
        Invariant: 0 ≤ i ≤ n and freq = frequency of the current word being 
        checked. mostFrequent is the frequency of the most frequent word from a[0]...a[i].
        mostFrequentIndex is the index of said word.
         */

        while (i < a.size()) {
            current = a.get(i);
            if (current.equals(prev)) {
                freq++;
            } else {
                if (freq > mostFrequent) {
                    mostFrequent = freq;
                    mostFrequentIndex = i - 1;
                }
                freq = 1;
            }
            prev = current;
            i++;
        }
        popular = a.get(mostFrequentIndex);
        return popular;
    }

    public int findElement(StringList a, String k) {
        int low = 0;
        int high = a.size() - 1;
        int mid;
        String current;

        /*
        invariant: 0 ≤ low ≤ high+1 ≤ n and a[0..low-1] < k < a[high+1..n-1]
        */
        
        while (low <= high) {
            mid = (high + low) / 2;
            current = a.get(mid);
            if (current.equals(k)) {
                return mid;
            } else if (current.compareTo(k) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int countGreaterOrEqual(StringList a, String k) {
        int low = 0;
        int high = a.size() - 1;
        int mid;

        /*
        invariant: 0 ≤ low ≤ high+1 ≤ n and a[0..low-1] < k ≤ a[high+1..n-1]
        */
        
        while (low <= high) {
            mid = (high + low) / 2;
            if (a.get(mid).compareTo(k) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return a.size() - low;
    }

    public int countGreater(StringList a, String k) {
        int low = 0;
        int high = a.size() - 1;
        int mid;
        
        /*
        invariant: 0 ≤ low ≤ high+1 ≤ n and a[0..low-1] < k ≤ a[high+1..n-1]
        */

        while (low <= high) {
            mid = (high + low) / 2;
            if (a.get(mid).compareTo(k) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return a.size() - low;
    }

    public int countBetween(StringList a, String k1, String k2) {
        int low = 0;
        int high = a.size() - 1;
        int mid;

        /*
        invariant: 0 ≤ low ≤ high+1 ≤ n and a[0..low-1] < k1 < a[high+1..n-1]
        */
        
        while (low <= high) {
            mid = (high + low) / 2;
            if (a.get(mid).compareTo(k1) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int k1Pos = low;

        low = 0;
        high = a.size() - 1;
        
        /*
        invariant: 0 ≤ low ≤ high+1 ≤ n and a[0..low-1] < k2 < a[high+1..n-1]
        */
        
        while (low <= high) {
            mid = (high + low) / 2;
            if (a.get(mid).compareTo(k2) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int k2Pos = low;

        return k2Pos - k1Pos;
    }

    public int countMatches(StringList a, String prefix, String substring) {
        int matches = 0;
        
        /*
        invariant: 0 ≤ low ≤ high+1 ≤ n and a[0..low-1] < prefix < a[high+1..n-1]
        */

        int low = 0;
        int high = a.size() - 1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (a.get(mid).compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        boolean flag = true;
        String current;

        /*
        invariant: 0 ≤ low ≤ n and matches = number of matches from a[low] to a[n-1]
        */
        
        while (flag && low < a.size()) {
            current = a.get(low);
            if (current.startsWith(prefix)) {
                if (current.contains(substring)) {
                    matches++;
                }
            } else {
                flag = false;
            }
            low++;
        }

        return matches;
    }
}
