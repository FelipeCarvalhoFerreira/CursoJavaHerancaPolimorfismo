package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Principal {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dn = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> product = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n ; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product.add(new ImportedProduct( name, price, customsFee));
			} else if(ch == 'c') {
				product.add(new Product(name, price));
			} else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = dn.parse(sc.next());
				product.add(new UsedProduct (name, price, manufactureDate));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product prod : product) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
