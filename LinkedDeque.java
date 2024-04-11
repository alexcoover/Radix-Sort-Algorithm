/**
 * The class defines the node-based queue
 * @author Alex Coover
 * @param <Type> the generic data type
 */
public class LinkedDeque<Type>
extends LinkedQueue<Type>
implements Deque<Type>
{
	/**
	 * The constructor initializes an empty queue.
	 */

	
	public LinkedDeque()
	{
		size = 0;
		head = null;
	}
	
	@Override
	public void addRear(Type data)
	{
		if (data == null) throw new NullPointerException();
		super.add(data);
	}

	@Override
	public void addFront(Type theElement)
	{
		if (theElement == null) throw new NullPointerException();
		if (size == 0) {//case for empty
			super.add(theElement);
		} else {//make new node head
			Node temp = new Node(theElement);
			temp.next = head;
			head = temp;			
			size++;	
		}	
	}

	@Override
	public Type removeRear()
	{
		if (size == 0)//case for empty queue
			throw new EmptyCollectionException("queue");
		if (size == 1) {//case for single node
	        Type removedData = head.data;
	        head = null;
	        size--;
	        return removedData;
		}
		Deque<Type> newDeq = new LinkedDeque<>();
		Node temp = head;
		while (temp.next.next != null) {//find new last node
			temp = temp.next;	
		}
		final Type fin = temp.next.data;//former tail value to return
		while (!this.isEmpty()) {//copy queue to temp queue
			newDeq.add(this.remove());
		}
		int deqSize = newDeq.size();
		for (int i = 2; i < deqSize; i++) {//add all but tail to original queue
			this.add(newDeq.remove());
		}
		this.add(temp.data);//add new tail
		return fin;
	}

	@Override
	public Type removeFront()
	{
		return super.remove();
	}

	@Override
	public Type peekRear()
	{
		if (size == 0)
			throw new EmptyCollectionException("queue");
		Node temp = head;
		for (int i = 1; i < size; i++) {//find tail
			temp = temp.next;
		}
		final Type value = temp.data;
		return value;
	}

	@Override
	public Type peekFront()
	{
		return super.peek();
	}

}
