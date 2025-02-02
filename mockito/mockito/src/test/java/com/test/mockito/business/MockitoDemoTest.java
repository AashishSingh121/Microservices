package com.test.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MockitoDemoTest {
	@Mock
	private DataService dataService;

	@Test
	void findgreatest() {
		final DataService dataService=mock( DataService.class);
		when( dataService.fetchData() ).thenReturn( new int[]{1,25,15} );
		final MockitoDemo l_mockitoDemo = new MockitoDemo(dataService);
		assertEquals(1, l_mockitoDemo.findgreatest());
	}
}