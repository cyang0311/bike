package com.example.bike.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bike.Entity.Bike;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//交给spring容器管理
public class BikeServiceImpl implements BikeService {

    @Autowired//按类型注入
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Bike bike) {
        //mongoTemplate.insert(bike,"bikes");
        mongoTemplate.insert(bike);//映射关系在实体类中保存
    }
    @Override
    public List<GeoResult<Bike>> findNear(double longitude, double latitude) {
        //根据经纬度传值，查找附近
        NearQuery nearQuery = NearQuery.near(longitude, latitude);
        //指定查找的距离、单位
        nearQuery.maxDistance(0.3,Metrics.KILOMETERS);
        GeoResults<Bike> geoResults = mongoTemplate.geoNear(nearQuery
                .query(new Query(Criteria.where("status").is(0))//限制查询条件
                        .limit(20))//限制查询数量
                ,Bike.class);
        return geoResults.getContent();
    }


}
