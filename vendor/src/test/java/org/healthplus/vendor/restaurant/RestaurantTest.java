package org.healthplus.vendor.restaurant;

import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RestaurantTest {

  @Autowired
  RestaurantService restaurantService;

  @Autowired
  MockMvc mockMvc;

  @Test
  void getRestaurantInfoByUrl() throws Exception {
    Long vendorId = 1L;

    mockMvc.perform(get("/vendor/{vendorId}/info", vendorId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

  }

  @Test
  void getRestaurantInfo() throws Exception {
    Long vendorId = 1L;

    RestaurantInfoInquiryDTO restaurantInfo = restaurantService.getRestaurant(vendorId);

    assertThat(restaurantInfo).isNotNull();
  }
}
