package com.marwane.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        return Math.random() * 100;
    }
}
