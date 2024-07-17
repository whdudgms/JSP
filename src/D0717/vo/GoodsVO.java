package D0717.vo;

public class GoodsVO {

    private int no;
    private String item;
    private int price;
    private int qty;
    private String fname;

    // Default constructor
    public GoodsVO() {}

    // Parameterized constructor
    public GoodsVO(int no, String item, int price, int qty, String fname) {
        this.no = no;
        this.item = item;
        this.price = price;
        this.qty = qty;
        this.fname = fname;
    }

    // Getters and Setters
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    // toString method for easy debugging and logging
    @Override
    public String toString() {
        return "GoodsVO{" +
                "no=" + no +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", fname='" + fname + '\'' +
                '}';
    }
}
