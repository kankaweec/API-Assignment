

package com.app.utils;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Store dates and perform date arithmetic
 * (another Date class, but more convenient that
 * java.util.Date or java.util.Calendar)
 * @version 1.03 25 Oct 1997
 * @author Cay Horstmann
 * @modify Prawith Thowphant
 * @company : Professional Computer Co., Ltd
 * @modify_date : 24/10/2551
 * @modify_by : Thanarak Kaoram
 * @description : remove unused import and other
 */
public class Day {
    
    
    private int milisecond;
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int enYear;
    private int thYear;
    private char e_t;
    
    private static final String fullMonth[][] =
    { { "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน",
              "กรกฎาคม", "สิงหาคม",
              "กันยายน", "ตุลาคม",
              "พฤศจิกายน", "ธันวาคม" },
              { "January", "Febuary",
                        "March",
                        "April",
                        "May",
                        "June",
                        "July",
                        "August",
                        "September",
                        "October",
                        "November",
                        "December" } };
    
    private static final String shortMonth[][] =
    { { "ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.", "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.",
              "ก.ย.", "ต.ค.", "พ.ย.",
              "ธ.ค." },
              { "Jan", "Feb", "Mar",
                        "Apr", "May",
                        "Jun", "Jul",
                        "Aug", "Sep",
                        "Oct", "Nov",
                        "Dec" } };
    
    private static final String dayName[][] =
    { { "อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์", "เสาร์" },
      { "Sunday", "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday" } };
    
    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";   
    public static final String DEFAULT_DATE_FORMAT2 = "dd-MM-yyyy";
    public static final String DEFAULT_DATETIME_FORMAT = "dd/MM/yyyy HH:mm";
    public static final String DEFAULT_DATETIME_FORMAT2 = "dd/MM/yyyy HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT3 = "yyyy-MM-dd HH:mm:ss";    
    public static final String DEFAULT_DATETIME_FORMAT4 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DATETIME_FORMAT5 = "yyyyMMdd HHmmss";
    public static final String DEFAULT_DATETIME_FORMAT6 = "yyyyMMddHHmmss";
    public static final String DEFAULT_DATETIME_FORMAT7 = "yyyy-MM-dd hh24:mi:ss";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_TIME_FORMAT2 = "HHmmss";
    public static final Locale APPLICATION_LOCALE = Locale.US;
    public static final Locale APPLICATION_LOCALE_TH = new Locale("th", "TH");
    public static final String TIME_HHMM_FORMAT = "HH.mm";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYYMMDD2 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYYMMDD3 = "yyyy/MM/dd";
    public static final String DEFAULT_TIMEZONE_PATTERN = "GMT+07:00";
    public static final String DEFAULT_DATE_DELIMITER = " ";    
    
    /**
     *  Constructs today's date
     */
    public Day() {
        GregorianCalendar todaysDate = new GregorianCalendar();
        enYear = todaysDate.get(Calendar.YEAR);
        thYear = enYear + 543;
        month = todaysDate.get(Calendar.MONTH) + 1;
        day = todaysDate.get(Calendar.DAY_OF_MONTH);
        hour = todaysDate.get(Calendar.HOUR_OF_DAY);
        minute = todaysDate.get(Calendar.MINUTE);
        second = todaysDate.get(Calendar.SECOND);
        milisecond = todaysDate.get(Calendar.MILLISECOND);
        e_t = 'T';
    }
    
    /**
     * Constructs a specific date
     * @param yyyy year (full year, e.g., 1996,
     * <i>not</i> starting from 1900)
     * @param m month
     * @param d day
     * @param e_t 'E'(English) or 'T'(Thai)
     * @exception IllegalArgumentException if yyyy m d not a valid date
     */
    public Day(int yyyy, int m, int d, char e_t) {
        if (e_t == 'e' || e_t == 'E') {
            this.e_t = 'E';
            enYear = yyyy;
        } else {
            this.e_t = 'T';
            enYear = yyyy - 543;
        }
        thYear = enYear + 543;
        month = m;
        day = d;
        if (!isValid())
            throw new IllegalArgumentException();
    }
    
 
    
