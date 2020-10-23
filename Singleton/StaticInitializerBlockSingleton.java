package Singleton;

public class StaticInitializerBlockSingleton {

	private static StaticInitializerBlockSingleton singletonInstance;

	static {
		try {
			singletonInstance = new StaticInitializerBlockSingleton();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private StaticInitializerBlockSingleton() {

	}

	public static StaticInitializerBlockSingleton getInstance() {
		return singletonInstance;
	}

}
