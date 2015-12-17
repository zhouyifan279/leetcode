import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

	private Integer peekedElement;
	private Iterator<Integer> iter;
	private boolean hasPeeked = false;

	public PeekingIterator(Iterator<Integer> iterator) {
		iter = iterator;
	}

	public Integer peek() {
		if (!hasPeeked) {
			peekedElement = iter.next();
			hasPeeked = true;
		}

		return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (!hasPeeked) {
			return iter.next();
		}

		Integer result = peekedElement;
		hasPeeked = false;
		peekedElement = null;
		return result;
	}

	@Override
	public boolean hasNext() {
		return hasPeeked || iter.hasNext();
	}

	@Override
	public void remove() {

	}
}