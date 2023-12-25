package ru.netology.gorodnichevilya.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.gorodnichevilya.domain.Operation;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import ru.netology.gorodnichevilya.service.AsyncInputOperationService;
import ru.netology.gorodnichevilya.service.StatementService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/operations")
public class OperationController {
	private final AsyncInputOperationService asyncInputOperationService;
	private final StatementService statementService;

	@GetMapping("/{customerId}")
	public ResponseEntity<Iterable<Operation>> getClientOperations(@PathVariable Integer customerId) {
		List<Operation> operations = statementService.getCustomerOperations(customerId);
		if (operations != null)
			return new ResponseEntity<>(operations, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public Operation postOperation(@RequestBody Operation operation) {
		asyncInputOperationService.addOperation(operation);
		return operation;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Operation> deleteOperation(@PathVariable int id) {
		AtomicReference<Operation> deletedOperation = new AtomicReference<>(null);
		statementService.getStatement()
				.values().forEach(operations -> operations.removeIf(operation -> {
					if (operation.getId() == id) {
						deletedOperation.set(operation);
						return true;
					}
					return false;
				}));
		if (deletedOperation.get() != null)
			return new ResponseEntity<>(deletedOperation.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
