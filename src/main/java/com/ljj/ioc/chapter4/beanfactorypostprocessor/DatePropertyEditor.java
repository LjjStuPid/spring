package com.ljj.ioc.chapter4.beanfactorypostprocessor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/30 14:20
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String datePattern;


    @Override
    public void setAsText(String text) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getDatePattern());
        try {
            Date date = simpleDateFormat.parse(text);
            setValue(date);
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
