package com.example.bike.Controller;

import com.example.bike.Entity.Bike;
import com.example.bike.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//标记该类位接受和响应用户请求的控制器
//加@com.example.bike.Controller，Spring容器会对他实例化
@Controller
public class BikeController {

    @Autowired//到spring容器中查找BikeService类型的实例，然后注入到BikeController实例中
    private BikeService bikeService;

    @RequestMapping("/bike/add")
    @ResponseBody//返回json数据
    public String addbike(@RequestBody Bike bike){
        //调用services 将数据保存在mongodb
        bikeService.save(bike);
        return "success ";
    }

    @RequestMapping("/bike/findNear")
    @ResponseBody
    public List<GeoResult<Bike>> findNear(double longitude, double latitude){
        List<GeoResult<Bike>> bikes = bikeService.findNear(longitude,latitude);
        return bikes;
    }
}