    /**
     * Gets the millisecond within the second
     * @return the millisecond within the second (0...999)
     */
    public int getMilisecond() {
        return milisecond;
    }
    
    /**
     * Gets the second within the minute
     * @return the second within the minute (0...59)
     */
    public
            
            int getSecond() {
        return second;
    }
    
    /**
     * Gets the minute within the hour
     * @return the minute within the hour (0...59)
     */
    public int getMinute() {
        return minute;
    }
    
    /**
     * Gets the hour of the day
     * @return the hour of the day (0...23)
     */
    public int getHour() {
        return hour;
    }
    
    /**
     * Gets the day of the month
     * @return the day of the month (1...31)
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Gets the month
     * @return the month (1...12)
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Gets the Year in A.D.
     * @return the Year in A.D. (counting from 0, <i>not</i> from 1900)
     */
    public int getYearEng() {
        return enYear;
    }
    
    /**
     * Gets the Year in B.E.
     * @return the Year in B.E. (counting from 0, <i>not</i> from 2443)
     */
    public int getYearThai() {
        return thYear;
    }
    
    /**
     * Sets the year type (A.D. or B.E.)
     * @param e_t 'E'(English) or 'T'(Thai)
     */
    public void setYearType(char e_t) {
        if (e_t == 'E' || e_t == 'e')
            this.e_t = 'E';
        else
            this.e_t = 'T';
    }
    
    /**
     * Gets the day of the week
     * @return the day of the weekday (0 = Sunday, 1 = Monday, ...,
     * 6 = Saturday)
     */
    public int weekday() {
        return (toJulian() + 1) % 7;
    }
    
    /**
     * The number of days between this and day parameter
     * @param b any date
     * @return the number of days between this and day parameter
     * and b (> 0 if this day comes after b)
     */
    public int daysBetween(Day b) {
        return toJulian() - b.toJulian();
    }
    
    /**
     *
     * @param sSDate specified dd/mm/yyyy such as 01/08/2549 or yyyy-mm-dd such as 2006-08-01
     * @param sEDate specified dd/mm/yyyy หรือ yyyy-mm-dd
     * @param sType  specified  T or E  depend on formate of date is Thai or Eng
     * @return   is amount of day between sSDate and sEDate
     */
    public static int dayBetween(String sSDate, String sEDate, String sType) {
        int iDay = 0;
        if ((sSDate != null && sEDate != null) &&
                (sSDate.length() == 10 && sEDate.length() == 10)) {
            try {
                if (sType.equals("E") || sType.equals("e")) {
                    Day d1 =
                            new Day(Integer.parseInt(sEDate.substring(0, 4)), Integer
                            .parseInt(sEDate.substring(5, 7)),
                            Integer.parseInt(sEDate.substring(8)),
                            'E');
                    Day d2 =
                            new Day(Integer.parseInt(sSDate.substring(0, 4)), Integer
                            .parseInt(sSDate.substring(5, 7)),
                            Integer.parseInt(sSDate.substring(8)),
                            'E');
                    iDay = d1.daysBetween(d2);
                } else if (sType.equals("T") || sType.equals("t")) {
                    Day d1 =
                            new Day(Integer.parseInt(sEDate.substring(6)) - 543,
                            Integer.parseInt(sEDate.substring(3, 5)),
                            Integer.parseInt(sEDate.substring(0, 2)),
                            'E');
                    Day d2 =
                            new Day(Integer.parseInt(sSDate.substring(6)) - 543,
                            Integer.parseInt(sSDate.substring(3, 5)),
                            Integer.parseInt(sSDate.substring(0, 2)),
                            'E');
                    iDay = d1.daysBetween(d2);
                }
            } catch (Exception e) {
                System.out.println("Exception  ::: "+ e.toString());
            }
        }
        return iDay;
    }
    
