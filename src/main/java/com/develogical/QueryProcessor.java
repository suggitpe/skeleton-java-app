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

        if (query.contains("what is ") && query.contains(" plus ")) {
            String[] arr = query.split(" ");
            Integer foo = parseInt(arr[3]) + parseInt(arr[5]);
            System.out.println(foo);
            return foo.toString();
        }

        if (query.contains("What is ") && query.contains(" * ")) {
            String[] arr = query.split(" ");
            Integer foo = parseInt(arr[3]) * parseInt(arr[5]);
            System.out.println(foo);
            return foo.toString();
        }

        if (query.contains("what is ") && query.contains(" multiplied by ")) {
            String[] arr = query.split(" ");
            Integer foo = parseInt(arr[3]) * parseInt(arr[6]);
            System.out.println(foo);
            return foo.toString();
        }

        if(query.toLowerCase().contains("which of the following numbers is the largest")){
            String[] numbers = query.split(":")[2].split(", ");
            String max = "0";
            for(String number: numbers){
                if(parseInt(max) < parseInt(number.trim())){
                    max = number.trim();
                }
            }
            System.out.println(numbers.length);
            return max;
        }

        if(query.toLowerCase().contains("which of the following numbers is both a square and a cube")){
            String[] numbers = query.split(":")[2].split(", ");
            for(String number: numbers){
                int check = parseInt(number.trim());
                if(isSquareAndCube(check))
                    return number.trim();
            }
            return "0";
        }

        return "";
    }

    boolean isSquareAndCube(int check){
        return isSquare(check) && isCube(check);
    }

    boolean isSquare(int check){
        int x = (int) Math.sqrt(check);
        if(Math.pow(x,2) == check){
            return true;
        }
        return false;
    }

    boolean isCube(int check){
        int n = (int) Math.round(Math.pow(check, 1.0/3.0));
        return Math.pow(n,3) == check;
    }
}
