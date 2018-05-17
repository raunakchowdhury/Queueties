# Queueties
## Methods and Runtimes
- isEmpty --> O(1)
- add --> O(1)
- removeMin --> amortized runtime O(n), worst case O(n^2)
- peekMin --> O(n)

## Runtimes
- isEmpty checks the size of the AL, so its runtime is constant.
- add has a constant runtime — it adds to the end of the AL.
- peekMin has a O(n) runtime - it cycles through the queue to find the minimum.
- removeMin has a O(n^2) runtime - it cycles through the queue to find the minimum (O(n) operation), and then calls AL's remove method (which has a O(n) amortized runtime).

## Priorities and Plan (ie heap todo)
- First priority is to implement the default constructor and to override the toString method so that we can initialize and visualize a created heap.
- Next steps would be to complete the isEmpty(), add(), and peekMin() methods. Add() is essential to subsequent methods.
- Following that, the next level in priority are the removeMin() and minChildPos() methods. minChildPos() is a helper function for removeMin() and the two should be completed together. 

## Here is the workflow/logic that we followed to implement each method (#2)
- The constructor was merely an initialization of an ArrayList with Integer objects.
- The toString() printed out a level-order traversal of the tree (ie. printed out elements of _heap one by one).
- For isEmpty() this group decided to use the size() method available for ArrayLists.
- peekMin() took advantage of the fact that the minimum value in a minheap is at index 0.
- add() was a little more complicated. In order to complete this method, the group had to recall that the poistion of the left child is 2(parent's index)+1 and 2(parent's index)+2. Each added value had to be compared with its parents and was swapped upwards until minheap properties satisfied.
- removeMin() relied heavily on minChildPos() and thus, minChildPos() had to be implemented first.
- the thinking and working was shared equally among team members. 

## Side Note 
- You might notice that there are four contributors for this repository. This is because AK was operating on her father's account so just so you know, there's nothing funky going on. Everything is under control. 
