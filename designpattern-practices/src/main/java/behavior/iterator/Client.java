package behavior.iterator;

public class Client {
	// Iterator Pattern
	public static void main(String[] args) {
		Aggregate<String> fruits = new AggregateInterface<>(new String[] {"Mango","Banana","Apple"});
		
		Iterator<String> it = fruits.createIterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}

}
