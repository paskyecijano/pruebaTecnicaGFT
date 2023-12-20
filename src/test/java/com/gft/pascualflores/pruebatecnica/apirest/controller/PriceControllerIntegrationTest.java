package com.gft.pascualflores.pruebatecnica.apirest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ActiveProfiles("test")
@SpringBootTest
class PriceControllerIntegrationTest {
  public static final long EXPECTED_PRODUCT_ID = 35455L;
  public static final long EXPECTED_BRAND_ID = 1L;
  public static final Double EXPECTED_PRICE = 35.5;
  public static final Double EXPECTED_PRICE2 = 25.45;
  public static final Double EXPECTED_PRICE3 = 35.5;
  public static final Double EXPECTED_PRICE4 = 30.5;
  public static final Double EXPECTED_PRICE5 = 38.95;

  private static final String PATH = "/api/v1/getPrice";
  private static final String PRODUCT_ID = "35455";
  private static final String BRAND_ID = "1";
  private static final String wrongDate = "2021-06-20T16:00:00Z";
  @Autowired private PriceController priceController;
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
  }

  @Test
  void given_test_data_when_call_priceController_then_return_ok_and_correct_data()
      throws Exception {
    callEndpoint("2020-06-14T10:00:00Z", EXPECTED_PRICE);
  }

  @Test
  void given_test_data_when_call_priceController_then_return_ok_and_correct_data2()
      throws Exception {
    callEndpoint("2020-06-14T16:00:00Z", EXPECTED_PRICE2);
  }

  @Test
  void given_test_data_when_call_priceController_then_return_ok_and_correct_data3()
      throws Exception {
    callEndpoint("2020-06-14T21:00:00Z", EXPECTED_PRICE3);
  }

  @Test
  void given_test_data_when_call_priceController_then_return_ok_and_correct_data4()
      throws Exception {
    callEndpoint("2020-06-15T10:00:00Z", EXPECTED_PRICE4);
  }

  @Test
  void given_test_data_when_call_priceController_then_return_ok_and_correct_data5()
      throws Exception {
    callEndpoint("2020-06-16T21:00:00Z", EXPECTED_PRICE5);
  }

  @Test
  void given_wrong_test_data_when_call_priceController_then_return_bad_request() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(PATH)
                .param("date", wrongDate)
                .param("productId", PRODUCT_ID)
                .param("brandId", BRAND_ID))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  private void callEndpoint(String date, Double price) throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(PATH)
                .param("date", date)
                .param("productId", PRODUCT_ID)
                .param("brandId", BRAND_ID))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.productId").value(EXPECTED_PRODUCT_ID))
        .andExpect(jsonPath("$.brandId").value(EXPECTED_BRAND_ID))
        .andExpect(jsonPath("$.price").value(price));
  }
}
