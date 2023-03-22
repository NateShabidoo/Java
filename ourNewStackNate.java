import java.util.*;
public class ourNewStackNate<T> {
	private Object[] value; // store Objects in Stack
	private int currentSize; // how many Objects are in Stack
	private int limitation; // maximum capacity
	private int index; // last Object in Stack
	private static int initialCapacity = 10;


  public ourNewStackNate() {
    currentSize = 0;
    index = 0;
    value = new Object[initialCapacity];
    limitation = initialCapacity;
  }

   // If user give negative size, set capacity to initialCapacity
	public ourNewStackNate(int s) {
		if(s <= 0)
			s = initialCapacity;
		value = new Object[s];
      limitation = s; // limitation is value.length
      currentSize = 0;
      index = 0;
	}

   // Insert a new item into the stack.
	public void push(T item) {
		if(currentSize == limitation) {
			System.out.println("stack is full, no push");
			return;
		}
		value[index] = item; //array name is value
		++index;
		++currentSize;
	}

   // Remove the most recently inserted (last item) from the stack
	public Object pop() {
		if(currentSize == 0) {
			System.out.println("empty stack, no pop");
         //throw new EmptyStackException();
         return null;
		}
      --index;
      Object lastItem = value[index];
      //value[index] = null; // delete from stack
      --currentSize;
      return lastItem;
	}

   // Return current size of stack
	public int getSize() {
		return currentSize;
	}

   // Peeks the most recently added item (last item)
	public Object peek() {
 		if(currentSize == 0) {
 			System.out.println("empty stack, no peek");
         //throw new EmptyStackException();
         return null;
 		}
 		return value[index - 1];
 	}

	public static void main(String[] args) {
    ourNewStackNate<Integer> xBox = new ourNewStackNate<>();
		xBox.push(100);
		xBox.push(200);
		xBox.push(300);
		while(xBox.getSize() > 0) {
			System.out.println(xBox.pop());
		}

        ourNewStackNate<String> yBox = new ourNewStackNate<>(3);
    		String tmp = (String)yBox.peek();
    		yBox.push("AAA");
    		yBox.push("BBB");
    		yBox.push("CCC");
    		yBox.push("DDD");
    		System.out.println(yBox.peek());
    		System.out.println(yBox.pop());
    		System.out.println(yBox.pop());
  	   }
   }
