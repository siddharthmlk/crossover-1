package com.dev.crossover.product;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dev.crossover.Application;
import com.dev.crossover.saleOrder.SaleOrderRepository;

@ContextConfiguration(classes = { Application.class })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestPropertySource(locations="classpath:application.properties")
public class ProductControllerTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SaleOrderRepository saleOrderRepository;
	
	Product p;

	protected MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext context;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        saleOrderRepository.deleteAll();
        productRepository.deleteAll();
        p = new Product();
        p.setCode("12");
        p.setDescription("dd");
        p.setPrice("34");
        p.setQuantity("100");
        productRepository.save(p);
    }
    
    @Test
    public void shouldGetProduct() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk())
        .andExpect(
				jsonPath("$[0].code", equalTo("12")))
		.andExpect(
				jsonPath("$[0].description", equalTo("dd")));
    }
}
