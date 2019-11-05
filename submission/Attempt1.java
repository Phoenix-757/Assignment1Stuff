
import asgoffering.ListADT;

import asgsupplements.IllegalGetException;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author
 * @version
 */
public class Attempt1 implements ListADT {

	private static int head;
	private static int tail;
	private static int curr;
	private static char[] list;

	public Attempt1() {
		head = 0;
		tail = 0;
		curr = 0;
		list = new char[tail];
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Character get() throws IllegalGetException {
		if (curr == tail) {
			throw new IllegalGetException();
		} else {
			return list[curr];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Character[] getElements() {
		Character[] val = new Character[getNumElts()];
		Attempt1 temp = new Attempt1();
		temp = this;
		temp.moveToFirst();
		for (int i = 0; i < getNumElts(); i++) {
			val[i] = temp.get();
			temp.next();
		}
		return val;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getNumElts() {
		int count = 0;
		for (int i = 0; i < tail; i++) {
			if (list[i] != '\u0000') {
				count++;
			}
		}
		return count;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getPosition() { // @TODO 
		return curr;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListADT insert(Character c) {
		if (getNumElts() == tail) {
			resize(tail + 1);
		}
		for (int i = tail - 1; i + 1 > curr; i--) {
			list[i+1] = list[i];
		}
		
		list[curr] = c;
		tail++;
		return this;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveToFirst() {
		curr = head;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean next() {
		if (curr != tail) {
			curr++;
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean prev() {
		if (curr != head) {
			curr--;
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListADT remove() {
		if (curr == tail) {
			return this;
		}
		if (curr == tail - 1) {
			resize(getNumElts() - 1);
		}
		else 
		{
			for (int i = curr; i < tail - 1; i++) {
				list[i] = list[i + 1];
			}
			resize(getNumElts() - 1);
			resize(getNumElts() + 1);
			tail = getNumElts();
			}
		return this;
	}

	public ListADT resize(int c) {
		char[] newList = new char[c];
		if (c <= tail) {
			for (int i = 0; i < c; i++) {
				newList[i] = list[i];
			}
			if (curr > c) {
				curr = c;
			}
		}
		else 
		{
			for (int i = 0; i < tail; i++) {
				newList[i] = list[i];
			}
		}
		
		list = newList;
		tail = getNumElts();
		
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return asgsupplements.Lutil.stringOf(this);
	}
	
	public static void main(String[] args) {
		Attempt1 test = new Attempt1();

		System.out.println("Num Elts: " + test.getNumElts());
		System.out.println("Tail: " + test.tail);
		System.out.println("Current: " + test.curr);
		System.out.println("Position: " + test.getPosition());
		//System.out.println(test.toString());
		
		
		System.out.println("- - - - - - - - - - -");
		test.insert('a');
		
		System.out.println("Num Elts: " + test.getNumElts());
		System.out.println("Tail: " + test.tail);
		System.out.println("Current: " + test.curr);
		System.out.println("Position: " + test.getPosition());
		//System.out.println(test);
		
		System.out.println("- - - - - - - - - - -");
		test.insert('b');
		
		System.out.println("Num Elts: " + test.getNumElts());
		System.out.println("Tail: " + test.tail);
		System.out.println("Current: " + test.curr);
		System.out.println("Position: " + test.getPosition());
		//System.out.println(test);
		
		System.out.println("- - - - - - - - - - -");
		test.insert('c');
		
		System.out.println("Num Elts: " + test.getNumElts());
		System.out.println("Tail: " + test.tail);
		System.out.println("Current: " + test.curr);
		System.out.println("Position: " + test.getPosition());
		test.next();

		System.out.println(test.toString());
		
		
		System.out.println("- - - - - - - - - - -");
		Character[] blah = test.getElements();
		for (int i = 0; i < blah.length; i++) {
			System.out.println(blah[i]);
		}
	}
}
