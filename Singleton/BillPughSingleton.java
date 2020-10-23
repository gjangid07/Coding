package Singleton;

public class BillPughSingleton {

	private BillPughSingleton() {

	}

	public static BillPughSingleton getInstance() {
		return BillPughSingleton.innerHelper.singletonInstance;
	}

	private static class innerHelper {
		private static BillPughSingleton singletonInstance = new BillPughSingleton();;

	}
}
