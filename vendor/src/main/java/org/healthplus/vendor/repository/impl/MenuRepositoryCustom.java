package org.healthplus.vendor.repository.impl;


import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;

import java.util.List;

public interface MenuRepositoryCustom {

  long modifyProductInfo(Long vendorId, Long productId, ProductInfoDTO productInfo);
  long modifyOptionDetailInfo(List<ProductOptionDetailInfoDTO> optionInfo);


  List<Long> findIdList(Long restaurantId);
}
