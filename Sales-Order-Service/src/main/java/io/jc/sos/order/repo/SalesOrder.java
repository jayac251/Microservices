/**
 * 
 */
package io.jc.sos.order.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 197651
 * . sales_order – id, order_date, cust_id, order_desc, total_price

 */
@Entity
public class SalesOrder {

	@Id
	@GeneratedValue
	Long id;	
	String orderDate;
	String custId;
	String orderDescription;
	String totalPrice;
	
	/**
	 * Default Constructor
	 */
	public SalesOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderDate
	 * @param custId
	 * @param orderDescription
	 * @param totalPrice
	 */
	public SalesOrder(String orderDate, String custId, String orderDescription, String totalPrice) {
		super();
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDescription = orderDescription;
		this.totalPrice = totalPrice;
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
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return the orderDescription
	 */
	public String getOrderDescription() {
		return orderDescription;
	}

	/**
	 * @param orderDescription the orderDescription to set
	 */
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	/**
	 * @return the totalPrice
	 */
	public String getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	} 
	
	
}