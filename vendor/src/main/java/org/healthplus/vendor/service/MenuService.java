package org.healthplus.vendor.service;

import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoListDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.enums.Result;

import java.util.List;

public interface MenuService {

  ProductInfoInquiryDTO getProduct(Long restaurantId, Long productId);

  Result updateProduct(Long vendorId, Long productId, ProductInfoListDTO productInfo);

  List<ProductInfoRegistrationResultDTO> registerProductInfo(Long restaurantId, List<ProductInfoRegistrationDTO> productInfo);

  List<ProductInfoListDTO> getProductList(Long restaurantId);

  Result removeProductInfo(Long restaurantId, Long productId);
}
