package D0716.dao;

import D0716.provider.ConnectionProvider;
import D0716.vo.BoardVO;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDAO {

    public int delete(BoardVO b){
        int re = -1;
        String sql = "delete board where no=? and pwd = ?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b.getNo());
            pstmt.setString(2, b.getPwd());
            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return re;
    }



    public int update(BoardVO b){
        System.out.println(b);
        int re = -1;
        String sql = "update board set title=?, content=?,fname=?,fsize=? where no=? and pwd=?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());
            pstmt.setString(3, b.getFname());
            pstmt.setInt(4, b.getFsize());
            pstmt.setInt(5, b.getNo());
            pstmt.setString(6, b.getPwd());
            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return re;
    }

    public BoardVO findByNo(int no){
        BoardVO b= null;
        String sql = "select * from board where no=?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                b = new BoardVO(no, rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5),rs.getDate(6), rs.getInt(7),rs.getString(8),rs.getInt(9));
            }

            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println("예외발생:"+e.getMessage());
        }

        return b;
    }

    public ArrayList<BoardVO> findAll(){
        ArrayList<BoardVO> list = new ArrayList<BoardVO>();
        String sql = "select * from board";
        try{
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(new BoardVO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9)
                        )

                );
            }
            ConnectionProvider.close(rs,stmt,conn);
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    //새로운 게시물 번호를 발행해주는 메소드
    //
    public int getNextNo(){
        int no = 0;
        String sql  ="select nvl(max(no),0)+1 from board";
        try{
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                no = rs.getInt(1);
            }
            ConnectionProvider.close(rs,stmt,conn);
        }catch(Exception e){
            System.out.println("예외발생"+e.getMessage());
        }
        return no;
    }
    public int insert(BoardVO b){
        int re = -1;
        int no = getNextNo();
        String sql = "insert into board values(?,?,?,?,?,sysdate,0,?,?)";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            pstmt.setString(2,b.getTitle());
            pstmt.setString(3,b.getWriter());
            pstmt.setString(4,b.getPwd());
            pstmt.setString(5,b.getContent());
            pstmt.setString(6,b.getFname());
            pstmt.setInt(7,b.getFsize());
            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println("예외 발생"+e.getMessage());
        }
        return re;
    }
}
