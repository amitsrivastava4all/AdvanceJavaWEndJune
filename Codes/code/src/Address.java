import java.util.Collections;

public class  Address implements Comparable<Address> {
	public Address(String city, String country) {
		
		this.city = city;
		this.country = country;
	}
	
	public int compareTo(Address address) {
		//Collections.sort();
		return this.city.compareTo(address.city);  // String
	}

	private String city;
	private String country;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}
	

}
