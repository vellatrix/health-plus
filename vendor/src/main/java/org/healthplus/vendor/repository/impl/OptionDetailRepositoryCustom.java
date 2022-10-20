package org.healthplus.vendor.repository.impl;


import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.entity.OptionDetail;

import java.util.List;

public interface OptionDetailRepositoryCustom {

  long modifyOptionDetailInfo(List<ProductOptionDetailInfoDTO> optionInfo);

  List<ProductOptionDetailInfoDTO> findProductOptionInfo(Long productId);

  List<Long> findIdList(List<Long> optionGroupIdList);

  List<OptionDetail> findDetailList(List<Long> menuIdList);
}
