package com.codegym.service;

import com.codegym.model.Setting;

import java.util.List;

public interface SettingService {

    void save(Setting setting);

    Setting findById(int id);


    void update(int id, Setting setting);


}
