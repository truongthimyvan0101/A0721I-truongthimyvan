package com.codegym.repository;

import com.codegym.model.Setting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class SettingRepositoryImpl implements SettingRepository{
    private static Map<String, Setting> settingMap = new HashMap<>();
    static {
        settingMap = new HashMap<>();
        settingMap.put("Nguyen văn A", new Setting("Vietnamese", 10, true, "Nguyễn văn A"));
        settingMap.put("John", new Setting("English", 5, false, "John"));
        settingMap.put("Linda", new Setting("Laos", 15, true, "Linda"));

    }

    @Override
    public List<Setting> findAll() {
        return new ArrayList<>(settingMap.values());
    }

    @Override
    public void update(Setting setting) {
settingMap.put(setting.getSignature(), setting);
    }

    @Override
    public Setting findBySignature(String signature) {
        return settingMap.get(signature);
    }
}
