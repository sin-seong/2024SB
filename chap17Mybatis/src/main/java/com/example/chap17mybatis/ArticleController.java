package com.example.chap17mybatis;

import com.example.chap17mybatis.dao.ArticleDao;
import com.example.chap17mybatis.model.Article;
import com.example.chap17mybatis.model.ArticleListModel;
import com.example.chap17mybatis.service.ArticleNotFoundException;
import com.example.chap17mybatis.service.ListArticleService;
import com.example.chap17mybatis.service.ReadArticleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {


    @Autowired
    ListArticleService listArticleService;
    @Autowired
    ReadArticleService readService;

    @GetMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        String pageNumberString = request.getParameter("p");
        int pageNumber = 1;
        if (pageNumberString != null && pageNumberString.length() > 0) {
            pageNumber = Integer.parseInt(pageNumberString);
        }
        ArticleListModel articleListModel = listArticleService.getArticleList(pageNumber);
        model.addAttribute("listModel", articleListModel);

        if (articleListModel.getArticleList().size() > 0) {
            int beginPagenumber =
                    (articleListModel.getRequestPage() - 1) / 10 * 10 + 1;
            int endPageNumber = beginPagenumber + 9;
            if (endPageNumber > articleListModel.getTotalPageCount()) {
                endPageNumber = articleListModel.getTotalPageCount();
            }
            model.addAttribute("beginPage", beginPagenumber);
            model.addAttribute("endPage", endPageNumber);
        }
        return "list_view";
    }
    @GetMapping("/read")
    public String read(Model model, HttpServletRequest request) {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String viewPage = null;
        try{
            Article article = readService.readArticle(articleId);
            model.addAttribute("article", article);
            viewPage = "read_view.jsp";
        }catch (ArticleNotFoundException ex) {
            viewPage = "/article_not_found.jsp";
        }
        return "read_view";
    }
}

