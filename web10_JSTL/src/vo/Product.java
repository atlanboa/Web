package vo;
/*
 * 상품에 대한 정보를 저장하고 있는 VO 클래스(자바 빈즈, Bean) ::
 * Property(프라퍼티)
 */
public class Product {
	private String name; //상품명
	private int value; //가격
	
	public Product(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return value;
	}
	public void setPrice(int price) {
		this.value = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", value=" + value + "]";
	}	
}






