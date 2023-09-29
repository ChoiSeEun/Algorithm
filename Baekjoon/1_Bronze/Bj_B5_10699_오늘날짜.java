import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Bj_B5_10699_오늘날짜 {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        System.out.println(format.format(d));
    }
}
