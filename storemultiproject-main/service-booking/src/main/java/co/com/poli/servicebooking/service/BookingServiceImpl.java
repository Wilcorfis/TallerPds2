package co.com.poli.servicebooking.service;

import co.com.poli.servicebooking.client.UserClient;
import co.com.poli.servicebooking.client.MovieClient;
import co.com.poli.servicebooking.entities.Booking;
import co.com.poli.servicebooking.entities.Movielist;
import co.com.poli.servicebooking.model.User;
import co.com.poli.servicebooking.model.Movie;
import co.com.poli.servicebooking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final MovieClient movieClient;

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Booking invoice) {
        bookingRepository.delete(invoice);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> findByUserId(Long UserId) {
        List<Booking> booking = bookingRepository.findByUserId(UserId);
        ModelMapper modelMapper = new ModelMapper();

        return bookingRepository.findByUserId(UserId);
    }
}
