package controller;

import Model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("WEB-INF/view/register.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthday_ = request.getParameter("birthday");
        Date birthday;
        String phone = request.getParameter("phone");
        if(id!=null&&pwd!=null&&name!=null&&gender!=null&&birthday_!=null&&phone!=null&&!id.equals("")&&!pwd.equals("")&&!name.equals("")&&!gender.equals("")&&!birthday_.equals("")&&!phone.equals(""))
        {
            System.out.println("작동이 완료되었습니다.");
            birthday = Date.valueOf(birthday_);
            LocalDate now = LocalDate.now();
            int age = now.getYear()- birthday.getYear()+1;
            MemberService service = new MemberService();
            Member member = new Member(id,pwd,name,gender,age,birthday,phone);
            service.registmember(member);
            response.sendRedirect("/mypage?ID="+id);
        }
        else
        {
            System.out.println("else 코드가 작동이 완료되었습니다.");
            request.getRequestDispatcher("WEB-INF/view/register.html").forward(request,response);
        }
    }
}
