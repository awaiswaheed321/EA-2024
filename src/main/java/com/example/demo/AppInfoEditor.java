package com.example.demo;

import java.beans.PropertyEditorSupport;

public class AppInfoEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] parts = text.split("\\|");
        AppInfo appInfo = new AppInfo(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Float.parseFloat(parts[4]));
        setValue(appInfo);
    }
}