

package com.app.utils;


import java.math.BigDecimal;

import java.sql.Timestamp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * Store tools for develop application
 * @author Prawith Thowphant
 * @version 1.00 25 Mar 2002
 * @description : remove unused import and other
 * @modify_by : Thanarak Kaoram
 * @modify_date : 24/10/2551
 */
public class Tools {
    
    
    /**
     * change value double is String to other format of double such as '1,500.50' to 1500.50
     * @param str String double
     * @return a double
     */
    public static double decimalFormatToDouble(String str) {
        double doubleVal = 0;
        if (str == null || str.trim().compareTo("") == 0 ||
                str.trim().compareToIgnoreCase("null") == 0)
            return doubleVal;
        
        try {
            doubleVal = NumberFormat.getInstance().parse(str).doubleValue();
        } catch (Exception e) {
            System.out.println("Exception in method decimalFormatToDouble [" + str + "]= " + e);
        }
        return doubleVal;
    }
    
    /**
     * change value int is String to other format of double such as '1,500.50' to 1500
     * @param str String int
     * @return a int
     */
    public static int intFormatToInt(String str) {
        int intVal = 0;
        if (str == null || str.trim().compareTo("") == 0 ||
                str.trim().compareToIgnoreCase("null") == 0)
            return intVal;
        
        try {
            intVal = NumberFormat.getInstance().parse(str).intValue();
        } catch (Exception e) {
            System.out.println("Exception in method intFormatToInt [" + str + "]= " + e);
        }
        return intVal;
    }
    
    /**
     * check value of String  if come is Null changed to ""
     * @param value String
     * @return a String
     */
    public static String chkNull(String value) {
        return (value == null ? "" : value.trim());
    }
    
    /*
     * check string if null return "0"
     * @param strDate : String
     * @return String
     */
    public static String chkNullToZero(String value) {
        return ((value == null || value.trim().compareTo("") == 0 || value.trim().compareToIgnoreCase("null") == 0) ? "0" :(value.trim()));
    }
    
    /*
     * check string if null return "0"
     * @param strDate : BigDecimal
     * @return String
     */
    public static BigDecimal chkNullToZero(BigDecimal value) {
        return (value == null) ? value.ZERO :(value);
    }
    
    /*
     * check string to database if null return ""
     * @param strDate : String
     * @return String
     */
    public static String chkNullDB(String value) {
        value = chkNull(value);
        return (value.equals(""))?(null):(value);
    }
    
    /*
     * check string to database if null return null
     * @param strDate : String
     * @return String
     */
    public static String chkValueDB(String value) {
        value = chkNull(value);
        return (value.equals(""))?(null):("'" + value + "'");
    }
    
    /*
     * check and pase string to integer
     * @param strDate : String
     * @return String
     */
    public static int parseInt(String str) {
        if (str == null || str.equals(""))
            return 0;
        else
            return Integer.parseInt(str);
    }
    
     /*
     * check and pase string to double
     * @param strDate : String
     * @return String
     */
    public static double parseDouble(String str) {
        if (str == null || str.equals(""))
            return 0;
        else
            return Double.parseDouble(str);
    }
    
     /*
     * change string to date formate
     * @param strDate : String
     * @return String
     */
    public static String chgFormatDate3(String strDate) {
        String rtnDate = "";
        if (strDate != null && strDate.length() == 10) {
            if (strDate.indexOf("-") != -1) {
                //*********** format of strDate : yyyy-dd-mm ***********//
                rtnDate = strDate;
            } else if (strDate.indexOf("/") != -1) {
                //*********** format of  strDate : dd/mm/yyyy ***********//
                String dd = strDate.substring(0, 2);
                String mm = strDate.substring(3, 5);
                String yyyy = (Integer.parseInt(strDate.substring(6)) - 543) + "";
                rtnDate = (yyyy + "-" + mm + "-" + dd);
            }
        }
        return rtnDate;
    }
    
    /*
     * for change string to date formate
     * @param strDate : "yyyy-mm-dd" (by yyyy to english year) or "dd/mm/yyyy" (by yyyy to thai year)
     * @return java.sql.Date
     */
    public static java.sql.Date chgString2Date(String strDate) {
        java.sql.Date rtnDate = null;
        if (strDate != null && strDate.length() >= 10) {
            if (strDate.indexOf("-") != -1) {
                rtnDate = java.sql.Date.valueOf(strDate.substring(0, 10));
            } else if (strDate.indexOf("/") != -1) {
                String dd = strDate.substring(0, 2);
                String mm = strDate.substring(3, 5);
                int yyyy = Integer.parseInt(strDate.substring(6, 10)) - 543;
                rtnDate = java.sql.Date.valueOf(yyyy + "-" + mm + "-" + dd);
            }
        }
        return rtnDate;
    }
    
