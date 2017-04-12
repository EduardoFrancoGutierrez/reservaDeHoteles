package com.miw.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miw.hotel.exceptions.InvalidBookingException;
import com.miw.hotel.exceptions.InvalidRoomException;
import com.miw.hotel.model.Booking;
import com.miw.hotel.model.Client;
import com.miw.hotel.model.Status;
import com.miw.hotel.repository.BookingRepository;
import com.miw.hotel.repository.ClientRepository;
import com.miw.hotel.repository.RoomRepository;
import com.miw.hotel.utils.MailSender;

@RestController
@RequestMapping(value = "/api/books")
public class BookingController {

	RoomRepository roomRepository;

	BookingRepository bookRepository;
	
	ClientRepository clientRepository;
	
	MailSender mailSender;

	@Autowired
	public void setBookingRepository(BookingRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Autowired
	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@Autowired
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Booking> getAllBooks() {
		return bookRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Booking getBook(@PathVariable(value = "id") String id) {
		return bookRepository.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void cancelBooking(@RequestBody String id) {
		Booking booking = bookRepository.findById(id);
		booking.setStatus(Status.CANCEL.name());
		bookRepository.save(booking);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createBook(@RequestBody Booking booking) throws InvalidRoomException, InvalidBookingException {
		if (!booking.valid()) {
			throw new InvalidBookingException();
		}

		if (roomRepository.findById(booking.getRoom().getId()) == null) {
			throw new InvalidRoomException();
		}
		
		if(clientRepository.findById(booking.getClient().getId()) == null) {
			booking.getClient().setId(clientRepository.findTopOrderByIdDesc().getId() + 1);
			clientRepository.save(booking.getClient());
		}

		booking.setId(bookRepository.findTopOrderByIdDesc().getId() + 1);
		bookRepository.save(booking);

	}
	
	@RequestMapping(value = "/client/{nif}", method = RequestMethod.GET)
    public List<Booking> getAllBooksByClientNif(@PathVariable String nif){
        Client client = clientRepository.findByNif(nif);
        return bookRepository.findByClient_Id(client.getId());
    }
}
