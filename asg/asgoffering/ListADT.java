package asgoffering;

import asgsupplements.IllegalGetException;

// am+dg
/**
 * ListADT specification.
 * <h1>ListADT</h1>
 * <h3>REQUIRED IMPLEMENTATION CLASS NAME: ListSL</h3>
 * <h2>Objectives</h2>
 * <ul>
 * <li>develop your ability to implement the ListADT using SINGLY Linked
 * Lists</li>
 * <li>improve your ability to write JUnit tests</li>
 * <li>improve your ability to write readable code according to best
 * practices</li>
 * </ul>
 * <h2>Introduction</h2>
 * <p>
 * The ListADT defines the API for a List. It is the same ADT as that of the
 * previous List assignment, except that the notion of a capability and some
 * methods have been removed. Note that a newly created ListADT is empty.
 * </p>
 * <h3>Description</h3>
 * <p>
 * Refer to the notes and book for a description of a list (ch 5.1, 5.2, 5.4).
 * Our ListADT will store Characters. Note that your implementation MUST store
 * Characters and must not use Generics.
 * </p>
 * <h2>Instructions</h2>
 * <p>
 * This assignment has two parts. The first involves developing a list of
 * problem instances / test cases for this ListADT. The second involves
 * developing the tests and the linked list implementation.
 * </p>
 * <h3>Part 1</h3>
 * <ol>
 * <li>You will submit this part to Scholar, Asg2Part1</li>
 * <li>Review your test cases from Asg1Part1.</li>
 * <li>Review the test cases notation given below</li>
 * <li>Using this notation, modify/add to your Asg1Part1 problem instances so
 * that they represent Asg2</li>
 * </ol>
 * <h3>Part 2</h3>
 * <ol>
 * <li>You will submit this part to Web-CAT, Asg2Part2, using the eclipse menu
 * "{@code Project->Submit Assignment...}"</li>
 * <li>Using the test cases you developed in Part 1, write the JUnit tests for
 * the ADT described by this API (you can reuse/modify your tests for Asg1)</li>
 * <li>Review the code in the textbook (Ch 5.4).</li>
 * <li>Implement, using the code in the book as a guide, the ADT described by
 * this API.</li>
 * </ol>
 * <p>
 * To see my comments after I've graded your work, or to see your results at any
 * time, login to http://web-cat.cs.vt.edu
 * </p>
 * <h2>Practical Tips</h2>
 * <p>
 * Follow an incremental development methodology. For example, develop tests for
 * a method, implement the method, run the tests. Do this until the method
 * passes the tests. Go on to the next method.
 * </p>
 * <p>
 * Sometimes you may have to implement a little bit as well in order to write
 * your JUnit tests. The process involves switching between JUnit tests and
 * implementation, in order to develop a good understanding of the problems to
 * be solved.
 * </p>
 * <h2>NOTES & WARNINGS</h2>
 * <ul>
 * <li>Any submission that that uses pre-existing classes (ex. LinkedList,
 * ArrayList) to defeat the purposes of this assignment will receive NO
 * CREDIT.</li>
 * <li>You may submit as many times as you like until the deadline.</li>
 * <li>The grade of your latest submission will be the one recorded.</li>
 * <li>All ADT methods are implemented.</li>
 * <li>Only ADT methods and constructors may be public.</li>
 * <li>Fields used as variables may NOT be declared public.</li>
 * <li>Code is formatted according to CPSC270 standards</li>
 * <li>Javadoc is written for every method</li>
 * <li>Javadoc is written for the implementation class and the test class</li>
 * <li>Javadoc is written for all non-private fields</li>
 * </ul>
 * <hr />
 * <h2>Problem Instances</h2>
 * <p>
 * Problem instances describe the semantics or expected behaviors of a Data
 * Type. This description includes the initial state of the Data Type, the
 * method called, any required parameters, and the expected outcomes (result
 * state, return value, or exception). Here are examples of each of these three
 * outcomes:
 * </p>
 * <h3>Return Value Example</h3>
 * <p>
 * Some problem instances describe a value returned by a method. Suppose that a
 * list's initial state is<code>&lt; a | b &gt;</code>. When the method
 * <code>get()</code> is called on this list, the expected return value would be
 * <code>'b'</code>. Here is the notation that expresses this problem instance:
 * </p>
 * 
 * <pre>
 * {@code < a | b >.get() == b}
 * </pre>
 * <p>
 * So a problem that maps the state of a data type to a return value is
 * indicated with an "equals" (<code>==</code>):
 * </p>
 * 
 * <pre>
 * {@code DataTypeState.Method(Parameters) == ReturnValue }
 * </pre>
 * 
 * <h3>Result State Example</h3>
 * <p>
 * Some problem instances describe the state of a Data Type after a method call.
 * Suppose that a list's initial state is {@code < a | > }. When the method
 * <code>add('c')</code> is called, the expected result state would be
 * {@code < a | c >}. Here is the notation that expresses this problem instance:
 * </p>
 * 
 * <pre>
 * {@code < a | >.add(c) -> < a | c >}
 * </pre>
 * <p>
 * So a problem that maps the state of a data type to a result state is
 * indicated with an "arrow" ({@code ->}):
 * </p>
 * 
 * <pre>
 * {@code DataTypeState.Method(Parameters) -> ResultState }
 * </pre>
 * 
 * <h3>Exception Example</h3>
 * <p>
 * Some problem instances describe illegal behavior. Suppose that a list's
 * initial state is{@code < | > }(i.e., empty) and the method is
 * <code>get()</code>. Because it is not possible to get from an empty list, the
 * expected outcome is an exception. Here is the notation that expresses this
 * problem instance:
 * </p>
 * 
 * <pre>
 *  {@code < | >.get() !! IllegalGetException }
 * </pre>
 * <p>
 * Thus a problem that maps the state of a data type to an exception is
 * indicated with a "doublebang" (<code>!!</code>):
 * </p>
 * 
 * <pre>
 * {@code DataTypeState.Method(Parameters) !! Exception }
 * </pre>
 * 
 * <h3>Problem Instance as a JUnit Method</h3>
 * <p>
 * Because a problem instance describes the semantics of a method call, a
 * problem instance can be used to represent a test case. In turn, the test case
 * is implemented as a single JUnit test method. For example, the code below is
 * a JUnit method that could be written to implement the return value problem
 * instance example above:
 * </p>
 * 
 * <pre>
 * {@code @Test}
 * public void doesGetOnAcBReturnB() {
 *     List l = new SomeListImplementation();
 *     l.add('a');
 *     l.next();
 *     Character expected = 'b';
 *     l.add(expected);
 *     Character actual = l.get();
 *     assertEquals(expected, actual);
 * }
 * </pre>
 * <p>
 * The code below is a JUnit method that could be written to implement the
 * result state problem instance example above:
 * </p>
 * 
 * <pre>
 * {@code @Test}
 * public void doesGetOnAcBReturnB() {
 *     List l = new SomeListImplementation();
 *     Character original = 'a';
 *     l.add(original);
 *     l.next();
 *     Character expected = 'c';
 *     l.add(expected);
 *     Character actual = l.get();
 *     assertEquals(expected, actual);
 *     l.prev();
 *     actual = l.get();
 *     assertEquals(original, actual);
 * }
 * </pre>
 * <p>
 * The code below is a JUnit method that could be written to implement the
 * exception problem instance example above. Note that the
 * {@code @Rule public...} statement is done ONLY ONCE and must occur before any
 * test methods.
 * </p>
 * 
 * <pre>
 * {@code @Rule public ExpectedException thrown = ExpectedException.none(); }
 * {@code @Test }
 * public void getOfEmptyShouldThrowIllegalGet() throws IllegalGetException {
 *     ListADT l = new SomeListImplementation();
 *     thrown.expect(IllegalGetException.class);
 *     l.get();
 * }
 * </pre>
 * 
 * <h3>Problem Instance Group as a JUnit class</h3>
 * <p>
 * You should group your problem instances by their common purpose. For example,
 * you might have several problem instances that describe valid return values.
 * You would group them using a class-like syntax. A group of problem instances
 * thus comprise a collection of related test cases.
 * </p>
 * 
 * <pre>
 * tests TestValuesReturnedByGet {
 * {@code    < a | b >.get() == b}
 * {@code    < | a , b >.get() == a}
 * }
 * </pre>
 * <p>
 * This group of test cases is called a test category. It corresponds to a JUnit
 * class. Here is a JUnit class that would correspond to the test category
 * above:
 * </p>
 * 
 * <pre>
 * public class TestValuesReturnedByGet {

 *     {@code @Test }
 *     public void doesGetOnAcBReturnB() {
 *         List l = new SomeListImplementation();
 *         l.add('b');
 *         l.add('a');
 *         l.next();
 *         Character expected = 'b';
 *         Character actual = l.get();
 *         assertEquals(expected, actual);
 *     }
 *     
 *     {@code @Test }
 *     public void doesGetOncABReturnA() {
 *         List l = new SomeListImplementation();
 *         l.add('b');
 *         Character expected = 'a';
 *         l.add(expected);
 *         Character actual = l.get();
 *         assertEquals(expected, actual);
 *     }
 *     
 * }
 * </pre>
 * 
 * @author acsiochi
 * @version 20191022
 */
