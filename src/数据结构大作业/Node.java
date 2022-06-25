package 数据结构大作业;

public class Node<T> extends Dishes {
	public T data;
	public Node<T> next;
	public Node(T data,Node<T> next) {
		this.data=data;
		this.next=next;
	}
	public Node() {
		this(null,null);
	}
	public String toString() {
		return this.data.toString();
	}
}
