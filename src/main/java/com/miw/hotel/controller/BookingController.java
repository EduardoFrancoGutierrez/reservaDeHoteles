package com.miw.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miw.hotel.model.Booking;
import com.miw.hotel.model.Client;
import com.miw.hotel.repository.BookingRepository;
import com.miw.hotel.repository.ClientRepository;

@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    
    @Autowired
    ClientRepository clientRepository;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Booking> getBookingsByClient(@RequestBody String nif){
        Client client = clientRepository.findByNif(nif);
        return bookingRepository.findByClient(client);
    }
}
