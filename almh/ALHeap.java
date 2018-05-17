/*****************************************************
* class ALHeap
* Implements a min heap using an ArrayList as underlying container
*****************************************************/

import java.util.ArrayList;

public class ALHeap {

//instance vars
private ArrayList<Integer> _heap;

/*****************************************************
* default constructor  ---  inits empty heap
*****************************************************/
public ALHeap() {
        _heap = new ArrayList<Integer>();
}


/*****************************************************
* toString()  ---  overrides inherited method
* Returns either
* a) a level-order traversal of the tree (simple version)
   -> current version implemented
* b) ASCII representation of the tree (more complicated, more fun)
*****************************************************/
public String toString() {
        String str = "[ ";
        for (Integer i : _heap) {
                str += i + " ";
        }
        str += "]";
        return str;

}    //O(n)


/*****************************************************
* boolean isEmpty()
* Returns true if no meaningful elements in heap, false otherwise
* changed by add and remove methods
*****************************************************/
public boolean isEmpty() {
        return (_heap.size() == 0);
}    //O(1)


/*****************************************************
* Integer peekMin()
* Returns min value in heap
* Postcondition: Heap remains unchanged.
* first value of _heap must be min value
*****************************************************/
public Integer peekMin() {
        return _heap.get(0);
}    //O(1)


/*****************************************************
* add(Integer)
* Inserts an element in the heap
* Postcondition: Tree exhibits heap property.

   algo:
   1) set addVal in the next available slot (ie. succeeding pos in a level order traversal).increment size
   2)if addVal<parent, swap with parent.
   3) continue swapping until minheap properties satisfied

   LC(p) = 2p+1
   RC(p) = 2p+2
   where p is index of parent node and each is either left or right child

   also useful:
   - right children have even indices
   - left children have odd indices
*****************************************************/
public void add( Integer addVal )
{
        int i; // initial index
        int par; // initial parent index

        // add addVal to heap and initialize
        _heap.add(addVal);
        i = _heap.size() - 1;

        //root
        if (i == 0) {
                return;
        } else if (i % 2 == 0) {
                par = (i - 2) / 2;
        } else {
                par = (i - 1) / 2;
        }

        //see if smaller than parent
        while (par >= 0 && par < _heap.size() && _heap.get(i) < _heap.get(par)) {

                //right child
                if (i % 2 == 0) {
                        swap(i, par);
                        i = par;
                        par = ((par - 2) / 2);
                }
                //left child
                else {
                        swap(i, par);
                        i = par;
                        par = ((par - 1) / 2);
                }
        }


}    //O(1)ish


/*****************************************************
* removeMin()  ---  means of removing an element from heap
   Algo:
   1) If there is no root, return null. If there is a root and nothing else, remove and return the root.
   2) Tracking the min (which would be the root at the start), find the smaller of the two children. Swap the min with the child.
   3) Repeat step 2 until there are no children below the min.
   4) Remove and return the min.
* Removes and returns least element in heap.
* Postcondition: Tree maintains heap property.
*****************************************************/
public Integer removeMin()
{
        //no root
        if (_heap.size() == 0)
                return null;
        // Only root remains
        if (minChildPos(0) == -1)
                return _heap.remove(0);
        int pos = 0; //keep a marker on the min, which is the root at first
        int minChildPos = minChildPos(0);
        // swap the min with the smaller child until there are no children left to swap with
        while (minChildPos != -1) {
                swap(pos,minChildPos);
                pos = minChildPos;
                //System.out.println(pos);
                minChildPos = minChildPos(pos);
        }
        return _heap.remove(pos);
}    //O(1)ish


/*****************************************************
* minChildPos(int)  ---  helper fxn for removeMin()
* Returns index of least child, or
* -1 if no children, or if input pos is not in ArrayList
* Postcondition: Tree unchanged
*****************************************************/
private int minChildPos( int pos ) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        if (left >= _heap.size())
                return -1;
        else if (left == _heap.size() -1 || _heap.get(left) >= _heap.get(right))
                return left;
        return right;
}    //O(?)


//************ aux helper fxns ***************
private Integer minOf(Integer a, Integer b) {
        if (a.compareTo(b) < 0)
                return a;
        else
                return b;
}

//swap for an ArrayList
private void swap(int pos1, int pos2) {
        _heap.set(pos1, _heap.set(pos2, _heap.get(pos1)));
}
//********************************************


//main method for testing
public static void main(String[] args) {

        ALHeap pile = new ALHeap();

        pile.add(2);
        System.out.println(pile);
        pile.add(4);
        System.out.println(pile);
        pile.add(6);
        System.out.println(pile);
        pile.add(8);
        System.out.println(pile);
        pile.add(10);
        System.out.println(pile);
        pile.add(1);
        System.out.println(pile);
        pile.add(3);
        System.out.println(pile);
        pile.add(5);
        System.out.println(pile);
        pile.add(7);
        System.out.println(pile);
        pile.add(9);
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        System.out.println("removing " + pile.removeMin() + "...");
        System.out.println(pile);
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}    //end main()

}//end class ALHeap
