package org.healthplus.vendor.repository.impl;

import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoListDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.entity.Menu;

import java.util.List;

public interface MenuRepositoryCustom {

  long modifyProductInfo(Long vendorId, Long productId, ProductInfoListDTO productInfo);

  ProductInfoInquiryDTO findProductInfo(Long restaurantId, Long productId);

  List<Long> findIdList(Long restaurantId);

  List<Menu> findProductListByVendorId(Long vendorId);

}
