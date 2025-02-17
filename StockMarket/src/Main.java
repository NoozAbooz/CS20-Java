import java.text.DecimalFormat;

public class Main {
	public static double money = 10000.00;
	
	public static void main(String[] args) {
		int day = 1;
		
		double s1Price = 180.00;
		int s1Count = 0;
		
		double s2Price = 1285.00;
		int s2Count = 0;
		
		double s3Price = 161.00;
		int s3Count = 0;
		
		double s4Price = 702.00;
		int s4Count = 0;
		
		do { 
			int input = display(day, s1Price, s1Count, s2Price, s2Count, s3Price, s3Count, s4Price, s4Count);

			switch (input) {
			case 1: // buy
				int stockSelection = (int)myTools.userInput("Which stock selection to buy (1-4)?");
				int stockCount = (int)myTools.userInput("How many to buy?");
				
				switch (stockSelection) {
				case 1:
					s1Count += purchase(stockCount, s1Price);
					money -= s1Price * stockCount;
					break;
				case 2:
					s2Count += purchase(stockCount, s2Price);
					money -= s2Price * stockCount;
					break;
				case 3:
					s3Count += purchase(stockCount, s3Price);
					money -= s3Price * stockCount;
					break;
				case 4:
					s4Count += purchase(stockCount, s4Price);
					money -= s4Price * stockCount;
					break;
				}
				
				break;
			case 2: // sell
				int sellStockSelection = (int)myTools.userInput("Which stock selection to sell (1-4)?");
				int sellStockCount = (int)myTools.userInput("How many to sell?");
				
				switch (sellStockSelection) {
				case 1:
					money += sell(sellStockCount, s1Count, s1Price);
					s1Count -= sellStockCount;
					break;
				case 2:
					money += sell(sellStockCount, s2Count, s2Price);
					s2Count -= sellStockCount;
					break;
				case 3:
					money += sell(sellStockCount, s3Count, s3Price);
					s3Count -= sellStockCount;
					break;
				case 4:
					money += sell(sellStockCount, s4Count, s4Price);
					s4Count -= sellStockCount;
					break;
				}
				break;
			case 3: // end day
				day++;
				s1Price = updatePrice(s1Price);
				s2Price = updatePrice(s2Price);
				s3Price = updatePrice(s3Price);
				s4Price = updatePrice(s4Price);
				break;
			}
			
		} while (day < 365 || (money >= 100 && s1Count + s2Count + s3Count + s4Count > 0));
	}
	
	public static int display(int day, double s1Price, int s1Count, double s2Price, int s2Count, double s3Price, int s3Count, double s4Price, int s4Count) {
		DecimalFormat df_obj = new DecimalFormat("#.##");
		System.out.println("Stock Market - Day " + day + ":");
		System.out.println("Company Name           Price         Shares Owned");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Facebook            $" + df_obj.format(s1Price) + "        " + s1Count);
		System.out.println("2. Google              $" + df_obj.format(s2Price) + "       " + s2Count);
		System.out.println("3. Microsoft           $" + df_obj.format(s3Price) + "        " + s3Count);
		System.out.println("4. Tesla               $" + df_obj.format(s4Price) + "        " + s4Count);
		System.out.println();
		System.out.println("Portfolio Value: $" + ((s1Price * s1Count) + (s2Price * s2Count) + (s3Price * s3Count) + (s4Price * s4Count)));
		System.out.println("Cash Available: $" + money);
		System.out.println();
		System.out.println("1. Buy");
		System.out.println("2. Sell");
		System.out.println("3. End Day");
		return myTools.userInput(1, 3);
	}
	
	public static double updatePrice(double price) {
		int majorMinorOdds = myTools.random(1, 100);
		double updatedPrice = 0;

		if (majorMinorOdds >= 95) { // 5% major
			double deviation = (double)(myTools.random(5, 15)) / 100; // 5% to 15%
			System.out.println(deviation);
			int plusMinus = myTools.random(0, 1); // 50% up or down
			
			if (plusMinus == 0) {
				updatedPrice = price - (price * deviation); 
			} else {
				updatedPrice = price + (price * deviation); 
			}
		} else if (majorMinorOdds > 80 && majorMinorOdds < 95) { // 15% nothing
			updatedPrice = price;
		} else { // 80% minor
			double deviation = (double)(myTools.random(5, 30)) / 1000; // 0.5% to 3%
			System.out.println(deviation);
			int plusMinus = myTools.random(0, 1); // 50% up or down
			
			if (plusMinus == 0) {
				updatedPrice = price - (price * deviation); 
			} else {
				updatedPrice = price + (price * deviation); 
			}
		}
		
		if (updatedPrice < 0.01) { // cannot be less than $0.01
			updatedPrice = 0.01;
		}
		return updatedPrice;
	}
	
	public static double purchase(int numberOfShares, double shareCost){
		double newCount = 0;
		if (numberOfShares * shareCost < money) {
			newCount = numberOfShares;
		}
		
		return newCount;
	}
	
	public static double sell(int numberOfShares, int totalOwnedShares, double shareCost){
		double totalEarning = 0;
		
		if (numberOfShares <= totalOwnedShares) {
			totalEarning = numberOfShares * shareCost;
		}
		return totalEarning;
	}

}