    /*
     * for change string to timestamp formate
     * @param strDate : "yyyy-mm-dd" (yyyy is english year) or "dd/mm/yyyy" (yyyy is thai year)
     * @return java.sql.Timestamp
     */
    public static java.sql.Timestamp chgString2TimeStamp(String strDate) {
        
        Timestamp rtnDate = null;
        Timestamp valueDate = null;
        if (strDate != null && strDate.length() >= 14) {
            rtnDate = new Timestamp(00-00-00);
            valueDate = new Timestamp(00-00-00);
            String dd = strDate.substring(6, 8);
            String mm = strDate.substring(4, 6);
            int yyyy = Integer.parseInt(strDate.substring(0, 4));
            String hh = strDate.substring(8, 10);
            String min =strDate.substring(10, 12);
            rtnDate =valueDate.valueOf(yyyy + "-" + mm + "-" + dd+" "+hh+":"+min+":"+"00");
            System.out.println(yyyy + "-" + mm + "-" + dd+" "+hh+":"+min+":"+"00");
        }
        System.out.println("rtnDate="+rtnDate);
        return rtnDate;
    }
    
    /*
     * for change string to date formate
     * @create_date : 18/06/2551
     * @create_by : Phitsanukorn Theansawang
     */
    public static String chgXMLDate2FormatDate(String strDate) {
        String rtnDate = null;
        if (strDate != null && strDate.length() >= 8) {
            strDate = strDate.substring(0, 8);
            String year = (Integer.parseInt(strDate.substring(0, 4)) + 543) + "";
            String month = strDate.substring(4, 6);
            String day = strDate.substring(6);
            rtnDate = (day + "/" + month + "/" + year);
        }
        return rtnDate;
    }
    
    /*
     * use for : Changed format String data to day month year(all thai and English) to "yyyymm" by yyyy count ค.ศ.
     * @param strDate : "dd/mm/yyyy" thai year or "yyyy-mm-dd" english year
     * @return String : "yyyymm" by yyyy is english year
     * @create_date : 28/04/2551
     * @create_by : Phitsanukorn Theansawang
     */
    public static String chgStringDate2YYYYMM(String strDate) throws Exception {
        String rtnData = "";
        try {
            if (strDate != null && strDate.length() == 10) {
                int year = 0, month = 0;
                if (strDate.indexOf("/") != 0) {
                    month = Integer.parseInt(strDate.substring(3, 5));
                    year = Integer.parseInt(strDate.substring(6));
                    year = (year - 543);
                } else if (strDate.indexOf("-") != 0) {
                    month = Integer.parseInt(strDate.substring(5, 7));
                    year = Integer.parseInt(strDate.substring(0, 4));
                }
                rtnData = (year + "" + ((month < 10)?("0" + month):(month + "")));
            }
        } catch (Exception ex) {
            System.out.println("Error Exception : method chgStringDate2YYYYMM(...) in Class Tools : " + ex.getMessage());
            ex.printStackTrace(System.out);
            throw ex;
        }
        return rtnData;
    }
   
    
    
   
    
    
    

    
   
    
    
    
    /**
     * Method xChgDateEngToThai change date eng to thai
     * @param data String
     * @return value String
     * example 1: 20080425 >> 25/04/2551
     */
    public static String xChgDateEngToThai(String data){
        String value = "";
        if (data.length() >= 10){
            value = data.substring(8,10) + "/" + data.substring(5,7) + "/" + (Integer.parseInt(data.substring(0,4))+543);
        }else if (data.length() == 8){
            value = data.substring(6,8) + "/" + data.substring(4,6) + "/" + (Integer.parseInt(data.substring(0,4))+543);
        }
        return value;
    }
    
