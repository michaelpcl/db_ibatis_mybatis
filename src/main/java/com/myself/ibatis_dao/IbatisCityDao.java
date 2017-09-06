package com.myself.ibatis_dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.myself.entity.City;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class IbatisCityDao implements ICityDao{

    private static SqlMapClient sqlMapClient = null;
    // 读取配置文件
    static {
        try {
            Reader reader = Resources.getResourceAsReader("IbatisSqlMapConfig.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // 获取总记录数
    public int calculateTotal() {
        try {
            int total = (Integer) sqlMapClient.queryForObject("calTotalCityNum");
            System.out.println("*****total num" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    //获取满足条件的记录集合
    public List getList(City city) {
        try {
            List list = sqlMapClient.queryForList("selectStudentByDistrict", city);
            System.out.println("*****根据地区分布获取的city的集合" + list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //获取单条记录
    public City getCityById(int id){
        try {
            City city = (City) sqlMapClient.queryForObject("selectCityById", id);
            System.out.println("*****获取的city  name" + city.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
