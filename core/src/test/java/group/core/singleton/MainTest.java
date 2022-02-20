package group.core.singleton;

public class MainTest {
    public static void main(String[] args) {
        //SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = SingletonService.getInstance();
    }
}
