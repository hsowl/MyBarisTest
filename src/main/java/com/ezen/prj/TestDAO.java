package com.ezen.prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    private TestDAO()   {}

    private static TestDAO instance = new TestDAO();

    public static TestDAO getInstance(){ return instance;}
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String oracle = "oracle.jdbc.driver.OracleDriver";
    String mysql = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
    String orurl = "jdbc:oracle:thin:@localhost:1521:xe";
    String myurl = "dbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
    String username = "scott";
    String pass = "tiger";

    public List<TestVO> selectAllTest() {

        List<TestVO> list = new ArrayList<>();
        try {
            String sql = "select * from test";
            Class.forName(oracle);
            conn = DriverManager.getConnection(url, username, pass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                TestVO vo = new TestVO();
                vo.setId(rs.getInt("id"));
                vo.setName(rs.getString("name"));
                vo.setPhone(rs.getString("phone"));
                vo.setAddress(rs.getString("address"));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

    public void insertTest(String name, String phone, String address) {
        try {
            String sql = "insert into test values (test_seq.nextval,?,?,?)";
            Class.forName(oracle);
            conn = DriverManager.getConnection(url, username, pass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,phone);
            pstmt.setString(3,address);

            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
