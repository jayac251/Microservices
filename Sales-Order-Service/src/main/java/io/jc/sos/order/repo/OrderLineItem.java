/**
 * 
 */
package io.jc.sos.orderline.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 197651
 *id, item_name, item_quantity, order_id
 */
@Entity
public class OrderLineItem {
	
	@Id
	@GeneratedValue
	Long id;	
	String itemName;
	String itemQuantity;
	String orderId;

	
	/**
	 * 
	 */
	public OrderLineItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param itemName
	 * @param itemQuantity
	 * @param orderId
	 */
	public OrderLineItem(String itemName, String itemQuantity, String orderId) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return the itemQuantity
	 */
	public String getItemQuantity() {
		return itemQuantity;
	}


	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}


	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
