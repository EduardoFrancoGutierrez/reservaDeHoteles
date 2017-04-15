package com.miw.hotel.controller;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miw.hotel.exceptions.InvalidBookingException;
import com.miw.hotel.exceptions.InvalidRoomException;
import com.miw.hotel.model.Booking;
import com.miw.hotel.model.Client;
import com.miw.hotel.model.Room;
import com.miw.hotel.repository.BookingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookingControllerTest {
	
	private static final String CLIENT_ID = "58f0a026e545a5298c4db96a";
	private static final String ROOM_ID = "58ee21dc734d1d271d37ea45";
	private static final String HOTEL_ID = "58ed07ea734d1d0e65fc797c";
	private static final String WRONG_HOTEL_ID = "58ed07ea734d1d0965fc797c";
	

	
	@Autowired
	private BookingController bookingController;
	
	@Autowired
	private BookingRepository bookingRepository;
	


	@Test
	public void testCreateInvalidBookingExceptionBook() {
		Booking booking = new Booking();
		
		Client client = new Client();
		client.setId(CLIENT_ID);
		client.setNif("AAAAAA");
		booking.setClient(client);
		
		Room room = new Room();
		room.setId(ROOM_ID);
		booking.setRoom(room);		
		
		try {
			bookingController.createBook(booking);
			fail();
		} catch (InvalidBookingException e) {
			
		} catch (InvalidRoomException e) {
			fail();
		}
	}
	
	@Test
	public void testCreateBook() {
		Booking booking = new Booking();
		Calendar cal=Calendar.getInstance();
		cal.set(1977, 12, 12);
		booking.setStartDate(cal.getTimeInMillis());
		
		booking.setEndDate(cal.getTimeInMillis()+(4*60*60*1000));

		Client client = new Client();
		client.setId(CLIENT_ID);
		client.setNif("AAAAAA");
		booking.setClient(client);
		
		Room room = new Room();
		room.setId(ROOM_ID);
		booking.setRoom(room);		
		
		try {
			bookingController.createBook(booking);	
			bookingRepository.deleteById(booking.getId());
	
		} catch (InvalidRoomException | InvalidBookingException e) {
			fail();
		}
	}
	
	@Test
	public void testCreateInvalidRoomExceptionBook() {
		Booking booking = new Booking();
		booking.setStartDate(Calendar.getInstance().getTimeInMillis());
		booking.setEndDate(Calendar.getInstance().getTimeInMillis()+(4*60*60*1000));
		
		Client client = new Client();
		client.setId(CLIENT_ID);
		client.setNif("AAAAAA");
		booking.setClient(client);
		
		Room room = new Room();	
		room.setId(new ObjectId().toString());
		booking.setRoom(room);
		
		try {
			bookingController.createBook(booking);
			fail();
		} catch (InvalidBookingException e) {
			fail();
		} catch (InvalidRoomException e) {
			
		}
	}
	
	@Test
	public void testGetAllBooks() {
		assertNotNull(bookingController.getAllBooks());
	}
	
	@Test
	public void testGetBooksByHotelID() {
		assertFalse(bookingController.getByHotelID(HOTEL_ID).isEmpty());
	}
	
	@Test
	public void testGetBooksByHotelIDEmpty() {
		assertTrue(bookingController.getByHotelID(WRONG_HOTEL_ID).isEmpty());
	}
	
	@Test
    public void testCreateInvalidBookingExceptionBookByRepeatBook() {
	    Booking booking = new Booking();
        Calendar cal=Calendar.getInstance();
        cal.set(1978, 12, 12);
        booking.setStartDate(cal.getTimeInMillis());
        
        booking.setEndDate(cal.getTimeInMillis()+(4*60*60*1000));

        Client client = new Client();
        client.setId(CLIENT_ID);
        client.setNif("AAAAAA");
        booking.setClient(client);
        
        Room room = new Room();
        room.setId(ROOM_ID);
        booking.setRoom(room);      
        
        try {
            bookingController.createBook(booking);  
            bookingController.createBook(booking);  
            
    
        } catch (InvalidBookingException e) {
            bookingRepository.deleteById(booking.getId());
        } catch (InvalidRoomException e) {
            fail();
        }
    }
		


}
