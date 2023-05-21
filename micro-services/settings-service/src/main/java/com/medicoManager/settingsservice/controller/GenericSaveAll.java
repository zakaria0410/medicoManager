package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BaseDTO;

import java.util.List;

public class GenericSaveAll<D extends BaseDTO> {
    private List<D> data;

    public GenericSaveAll() {
    }

    public List<D> getData() {
        return data;
    }

    public void setData(List<D> data) {
        this.data = data;
    }
}
