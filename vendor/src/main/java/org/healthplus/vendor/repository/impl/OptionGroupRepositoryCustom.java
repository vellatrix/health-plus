package org.healthplus.vendor.repository.impl;

import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.entity.OptionGroup;
import java.util.List;

public interface OptionGroupRepositoryCustom {


  List<Long> findIdList(List<Long> menuIdList);

  List<OptionGroup> findGroupList(List<Long> optionGroupIdList);

  long modifyOptionGroupInfo(ProductOptionGroupInfoDTO optionGroupList);
}
