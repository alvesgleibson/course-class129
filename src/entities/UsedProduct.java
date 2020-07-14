package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date date) {
		super(name, price);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String priceTag() {
		return getName() + " (used) $ "
				+ String.format("%.2f", getPrice() + " (Manufacture date : " + sdf.format(getDate()) + ")");
	}

}
