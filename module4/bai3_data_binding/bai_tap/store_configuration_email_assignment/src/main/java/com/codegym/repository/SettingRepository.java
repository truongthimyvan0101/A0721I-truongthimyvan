package com.codegym.repository;

import com.codegym.model.Setting;

import java.util.List;

public interface SettingRepository {
    List<Setting> findAll();
    void update (Setting setting);
    Setting findBySignature(String signature);

}
