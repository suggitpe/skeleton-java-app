package com.develogical;

import static java.lang.Integer.parseInt;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }

        if (query.toLowerCase().contains("your name")) {
            return "Pete Suggitt";
        }

        if (query.toLowerCase().contains("what is ")) {
            String[] arr = query.split(" ");
            Integer foo = parseInt(arr[2]) + parseInt(arr[4]);
            System.out.println(foo);
            return foo.toString();
        }

        return "";
    }
}
