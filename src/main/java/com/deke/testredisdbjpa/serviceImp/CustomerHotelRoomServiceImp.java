package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.CustomerHotelRoomRequestDto;
import com.deke.testredisdbjpa.entity.Customer;
import com.deke.testredisdbjpa.entity.CustomerHotelRoom;
import com.deke.testredisdbjpa.entity.HotelRoom;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.repositories.CustomerHotelRoomRepository;
import com.deke.testredisdbjpa.service.*;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import com.deke.testredisdbjpa.testRest.RestController;
import com.deke.testredisdbjpa.testRest.TestRestTemplateService;
import lombok.SneakyThrows;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class CustomerHotelRoomServiceImp extends BaseServiceImp<CustomerHotelRoom, CustomerHotelRoom, CustomerHotelRoomRepository, CustomerHotelRoom> implements CustomerHotelRoomService {

    private final CustomerService customerService;
    private final HotelRoomService hotelRoomService;
    private final PricingService pricingService;
    private final TestRestTemplateService testRestTemplateService;

    public CustomerHotelRoomServiceImp(CustomerService customerService, HotelRoomService hotelRoomService, PricingService pricingService, TestRestTemplateService testRestTemplateService) {
        this.customerService = customerService;
        this.hotelRoomService = hotelRoomService;
        this.pricingService = pricingService;
        this.testRestTemplateService = testRestTemplateService;
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
        customerHotelRoom.setHotelRoom(hotelRoomService.findOne(hotelRoomRequestDto.getHotelRoomId()).stream().findFirst().orElse(null));
        customerHotelRoom.setExitDate(hotelRoomRequestDto.getExitDate());
        customerHotelRoom.setEntryDate(hotelRoomRequestDto.getEntryDate());
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
        double usd = Double.parseDouble(Objects.requireNonNull(testRestTemplateService.getRecentUSD().getAlis()));
        return String.format(Objects.equals(pricing.getMoneyType().toLowerCase(), "dolar") ?
                pricing.getChildPrice() * usd + pricing.getAdultPrice() * usd + " DOLAR" :
                pricing.getChildPrice() + pricing.getAdultPrice() + " TL");
    }
}
