package com.miw.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miw.hotel.Hotel;
import com.miw.hotel.HotelRepository;

@RestController
@RequestMapping(value = "/api/hotels")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Hotel> gethotels(){
        return hotelRepository.findAll();
    }
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Hotel gethotel(@PathVariable(value="name")String name){
        return hotelRepository.findByName(name);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addhotel(@RequestBody Hotel hotel){
        hotelRepository.insert(hotel);
    }

}
