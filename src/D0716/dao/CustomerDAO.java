package D0716.dao;

import D0716.provider.ConnectionProvider;
import D0715_mvc.vo.CustomerVO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    public ArrayList<CustomerVO> findAll(){
        ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
        String sql  = "select * from customer";
        try{
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(new CustomerVO(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            ConnectionProvider.close(rs,stmt,conn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public CustomerVO findByCustid(int custid){
        CustomerVO customer = new CustomerVO();
        String sql  = "select * from customer";
        try{
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                customer.setCustid(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setAddress(rs.getString(3));
                customer.setPhone(rs.getString(4));
            }
            ConnectionProvider.close(rs,stmt,conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }


    public int insert(CustomerVO c){
        int re = -1;
        String sql = "insert into customer values(?,?,?,?)";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,c.getCustid());
            pstmt.setString(2,c.getName());
            pstmt.setString(3,c.getAddress());
            pstmt.setString(4,c.getPhone());
            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println("예외발생"+e.getMessage());
        }
        return re;
    }

    public int update(CustomerVO c){
        int re = -1;
        String sql = "update  customer set name=?, address=?, phone=? where custid=?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,c.getName());
            pstmt.setString(2,c.getAddress());
            pstmt.setString(3,c.getPhone());
            pstmt.setInt(4,c.getCustid());

            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println("예외발생"+e.getMessage());
        }
        return re;
    }


    public int delete(int custid){
        int re = -1;
        String sql = "delete from customer where custid =?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,custid);
            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println("예외발생"+e.getMessage());
        }
        return re;
    }

}
