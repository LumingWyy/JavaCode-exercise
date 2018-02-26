/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/16
 * */

import java.util.*;

public class VendingMachine {
	private Map<Coin, Integer> cashBox;
	private Map<Item, Integer> itemBox;

	public VendingMachine() {
		cashBox = new HashMap<Coin, Integer>();
		cashBox.put(Coin.TEN, 0);
		cashBox.put(Coin.FIFTY, 0);
		cashBox.put(Coin.HUNDRED, 0);
		itemBox = new HashMap<Item, Integer>();
		itemBox.put(Item.MILK, 0);
		itemBox.put(Item.JUICE, 0);
		itemBox.put(Item.COFFEE, 0);
	}

	public Map<Coin, Integer> getCashBox() {
		return cashBox;
	}

	public Map<Item, Integer> getItemBox() {
		return itemBox;
	}

	public void insert(Coin c) {
		int x = cashBox.get(c);
		cashBox.put(c, x + 1);
	}

	private int total() {
		return cashBox.get(Coin.TEN) * 10 + cashBox.get(Coin.FIFTY) * 50 + cashBox.get(Coin.HUNDRED) * 100;
	}

	private boolean pay(int c) {
		while (cashBox.get(Coin.TEN) < c) {
			if (cashBox.get(Coin.FIFTY) > 0) {
				int t1 = cashBox.get(Coin.FIFTY);
				int t2 = cashBox.get(Coin.TEN);
				cashBox.put(Coin.FIFTY, t1 - 1);
				cashBox.put(Coin.TEN, t2 + 5);
			} else if (cashBox.get(Coin.HUNDRED) > 0) {
				int t1 = cashBox.get(Coin.HUNDRED);
				int t2 = cashBox.get(Coin.FIFTY);
				int t3 = cashBox.get(Coin.TEN);
				cashBox.put(Coin.HUNDRED, t1 - 1);
				cashBox.put(Coin.FIFTY, t2 + 1);
				cashBox.put(Coin.TEN, t3 + 5);
			} else {
				return false;
			}
		}
		int t = cashBox.get(Coin.TEN);
		assert t >= c : "t >= c must hold but, " + "t=" + t + " & c=" + c;
		cashBox.put(Coin.TEN, t - c);
		return true;
	}

	public boolean select(Item i) {
		int cost = i.getCost();
		if (total() < cost)
			return false;
		boolean b = pay(cost / 10);
		if (b) {
			int c = itemBox.get(i);
			itemBox.put(i, c + 1);
			return true;
		} else {
			assert false : "cashBox: " + cashBox + ", " + "cost: " + cost;
			return false;
		}
	}
}