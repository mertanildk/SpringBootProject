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


@Service
public class CustomerHotelRoomServiceImp extends BaseServiceImp<CustomerHotelRoom, CustomerHotelRoom, CustomerHotelRoomRepository, CustomerHotelRoom> implements CustomerHotelRoomService {

    private final CustomerService customerService;
    private final HotelRoomService hotelRoomService;
    private final PricingService pricingService;
    private final ModelMapper modelMapper;

    public CustomerHotelRoomServiceImp
            (CustomerService customerService, HotelRoomService hotelRoomService,
             PricingService pricingService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.hotelRoomService = hotelRoomService;
        this.pricingService = pricingService;
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
                stream().findFirst().orElseThrow(() -> new RestRuntimeException("HotelRoom not found","001")));
        return save(customerHotelRoom);
    }

    @Override
    public Pricing test(String id) {//hotelRoomId -> hotelId
        HotelRoom hotelRoom = Streamable.of(findAll()).stream()
                .filter(customerHotelRoom -> customerHotelRoom.getHotelRoom().getOid().equals(id))
                .findAny().orElseThrow().getHotelRoom();

        //hotel id ve room id yi çekip iki id'ye göre pricing tablosundan price çekecez
        return Streamable.of(pricingService.findAll())
                .stream().filter(pricing1 ->
                        pricing1.getHotel().getOid().equals(hotelRoom.getHotel().getOid()) &&
                                pricing1.getRoom().getOid().equals(hotelRoom.getRoom().getOid())).findAny().orElse(null);


    }

    @Override
    @SneakyThrows
    public String calculatePrice(String id) {
        Pricing pricing = pricingService.findOne(id).stream().findFirst().orElseThrow(() -> new Exception("Pricing not found"));
        double usd = Double.parseDouble(Objects.requireNonNull(new ExternalApiUtil().getRecentUSD().getAlis()));
        return String.format(Objects.equals(pricing.getMoneyType().toLowerCase(), "dolar") ?
                pricing.getChildPrice() * usd + pricing.getAdultPrice() * usd + " DOLAR" :
                pricing.getChildPrice() + pricing.getAdultPrice() + " TL");
    }
}
