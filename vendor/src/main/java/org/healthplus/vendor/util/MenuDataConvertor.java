package org.healthplus.vendor.util;

import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.entity.OptionGroup;

import java.util.ArrayList;
import java.util.List;

public class MenuDataConvertor {

  public static ProductInfoDTO toMenuInquiryDTO(Menu menu, List<ProductOptionGroupInfoDTO> optionGroupDtoList) {
    return ProductInfoDTO.builder()
            .menuId(menu.getMenuId())
            .name(menu.getName())
            .price(menu.getPrice())
            .description(menu.getDescription())
            .useYn(menu.getUseYn())
            .soldYn(menu.getSoldYn())
            .calorie(menu.getCalorie())
            .optionGroup(optionGroupDtoList)
            .build();
  }

  public static Menu createMenu(Long restaurantId, ProductInfoRegistrationDTO dto) {
    return Menu.builder()
            .restaurantId(restaurantId)
            .categoryId(dto.getCategoryId())
            .name(dto.getName())
            .price(dto.getPrice())
            .calorie(dto.getCalorie())
            .description(dto.getDescription())
            .menuType(dto.getMenuType())
            .build();
  }

  public static OptionGroup createOptionGroup(Long menuId, ProductOptionGroupInfoDTO dto) {
    return new OptionGroup(menuId,
            dto.getName(),
            dto.getBasicChoiceYn(),
            dto.getEtcChoiceYn());
  }

  public static ProductInfoRegistrationResultDTO toRegistrationResultDTO(Menu menu, List<ProductOptionGroupInfoDTO> optionGroupDtoList) {
    return ProductInfoRegistrationResultDTO.builder()
            .menuId(menu.getMenuId())
            .restaurantId(menu.getRestaurantId())
            .categoryId(menu.getCategoryId())
            .type(menu.getMenuType().name())
            .description(menu.getDescription())
            .soldYn(menu.getSoldYn())
            .useYn(menu.getUseYn())
            .createdAt(menu.getCreatedAt())
            .name(menu.getName())
            .price(menu.getPrice())
            .calorie(menu.getCalorie())
            .optionGroups(optionGroupDtoList)
            .build();
  }

  public static List<ProductOptionDetailInfoDTO> toInquiryDTOList(List<OptionDetail> optionDetails) {
    List<ProductOptionDetailInfoDTO> optionDetailDTOList = new ArrayList<>();

    for (OptionDetail optionDetail : optionDetails) {
      optionDetailDTOList.add(new ProductOptionDetailInfoDTO(optionDetail.getOptionDetailId(), optionDetail.getName(), optionDetail.getPrice()));
    }

    return optionDetailDTOList;
  }

  public static List<OptionDetail> addOptionDetails(Long optionGroupId, List<ProductOptionDetailInfoDTO> optionDetails) {
    if(optionDetails.size() == 0) throw new IllegalArgumentException("옵션 상세 데이터가 존재하지 않습니다.");

    List<OptionDetail> optionDetailList = new ArrayList<>();
    for (ProductOptionDetailInfoDTO dto : optionDetails) {
      optionDetailList.add(new OptionDetail(optionGroupId, dto.getName(), dto.getPrice()));
    }

    return optionDetailList;
  }

  public static ProductOptionGroupInfoDTO toOptionGroupDto(OptionGroup group, List<ProductOptionDetailInfoDTO> optionDetails) {
    return ProductOptionGroupInfoDTO.builder()
            .optionGroupId(group.getOptionGroupId())
            .name(group.getName())
            .basicChoiceYn(group.getBasicChoiceYn())
            .etcChoiceYn(group.getEtcChoiceYn())
            .optionDetails(optionDetails)
            .build();
  }

  public static ProductOptionDetailInfoDTO toOptionDetailInquiryDTO(OptionDetail optionDetail) {
    return new ProductOptionDetailInfoDTO(optionDetail.getOptionDetailId(), optionDetail.getName(), optionDetail.getPrice());
  }

  public static ProductOptionGroupInfoDTO toOptionGroupInquiryDTO(OptionGroup optionGroup, List<ProductOptionDetailInfoDTO> optionDetailDtoList) {
    return ProductOptionGroupInfoDTO.builder()
            .optionGroupId(optionGroup.getOptionGroupId())
            .name(optionGroup.getName())
            .basicChoiceYn(optionGroup.getBasicChoiceYn())
            .etcChoiceYn(optionGroup.getEtcChoiceYn())
            .optionDetails(optionDetailDtoList)
            .build();
  }

}
