package com.codegym.service;


import com.codegym.model.Setting;
import com.codegym.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SettingServiceImpl implements SettingService {
private SettingRepository settingRepository;
@Autowired
public SettingServiceImpl(SettingRepository settingRepository) {this.settingRepository = settingRepository;}
    @Override
    public List<Setting> findAll() {
        return settingRepository.findAll();
    }

    @Override
    public Setting findBySignature(String signature) {
        return settingRepository.findBySignature(signature);
    }

    @Override
    public void update(Setting setting) {
settingRepository.update(setting);
    }

    @Override
    public List<Setting> getAllUser() {
        return null;
    }
}