    /**
     * A string representation of the day
     * @return a string representation of the day
     */
    public String toString() {
        if (e_t == 'E')
            return toString("yyyy-mm-dd hh:mn:ss.zz");
        else
            return toString("dd/mm/yyyy hh:mn:ss.zz");
    }
    
    /**
     * A string representation of the day
     * @param dateFormat date format
     * The valid values are<br>
     * "day" for day of week<br>
     * "d" or "dd" for date<br>
     * "m" or "mm" for month in number<br>
     * "mon" for month in short name<br>
     * "month" for month in full name<br>
     * "yy" or "yyyy" for year
     * "hh" for hour<br>
     * "mn" or "mi" for minute<br>
     * "ss" for second<br>
     * "zz" for milisecond<br>
     * " " or "/" or "-" or ":" or "." or "," for separator.<br>
     * e.g. "yyyy-mm-dd hh:mn:ss", "dd/mm/yyyy", "dd mon yy", "dd month yyyy".
     * @return a string representation of the day
     */
    public String toString(String dateFormat) {
        StringBuffer theDate = new StringBuffer("");
        StringBuffer theFormat = new StringBuffer("");
        final String separator = " /-:.,";
        
        int strLen = dateFormat.length();
        char charVal;
        
        
        for (int i = 0; i < strLen; i++) {
            charVal = dateFormat.charAt(i);
            if (separator.indexOf((int)charVal) == -1) {
                theFormat.append(charVal);
            } else {
                if (theFormat.length() > 0) {
                    theDate.append(getValue(theFormat.toString()));
                    theFormat.delete(0, theFormat.length());
                }
                theDate.append(charVal);
            }
        }
        
        if (theFormat.length() > 0)
            theDate.append(getValue(theFormat.toString()));
        
        return theDate.toString();
    }
    
    /**
     * Gets the String value by format
     * @param theFormat e.g. day, dd, mm, mon, month, yy, yyyy, hh, mn, ss
     * @return the String value
     */
    private String getValue(String theFormat) {
        int arrIndex, year;
        String returnValue = null;
        
        if (e_t == 'T') {
            arrIndex = 0;
            year = thYear;
        } else {
            arrIndex = 1;
            year = enYear;
        }
        
        if (theFormat.compareToIgnoreCase("d") == 0)
            returnValue = "" + day;
        else if (theFormat.compareToIgnoreCase("dd") == 0)
            returnValue = ((day < 10) ? "0" : "") + day;
        else if (theFormat.compareToIgnoreCase("day") == 0)
            returnValue = dayName[arrIndex][weekday()];
        else if (theFormat.compareToIgnoreCase("m") == 0)
            returnValue = "" + month;
        else if (theFormat.compareToIgnoreCase("mm") == 0)
            returnValue = ((month < 10) ? "0" : "") + month;
        else if (theFormat.compareToIgnoreCase("mon") == 0)
            returnValue = shortMonth[arrIndex][month - 1];
        else if (theFormat.compareToIgnoreCase("month") == 0)
            returnValue = fullMonth[arrIndex][month - 1];
        else if (theFormat.compareToIgnoreCase("yy") == 0) {
            year %= 100;
            returnValue = ((year < 10) ? "0" : "") + year;
        } else if (theFormat.compareToIgnoreCase("yyyy") == 0)
            returnValue = "" + year;
        else if (theFormat.compareToIgnoreCase("hh") == 0)
            returnValue = ((hour < 10) ? "0" : "") + hour;
        else if (theFormat.compareToIgnoreCase("mn") == 0 ||
                theFormat.compareToIgnoreCase("mi") == 0)
            returnValue = ((minute < 10) ? "0" : "") + minute;
        else if (theFormat.compareToIgnoreCase("ss") == 0)
            returnValue = ((second < 10) ? "0" : "") + second;
        else if (theFormat.compareToIgnoreCase("zz") == 0)
            returnValue =
                    ((milisecond < 100) ? ((milisecond < 10) ? "00" : "0") : "") +
                    milisecond;
        else
            returnValue = theFormat;
        
        return returnValue;
    }
    
  
    
