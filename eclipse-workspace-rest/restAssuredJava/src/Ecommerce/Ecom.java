package Ecommerce;

public class Ecom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Login
		LoginApi.performLogin();
		
		//Add product
		AddProductApi.addProduct();
		
		//Create Order
		CreateOrderApi.createOrder();
		
		//Delete Product
		DeleteProduct.deleteProduct();
		
		//Delete Order
		DeleteOrderApi.deleteOrder();

	}

}
