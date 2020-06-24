package com.develogical.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryPage {
    public void writeTo(List<String> queries, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<ul>");
        for(String s: queries){
            writer.println("<li>" + s + "</li>");
        }
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