public interface ListADT {

    /**
     * <p>
     * get the current character. If it is not possible to get the current
     * character, throw an IllegalGetException.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b | a >
     *  When Character val = bl.get()
     *  Then val == 'a'
     * }
     * </pre>
     * 
     * @return the character at the current position
     * @throws IllegalGetException
     *             when not possible to get()
     */
    public Character get()
        throws IllegalGetException;


    /**
     * <p>
     * get the elements of the list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b | a >
     *  When Character[] val = bl.getElements()
     *  Then val == { b, a }
     * }
     * </pre>
     * 
     * @return an array of the elements in this list.
     */
    public Character[] getElements();


    /**
     * <p>
     * get the number of elements in the list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < | b , a >
     *  When int val = bl.getNumElts()
     *  Then val == 2
     *  
     * Given ListADT bl == < | >
     *  When int val = bl.getNumElts()
     *  Then val == 0
     * }
     * </pre>
     * 
     * @return the number of elements of this ListADT.
     */
    public Integer getNumElts();


    /**
     * <p>
     * get the current position of the list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b | a >
     *  When int val = bl.getPosition()
     *  Then val == 1
     * }
     * </pre>
     * 
     * @return the current position of this ListADT.
     */
    public Integer getPosition();


    /**
     * <p>
     * insert c into this ListADT at the current position. See chapter 5 for
     * details on the insert operation.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b | a >
     *  When bl.insert('x')
     *  Then bl == < b | x , a >
     * }
     * </pre>
     *
     * @param c
     *            Character to be inserted
     * @return this object's address (return this;)
     */
    public ListADT insert(Character c);


