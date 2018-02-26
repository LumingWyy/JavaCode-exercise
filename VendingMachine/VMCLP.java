/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/16
 * */

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class VMCLP {
	private static void showBanner() {
		System.out.println("***VendingMachine***");
		System.out.println("   ***Welcome!***   ");
	}

	private static void help() {
		System.out.println("please input 'stop', 'insert', 'select', 'showItems', 'showCoins'");
	}

	public static void main(String[] args) throws IOException {
		VendingMachine vm = new VendingMachine();
		String line;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		showBanner();
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.equals("")) { 

			} else if (line.equals("stop")) {
				Map<Item, Integer> items = vm.getItemBox();
				Map<Coin, Integer> coins = vm.getCashBox();
				System.out.println("Items bought: " + items);
				System.out.println("Change: " + coins);
				System.out.println("bye bye!!");
				break;
			} else if (line.equals("help")) {
				help();
			} else if (line.equals("insert")) {
				System.err.println("Usage: insert [10|50|100]");
			} else if (line.equals("select")) {
				System.err.println("Usage: select [milk|juice|coffee]");
			} else if (line.equals("showItems")) {
				System.out.println(vm.getItemBox());
			} else if (line.equals("showCoins")) {
				System.out.println(vm.getCashBox());
			} else if (Pattern.matches("insert[ \t].*", line)) {
				String[] la = line.split("[ \t]", 2);
				if (la.length < 2) { 
					assert false : "In insert command: " + line;
				} else {
					String a = la[1].trim();
					if (a.equals("10")) {
						vm.insert(Coin.TEN);
					} else if (a.equals("50")) {
						vm.insert(Coin.FIFTY);
					} else if (a.equals("100")) {
						vm.insert(Coin.HUNDRED);
					} else {
						System.err.println("Usage: insert [10|50|100]");
					}
				}
			} else if (Pattern.matches("select[ \t].*", line)) {
				String[] la = line.split("[ \t]", 2);
				if (la.length < 2) {
				} else {
					String a = la[1].trim();
					if (a.equals("milk")) {
						if (vm.select(Item.MILK)) {
							System.out.println("you bought one milk.");
						} else {
							System.out.println("Not enough coins!");
						}
					} else if (a.equals("juice")) {
						if (vm.select(Item.JUICE)) {
							System.out.println("you bought one juice.");
						} else {
							System.out.println("Not enough coins!");
						}
					} else if (a.equals("coffee")) {
						if (vm.select(Item.COFFEE)) {
							System.out.println("you bought one coffee.");
						} else {
							System.out.println("Not enough coins!");
						}
					} else {
						System.err.println("Usage: select [milk|juice|coffee]");
					}
				}
			} else {
				System.err.println("No such a command!!!");
			}
			System.out.print("VM> ");
		}
	}
}
