package nova.common;

public interface Executor<K, T> {
    K execute(T t);
}
