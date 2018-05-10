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
