package org.healthplus.vendor.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.enums.IsYn;
import org.healthplus.vendor.enums.MenuType;
import org.healthplus.vendor.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MenuApiTest {

  @Autowired
  MenuService menuService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void getProductInfoByUrl() throws Exception {
    Long restaurantId = 1L;
    Long productId = 1L;

    mockMvc.perform(get("/menu/{restaurantId}/{productId}/info", restaurantId, productId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
  }



  @Test
  void addProductInfoByUrl() throws Exception {
    Long restaurantId = 1L;
    ProductInfoRegistrationDTO productInfo = ProductInfoRegistrationDTO.builder()
            .categoryId(1L)
            .name("치킨 샐러드")
            .price(10000)
            .calorie(450)
            .description("담백한 치킨 샐러드")
            .categoryType("SALAD")
            .menuType(MenuType.A)
            .optionGroup(Arrays.asList(
                    new ProductOptionGroupInfoDTO("기본", IsYn.Y, IsYn.N,
                            Arrays.asList(
                                    new ProductOptionDetailInfoDTO("그릴 치킨", 15000),
                                    new ProductOptionDetailInfoDTO("베이크 치킨", 14000),
                                    new ProductOptionDetailInfoDTO("숯불 치킨", 16000)
                            )),
                    new ProductOptionGroupInfoDTO("음료선택", IsYn.N, IsYn.N,
                            Arrays.asList(
                                    new ProductOptionDetailInfoDTO("콜라", 1500),
                                    new ProductOptionDetailInfoDTO("사이다", 1500),
                                    new ProductOptionDetailInfoDTO("오렌지주스", 2000)
                            ))
            ))
            .build();

    mockMvc.perform(post("/vendor/{restaurantId}/product", restaurantId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productInfo)))
            .andExpect(status().isOk())
            .andDo(print());

  }
}
