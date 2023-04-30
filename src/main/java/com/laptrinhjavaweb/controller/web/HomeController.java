package com.laptrinhjavaweb.controller.web;


import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        Long categoryId = 1L;
//        request.setAttribute("news",newService.findByCategoryId(categoryId));
        request.setAttribute("category",categoryService.findAll());
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request, response);
    }

    protected  void  doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{

    }


}
