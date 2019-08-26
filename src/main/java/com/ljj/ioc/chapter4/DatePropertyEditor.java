package com.ljj.ioc.chapter4;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/26 11:15
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String datePattern;

    @Override
    public void setAsText(String text) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getDatePattern());
        try {
            Date dateValue = simpleDateFormat.parse(text);
            setValue(dateValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
