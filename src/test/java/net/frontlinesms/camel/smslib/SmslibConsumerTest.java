package net.frontlinesms.camel.smslib;

import static org.mockito.Mockito.*;

import org.apache.camel.Processor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmslibConsumerTest {
	Processor mockProcessor;
	SmslibEndpoint mockEndpoint;
	SmslibService mockSmslibService;
	SmslibConsumer c;
	
	@Before
	public void setUp() {
		mockProcessor = mock(Processor.class);
		mockEndpoint = mock(SmslibEndpoint.class);
		mockSmslibService = mock(SmslibService.class);
		c = new SmslibConsumer(mockEndpoint, mockSmslibService, mockProcessor);
	}
	
	@After
	public void tearDown() {
		mockProcessor = null;
		mockEndpoint = null;
		mockSmslibService = null;
		c = null;
	}
	
	@Test
	public void testDoStartShouldStartService() throws Exception {
		c.doStart();
		verify(mockSmslibService).startFor(c);
	}
	
	@Test
	public void testDoStopShouldStopService() throws Exception {
		c.stop();
		verify(mockSmslibService).stopFor(c);
	}
}