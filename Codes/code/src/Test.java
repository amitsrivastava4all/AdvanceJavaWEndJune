import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

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
		}
		System.out.println("Customer "+customerMap);
		Customer c = customerMap.get(1);
		System.out.println(c);  // c.toString()
		// TODO Auto-generated method stub

	}

}
