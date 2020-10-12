package site.newvalue.service;


import site.newvalue.domain.Province;

import java.util.List;

public interface ProvinceService {

    List<Province> findAll();

    String findAllJson();
}
