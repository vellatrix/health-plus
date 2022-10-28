package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.healthplus.vendor.entity.QMenu.*;
import static org.healthplus.vendor.entity.QOptionDetail.*;
import static org.healthplus.vendor.entity.QOptionGroup.*;
import static org.healthplus.vendor.entity.QRestaurant.*;


@Repository
@RequiredArgsConstructor
public class VendorRepositoryImpl implements VendorRepositoryCustom {

  private final JPAQueryFactory query;


}
