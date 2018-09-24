import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

class SortByPrice implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return ((Double)o1.getPrice()).compareTo(o2.getPrice());
	}
	
}

public class Test {

	public static void main(String[] args) {
		
		String names[] = {"ram","shyam"};
		TreeMap<Integer,Customer> customerMap = new TreeMap<>();
		for(int i = 1;i<=2;i++) {
		Customer customer = new Customer(i,names[i-1],9000*i);
		customerMap.put(customer.getId(), customer);
		Address address1 = new Address("Delhi","India");
		Address address2 = new Address("Delhi","India");
		Address address3 = new Address("Mumbai","India");
		TreeSet<Address> officeAddressSet = new TreeSet<>();
		officeAddressSet.add(address1);
		officeAddressSet.add(address2);
		officeAddressSet.add(address3);
		//System.out.println(officeAddressSet);
		HashMap<String,TreeSet<Address>> addressMap = new HashMap<>();
		addressMap.put("office", officeAddressSet);	
		customer.setAddressMap(addressMap);
		Address resaddress1 = new Address("New Delhi","India");
		Address resaddress2 = new Address("New Delhi","India");
		Address resaddress3 = new Address("Navi Mumbai","India");
		TreeSet<Address> resAddressSet = new TreeSet<>();
		resAddressSet.add(address1);
		resAddressSet.add(address2);
		resAddressSet.add(address3);
		//System.out.println(officeAddressSet);
		addressMap.put("res",resAddressSet);
		
		// Order
		HashMap<Integer, Order> orderMap = new HashMap<>();
		Order order =new Order(1, "Mobile", new Date());
		
		// Product
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(100, "Apple", 90000));
		products.add(new Product(102, "Samsung", 80000));
		products.add(new Product(101, "LG", 60000));
		order.setProducts(products);
		//Collections.sort(products, new SortByPrice());
//		Collections.sort(products, new Comparator<Product>() {
//		public int compare(Product first, Product second) {
//			return first.getName().compareToIgnoreCase(second.getName());
//		}
//		});
		if(10>2) {
		Collections.sort(products, (first,second)->first.getName().compareToIgnoreCase(second.getName()));
		}
		orderMap.put(order.getId(), order);
		Calendar c1 = Calendar.getInstance();
		c1.set(2018, 10, 11);
		order =new Order(2, "LED", c1.getTime());
		
		
		orderMap.put(order.getId(), order);
		customer.setOrderMap(orderMap);
		
		}
		System.out.println("Customer "+customerMap);
		Customer c = customerMap.get(1);
		Order order = c.getOrderMap().get(1);
		ArrayList<Product> prod = order.getProducts();
		System.out.println(prod.contains(new Product(10211, "Samsung", 80000))?"Found":"Not Found");
		System.out.println(c);  // c.toString()
		
		"Amit".equals("Amit");
		
		// TODO Auto-generated method stub

	}

}
