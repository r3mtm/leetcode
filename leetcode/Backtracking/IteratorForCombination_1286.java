/*

TAGS={Backtracking, Design}

1286. Iterator for Combination


Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.

*/

class CombinationIterator {

    Queue<String> combinations;
    int index = 0;
    
    public CombinationIterator(String characters, int combinationLength) {
        combinations = new LinkedList<String>();
        generateAll(characters, combinationLength, "", 0);
    }
    
    public String next() {
        return combinations.poll();
    }
    
    public boolean hasNext() {
        return !combinations.isEmpty();
    }
    
    public void generateAll(String characters, int combinationLength, String now, int index) {
        
        if (now.length() == combinationLength) {
            combinations.add(now);
            return;
        }
        
        for (int i = index; i < characters.length(); ++i) {
            generateAll(characters, combinationLength, now + characters.charAt(i), i + 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */