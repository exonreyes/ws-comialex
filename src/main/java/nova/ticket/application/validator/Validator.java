package nova.ticket.application.validator;

public interface Validator<K,T>{
    K isValid(T obj);
}
