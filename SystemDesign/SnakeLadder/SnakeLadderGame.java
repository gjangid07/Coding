package SystemDesign.SnakeLadder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class countClass {
	int count;
}

class Signal {
	boolean signal;

	public Signal(boolean s) {
		signal = s;
	}
}

public class SnakeLadderGame {

//	private static int[][] snakeLadderBoard;
	private static Snake[] snakes;
	private static Ladder[] ladders;
	private static Player1 player1;
	private static Player2 player2;
//	volatile static Boolean flag=true;

	static {
//		snakeLadderBoard = new int[10][10];
		snakes = new Snake[] { new Snake(17, 7), new Snake(62, 19), new Snake(54, 34), new Snake(64, 60),
				new Snake(87, 36), new Snake(93, 73), new Snake(95, 75), new Snake(98, 79), };

		ladders = new Ladder[] { new Ladder(23, 2), new Ladder(29, 7), new Ladder(41, 22), new Ladder(77, 28),
				new Ladder(32, 30), new Ladder(56, 44), new Ladder(69, 54), new Ladder(90, 70), new Ladder(83, 80),
				new Ladder(93, 87), };

		Arrays.sort(snakes, (a, b) -> a.head - b.head);
		Arrays.sort(ladders, (a, b) -> a.tail - b.tail);
		PlayerUtil util = new PlayerUtil(snakes, ladders);

	}

	public static void main(String[] args) {

		Lock lock = new ReentrantLock();

		Condition player1PlayingCondition = lock.newCondition();

		countClass count = new countClass();

		CyclicBarrier barrier = new CyclicBarrier(2);

		Signal signal = new Signal(true);

		boolean flag = true;

		player1 = new Player1(lock, "player1", player1PlayingCondition, count, signal, barrier);
		player1.setPosition(0);

		player2 = new Player2(lock, "player2", player1PlayingCondition, count, signal, barrier);
		player2.setPosition(0);

		Thread player1Thread = new Thread(player1);
		Thread player2Thread = new Thread(player2);

		player1Thread.start();
		player2Thread.start();

		System.out
				.println("Both Threads Started by " + Thread.currentThread().getName() + "at: " + LocalDateTime.now());

		try {
			player1Thread.join();
			player2Thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Player1 implements Runnable {
	private int position;
	private Lock lock;
	private String playerName;
	private Condition player1Condition;
	countClass count;
	CyclicBarrier barrier;
	Signal signal;

	public Player1(Lock l, String name, Condition player1Condition, countClass count, Signal s, CyclicBarrier b) {
		lock = l;
		playerName = name;
		this.player1Condition = player1Condition;
		this.count = count;
		barrier = b;
		signal = s;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public void run() {

		try {
			Thread.sleep((long) (Math.random() * 2000));
			System.out.println(this.playerName + " has arrived at " + LocalDateTime.now());
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e1) {
			e1.printStackTrace();
		}

		outer: while (this.getPosition() <= 100 && signal.signal) {

			try {
				lock.lock();

				while (count.count % 2 != 0) {
					Thread.sleep(1000);
					System.out.println(this.playerName + " rolling the dice...");

					int value = 1 + (int) (Math.random() * 6);
					System.out.println(this.playerName + " got the value " + value);

					if (this.getPosition() + value > 100) {
						System.out.print(this.playerName + " current position: " + this.getPosition());
						System.out.println(this.playerName + " got the value " + value + " ,So can't move");
						count.count++;
						player1Condition.signalAll();
						continue;
					}

					if (PlayerUtil.isBiteBySnake(this.getPosition() + value)) {

						Snake snake = PlayerUtil.getSnakeByHead(this.getPosition() + value);
						this.setPosition(snake.tail);
						System.out.println(this.playerName + " bitten by snake!");
						System.out.println(this.playerName + " reached the position " + this.getPosition());

					} else if (PlayerUtil.isThereisLadder(this.getPosition() + value)) {
						Ladder ladder = PlayerUtil.getLadderByTail(this.getPosition() + value);
						this.setPosition(ladder.head);
						System.out.println(this.playerName + " climbed up the ladder!");
						System.out.println(this.playerName + " reached the position " + this.getPosition());
					} else {
						if (this.getPosition() + value == 100) {
							System.out.print(this.playerName + " moved from " + this.getPosition());
							this.setPosition(this.getPosition() + value);
							System.out.println(" to the position " + this.getPosition());
							count.count++;
							player1Condition.signalAll();
							break outer;
						}
						System.out.print(this.playerName + " moved from " + this.getPosition());
						this.setPosition(this.getPosition() + value);
						System.out.println(" to the position " + this.getPosition());
					}

					count.count++;
					player1Condition.signalAll();
					Thread.sleep(1000);
				}

				player1Condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
		if (this.getPosition() == 100) {
			System.out.println(this.playerName + " has Won!");
		}
		signal.signal = false;
	}

}

class Player2 implements Runnable {
	private int position;
	private Lock lock;
	private String playerName;
	private Condition player1Condition;
	countClass count;
	Signal signal;
	CyclicBarrier barrier;

	public Player2(Lock l, String name, Condition player1Condition, countClass count, Signal s, CyclicBarrier b) {
		lock = l;
		playerName = name;
		this.player1Condition = player1Condition;
		this.count = count;
		signal = s;
		barrier = b;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public void run() {

		try {
			Thread.sleep((long) (Math.random() * 3000));
			System.out.println(this.playerName + " has arrived at " + LocalDateTime.now());
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e1) {
			e1.printStackTrace();
		}

		outer: while (this.getPosition() <= 100 && signal.signal) {

			try {
				lock.lock();
				while (count.count % 2 == 0) {
					Thread.sleep(1000);
					System.out.println(this.playerName + " rolling the dice...");

					int value = 1 + (int) (Math.random() * 6);
					System.out.println(this.playerName + " got the value " + value);

					if (this.getPosition() + value > 100) {
						System.out.print(this.playerName + " current position: " + this.getPosition());
						System.out.println(this.playerName + " got the value " + value + " ,So can't move");
						count.count++;
						player1Condition.signalAll();
						continue;
					}

					if (PlayerUtil.isBiteBySnake(this.getPosition() + value)) {

						Snake snake = PlayerUtil.getSnakeByHead(this.getPosition() + value);
						this.setPosition(snake.tail);
						System.out.println(this.playerName + " bitten by snake!");
						System.out.println(this.playerName + " reached the position " + this.getPosition());

					} else if (PlayerUtil.isThereisLadder(this.getPosition() + value)) {
						Ladder ladder = PlayerUtil.getLadderByTail(this.getPosition() + value);
						this.setPosition(ladder.head);
						System.out.println(this.playerName + " climbed up the ladder!");
						System.out.println(this.playerName + " reached the position " + this.getPosition());
					} else {
						if (this.getPosition() + value == 100) {
							System.out.print(this.playerName + " moved from " + this.getPosition());
							this.setPosition(this.getPosition() + value);
							System.out.println(" to the position " + this.getPosition());
							count.count++;
							player1Condition.signalAll();
							break outer;
						}
						System.out.print(this.playerName + " moved from " + this.getPosition());
						this.setPosition(this.getPosition() + value);
						System.out.println(" to the position " + this.getPosition());
					}

					count.count++;
					player1Condition.signalAll();
					Thread.sleep(1000);
				}
				player1Condition.await();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
		if (this.getPosition() == 100) {
			System.out.println(this.playerName + " has Won!");
		}
		signal.signal = false;

	}

}
