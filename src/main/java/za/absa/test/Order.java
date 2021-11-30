package za.absa.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(columnDefinition = "number")
  private int qty;
  @Column(columnDefinition = "Varchar(50)")
  private String isdn;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public String getIsdn() {
    return isdn;
  }

  public void setIsdn(String isdn) {
    this.isdn = isdn;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", qty=" + qty +
        ", isdn='" + isdn + '\'' +
        '}';
  }
}
