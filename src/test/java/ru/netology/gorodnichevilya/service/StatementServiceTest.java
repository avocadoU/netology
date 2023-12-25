package ru.netology.gorodnichevilya.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.gorodnichevilya.domain.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementServiceTest extends OperationHistoryApiApplicationTest {
	@Autowired
	private StatementService statementService;

	@Test
	public void getStatementServiceTest() {
		int operationId = 1;
		int operationClientId = 0;
		int clientId = 1;
		int operationSum = 25;
		Currency operationCurrency = Currency.RUB;
		String operationMerchant = "Bread";
		Operation operation = new Operation(operationId, operationSum, operationCurrency, operationMerchant, clientId);
		statementService.setOperation(clientId, operation);
		Operation serviceOperation = statementService.getOperation(clientId, operationClientId);
		assertEquals(operation, serviceOperation);
		assertEquals(operationId, serviceOperation.getId());
		assertEquals(operationSum, serviceOperation.getSum());
		assertEquals(operationCurrency, serviceOperation.getCurrency());
		assertEquals(operationMerchant, serviceOperation.getMerchant());
	}
}
