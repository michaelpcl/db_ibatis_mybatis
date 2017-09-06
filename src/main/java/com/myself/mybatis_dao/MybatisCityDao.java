package com.myself.mybatis_dao;

import com.ibatis.common.resources.Resources;
import com.myself.entity.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class MybatisCityDao implements IMybatisCityDao{

    private static SqlSessionFactory sqlSessionFactory = null;


    // 读取配置文件
    static {
        try {
            String resource = "mybatisSqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int calculateTotal() {
        SqlSession session = sqlSessionFactory.openSession();
        int total = session.selectOne("calTotalCityNum");
        System.out.println("*****total num" + total);
        if(session != null){
            session.close();
        }
        return 0;
    }


    public List getList(City city) {
        SqlSession session = sqlSessionFactory.openSession();
        List list = session.selectList("selectStudentByDistrict",city);
        System.out.println("*****根据地区分布获取的city的集合" + list.size());
        if(session != null){
            session.close();
        }
        return null;
    }

    public City getCityById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        City city = session.selectOne("selectCityById", id);
        System.out.println("*****获取的city  name" + city.getName());
        return null;
    }
}