    /**
     * Computes the number of days between two dates
     * @return true if this is a valid date
     */
    private boolean isValid() {
        Day t = new Day();
        t.fromJulian(this.toJulian());
        return t.day == day && t.month == month && t.enYear == enYear;
    }
    
    /**
     * @return The Julian day number that begins at noon of this day
     * Positive year signifies A.D., negative year B.C.
     * Remember that the year after 1 B.C. was 1 A.D.
     *
     * A convenient reference point is that May 23, 1968 noon
     * is Julian day 2440000.
     *
     * Julian day 0 is a Monday.
     *
     * This algorithm is from Press et al., Numerical Recipes
     * in C, 2nd ed., Cambridge University Press 1992
     */
    private int toJulian() {
        int jy = enYear;
        if (enYear < 0)
            jy++;
        int jm = month;
        if (month > 2)
            jm++;
        else {
            jy--;
            jm += 13;
        }
        int jul =
                (int)(java.lang.Math.floor(365.25 * jy) + java.lang.Math.floor(30.6001 *
                jm) +
                day + 1720995.0);
        
        int IGREG = 15 + 31 * (10 + 12 * 1582);
        //********** Gregorian Calendar adopted Oct. 15, 1582 **********//
        
        if (day + 31 * (month + 12 * enYear) >= IGREG) {
            //********** change over to Gregorian calendar **********//
            int ja = (int)(0.01 * jy);
            jul += 2 - ja + (int)(0.25 * ja);
        }
        return jul;
    }
    
    /**
     * Converts a Julian day to a calendar date
     * @param j  the Julian date
     * This algorithm is from Press et al., Numerical Recipes
     * in C, 2nd ed., Cambridge University Press 1992
     */
    private void fromJulian(int j) {
        int ja = j;
        int JGREG = 2299161;
        if (j >= JGREG) {
            //********** cross-over to Gregorian Calendar produces this correction **********//
            int jalpha = (int)(((float)(j - 1867216) - 0.25) / 36524.25);
            ja += 1 + jalpha - (int)(0.25 * jalpha);
        }
        int jb = ja + 1524;
        int jc = (int)(6680.0 + ((float)(jb - 2439870) - 122.1) / 365.25);
        int jd = (int)(365 * jc + (0.25 * jc));
        int je = (int)((jb - jd) / 30.6001);
        day = jb - jd - (int)(30.6001 * je);
        month = je - 1;
        if (month > 12)
            month -= 12;
        enYear = jc - 4715;
        if (month > 2)
            --enYear;
        if (enYear <= 0)
            --enYear;
        thYear = enYear + 543;
    }
    
    
    
