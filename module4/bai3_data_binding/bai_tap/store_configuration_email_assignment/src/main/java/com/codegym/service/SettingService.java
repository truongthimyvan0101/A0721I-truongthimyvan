package com.codegym.service;


import com.codegym.model.Setting;

import java.util.List;

public interface SettingService {
    List<Setting> findAll();
    Setting findBySignature(String signature);
    void update (Setting setting);

    List<Setting> getAllUser();
}