    /**
     * <p>
     * move the current position to position 0 (the first position) of the list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b , a | >
     *  When bl.moveToFirst()
     *  Then bl.get() == 'b'
     *   And bl.getPosition() == 0
     * }
     * </pre>
     */
    public void moveToFirst();


    /**
     * <p>
     * Move the current position one spot closer to the tail of the list. If it
     * is not possible to move to the next position, leave the list as it is (do
     * nothing) and return false.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < | b , a >
     *  When bl.next()
     *  Then bl.get() == 'a'
     *   And bl.getPosition() == 1
     * }
     * </pre>
     * 
     * @return true if succeeded, false otherwise
     */
    public Boolean next();


    /**
     * <p>
     * move the current position one spot closer to the head of the list. If it
     * is not possible to move to the previous position, leave the list as it is
     * (do nothing) and return false.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b , a | >
     *  When bl.prev()
     *  Then bl.get() == 'a'
     *   And bl.getPosition() == 1
     * }
     * </pre>
     * 
     * @return true if succeeded, false otherwise
     */
    public Boolean prev();


    /**
     * <p>
     * remove the current element from this ListADT. See chapter 5 for details
     * on the remove operation. If it is not possible to remove the current
     * element, then leave the list alone (do nothing).
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code
     * Given ListADT bl == < b | a >
     *  When bl.remove()
     *  Then bl == < b | >
     *  }
     * </pre>
     * 
     * @return this object's address (return this;)
     */
    public ListADT remove();


    /**
     * <p>
     * toString gets a String representing the position and contents of this
     * ListADT. Notation is that of Chapter 5. Type the following as the
     * implementation of this method:
     * </p>
     * 
     * <pre>
     * 
     * /**
     *  * {&#64;inheritDoc}
     * &#42;/
     * &#64;Override
     * public String toString() {
     *     return asString();
     * }
     * </pre>
     * 
     * <h3>Example</h3>
     * 
     * <pre>
     * {@code Given ListADT bl = new CharList(); }
     *   And bl.add('a');
     *  When String res = bl.toString();
     *  Then res == {@code "< | a >" }
     * </pre>
     * 
     * @return string representation of this ListADT
     */
    public String toString();

}
