package mx.jbs.java.arq.la.api_gestion_shuttle.util;

public class SQLUtil {
    public static String getLike(String str){
        return "%"+str.trim().toUpperCase()+"%";
    }
}
