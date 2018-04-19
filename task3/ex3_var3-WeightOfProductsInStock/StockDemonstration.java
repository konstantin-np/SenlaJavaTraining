public class StockDemonstration {

	public static void main(String[] args) {
		
		int stockCapacity = 7;
		Stock stock = new Stock(stockCapacity);
		
		Computer comp1 = new Computer("PC Dell 7sv90", "Dell", 6.8, 2.3, 4, 500, 2);
		Computer comp2 = new Computer("PC MEGA-IGROVOJ", "PRO GAMING", 5, 2.0, 2, 500, 2);
		Laptop lapt1 = new Laptop("Lenovo b570e", "Lenovo", 3.7, 2.3, 4, 500, 2, "1366*768", 2.5);
		PowerBank pb = new PowerBank("Xiaomi Gray", "Xiaomi", 0.48, 10000);
		Printer prnt1 = new Printer("Printer FastPrint 2000", "Canon", 4.2, "Laser", 100);
		Printer prnt2 = new Printer("Printer XEROX-9000", "XEROX", 6.8, "InkJet", 150);
		Laptop lapt2 = new Laptop("Asus M670", "Asus", 1.8, 2.2, 6, 500, 2, "1366*768", 4);
		Laptop lapt3 = new Laptop("Pure60", "MSI", 2.2, 3, 16, 1024, 4, "1366*768", 4);
		
		stock.addProduct(comp1);
		stock.addProduct(comp2);
		stock.addProduct(lapt1);
		stock.addProduct(pb);
		stock.addProduct(prnt1);
		stock.addProduct(prnt2);
		stock.addProduct(lapt2);
		stock.addProduct(lapt3);
		
		
		for(Product prd : stock.getProducts()) 
		{
            System.out.println(prd.toString());
		}
		
		double weight = stock.getProductsWeight();
		System.out.printf("Weight of all products in stock is %.2f%n", weight);
	}
}