    /*
     * use for : find begin date of month and find last date of month by parameter
     * @param strDate : format date month year ("dd/mm/yyyy" is thai year) or ("yyyy-mm-dd" is eng year)
     * @return : format send back "dd/mm/yyyy"  yyyy is thai year
     * @create_date : 25/04/2551
     * @create_by : Phitsanukorn Theansawang
     */
    public static String [] getBegin_EndDateOfMonth(String strDate) throws Exception {
        if (strDate == null || strDate.equals("") || strDate.length() != 10)
            throw new Exception("<Tools : getBeginDateOfMonth> The Parameter has been passing into method getBeginDateOfMonth invalid value can't be working, Please check parameter again");
        
        int month = 0, year = 0;
        String strDay = "";
        String [] rtnDate = new String[2];
        try {
            //*********** if strDate come is format dd/mm/yyyy ***********//
            if (strDate.indexOf("/") != 0) {
                month = Integer.parseInt(strDate.substring(3, 5));
                year = Integer.parseInt(strDate.substring(6));
                year = (year - 543);
            }
            //*********** if strDate come is format  yyyy-mm-dd ***********//
            else if (strDate.indexOf("-") != 0) {
                month = Integer.parseInt(strDate.substring(5, 7));
                year = Integer.parseInt(strDate.substring(0, 4));
            }
            
            java.util.Calendar calendar = new GregorianCalendar(year, (month - 1), 1);
            int firstDayOfMonth = calendar.getActualMinimum(calendar.DATE);
            int endDayOfMonth = calendar.getActualMaximum(calendar.DATE);

            
            year = (year + 543);
            strDay = (firstDayOfMonth < 10)?("0" + firstDayOfMonth):(firstDayOfMonth + "");
            rtnDate[0] = (strDay + "/" + ((month >= 10)?(month + ""):("0" + month)) + "/" + year);
            
            strDay = (endDayOfMonth < 10)?("0" + endDayOfMonth):(endDayOfMonth + "");
            rtnDate[1] = (strDay + "/" + ((month >= 10)?(month + ""):("0" + month)) + "/" + year);
        } catch (Exception ex) {
            System.out.println("Error Exception : method getBegin_EndDateOfMonth(strDate) in Class Tools : " + ex.getMessage());
            throw ex;
        }
        return rtnDate;
    }
    
    /*
     * use for : get month
     * @param strYear : only  eng year example "2008"
     * @param strMonth : "04", "4"
     * @param type : 'T', 't', 'E', 'e' (t return type "dd/mm/yyyy" thai year if e return type "yyyy-mm-dd" eng year)
     * @create_date : 29/04/2551
     * @create_by : Phitsanukorn Theansawang
     */
    public static String getEndDateOfMonth(String strYear, String strMonth, char type) throws Exception {
        int month = 0, year = 0;
        String strDay = "";
        String rtnDate = null;
        try {
            month = intFormatToInt(strMonth);
            year = intFormatToInt(strYear);
            java.util.Calendar calendar = new GregorianCalendar(year, (month - 1), 1);
            int endDayOfMonth = calendar.getActualMaximum(calendar.DATE);
            strDay = (endDayOfMonth < 10)?("0" + endDayOfMonth):(endDayOfMonth + "");
            if (type == 'E' || type == 'e') {
                rtnDate = (year + "-" + ((month >= 10)?(month + ""):("0" + month)) + "-" + strDay);
            } else if (type == 'T' || type == 't') {
                year = (year + 543);
                rtnDate = (strDay + "/" + ((month >= 10)?(month + ""):("0" + month)) + "/" + year);
            }
        } catch (Exception ex) {
            System.out.println("Error Exception : method getEndDateOfMonth(strYear, strMonth, type) in Class Tools : " + ex.getMessage());
            throw ex;
        }
        return rtnDate;
    }
    
    /**
     * Method mySplit for split string
     * @param data String,split
     * @return ArrayList
     * example 1: mySplit("0001|0002|0003","|");
     */
    public static ArrayList mySplit(String msg,String split){
        int chk=0;
        int start = 0;
        ArrayList result = new ArrayList();
        while(chk!=-1){
            chk=msg.indexOf(split,start);
            if(chk>-1){
                result.add(msg.substring(start,chk));
                start = chk+1;
            }else{
                result.add(msg.substring(start));
            }
        }
        return result;
    }
    
   
    
    
    /**
     * เปลี่ยนค่า Double ให้เป็น String ตามรูปแบบที่ต้องการ
     * @param x the double to print
     * @param fmt the format string
     * @return String ที่แปลงรูปแบบแล้ว
     */
    public static String dtoa(double x, String fmt) {
        NumberFormat form;

        form = NumberFormat.getInstance();
        ((DecimalFormat)form).applyPattern(fmt);
        return form.format(x);
    }

    /**
     * เปลี่ยนค่า String ให้เป็น String ตามรูปแบบที่ต้องการ
     * @param x the double to print
     * @param fmt the format string
     * @return String ที่แปลงรูปแบบแล้ว
     */
    public static String dtoa(String x, String fmt) {
        if (x == null || x.compareTo("") == 0 ||
            x.compareToIgnoreCase("null") == 0)
            return "";
        NumberFormat form;

        form = NumberFormat.getInstance();
        ((DecimalFormat)form).applyPattern(fmt);
        return form.format(new Double(x).doubleValue());
    }
    
    /**
     * check value of String  if come is Null changed to ""
     * @param value String
     * @return true or false
     */
    public static boolean isNotEmpty(Object input) {
        if(input == null || input.equals("") ){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * check value of String  if come is Null changed to ""
     * @param value String
     * @return true or false
     */
    public static boolean isEmpty(Object input) {
        if(input == null || input.equals("") ){
            return true;
        }else{
            return false;
        }
    }
}
