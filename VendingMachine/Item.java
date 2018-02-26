/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/16
 * */

public enum Item {
	MILK(40), JUICE(80), COFFEE(120);
	private final int cost;

	private Item(int c) {
		cost = c;
	}

	public int getCost() {
		return cost;
	}
}