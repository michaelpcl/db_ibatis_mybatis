package com.myself;


import com.myself.entity.City;
import com.myself.ibatis_dao.IbatisCityDao;
import com.myself.mybatis_dao.MybatisCityDao;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class MybatisTest {
    public static void main(String[] args) {

        MybatisCityDao cityDao = new MybatisCityDao();
        City city = new City();
        city.setDistrict("Noord-Holland");


        System.out.println("获取总记录数");
        cityDao.calculateTotal();


        System.out.println("根据id获取记录");
        cityDao.getCityById("1");


        System.out.println("根据对象查询");
        cityDao.getList(city);

    }
}
