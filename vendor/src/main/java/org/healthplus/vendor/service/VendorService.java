package org.healthplus.vendor.service;

import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.dto.VendorProfileInquiryDTO;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.dto.VendorRegistrationResultDTO;
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
