package com.deke.testredisdbjpa.serviceImp;

import com.deke.testredisdbjpa.dto.request.PricingRequestDto;
import com.deke.testredisdbjpa.entity.Hotel;
import com.deke.testredisdbjpa.entity.Period;
import com.deke.testredisdbjpa.entity.Pricing;
import com.deke.testredisdbjpa.entity.Room;
import com.deke.testredisdbjpa.repositories.PricingRepository;
import com.deke.testredisdbjpa.service.*;
import com.deke.testredisdbjpa.serviceImp.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("pricingService")
public class PricingServiceImp extends BaseServiceImp<Pricing, Pricing, PricingRepository, Pricing> implements PricingService {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PeriodService periodService;

    @Autowired
    private HostelTypeService hostelTypeService;

    @Override
    public String getPricingDetailById(String id) {
        Pricing pricing = getDao().findById(id).get();

        return "hotel name = " + pricing.getHotel().getHotelName() +
                " room name = " + pricing.getRoom().getRoomType() +
                " period name = " + pricing.getPeriod().getPeriodName() +
                " adult price = " + pricing.getAdultPrice() +
                " child price = " + pricing.getChildPrice();
    }

    @Override
    public Pricing addPricing(PricingRequestDto pricingRequestDto) {
        return getDao().save(Pricing.builder()
                .hotel(hotelService.findOne(pricingRequestDto.getHotelOid()).get())
                .room(roomService.findOne(pricingRequestDto.getRoomOid()).get())
                .period(periodService.findOne(pricingRequestDto.getPeriodOid()).get())
                .hostelType(hostelTypeService.findOne(pricingRequestDto.getHostelTypeOid()).get())
                .adultPrice(pricingRequestDto.getAdultPrice())
                .childPrice(pricingRequestDto.getChildPrice())
                .moneyType(pricingRequestDto.getMoneyType())
                .build());

    }
}
