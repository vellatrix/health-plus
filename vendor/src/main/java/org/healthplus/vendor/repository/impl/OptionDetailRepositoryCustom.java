package org.healthplus.vendor.repository.impl;


import java.util.List;

public interface OptionDetailRepositoryCustom {


  List<Long> findIdList(List<Long> optionGroupIdList);
}
