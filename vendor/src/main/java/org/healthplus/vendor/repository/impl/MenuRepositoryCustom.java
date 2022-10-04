package org.healthplus.vendor.repository.impl;


import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;

import java.util.List;

public interface MenuRepositoryCustom {

  long modifyProductInfo(Long vendorId, Long productId, ProductInfoDTO productInfo);
  long modifyOptionDetailInfo(List<ProductOptionDetailInfoDTO> optionInfo);


  List<Long> findIdList(Long restaurantId);
}
