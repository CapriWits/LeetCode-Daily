import java.util.Iterator;

/* 284. Peeking Iterator */
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement; // 保存指针后面下一个元素

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer ret = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}