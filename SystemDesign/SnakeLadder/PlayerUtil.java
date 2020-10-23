package SystemDesign.SnakeLadder;

public class PlayerUtil {
	
	private static Snake[] snakes;
	private static Ladder[] ladders;
	
	public PlayerUtil(Snake[] s, Ladder[] l) {
		snakes = s;
		ladders = l; 
	}

	public static Ladder getLadderByTail(int tail) {
		return getLadderByTail(ladders, tail, 0, ladders.length);
	}

	private static Ladder getLadderByTail(Ladder[] ladders, int tail, int start, int end) {

		while (start <= end) {
			int mid = end + (start - end) / 2;

			if (ladders[mid].tail == tail) {
				return ladders[mid];
			} else if (ladders[mid].tail > tail) {
				return getLadderByTail(ladders, tail, 0, mid - 1);
			} else {
				return getLadderByTail(ladders, tail, mid + 1, end);
			}
		}

		return null;
	}

	static Snake getSnakeByHead(int head) {
		return getSnakeByHead(snakes, head, 0, snakes.length);
	}

	private static Snake getSnakeByHead(Snake[] snakes, int head, int start, int end) {

		while (start <= end) {
			int mid = end + (start - end) / 2;

			if (snakes[mid].head == head) {
				return snakes[mid];
			} else if (snakes[mid].head > head) {
				return getSnakeByHead(snakes, head, 0, mid - 1);
			} else {
				return getSnakeByHead(snakes, head, mid + 1, end);
			}
		}

		return null;
	}

	public static boolean isBiteBySnake(int val) {

		return isBiteBySnakeBinarySearch(val, snakes, 0, snakes.length);
	}

	private static boolean isBiteBySnakeBinarySearch(int val, Snake[] snakes, int start, int end) {

		if(val>snakes[snakes.length-1].head) {
			return false;
		}
		
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (snakes[mid].head == val) {
				return true;
			} else if (snakes[mid].head > val) {
				return isBiteBySnakeBinarySearch(val, snakes, 0, mid - 1);
			} else {
				return isBiteBySnakeBinarySearch(val, snakes, mid + 1, end);
			}
		}

		return false;
	}

	public static boolean isThereisLadder(int val) {

		return isThereisLadderBinarySearch(val, ladders, 0, ladders.length);
	}

	private static boolean isThereisLadderBinarySearch(int val, Ladder[] ladders, int start, int end) {
		
		if(val>ladders[ladders.length-1].tail) {
			return false;
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (ladders[mid].tail == val) {
				return true;
			} else if (ladders[mid].tail > val) {
				return isThereisLadderBinarySearch(val, ladders, 0, mid - 1);
			} else {
				return isThereisLadderBinarySearch(val, ladders, mid + 1, end);
			}
		}

		return false;
	}

}
