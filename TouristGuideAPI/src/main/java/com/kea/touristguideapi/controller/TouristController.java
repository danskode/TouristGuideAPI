package com.kea.touristguideapi.controller;
import com.kea.touristguideapi.model.TouristAttraction;
import com.kea.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // see all ...
    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllMessages(){
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    //search for one ...
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name){
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        TouristAttraction attraction = touristService.getTouristAttractionByName(nameStriped);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    //create a new one ...
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(String name, String description){
        TouristAttraction newAttraction = touristService.addTouristAttraction(name, description);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    //edit one ...
    @PostMapping("/update/{name}")
    public ResponseEntity<String> updateTouristAttraction(@PathVariable String name, String description){
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        TouristAttraction attraction = touristService.getTouristAttractionByName(nameStriped);

        if (attraction != null) {
            touristService.updateTouristAttraction(attraction, description);
            return new ResponseEntity<>("Updated succesfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete one ...
    @PostMapping("/delete/{name}")
    public ResponseEntity<String> deleteTouristAttractionByName(@PathVariable String name) {
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        touristService.deleteTouristAttractionByName(nameStriped);
        return new ResponseEntity<>("Attraction deleted", HttpStatus.OK);
    }
}
