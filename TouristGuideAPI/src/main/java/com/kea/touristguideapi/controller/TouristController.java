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

    //create a new one ... virker ikke pt ...
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newAttraction = touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    //edit one ...
    @PostMapping("/update/{urlName}")
    public ResponseEntity<String> updateTouristAttraction(@PathVariable String urlName, @RequestBody String name, String description){
        String nameStriped = urlName.toLowerCase().replaceAll("\\s", "");
        TouristAttraction attraction = touristService.getTouristAttractionByName(nameStriped);
        touristService.updateTouristAttraction(attraction, name, description);
        return new ResponseEntity<>("Updated just fine!", HttpStatus.OK);
    }

    //delete one ...
    @PostMapping("/delete/{name}")
    public ResponseEntity<String> deleteTouristAttractionByName(@PathVariable String name) {
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        touristService.deleteTouristAttractionByName(nameStriped);
        return new ResponseEntity<>("Attraction deleted", HttpStatus.OK);
    }
}
