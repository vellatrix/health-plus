package org.healthplus.vendor.repository.impl;


import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;

import java.util.List;

public interface OptionGroupRepositoryCustom {


  List<Long> findIdList(List<Long> menuIdList);
}
