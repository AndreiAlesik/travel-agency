package com.example.travelagency.web.attraction;

import com.example.travelagency.dto.ResponseObject;
import com.example.travelagency.service.attraction.AttractionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class AttractionControllerBean implements AttractionController {
    private final AttractionService attractionService;

    @Override
    public ResponseObject getAllCustomers() {
        var allAttractions = attractionService.getAll();

        return new ResponseObject(HttpStatus.OK, "OK", allAttractions);
    }
}
