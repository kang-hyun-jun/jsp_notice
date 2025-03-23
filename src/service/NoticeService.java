package service;

import Model.Notice;
import sqldata.SqlData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    public List<Notice> getNotices()  {
        return getNotices("title","",1);
    }
    public List<Notice> getNotices(int page)  {
        return getNotices("title","",page);
    }
    public List<Notice> getNotices(String filter, String search, int page)  {

        //SQL(by JDBC)
        List<Notice> notices = new ArrayList<Notice>();
        int start = (page-1)*10+1;
        int end = start + 9;
        String sql = "SELECT * FROM (SELECT ROWNUM NUM,N.* FROM (SELECT * FROM NOTICE WHERE "+ filter +" LIKE ? ORDER BY REGDATE DESC)N)WHERE NUM BETWEEN ? AND ?";
        try {
            Class.forName(SqlData.driver);//오라클 드라이버 로드
            Connection con = DriverManager.getConnection(SqlData.url,SqlData.user,SqlData.password);//드라이버 매니저를 통해서 연결
            PreparedStatement ps = con.prepareStatement(sql);// 실행 도구 생성
            ps.setString(1,"%"+search+"%");
            ps.setInt(2,start);
            ps.setInt(3,end);
            ResultSet rs = ps.executeQuery();// 결과값 얻어올 수 있는 객체


            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writer_id = rs.getString("writer_id");
                String content = rs.getString("content");
                Date regdate = rs.getDate("regdate");
                int hit = rs.getInt("hit");
                String files = rs.getString("files");
                Notice notice = new Notice(id,title,writer_id,content,regdate,hit,files);
                notices.add(notice);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notices;
    }
    public int getNoticeCount()  {
        return getNoticeCount("title","");
    }
    public int getNoticeCount(String filter, String search)  {
        String sql = "SELECT COUNT(ID) COUNT FROM (SELECT ROWNUM NUM,N.* FROM (SELECT * FROM NOTICE WHERE "+filter+" LIKE ? ORDER BY REGDATE DESC)N)M";
        try {
            Class.forName(SqlData.driver);
            Connection con = DriverManager.getConnection(SqlData.url,SqlData.user,SqlData.password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"%"+search+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("COUNT");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
