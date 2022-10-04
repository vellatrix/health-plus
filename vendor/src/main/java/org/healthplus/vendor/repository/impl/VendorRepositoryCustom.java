package org.healthplus.vendor.repository.impl;


import org.healthplus.vendor.dto.*;

import java.util.List;

public interface VendorRepositoryCustom {

  ProductInfoInquiryDTO findProductInfo(Long vendorId, Long productId);

  List<ProductOptionDetailInfoDTO> findProductOptionInfo(Long productId);

  RestaurantInfoInquiryDTO findRestaurantInfo(Long vendorId);


}
