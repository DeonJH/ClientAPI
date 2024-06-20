package com.clientApi;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.clientApi.controller.ClientsController;
import com.clientApi.model.Client;
import com.clientApi.service.ClientService;

import lombok.SneakyThrows;

public class ControllerTests {
	
	private MockMvc mockMvc;
	
	@Mock
	private ClientService clientService;
	
	@InjectMocks
	private ClientsController clientsController;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(clientsController).build();
	}
	
	@SneakyThrows
	@Test
	public void testGetClient() {
		// set up
		when(clientService.getClient((long) 1))
				.thenReturn(Client.builder().id((long) 1).name("John Doe").email("JohnD@ex.com").build());

		// assert
		mockMvc.perform(get("/clients/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json("{'id':1,'name':'John Doe','email':'JohnD@ex.com'}"));

	}

	@SneakyThrows
	@Test
	public void testGetAllClients() {
		// set up
		List<Client> clients = new ArrayList<Client>();
		clients.add(Client.builder().id((long) 1).name("John Doe").email("JohnD@ex.com").build());
		clients.add(Client.builder().id((long) 2).name("Jane Doe").email("JaneD@ex.com").build());

		when(clientService.getAllClients()).thenReturn(clients);

		// assert
		mockMvc.perform(get("/clients").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(
						"[{'id':1,'name':'John Doe','email':'JohnD@ex.com'},{'id':2,'name':'Jane Doe','email':'JaneD@ex.com'}]"));

	}

}
