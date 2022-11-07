package org.healthplus.vendor.menu;

import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.enums.IsYn;
import org.healthplus.vendor.enums.MenuType;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.repository.OptionDetailRepository;
import org.healthplus.vendor.repository.OptionGroupRepository;
import org.healthplus.vendor.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MenuTest {

  @Autowired
  MenuService menuService;

  @Autowired
  OptionDetailRepository optionDetailRepository;

  @Autowired
  OptionGroupRepository optionGroupRepository;



  @Test
  void getProductInfo() throws Exception {
    Long vendorId = 1L;
    Long productId = 2L;

    ProductInfoDTO productInfo = menuService.getProduct(vendorId, productId);

    System.out.println(productInfo);

    assertThat(productInfo).isNotNull();
  }

  @Test
  void addProductInfo() {
    // given
    Long restaurantId = 1L;
    List<ProductInfoRegistrationDTO> productList = new ArrayList<>();
    ProductInfoRegistrationDTO productInfo1 = ProductInfoRegistrationDTO.builder()
            .categoryId(1L)
            .name("치즈 샐러드")
            .price(9000)
            .calorie(200)
            .description("치즈맛이 풍부한 샐러드")
            .categoryType("SALAD")
            .menuType(MenuType.A)
            .optionGroup(Arrays.asList(
                    new ProductOptionGroupInfoDTO("기본", IsYn.Y, IsYn.N,
                            Arrays.asList(
                                    new ProductOptionDetailInfoDTO("아메리칸 치즈", 11000),
                                    new ProductOptionDetailInfoDTO("모짜렐라 치즈", 10000),
                                    new ProductOptionDetailInfoDTO("리코타 치즈", 9500)
                    )),
                    new ProductOptionGroupInfoDTO("소스선택", IsYn.N, IsYn.Y,
                            Arrays.asList(
                                    new ProductOptionDetailInfoDTO("오리엔탈", 0),
                                    new ProductOptionDetailInfoDTO("딥치즈", 500),
                                    new ProductOptionDetailInfoDTO("시저", 500)
                    ))
            ))
            .build();

    ProductInfoRegistrationDTO productInfo2 = ProductInfoRegistrationDTO.builder()
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

    productList.add(productInfo1);
    productList.add(productInfo2);

    // when
    List<ProductInfoRegistrationResultDTO> result = menuService.registerProductInfo(restaurantId, productList);

    // then
    assertThat(result).isNotNull();


  }

  @Test
  void getProductList() {
    // given
    Long restaurantId = 1L;

    // when
    List<ProductInfoDTO> productList = menuService.getProductList(restaurantId);

    // then
    assertThat(productList).isNotNull();
    System.out.println(productList);
  }

  @Test
  void removeProduct() {
    Long restaurantId = 1L;
    Long productId = 1L;

    Result result = menuService.removeProductInfo(restaurantId, productId);

    assertThat(result).isEqualTo(Result.SUCCESS);
  }

  @Test
  void updateProduct() {
    Long restaurantId = 1L;
    Long productId = 1L;

    ProductInfoDTO newProductInfo = ProductInfoDTO.builder()
            .menuId(1L)
            .name("골드 치킨 샐러드")
            .price(13000)
            .calorie(600)
            .description("우아한 샐러드")
            .optionGroup(Arrays.asList(
                    new ProductOptionGroupInfoDTO(2L,"냠냠", IsYn.Y, IsYn.N,
                            Arrays.asList(
                                    new ProductOptionDetailInfoDTO(2L,"냠 치킨", 12000),
                                    new ProductOptionDetailInfoDTO(3L,"냠2 치킨", 13000),
                                    new ProductOptionDetailInfoDTO(4L,"냠3 치킨", 20000)
                            )),
                    new ProductOptionGroupInfoDTO(3L,"소스선택", IsYn.Y, IsYn.Y,
                            Arrays.asList(
                                    new ProductOptionDetailInfoDTO(40L,"오리엔탈", 500),
                                    new ProductOptionDetailInfoDTO(41L,"양념", 600),
                                    new ProductOptionDetailInfoDTO(42L,"갈릭", 800),
                                    new ProductOptionDetailInfoDTO(43L,"타르타르", 700)
                            ))
            ))
            .build();

    List<ProductInfoDTO> result = menuService.updateProduct(restaurantId,
                                                                productId,
                                                                newProductInfo);

    System.out.println(result);
    assertThat(result).isNotNull();
  }

  @Test
  void getProductListByCategoryId() {
    Long categoryId = 1L;

    PageRequest pageRequest = PageRequest.of(0, 4);

    Page<ProductInfoByCategoryDTO> productList = menuService.getProductListByCategoryId(categoryId, pageRequest);

    assertThat(productList.getSize()).isEqualTo(4);
  }

}
