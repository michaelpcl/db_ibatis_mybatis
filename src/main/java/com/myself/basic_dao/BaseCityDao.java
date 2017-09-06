package com.myself.basic_dao;

import com.myself.entity.City;
import com.myself.utils.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class BaseCityDao extends DBHelper {

    public List getList(){
        ArrayList list = new ArrayList();
        ResultSet rs = null;
        DBHelper db=new DBHelper();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from city");
        rs=db.query(stringBuffer.toString());
        System.out.println("**********sql" + stringBuffer.toString());
        try {
            if(rs != null) {
                while (rs.next()) {
                    City city = new City();
                    city.setId(rs.getString("id"));
                    city.setName(rs.getString("name"));
                    list.add(city);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }



}
