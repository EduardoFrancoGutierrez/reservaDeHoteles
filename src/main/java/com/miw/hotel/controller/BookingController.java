package com.miw.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miw.hotel.model.Booking;
import com.miw.hotel.model.Status;
import com.miw.hotel.repository.BookingRepository;

@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {
    @Autowired
    BookingRepository bookRepository;

    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Booking> getAllBooks(){
        return bookRepository.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Booking getBook(@PathVariable(value="id")int id){
        return bookRepository.findById(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void cancelBooking(@RequestBody int id){
        Booking booking = bookRepository.findById(id);
        booking.setStatus(Status.CANCEL);
    	bookRepository.save(booking);
    }

}
