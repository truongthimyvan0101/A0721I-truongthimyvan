package com.codegym.service;

import com.codegym.model.Setting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingServiceImpl implements SettingService {
    private static Map<String, Setting> settingMap;

    static {
        settingMap = new HashMap<>();
        settingMap.put("Nguyễn văn A", new Setting("Vietnamese", 10, true, "Nguyễn văn A"));
        settingMap.put("Linda", new Setting("English", 5, false, "Linda"));
        settingMap.put("john", new Setting("Laos", 15, true, "John"));
    }
    @Override
    public List<Setting> findAll() {
        return null;
    }

    @Override
    public Setting findBySignature(String signature) {
        return null;
    }

    @Override
    public void save(Setting setting) {

    }
}
