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
        if(filter_!=null&&!filter_.equals("")){
            filter = filter_;
        }
        if(search_!=null&&!search_.equals("")){
            search = search_;
        }
        if(page_!=null&&!page_.equals("")){
            page = Integer.parseInt(page_);
        }

        List<Notice> notices = new ArrayList<>();
        NoticeService service = new NoticeService();
        int count = service.getNoticeCount(filter,search);
        notices =service.getNotices(filter,search,page);

        request.setAttribute("notices", notices);
        request.setAttribute("count", ((count-1)/10)+1);



        request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
    }
}
