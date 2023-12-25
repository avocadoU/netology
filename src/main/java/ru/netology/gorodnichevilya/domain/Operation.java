package ru.netology.gorodnichevilya.domain;

import lombok.*;
import ru.netology.gorodnichevilya.service.Currency;

@Getter
@Setter
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Operation implements ConsolePrintable {
	private int id;
	private int sum;
	private Currency currency;
	private String merchant;
	private Integer customerId;

	@Override
	public void printToConsole() {
		System.out.println("Operation{" +
				"id=" + id +
				", sum=" + sum +
				", currency='" + currency + '\'' +
				", merchant='" + merchant + '\'' +
				'}');
	}

}
