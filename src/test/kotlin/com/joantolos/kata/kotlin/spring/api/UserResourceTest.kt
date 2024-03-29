package com.joantolos.kata.kotlin.spring.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
class UserResourceTest {

	@Autowired
	private val mockMvc: MockMvc? = null

	@Test
	@Modifying
	@Transactional
	fun shouldGetAllUsers() {
		this.mockMvc
				?.perform(MockMvcRequestBuilders.get("/users"))
				?.andDo(MockMvcResultHandlers.print())
				?.andExpect(MockMvcResultMatchers.status().isOk)
				?.andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("luke"))
	}

	@Test
	@Modifying
	@Transactional
	fun shouldAddUser() {
		mockMvc?.perform(MockMvcRequestBuilders.post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"username\":\"Sith\", \"password\":\"XXX\" }")
		)?.andDo(MockMvcResultHandlers.print())
		 ?.andExpect(MockMvcResultMatchers.status().isCreated)
	}

	@Test
	@Modifying
	@Transactional
	fun shouldUpdateUser() {
		mockMvc?.perform(MockMvcRequestBuilders.put("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"username\":\"luke\", \"password\":\"yyy\"}"))
				?.andDo(MockMvcResultHandlers.print())
				?.andExpect(MockMvcResultMatchers.status().isCreated)
	}
}
