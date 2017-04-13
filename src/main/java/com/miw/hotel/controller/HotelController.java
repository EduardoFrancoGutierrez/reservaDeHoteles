package com.miw.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miw.hotel.model.Hotel;
import com.miw.hotel.repository.HotelRepository;
import com.miw.hotel.repository.RoomRepository;
import com.miw.hotel.wrapper.HotelWrapper;

@RestController
@RequestMapping(value = "/api/hotels")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;
    
    @Autowired
    RoomRepository roomRepository;

    
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
    
    @RequestMapping(value = "androoms", method = RequestMethod.GET) 
    public List<HotelWrapper> getAllHotels() {
    	List<Hotel> hotels = hotelRepository.findAll();
    	List<HotelWrapper> hotelsWrapper = new ArrayList<HotelWrapper>();
    	for(Hotel hotel : hotels){
    		hotelsWrapper.add(new HotelWrapper(hotel.getName(), hotel.getImage(), roomRepository.findByHotel_Id(hotel.getId())));
    	}
    	
    	return hotelsWrapper;
    }

}
