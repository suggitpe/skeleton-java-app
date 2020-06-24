package com.develogical;

import com.develogical.web.ApiResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.develogical.web.QueryPage;
import com.develogical.web.StatusPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.Source;

public class WebServer {

  private static final Map<String, String> queries = new HashMap<>();

  public WebServer() throws Exception {

    Server server = new Server(portNumberToUse());

    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(new ServletHolder(new RootPage()), "/*");
    handler.addServletWithMapping(new ServletHolder(new Api()), "/api/*");
    handler.addServletWithMapping(new ServletHolder(new QueryList()), "/list");
    server.setHandler(handler);

    server.start();
  }

  static class Api extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String query = req.getParameter("q");
      String answer = new QueryProcessor().process(query);
      queries.put(query, answer);
      new ApiResponse(answer).writeTo(resp);
    }
  }

  static class QueryList extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      new QueryPage().writeTo(queries, resp);
    }
  }

  private static class RootPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      new StatusPage().writeTo(resp);
    }
  }

  private Integer portNumberToUse() {
    return System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 5000;
  }

  public static void main(String[] args) throws Exception {
    new WebServer();
  }
}