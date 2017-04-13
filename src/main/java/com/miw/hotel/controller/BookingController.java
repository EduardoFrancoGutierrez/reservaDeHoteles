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

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	BookingRepository bookRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
    ClientRepository hotelRepository;
	
	@Autowired
	MailSender mailSender;

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
		
		Client client = clientRepository.findById(booking.getClient().getId());
		String body = "Sr/Sra " + client.getName() + ":\n Su reserva en el hotel ";
		body += hotelRepository.findById(roomRepository.findById(booking.getRoom().getId()).getId()).getName();
		body += " y con código de reserva ";
		body += booking.getReservationCode();
		body += " ha sido cancelada.";
		mailSender.sendMail(client.getEmail(), "Reserva " + booking.getReservationCode() + " cancelada", body);
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
			booking.getClient().setId(clientRepository.findTopOrderById().getId() + 1);
			clientRepository.save(booking.getClient());
		}

		booking.setId(bookRepository.findTopOrderById().getId() + 1);
		bookRepository.save(booking);

	}
	
	@RequestMapping(value = "/client/{reservationCode}", method = RequestMethod.GET)
    public List<Booking> getAllBooksByClientNif(@PathVariable String reservationCode){
        return bookRepository.findByReservationCode(reservationCode);
    }
}
