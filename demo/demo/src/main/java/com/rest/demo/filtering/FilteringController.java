package com.rest.demo.filtering;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering") //field2
	public MappingJacksonValue filtering() {

		final SomeBean someBean = new SomeBean( "value1", "value2", "value3");

		final MappingJacksonValue mappingJacksonValue = new MappingJacksonValue( someBean);

		final SimpleBeanPropertyFilter filter =
			SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

		final FilterProvider filters =
			new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );

		mappingJacksonValue.setFilters(filters );


		return mappingJacksonValue;
	}

	@GetMapping("/filtering-list") //field2, field3
	public MappingJacksonValue filteringList() {
		final List<SomeBean> list = Arrays.asList( new SomeBean( "value1", "value2", "value3"),
												   new SomeBean("value4","value5", "value6"));
		final MappingJacksonValue mappingJacksonValue = new MappingJacksonValue( list);

		final SimpleBeanPropertyFilter filter =
			SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

		final FilterProvider filters =
			new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );

		mappingJacksonValue.setFilters(filters );


		return mappingJacksonValue;
	}

}
