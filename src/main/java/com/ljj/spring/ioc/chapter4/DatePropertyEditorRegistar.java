package com.ljj.spring.ioc.chapter4;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/26 13:34
 */
public class DatePropertyEditorRegistar implements PropertyEditorRegistrar {

    private PropertyEditor propertyEditor;

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(java.util.Date.class, getPropertyEditor());
    }

    public PropertyEditor getPropertyEditor() {
        return propertyEditor;
    }

    public void setPropertyEditor(PropertyEditor propertyEditor) {
        this.propertyEditor = propertyEditor;
    }
}
