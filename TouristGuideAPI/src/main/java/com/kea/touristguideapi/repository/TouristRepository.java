package com.kea.touristguideapi.repository;
import com.kea.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        //populateTouristAttractions();
        touristAttractions.add(new TouristAttraction("Rundetårn","Flot højt tårn i København."));
        touristAttractions.add(new TouristAttraction("Odense Zoo","Her kan du bl.a. se en rød panda! Lidt uden for København ..."));
        touristAttractions.add(new TouristAttraction("Skagen","Her har alle de store danske malere været."));
        touristAttractions.add(new TouristAttraction("Hedehusene","Meget idyllisk landsby med en spændende historie."));
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        for(TouristAttraction touristAttraction : touristAttractions) {
            String getName = touristAttraction.getName().toLowerCase().replaceAll("\\s", "");
            if (getName.equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(String name, String description) {
        TouristAttraction newTouristAttraction = new TouristAttraction(name, description);
        touristAttractions.add(newTouristAttraction);
        return newTouristAttraction;
    }

    public void updateTouristAttraction(TouristAttraction attraction, String description) {
        attraction.setDescription(description);
    }

    public void deleteTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            String getName = touristAttraction.getName().toLowerCase().replaceAll("\\s", "");
            if (getName.equals(name)) {
                touristAttractions.remove(touristAttraction);
            }
        }
    }
}
