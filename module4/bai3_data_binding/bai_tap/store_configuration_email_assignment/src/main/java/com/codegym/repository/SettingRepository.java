package com.codegym.repository;

import com.codegym.model.Setting;

import java.util.List;

public interface SettingRepository {
    List<Setting> findAll();
    Setting findBySignature(String signature);
    void update (Setting setting);

}
