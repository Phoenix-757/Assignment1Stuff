import asgoffering.ListADT;
import asgsupplements.IllegalGetException;

public class ListSL implements ListADT {

	private int head;
	private int tail;
	private int curr;
	private Character[] list;
	
	
	public ListSL() {
		head = 0;
		tail = 0;
		curr = 0;
		list = new Character[0];
	}
	
	
	@Override
	public Character get() throws IllegalGetException {
		if (curr == tail) {
			throw new IllegalGetException();
		}
		return list[curr];
	}

	@Override
	public Character[] getElements() {
		Character[] val = new Character[getNumElts()];
		ListSL temp = new ListSL();
		temp = this;
		temp.moveToFirst();
		for (int i = 0; i < getNumElts(); i++) {
			val[i] = temp.get();
			temp.next();
		}
		return val;
	}

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

	@Override
	public Integer getPosition() {
		return curr;
	}

	@Override
	public ListADT insert(Character c) {
		Character[] nList = new Character[tail + 1];
		nList[0] = 'A';
		/**
		for (int i = 0; i < curr; i++) { // copy all values before curr
			nList[i] = list[i];
			System.out.println("Copying before curr (index, value): (" + i + ", " + list[i] + ")");
		}
		nList[curr] = c; // copy value at curr
		System.out.println("Copying at curr (index, value): (" + curr + ", " + c + ")");
		for (int i = curr + 1; i < tail; i++) { // copy all values after curr
			nList[i] = list[i];
			System.out.println("Copying after curr (index, value): (" + i + ", " + list[i] + ")");
		}
		**/
		
		list = nList;
		tail = getNumElts();
		System.out.println("Test " + this.toString());
		
		return this;
	}

	@Override
	public void moveToFirst() {
		curr = 0;
	}

	@Override
	public Boolean next() {
		if (curr != tail) {
			curr++;
			return true;
		}
		return false;
	}

	@Override
	public Boolean prev() {
		if (curr != head) {
			curr--;
			return true;
		}
		return false;
	}

	@Override
	public ListADT remove() {
		Character[] nList = new Character[tail + 1];
		for (int i = 0; i < curr; i++) { // copy all values before curr
			nList[i] = list[i];
			System.out.println("Copying before curr (index, value): (" + i + ", " + list[i] + ")");
		}
		for (int i = curr + 1; i < tail; i++) { // copy all values after curr
			nList[i + 1] = list[i];
			System.out.println("Copying after curr (index, value): (" + i + ", " + list[i] + ")");
		}
		list = nList;
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
		ListSL test = new ListSL();
		test.insert('A');
		test.insert('B');
		System.out.println(test.toString());
		System.out.println(test.tail);
		test.next();
		System.out.println(test.getPosition());
	}
}
