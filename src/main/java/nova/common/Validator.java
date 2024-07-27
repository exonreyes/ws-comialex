package nova.common;

public interface Validator<K,T>{
    K isValid(T t);
}
