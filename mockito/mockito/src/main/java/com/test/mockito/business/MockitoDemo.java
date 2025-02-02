package com.test.mockito.business;

public class MockitoDemo {
	private final DataService dataService;

	public MockitoDemo( final DataService p_dataService ) {
		dataService = p_dataService;
	}

	public int findgreatest(){
		final int[] list =dataService.fetchData();
		return list[0];
	}
}

interface DataService{
	int[] fetchData();
}
