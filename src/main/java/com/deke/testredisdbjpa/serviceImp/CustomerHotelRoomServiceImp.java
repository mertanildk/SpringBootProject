package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.entity.dto.request.CustomerHotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.entity.CustomerHotelRoom;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.utils.exceptions.NonMatchedAnyEntityException;
import com.deke.testredisdbjpa.repositories.CustomerHotelRoomRepository;
import com.deke.testredisdbjpa.service.CustomerHotelRoomService;
import com.deke.testredisdbjpa.service.CustomerService;
import com.deke.testredisdbjpa.service.HotelRoomService;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import com.deke.testredisdbjpa.utils.messages.ExceptionMessages;
import com.deke.testredisdbjpa.utils.mapping.modelMapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerHotelRoomServiceImp extends BaseServiceImp<CustomerHotelRoom, CustomerHotelRoom, CustomerHotelRoomRepository, CustomerHotelRoom> implements CustomerHotelRoomService {

    private final CustomerService customerService;
    private final HotelRoomService hotelRoomService;
    private final ModelMapperService modelMapper;

    @SneakyThrows
    @Override
    public CustomerHotelRoom rentARoom(CustomerHotelRoomRequestDto hotelRoomRequestDto) {
        Customer customer = modelMapper.forClass().map(hotelRoomRequestDto.getCustomerRequestDto(), Customer.class);
        customerService.save(customer);
        CustomerHotelRoom customerHotelRoom = modelMapper.forClass().map(hotelRoomRequestDto, CustomerHotelRoom.class);
        customerHotelRoom.setCustomer(customer);
        customerHotelRoom.setHotelRoom(hotelRoomService.findOne(hotelRoomRequestDto.getHotelRoomId()).
                stream().findFirst().orElseThrow(() -> new NonMatchedAnyEntityException(Hotel.class.getName()+ExceptionMessages.NOT_FOUND, "001")));
        return save(customerHotelRoom);
    }


}
