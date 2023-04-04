package com.example.travelagency.util.mapstruct;


import com.example.travelagency.domain.Stage;
import com.example.travelagency.dto.stage.StageRequestDTO;
import com.example.travelagency.dto.stage.StageResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StageMapper {
    Stage requestDTOToStage(StageRequestDTO stageRequestDTO);

    StageResponseDTO stageToResponseDTO(Stage stage);
}
