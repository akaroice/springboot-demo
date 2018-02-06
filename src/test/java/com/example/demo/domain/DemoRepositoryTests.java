package com.example.demo.domain;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest(excludeAutoConfiguration = {CacheAutoConfiguration.class, FlywayAutoConfiguration.class})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class DemoRepositoryTests {
	@Autowired
	private DemoRepository demoRepository;

	@Test
	public void saveTest() {
		DemoEntity entity = new DemoEntity();
		entity.setName("name");
		entity.setVersion(10L);
		entity.setCreatedBy("akaroice");
		entity.setCreatedAt(new DateTime().toDate());
		entity.setModifiedBy("akaroice");
		entity.setModifiedAt(new DateTime().toDate());
		demoRepository.save(entity);
	}

	@Test
	public void findTest() {
		DemoEntity found = demoRepository.findOne(1L);
		assertThat(found.getName()).isEqualTo("demo test");
		assertThat(found.getVersion()).isEqualTo(115);
	}
}
