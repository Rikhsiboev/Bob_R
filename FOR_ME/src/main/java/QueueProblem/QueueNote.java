package QueueProblem;

public class QueueNote <T> {

    T value;
    QueueNote<T> next;

    public QueueNote(T value) {
        this.value = value;
    }
}
