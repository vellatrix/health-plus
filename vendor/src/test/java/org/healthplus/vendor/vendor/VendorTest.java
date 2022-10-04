package org.healthplus.vendor.vendor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.enums.IsYn;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class VendorTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  VendorService vendorService;

  @Autowired
  ObjectMapper objectMapper;

  static VendorRegistrationDTO vendor = VendorRegistrationDTO.builder()
          .id("test1234")
          .password("testpassword")
          .name("김민수")
          .bank("신한")
          .accountNumber("111-224-333333")
          .email("test@test.com")
          .phoneNumber("01028831222")
          .businessName("건강한 수제견과")
          .businessHour("09:00~19:00")
          .businessNumber("3213211122")
          .mainType("견과")
          .subType("견과")
          .minimumPrice(15000)
          .deliveryFee(0)
          .city("서울특별시 서초구")
          .street("서초대로 332")
          .zipCode(13324)
          .build();

  @Test
  void addVendor() {
    VendorRegistrationResultDTO result = vendorService.registerVendor(vendor);

    assertThat(result).isNotNull();
  }

  @Test
  void addVendorByUrl() throws Exception {
    mockMvc.perform(post("/vendor")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(vendor)))
            .andExpect(status().isOk())
            .andDo(print());
  }

  @Test
  void getVendorProfileByUrl() throws Exception {
    Long vendorId = 1L;

    mockMvc.perform(get("/vendor/{vendorId}/profile", vendorId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
  }

  @Test
  void getVendorProfile(){
    Long vendorId = 1L;

    VendorProfileInquiryDTO vendorProfile = vendorService.getVendorProfile(vendorId);

    assertThat(vendorProfile.getBusinessName()).isEqualTo("슈퍼 샐러드");
    assertThat(vendorProfile.getBusinessNumber()).isEqualTo("1103984932");
  }

  @Test
  void removeVendor() {
    Long vendorId = 1L;

    Result result = vendorService.removeVendor(vendorId);

    assertThat(result).isEqualTo(Result.SUCCESS);
  }
}
