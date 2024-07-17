package D0717.dao;

import D0717.provider.ConnectionProvider;
import D0717.vo.GoodsVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class GoodsDAO {

    public int delete(GoodsVO g){
        int re = -1;
        String sql  = "delete from goods where no=?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, g.getNo());
            re= pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
        }
        return re;
    }

    public int update(GoodsVO g){
        int re = -1;
        String sql  = "update goods set item=?,price=?,qty=?,fname=? where no=?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,g.getItem());
            pstmt.setInt(2,g.getPrice());
            pstmt.setInt(3,g.getQty());
            pstmt.setString(4,g.getFname());
            pstmt.setInt(5, g.getNo());
            re= pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
        }
        return re;
    }


    public int insert(GoodsVO g){
        int re = -1;
        String sql  = "insert into goods values(seq_goods.nextval,?,?,?,?)";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,g.getItem());
            pstmt.setInt(2,g.getPrice());
            pstmt.setInt(3,g.getQty());
            pstmt.setString(4, g.getFname());
            re= pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return re;
    }


    public ArrayList<GoodsVO> findAll(){
        ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
        String sql =  "select * from goods";
        try{
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(new
                        GoodsVO(rs.getInt(1),rs.getString(2 ), rs.getInt(3),rs.getInt(4),rs.getString(5)))
;            }
            ConnectionProvider.close(rs,stmt,conn);
        }catch (Exception e){

        }
        return list;
    }


    public GoodsVO findByNo(int no){
        GoodsVO g = null;
        String sql = "select * from goods where no = ?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                g = new GoodsVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5));
            }
            ConnectionProvider.close(rs,pstmt,conn);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return g;
    }





}
