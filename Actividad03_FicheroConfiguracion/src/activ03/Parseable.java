package activ03;

public interface Parseable<T> {

    T parseFromMenu();

    T parse(String str);
}
