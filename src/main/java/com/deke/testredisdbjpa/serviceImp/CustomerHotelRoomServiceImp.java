package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CustomerHotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.entity.CustomerHotelRoom;
import com.deke.testredisdbjpa.repositories.CustomerHotelRoomRepository;
import com.deke.testredisdbjpa.service.CustomerHotelRoomService;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.service.HotelRoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
public class CustomerHotelRoomServiceImp extends BaseServiceImp<CustomerHotelRoom,CustomerHotelRoom, CustomerHotelRoomRepository,CustomerHotelRoom> implements CustomerHotelRoomService {

    private final CustomerService customerService;
    private final HotelRoomService hotelRoomService;

    public CustomerHotelRoomServiceImp(CustomerService customerService, HotelRoomService hotelRoomService) {
        this.customerService = customerService;
        this.hotelRoomService = hotelRoomService;
    }

    @Override
    @SneakyThrows
    public CustomerHotelRoom rentARoom(CustomerHotelRoomRequestDto hotelRoomRequestDto) {
        Customer customer = new Customer();
        customer.setEmail(hotelRoomRequestDto.getEmail());
        customer.setName(hotelRoomRequestDto.getName());
        customer.setPhone(hotelRoomRequestDto.getPhone());
        customerService.save(customer);
        CustomerHotelRoom customerHotelRoom = new CustomerHotelRoom();
        customerHotelRoom.setCustomer(customer);
        customerHotelRoom.setHotelRoom(hotelRoomService.findOne(hotelRoomRequestDto.getHotelRoomId()).stream().findFirst().get());
        customerHotelRoom.setExitDate(hotelRoomRequestDto.getExitDate());
        customerHotelRoom.setEntryDate(hotelRoomRequestDto.getEntryDate());
        return save(customerHotelRoom);
    }
}
