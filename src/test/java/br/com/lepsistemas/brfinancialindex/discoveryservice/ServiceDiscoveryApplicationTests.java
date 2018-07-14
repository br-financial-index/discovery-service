package br.com.lepsistemas.brfinancialindex.discoveryservice;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpStatus.OK;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceDiscoveryApplicationTests {
	
	@LocalServerPort
    private int port;
	
	@Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void should_start_eureka_server() {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + "/eureka/apps", String.class);
		assertThat(entity.getStatusCode(), is(OK));
	}

}
