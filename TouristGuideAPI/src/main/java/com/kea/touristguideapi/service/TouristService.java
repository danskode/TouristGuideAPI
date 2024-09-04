package com.kea.touristguideapi.service;

import com.kea.touristguideapi.model.TouristAttraction;
import com.kea.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllTouristAttractions(){
        return touristRepository.getAllTouristAttractions();
    }

    public List<TouristAttraction> getTouristAttractionByName(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addTouristAttraction(touristAttraction);
    }

    public void deleteTouristAttractionByName(String nameStriped) {
        touristRepository.deleteTouristAttractionByName(nameStriped);
    }

    //CRUD-metoder svarende til dem i Repository ...
}
