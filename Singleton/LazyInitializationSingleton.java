package Singleton;

public class LazyInitializationSingleton {

	private static LazyInitializationSingleton singletonInstance;
	
	private LazyInitializationSingleton() {

	}

	public static LazyInitializationSingleton getInstance() {
		
		if(singletonInstance==null) {
			synchronized (singletonInstance) {
				if(singletonInstance==null) {
					singletonInstance = new LazyInitializationSingleton();
				}
			}
		}
		return singletonInstance;
	}
}
