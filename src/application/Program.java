package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		List<Product> products = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");

			System.out.print("Common, used or imported (c/u/i): ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			switch (c) {

			case 'i':
				System.out.print("CustomsFee: ");
				products.add(new ImportedProduct(name, price, sc.nextDouble()));
				break;

			case 'u':
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				products.add(new UsedProduct(name, price, sdf.parse(sc.next())));
				break;

			case 'c':

				products.add(new Product(name, price));
				break;

			}

		}
		
		System.out.println("Price Tags:");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
