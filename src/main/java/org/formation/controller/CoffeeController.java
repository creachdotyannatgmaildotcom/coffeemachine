package org.formation.controller;

import java.util.List;

import org.formation.dto.AcountInfoDto;
import org.formation.model.Coffee;
import org.formation.service.CoffeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("coffees")
public class CoffeeController {

	private static final Logger LOG = LoggerFactory.getLogger(CoffeeController.class);
	private CoffeeService service;

	@Value("${build.version}")
	private String build;
	@Autowired
	private AcountInfoDto infoDto;

	CoffeeController(CoffeeService service) {
		this.service = service;
	}

	@GetMapping
	List<Coffee> getCoffees() {
		LOG.trace("===========> TRACE");
		LOG.debug("===========> DEBUG");
		LOG.info("===========> INFO");
		LOG.warn("===========> WARN");
		LOG.error("===========> ERROR");

		return service.getAll();
	}

	@PostMapping
	Coffee createCoffee(@RequestBody @Valid Coffee coffee) {
		return service.save(coffee);
	}

	@GetMapping("{id}")
	ResponseEntity<Coffee> getCoffeeById(@PathVariable Long id) {
		return service.getById(id).map(c -> ResponseEntity.ok(c)).orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "get build version", description = "get the version of the build")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Response is ok"

	), @ApiResponse(responseCode = "500", description = "server is on error"

	)

	})
	@GetMapping("build")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.ok(build);
	}

	@GetMapping("account")
	public ResponseEntity<AcountInfoDto> getInfo() {
		return ResponseEntity.ok(infoDto);
	}

}
