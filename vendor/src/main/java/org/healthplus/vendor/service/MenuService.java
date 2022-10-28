package org.healthplus.vendor.service;

import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.enums.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {

  ProductInfoDTO getProduct(Long restaurantId, Long productId);

  List<ProductInfoDTO> updateProduct(Long restaurantId, Long productId, ProductInfoDTO productInfo);

  List<ProductInfoRegistrationResultDTO> registerProductInfo(Long restaurantId, List<ProductInfoRegistrationDTO> productInfo);

  List<ProductInfoDTO> getProductList(Long restaurantId);

  Result removeProductInfo(Long restaurantId, Long productId);

  Page<ProductInfoByCategoryDTO> getProductListByCategoryId(Long categoryId, Pageable pageable);
}
