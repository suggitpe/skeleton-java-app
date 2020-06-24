package com.develogical.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class QueryPage {
    public void writeTo(Map<String, String> queries, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<ul>");
        for (String key : queries.keySet()) {
            writer.println("<li>" + key + ":" + queries.get(key) + "</li>");
        }
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
