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

    public TouristAttraction getTouristAttractionByName(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction(String name, String description) {
        return touristRepository.addTouristAttraction(name, description);
    }

    public void updateTouristAttraction(TouristAttraction touristAttraction, String description) {
       touristRepository.updateTouristAttraction(touristAttraction, description);
    }

    public void deleteTouristAttractionByName(String name) {
        touristRepository.deleteTouristAttractionByName(name);
    }
}
