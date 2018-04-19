import java.util.ArrayList;
import java.util.List;

public class Stock 
{
	private int stockLimit;
	private List<Product> products;
	
	public Stock(int limit)
	{
		this.stockLimit = limit;
		this.products = new ArrayList<Product>();
	}

	public int getStockLimit() {
		return stockLimit;
	}

	public void setStockLimit(int stockLimit) {
		this.stockLimit = stockLimit;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product prd)
	{
		if (this.products.size() + 1 <= this.stockLimit)
		{
			this.products.add(prd);
		}
		else
		{
			System.out.println("Stock is full!");
		}
	}
	
	public void removeProduct(Product prd) //remove by value
	{
		if (this.products.contains(prd))
			this.products.remove(prd);
		else
			System.out.println("Such product is not in stock!");
	}
	
	public void removeProduct(int indx) //remove by index
	{
		if (this.products.size() > indx)
			this.products.remove(indx);
	}
	
	public double getProductsWeight()
	{
		double weight = 0;
		for (int i = 0; i < this.products.size(); i++)
		{
			weight += this.products.get(i).weight;
		}
		return weight;
	}
}
