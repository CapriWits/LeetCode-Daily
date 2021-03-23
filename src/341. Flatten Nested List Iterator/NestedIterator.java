import java.util.*;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * use Stack and Recursion
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0 ; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {    // stack not empty, judge the peek elem's type(List/Integer)
            NestedInteger elem = stack.peek();
            if (elem.isInteger()) {
                return true;
            } else { // peek elem is list, iterate the list to push elem into the stack
                elem = stack.pop();
                List<NestedInteger> list = elem.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
                return hasNext();
            }
        }
    }

}

/**
 * use DFS and Queue
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<Integer> queue = new ArrayDeque<Integer>();

    public NestedIterator(List<NestedInteger> nestedList) {
        DFS(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.pollFirst() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * DFS the nestedList, offer the elements into the queue
     */
    private void DFS(List<NestedInteger> nestedList) {
        for (NestedInteger elem : nestedList) {
            if (elem.isInteger()) { // elem is Integer, offer the queue
                queue.addLast(elem.getInteger());
            } else {    // elem is List, DFS the list and offer the elements into queue
                DFS(elem.getList());
            }
        }
    }

}


/**
 * use Java Iterator
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for (NestedInteger node : nestedList) {
            DFS(node, list);
        }
        this.iterator = list.iterator(); // all the operation use list's iterator
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * DFS get every element into List res;
     */
    private void DFS(NestedInteger node, List<Integer> res) {
        if (node.isInteger()) {
            res.add(node.getInteger());
            return;
        }
        for (NestedInteger child : node.getList()) {
            DFS(child, res);
        }
    }

}

