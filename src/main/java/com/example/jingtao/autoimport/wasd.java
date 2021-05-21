package com.example.jingtao.autoimport;

import org.springframework.stereotype.Component;

@Component
public class wasd {
    public static void main(String[] args) {
        String a = "http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry?ticket=ST-4478452-mxQnqXkTV9QCUkH7MmiD-cas";
        String b = "http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry?ticket=ST-4482392-M6yQfyl5URXqbOqBIvum-cas";
        System.out.println(a.equals(b));
        //Connection connection = Jsoup.connect("asbvubuwbvn");
        //connection.request().h
//        System.out.println(parseWeeks("2-13周上"));
//        System.out.println(parseWeeks("6,8,10,12周上"));
//        System.out.println(parseWeeks("1周上"));
        int[] ints = parseWeeks("2-13周上");
        int[] ints1 = parseWeeks("6,8,10,12周上");
        int[] ints2 = parseWeeks("1周上");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        for (int i = 0; i < ints1.length; i++) {
            System.out.print(ints1[i] + " ");
        }
        for (int i = 0; i < ints2.length; i++) {
            System.out.print(ints2[i] + " ");
        }

    }

    public static int[] parseWeeks(String s) {
        if (s.contains("-")) {
            return parseWeeksOne(s);
        } else {
            if (s.contains(",")) {
                return parseWeeksTwo(s);
            } else {
                return parseWeeksThree(s);
            }
        }


    }

    public static int[] parseWeeksOne(String s) {
//11-19周
        int star;
        int end;
        String[] split = s.split("-");
        star = Integer.parseInt(split[0]);
        if (split[1].charAt(1) > '0' && split[1].charAt(1) < '9') {
            end = Integer.parseInt(split[1].substring(0, 2));
        } else {
            end = Integer.parseInt(split[1].substring(0, 1));
        }
        int[] res = new int[end - star + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = star++;
        }
        return res;
    }

    public static int[] parseWeeksTwo(String s) {
        String[] split = s.split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < (res.length - 1); i++) {
            res[i] = Integer.parseInt(split[i]);
        }
        if (split[split.length - 1].charAt(1) > '0' && split[split.length - 1].charAt(1) < '9') {
            res[res.length - 1] = Integer.parseInt(split[split.length - 1].substring(0, 2));
        } else {
            res[res.length - 1] = Integer.parseInt(split[split.length - 1].substring(0, 1));
        }
        return res;
    }

    public static int[] parseWeeksThree(String s) {
        int[] res = new int[1];
        if (s.charAt(1) > '0' && s.charAt(1) < '9') {
            res[0] = Integer.parseInt(s.substring(0, 2));
        } else {
            res[0] = Integer.parseInt(s.substring(0, 1));
        }
        return res;

    }
}
