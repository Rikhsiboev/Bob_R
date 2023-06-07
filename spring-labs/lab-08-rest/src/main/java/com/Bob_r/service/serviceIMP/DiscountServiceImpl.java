package com.Bob_r.service.serviceIMP;

import com.Bob_r.dto.DiscountDTO;
import com.Bob_r.entity.Discount;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.DiscountRepository;
import com.Bob_r.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> findAllDiscounts() {
        return discountRepository.findAll().stream()
                .map(obj -> mapperUtil.convert(obj, new DiscountDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateDiscount(DiscountDTO discountDTO) {

        Long discountId = discountDTO.getId();

        Discount discount= mapperUtil.convert(discountDTO, new Discount());

        discountRepository.findById(discountId).ifPresent(dbDiscount -> {
            dbDiscount.setName(discount.getName());
            dbDiscount.setDiscount(discount.getDiscount());
            dbDiscount.setDiscountType(dbDiscount.getDiscountType());

            discountRepository.save(dbDiscount);
        });
    }

    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        discountRepository.save(
                mapperUtil.convert(discountDTO,new Discount())
        );
        return discountDTO;
    }

    @Override
    public DiscountDTO getDiscountByName(String name) {
        return mapperUtil.convert(discountRepository.findFirstByName(name),new DiscountDTO());
    }
}
