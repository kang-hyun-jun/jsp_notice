package service;

import Model.Member;
import sqldata.SqlData;

import java.sql.*;


public class MemberService {
    public void registmember(Member member)
    {
        String sql = "INSERT INTO MEMBER (ID, PWD, NAME, GENDER,AGE,BIRTHDAY,PHONE) VALUES (?,?,?,?,?,?,?)";
        try {
            Class.forName(SqlData.driver);
            Connection con = DriverManager.getConnection(SqlData.url,SqlData.user,SqlData.password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,member.getID());
            ps.setString(2,member.getPWD());
            ps.setString(3,member.getNAME());
            ps.setString(4,member.getGENDER());
            ps.setInt(5,member.getAGE());
            ps.setDate(6,member.getBIRTHDAY());
            ps.setString(7,member.getPHONE());
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
