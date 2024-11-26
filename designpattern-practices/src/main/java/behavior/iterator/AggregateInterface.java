package behavior.iterator;

public class AggregateInterface<E> implements Aggregate<E> {
	private E[] data = null;
	
	public AggregateInterface(E[] data){
		this.data = data;
	}
	
	public Iterator<E> createIterator() {
		return new IteratorInterface();
	}
	
	private class IteratorInterface implements Iterator<E>{
		private int index = 0;
		
		@Override
		public E next() {
			return index < data.length ? data[index++] : null;
		}

		@Override
		public boolean hasNext() {
			return index < data.length;
		}
		
	}
}
