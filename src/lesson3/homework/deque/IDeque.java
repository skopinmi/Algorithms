package lesson3.homework.deque;

public interface IDeque<E> {
    boolean insertRight(E value);

    E removeLeft();

    boolean insertLeft(E value);

    E removeRight();
}
