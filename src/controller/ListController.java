package controller;

import Model.Notice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NoticeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String filter = "TITLE";
        String search = "";
        int page = 1;

        String filter_ = request.getParameter("f");
        String search_ = request.getParameter("s");
        String page_ = request.getParameter("p");
        if(!filter_.equals("")&&filter_!=null){
            filter = filter_;
        }
        if(!search_.equals("")&&search_!=null){
            search = search_;
        }
        if(!page_.equals("")&&page_!=null){
            page = Integer.parseInt(page_);
        }

        List<Notice> notices = new ArrayList<>();
        NoticeService service = new NoticeService();
        notices =service.getNotices(filter,search,page);

        request.setAttribute("notices", notices);



        request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
    }
}
