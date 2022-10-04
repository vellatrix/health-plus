package org.healthplus.vendor.service;

import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.enums.Result;

public interface VendorService {


  ProductInfoInquiryDTO getProduct(Long vendorId, Long productId);

  RestaurantInfoInquiryDTO getRestaurant(Long vendorId);

  Result updateProduct(Long vendorId, Long productId, ProductInfoDTO productInfo);

  ProductInfoRegistrationResultDTO registerProductInfo(Long restaurantId, ProductInfoRegistrationDTO productInfo);

  VendorRegistrationResultDTO registerVendor(VendorRegistrationDTO vendorInfo);

  VendorProfileInquiryDTO getVendorProfile(Long vendorId);

  Result removeVendor(Long vendorId);
}
