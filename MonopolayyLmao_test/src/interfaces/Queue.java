package interfaces;

public interface Queue {
    public void enqueue(int object);
    public Object dequeue();
    public int front();
    public int size();
    public void fill();
}
