public class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public Solution() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int number){
        //push to min stack if smaller or equal to cur min
        if(minStack.empty() || number <= minStack.peek()){
            minStack.push(number);
        }
        stack.push(number);
    }

    public int pop(){
        int number = stack.pop();
        if( number == minStack.peek()){
            minStack.pop();
        }
        
        return number;
    }

    public int min() {
        return minStack.peek();
    }
}


