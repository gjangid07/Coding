package Singleton;

public class EagerInitializationSingleton {

	private static final EagerInitializationSingleton singletonInstance = 
			new EagerInitializationSingleton();

	private EagerInitializationSingleton() {

	}

	public static EagerInitializationSingleton getInstance() {
		return singletonInstance;
	}
}