    /**
     * use for change format date from dd/mm/yyyy or yyyy-mm-dd
     * to dd/mm/yyyy
     * @param string format dd/mm/yyyy or yyyy-mm-dd
     * @return Thai brief date format such as 03/01/2512
     */
    public static String thaiBriefDateFormat(String string) {
        String returnValue = "";
        if (string == null || string.compareTo("") == 0 ||
                string.length() < 10)
            return returnValue;
        
        if (string.indexOf("-") != -1) {
            returnValue =
                    string.substring(8, 10) + "/" + string.substring(5, 7) + "/" +
                    (Integer.parseInt(string.substring(0, 4)) + 543);
        } else {
            returnValue = string.substring(0, 6) + string.substring(6, 10);
        }
        return returnValue;
    }
    
    
    
    
   
   
    /**
     * use for change format date from dd/mm/yyyy or yyyy-mm-dd
     * to yyyymmdd
     * @param string format dd/mm/yyyy or yyyy-mm-dd
     * @return  date format such as 1969-03-01(yyyy-mm-dd)
     */
    public static String englishXMLDateFormatYYYY(String string) {
        String returnValue = "";
        if (string == null || string.compareTo("") == 0 ||
                string.length() < 10)
            return returnValue;
        
        if (string.length() > 10) {
            string = string.substring(0, 10);
        }
        
        if (string.indexOf("-") != -1) {
            returnValue =
                    string.substring(0, 4) +"-"+ string.substring(5, 7) +"-"+ string
                    .substring(8, 10);
        } else {
            returnValue =
                    (Integer.parseInt(string.substring(6, 10)) - 543) +"-"+ string
                    .substring(3, 5) +"-"+ string.substring(0, 2);
        }
        return returnValue;
    }
    /**
     * use for change format date from dd/mm/yyyy or yyyy-mm-dd
     * to yyyymmdd
     * @param string format dd/mm/yyyy or yyyy-mm-dd
     * @return Thai xml date format such as 19690301
     */
    public static String englishXMLDateFormat(String string) {
        String returnValue = "";
        if (string == null || string.compareTo("") == 0 ||
                string.length() < 10)
            return returnValue;
        
        if (string.length() > 10) {
            string = string.substring(0, 10);
        }
        
        if (string.indexOf("-") != -1) {
            returnValue =
                    string.substring(0, 4) + string.substring(5, 7) + string
                    .substring(8, 10);
        } else {
            returnValue =
                    (Integer.parseInt(string.substring(6, 10)) - 543) + string
                    .substring(3, 5) + string.substring(0, 2);
        }
        return returnValue;
    }
    
    /**
     * use for change format date from dd/mm/yyyy hh:mi:ss or yyyy-mm-dd hh:mi:ss
     * to yyyymmddhhmiss
     * @param string format dd/mm/yyyy hh:mi:ss or yyyy-mm-dd hh:mi:ss
     * @return Thai xml date format such as 19690301191500
     */
    public static String englishXMLDateTimeFormat(String string) {
        String returnValue = "";
        if (string == null || string.compareTo("") == 0 ||
                string.length() < 16)
            return returnValue;
        
        if (string.indexOf("-") != -1) {
            returnValue =
                    string.substring(0, 4) + string.substring(5, 7) + string
                    .substring(8, 10) + string.substring(11, 13) +
                    string.substring(14, 16) + string.substring(17, 19);
        } else {
            returnValue =
                    (Integer.parseInt(string.substring(6, 10)) - 543) + string
                    .substring(3, 5) + string.substring(0, 2) +
                    string.substring(11, 13) + string.substring(14, 16) +
                    string.substring(17, 19);
        }
        return returnValue;
    }
    /*
         * for change string to timestamp formate
         * @param strDate : "yyyy-mm-dd" (yyyy is english year) or "dd/mm/yyyy" (yyyy is thai year)
         * @return java.sql.Timestamp
         */
        public static String chgString2TimeStamp(String strDate) {
           // System.out.println("==chgString2TimeStampA strDate="+strDate);
            Timestamp rtnDate = null;
            Timestamp valueDate = null;
            String dateRtn="";
            if (strDate != null && strDate.length() >= 14) {
                rtnDate = new Timestamp(00-00-00);
                valueDate = new Timestamp(00-00-00);
                String dd = strDate.substring(6, 8);
                String mm = strDate.substring(4, 6);
                int yyyy = Integer.parseInt(strDate.substring(0, 4));
                String hh = strDate.substring(8, 10);
                String min =strDate.substring(10, 12);
                String second=strDate.substring(12, 14);
                rtnDate =valueDate.valueOf(yyyy + "-" + mm + "-" + dd+" "+hh+":"+min+":"+second);
                dateRtn=yyyy + "-" + mm + "-" + dd+" "+hh+":"+min+":"+second;
             //   System.out.println(yyyy + "-" + mm + "-" + dd+" "+hh+":"+min+":"+second);
            }
           // System.out.println("dateRtn="+dateRtn);
            return dateRtn;
        }
        
