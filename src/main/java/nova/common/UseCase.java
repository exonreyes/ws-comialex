package nova.common;

public interface UseCase<K, T> {
    K execute(T params);
}
