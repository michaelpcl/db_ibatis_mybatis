package com.myself;


import com.myself.entity.City;
import com.myself.ibatis_dao.IbatisCityDao;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class IbatisTest {
    public static void main(String[] args) {
        IbatisCityDao cityDao = new IbatisCityDao();
        City city = new City();
        city.setDistrict("Noord-Holland");


        System.out.println("获取总记录数");
        cityDao.calculateTotal();


        System.out.println("根据id获取记录");
        cityDao.getCityById(1);


        System.out.println("根据对象查询");
        cityDao.getList(city);

    }
}
