package com.rays.ioc;

public class Order {

	private Payment payment;
	private Inventory inventory;
	
	public Order(Payment payment ,Inventory inventory) {
		this.payment = payment;
		this.inventory = inventory;
		
	}
	public Order() {
		
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void bookATicket(int items) {
		
		int price = 10;
		
		double totalAmount = items * price;
		
		double updatedBalance = payment.makePayment(totalAmount);
		
		int updatedStock = inventory.sold(items);
		
		System.out.println("Tickets are Booked");
		System.out.println("Total Amount paid : " + totalAmount);
		System.out.println("Remaining Balance: " + updatedBalance);
		System.out.println("Total Booked Tickets: " + items);
		System.out.println("Updated Stock: " + updatedStock);

	}
}