        /**
         * เปลี่ยนค่า java.util.Date ตาม Format dd/mm/yyyy Ex. 01/02/2558
         *
         * @param java.util.Date rcvDate
         *
         *
         * @return  String
         */
        public static String formatThai(java.util.Date date) {
            return formatThai(date, DEFAULT_DATETIME_FORMAT2);
        }
    
        /**
         * เปลี่ยนค่า java.sql.Date ตาม Format dd/mm/yyyy Ex. 01/02/2558
         *
         * @param java.util.Date rcvDate
         * @return  String
         */
        public static String formatThai(java.sql.Date date) {
            return formatThai(date, DEFAULT_DATETIME_FORMAT2);
        }
    
        /**
         * เปลี่ยนค่า java.util.Date ตาม Format ที่ส่งมา
         *
         * @param java.util.Date date
         * @param String pattern
         *
         * @return  String
         */
        public static String formatThai(java.util.Date date, String pattern) {
            if (date == null) {
                return null;
            }
            SimpleDateFormat sdf = getSimpleDateFormat(pattern, APPLICATION_LOCALE_TH);
            return sdf.format(date);
        }
    
        /**
         * เปลี่ยนค่า java.sql.Date ตาม Format ที่ส่งมา
         *
         * @param java.sql.Date date
         * @param String pattern
         *
         * @return  String
         */
        public static String formatThai(java.sql.Date date, String pattern) {
            if (date == null) {
                return null;
            }
            SimpleDateFormat sdf = getSimpleDateFormat(pattern, APPLICATION_LOCALE_TH);
            return sdf.format(date);
        }
    
        /**
         * เปลี่ยนค่า  java.sql.Timestamp ตาม Format ที่ส่งมา
         *
         * @param java.sql.Timestamp timestamp
         * @param String pattern
         *
         * @return  String
         */
        public static String formatThai(java.sql.Timestamp timestamp, String pattern) {
            if (timestamp == null) {
                return null;
            }
            SimpleDateFormat sdf = getSimpleDateFormat(pattern, APPLICATION_LOCALE_TH);
            return sdf.format(timestamp);
        }
        
        public static SimpleDateFormat getSimpleDateFormat(String pattern, Locale locale) {
            return new SimpleDateFormat(pattern, locale);
        }
        
        public static java.sql.Timestamp strEn2SqlDateTime(String dateString) {
            return strEn2SqlDateTime(dateString,DEFAULT_DATETIME_FORMAT3);
        }
    
        /**
         * convertDateEnStrToSqlTimetamp เปลี่ยนค่า dateString ต้องส่ง format dateString และ  Locale เป็น US
         * @param String dateString
         * @param String pattern
         * @return  java.sql.Timestamp
         *
         * Ex.
         * DateUtil.convertDateEnStrToSqlTimetamp("25-04-1977 10:10:10", "dd-MM-yyyy HH:mm:ss")
         * DateUtil.convertDateEnStrToSqlTimetamp("25/04/1977 10:10:10", "dd/MM/yyyy HH:mm:ss")
         * DateUtil.convertDateEnStrToSqlTimetamp("1977-04-25 10:10:10", "yyyy-MM-dd HH:mm:ss")
         *
         */
        public static java.sql.Timestamp strEn2SqlDateTime(String dateString, String format) {
        //        System.out.println("strEn2SqlDateTime: "+dateString);
            java.sql.Timestamp sqlDate = null;
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US); 
                java.util.Date inputDate = formatter.parse(dateString);
                sqlDate = new java.sql.Timestamp(inputDate.getTime());
            } catch (Exception e) {
                System.out.println("Exception :: strEn2SqlDateTime " + e.getMessage());
                return null;
            }
        //        System.out.println(">>>>> result: "+dateString.substring(0, 19));
            return sqlDate;
        }    
}
