package ru.netology.gorodnichevilya.service;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.gorodnichevilya.configuration.OperationProcessingProperties;
import ru.netology.gorodnichevilya.domain.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
@RequiredArgsConstructor
public class AsyncInputOperationServiceTest {
	@Autowired
	private AsyncInputOperationService asyncInputOperationService;
	@Autowired
	private StatementService statementService;
	@Autowired
	private OperationProcessingProperties properties;

	@Test
	public void getAsyncInputOperationServiceTest() throws InterruptedException {
		Operation operation = new Operation(1, 20, Currency.RUB, "Coffee", 2);
		asyncInputOperationService.addOperation(operation);
		Thread.sleep(2L * properties.getTimeout());
		Operation serviceOperation = statementService.getOperation(operation.getCustomerId(), 0);
		assertEquals(operation, serviceOperation);
		assertEquals(operation.getId(), serviceOperation.getId());
		assertEquals(operation.getSum(), serviceOperation.getSum());
		assertEquals(operation.getCurrency(), serviceOperation.getCurrency());
		assertEquals(operation.getMerchant(), serviceOperation.getMerchant());
	}
}
