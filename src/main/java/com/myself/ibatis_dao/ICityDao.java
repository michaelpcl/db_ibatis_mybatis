package com.myself.ibatis_dao;

import com.myself.entity.City;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public interface ICityDao {
    // 获取总记录数
    int calculateTotal();

    //获取满足条件的记录集合
    List getList(City city);

    //获取单条记录
    City getCityById(int id);
}
