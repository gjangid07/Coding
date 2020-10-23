package Arrays;

import java.util.concurrent.TimeUnit;

import javax.management.timer.TimerNotification;

public class TestNew123 {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(5));
	}
}
