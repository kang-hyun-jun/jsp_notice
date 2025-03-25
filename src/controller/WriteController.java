package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NoticeService;

import java.io.IOException;

@WebServlet("/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{

        request.getRequestDispatcher("/WEB-INF/view/write.html").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String title = request.getParameter("title");
        String writer_id = "khj";
        String content = request.getParameter("content");
        String files = "Null";

        NoticeService service = new NoticeService();
        service.writeNotice(title,content,writer_id,files);
        int count = service.getNoticeCount();

        response.sendRedirect("/detail?id=" + count);
    }
}
