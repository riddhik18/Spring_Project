package com.example.controller;

import com.example.entity.Booking;
import com.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarBookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/carbooking")
    public String showBookingForm(Model model) {
        // You may populate model attributes if needed
        model.addAttribute("booking", new Booking());
        return "carbooking";
    }

    @PostMapping("/submit_booking")
    public String submitBookingForm(Booking booking) {
        // You may perform validation, save to the database, etc.
        bookingService.saveBooking(booking);
        return "redirect:/success"; // Redirect to a success page
    }

   

}
