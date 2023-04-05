package com.example.travelagency.service.stage;

import com.example.travelagency.domain.Stage;
import com.example.travelagency.dto.stage.StageRequestDTO;


import java.util.List;

public interface StageService {
    Stage create(StageRequestDTO stageRequestDTO);
    List<Stage> getAll();
    Stage updateById(Integer id, Stage stageToUpdate);
    Stage getById(Integer id);
}
