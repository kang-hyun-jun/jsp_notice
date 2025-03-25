package controller;

import Model.Notice;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NoticeService;

import java.io.IOException;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_ = request.getParameter("id");
        int id=0;
        if(id_ != null && !id_.equals(""))
        {
            id = Integer.parseInt(id_);
            NoticeService service = new NoticeService();
            int count = service.getNoticeCount();
            request.setAttribute("count",count);
            Notice notice = service.getNotice(id);

            if(id<count)
            {
                Notice nextNotice = service.getNotice(id+1);
                request.setAttribute("nextNotice", nextNotice);
            }
            if(id>1)
            {
                Notice prevNotice = service.getNotice(id-1);
                request.setAttribute("prevNotice",prevNotice);
            }
            request.setAttribute("notice",notice);
        }
        else
        {
            request.getRequestDispatcher("/list").forward(request,response);
        }

        request.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(request,response);
    }
}
