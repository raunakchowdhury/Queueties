# Queueties
##Methods and Runtimes
- isEmpty --> O(1)
- add --> O(1)
- removeMin --> amortized runtime O(n), worst case O(n^2)
- peekMin --> O(n)

##Runtimes
- isEmpty checks the size of the AL, so its runtime is constant.
- add has a constant runtime — it adds to the end of the AL.
- peekMin has a O(n) runtime - it cycles through the queue to find the minimum.
- removeMin has a O(n^2) runtime - it cycles through the queue to find the minimum (O(n) operation), and then calls AL's remove method (which has a O(n) amortized runtime).

##Priorities and Plan (ie heap todo)
- First priority is to implement the default constructor and to override the toString method so that we can initialize and visualize a created heap.
- Next steps would be to complete the isEmpty(), add(), and peekMin() methods. Add() is essential to subsequent methods.
- Following that, the next level in priority are the removeMin() and minChildPos() methods. minChildPos() is a helper function for removeMin() and the two should be completed together. 

