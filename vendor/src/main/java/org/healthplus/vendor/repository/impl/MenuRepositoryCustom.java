package org.healthplus.vendor.repository.impl;

import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuRepositoryCustom {

  long modifyProductInfo(Long restaurantId, Long productId, ProductInfoDTO productInfo);

  List<Long> findIdList(Long restaurantId);

  Page<ProductInfoByCategoryDTO> findByCategoryId(Long categoryId, Pageable pageable);
}
