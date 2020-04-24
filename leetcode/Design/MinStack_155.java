/*

155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class MinStack {

    /** initialize your data structure here. */
    List<Integer> list;
    List<Integer> mins;
    int pos;
    public MinStack() {
        list = new ArrayList<Integer>();
        mins = new ArrayList<Integer>();
        pos = -1;
    }
    
    public void push(int x) {
        list.add(x);

        if (pos == -1) {
            mins.add(x);
        } else {
            int min = mins.get(pos);
            if (min < x) {
                mins.add(min);
            } else {
                mins.add(x);
            }
        }
        ++pos;
    }
    
    public void pop() {
        if (pos != -1) {
            list.remove(pos);
            mins.remove(pos);
            --pos;
        }
    }
    
    public int top() {
        return list.get(pos);
    }
    
    public int getMin() {
        return mins.get(pos);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack_155 {
    public static void main (String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
