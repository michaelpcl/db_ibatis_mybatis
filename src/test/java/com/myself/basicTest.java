package com.myself;

import com.myself.basic_dao.BaseCityDao;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class basicTest {
    public static void main(String[] args) {
        BaseCityDao cityDao = new BaseCityDao();
        List list = cityDao.getList();
        System.out.println("***********list size" + list.size());
    }
}
