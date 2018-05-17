import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class RunMed {
private ALHeapMin lilVals;
private ALHeapMax bigVals;

/*****************************************************
* default constructor  ---  inits empty heap
*****************************************************/
public RunMed(){
        lilVals = new ALHeapMin();
        bigVals = new ALHeapMax();
}

/*****************************************************
* algo for getMedian
* if (input < rootMax)
*   max.add(input);
* else
*   min.add(input);
* balanceHeaps(); (sizeDiff < 2)
* if (sizeDiff >= 2)
*   MinSize(max, min).add(MaxSize(max, min).remove());
* if (maxSize == minSize)
*   median = mean(maxRoot, minRoot);
* else
*   median = maxRoot;
*****************************************************/
public double getMedian() {
        double med;
        if (bigVals.size() == 0) //no values in maxHeap
                throw new NoSuchElementException();
        if (bigVals.size() == lilVals.size())
                med = (bigVals.peekMax() + lilVals.peekMin()) / 2.0;
        else
                med = bigVals.peekMax();
        return med;
}

public void add(Integer newVal) {
        if (bigVals.size() == 0) //if this is the first int, just add it
                bigVals.add(newVal);
        else if (newVal < bigVals.peekMax())
                bigVals.add(newVal);
        else
                lilVals.add(newVal);
        balance();
}

public void balance() {
        if (Math.abs(bigVals.size() - lilVals.size()) >= 2) {
                if (lilVals.size() <= bigVals.size())
                        lilVals.add(bigVals.removeMax());
                else
                        bigVals.add(lilVals.removeMin());
        }
}
}
