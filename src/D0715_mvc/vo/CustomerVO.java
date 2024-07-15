package D0715_mvc.vo;

import java.util.Objects;

public class CustomerVO {

    private int custid;
    private String name;
    private String address;
    private String phone;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerVO customerVO = (CustomerVO) o;
        return custid == customerVO.custid && Objects.equals(name, customerVO.name) && Objects.equals(address, customerVO.address) && Objects.equals(phone, customerVO.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custid, name, address, phone);
    }

    public CustomerVO() {
    }

    public CustomerVO(int custid, String name, String address, String phone) {
        this.custid = custid;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CusomerVo{" +
                "custid=" + custid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
