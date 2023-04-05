package com.example.travelagency.service.guide;

import com.example.travelagency.domain.Guide;


import java.util.List;

public interface GuideService {
    Guide create(Guide guide);

    List<Guide> getAll();

    void delete(Integer id);

    Guide updateById(Integer id, Guide guide);

    Guide getById(Integer id);
}
