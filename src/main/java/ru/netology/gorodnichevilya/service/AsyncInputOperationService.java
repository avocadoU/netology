package ru.netology.gorodnichevilya.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.gorodnichevilya.configuration.OperationProcessingProperties;
import ru.netology.gorodnichevilya.domain.Operation;
import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;


@Component
@RequiredArgsConstructor
public class AsyncInputOperationService {
	private final Queue<Operation> operations = new LinkedList<>();
	private final StatementService statementService;
	private final OperationProcessingProperties properties;


	public boolean addOperation(Operation operation){
		System.out.println("Operation add processing " + operation);
		return operations.offer(operation);
	}

	private void startProcessing(){
		Thread t = new Thread(this::processQueue);
		t.start();
	}

	private void processQueue() {
		while (true) {
			Operation operation = operations.poll();
			if (operation == null) {
				try {
					System.out.println("No operation");
					Thread.sleep(properties.getTimeout());
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			} else {
				System.out.println("Processing operation " + operation);
				statementService.setOperation(operation.getCustomerId(), operation);			}

		}
	}

	@PostConstruct
	public void init(){
		this.startProcessing();
	}
}