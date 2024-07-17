package D0716.dao;

import D0716.provider.ConnectionProvider;
import D0716.vo.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {



    //로그인시 아이디와 암호를 매개변수로 전달받아 회원의 정보가 올바른지 판별하는 메소드
    // 올바른 회원일 경우
    // 아이디도 맞고 암호도 맞으면  1
    // 아이디는 있는데 암호가 틀리면     0
    // 아이디도 없으면             -1
    public int isMember(String id, String pwd){
        int re  = -1;
        String sql = "select pwd from member where id = ?";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String dbPwd = rs.getString(1);
                if(dbPwd.equals(pwd)){
                    re = 1;
                }else{
                    re=0;
                }

                return re;
            }
            ConnectionProvider.close(rs,pstmt,conn);
        }catch (Exception e){
            System.out.println("예외발생 :" + e.getMessage());
        }

        return -1;
    }

    // id를 사용할 수 있는 반별하는 메소드
    // 사용가능 : 1  이미 존재 0
    //
    public int idCheck(String id){
        int re = 1;
        try{
            String sql = "select * from member where id = ?";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                re = 0;
            }
            ConnectionProvider.close(pstmt,conn);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  re;
    }


    public int insert(MemberVO memberVO){
        int re = -1;
        String sql = "insert into member values(?,?,?)";
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,memberVO.getId());
            pstmt.setString(2,memberVO.getName());
            pstmt.setString(3,memberVO.getPw());
            re = pstmt.executeUpdate();
            ConnectionProvider.close(pstmt,conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return re;
    }




}
