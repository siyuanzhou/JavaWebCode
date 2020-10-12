package site.syzhou.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("请输入日期数据");
        } else {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = df.parse(s);
            } catch (ParseException e) {
                throw new RuntimeException("日期准换错误");
            }
            return date;
        }
    }
}
