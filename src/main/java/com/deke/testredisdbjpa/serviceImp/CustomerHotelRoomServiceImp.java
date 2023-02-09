package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CustomerHotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.entity.CustomerHotelRoom;
import com.deke.testredisdbjpa.entity.HotelRoom;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.exceptions.RestRuntimeException;
import com.deke.testredisdbjpa.repositories.CustomerHotelRoomRepository;
import com.deke.testredisdbjpa.service.CustomerHotelRoomService;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.service.HotelRoomService;
import com.deke.testredisdbjpa.service.PricingService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import com.deke.testredisdbjpa.utils.ExternalApiUtil;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;


@Service
public class CustomerHotelRoomServiceImp extends BaseServiceImp<CustomerHotelRoom, CustomerHotelRoom, CustomerHotelRoomRepository, CustomerHotelRoom> implements CustomerHotelRoomService {

    private final CustomerService customerService;
    private final HotelRoomService hotelRoomService;
    private final ModelMapper modelMapper;

    public CustomerHotelRoomServiceImp
            (CustomerService customerService, HotelRoomService hotelRoomService,
             ModelMapper modelMapper) {
        this.customerService = customerService;
        this.hotelRoomService = hotelRoomService;
        this.modelMapper = modelMapper;
    }

    @Override
    @SneakyThrows
    public CustomerHotelRoom rentARoom(CustomerHotelRoomRequestDto hotelRoomRequestDto) {
        Customer customer = modelMapper.map(hotelRoomRequestDto.getCustomerRequestDto(), Customer.class);
        customerService.save(customer);
        CustomerHotelRoom customerHotelRoom = modelMapper.map(hotelRoomRequestDto, CustomerHotelRoom.class);
        customerHotelRoom.setCustomer(customer);
        customerHotelRoom.setHotelRoom(hotelRoomService.findOne(hotelRoomRequestDto.getHotelRoomId()).
                stream().findFirst().orElseThrow(() -> new RestRuntimeException("HotelRoom not found", "001")));
        return save(customerHotelRoom);
    }


}
