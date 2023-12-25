package ru.netology.gorodnichevilya.service;

import lombok.Getter;
import ru.netology.gorodnichevilya.domain.Operation;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class CashbackOperation extends Operation {
	private int cashbackAmount;

	public CashbackOperation(Integer id, Integer sum, Currency currency, String merchant, Integer customerId, int cashbackAmount) {
		super(id, sum, currency, merchant, customerId);
		this.cashbackAmount = cashbackAmount;
	}

	@Override
	public String toString() {
		return "Operation{ id = " + getId() +
				", sum: " + getSum() +
				", currency: " + getCurrency() +
				", merchant: " + getMerchant() +
				", cashbackAmount " + cashbackAmount + "}";
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || object.getClass() != this.getClass()) {
			return false;
		}
		CashbackOperation operation = (CashbackOperation) object;
		return getId() == operation.getId()
				&& (getSum() == operation.getSum()
				&& cashbackAmount == operation.cashbackAmount
				&& (getCurrency() != null && getCurrency().equals(operation.getCurrency()))
				&& (getMerchant() != null && getMerchant().equals(operation.getMerchant())));
	}

	@Override
	public int hashCode() {
		final int prime = 30;
		AtomicInteger res = new AtomicInteger(1);
		res.set(prime * res.get() + getId());
		res.set(prime * res.get() + getSum());
		res.set(prime * res.get() + cashbackAmount);
		res.set(prime * res.get() + ((getCurrency() == null) ? 0 : getCurrency().hashCode()));
		res.set(prime * res.get() + ((getCurrency() == null) ? 0 : getCurrency().hashCode()));
		return res.get();
	}

	@Override
	public void printToConsole() {
		System.out.println(
				"ID: " + getId() + ".\n" +
				" Сумма операции " + getSum() +	getCurrency() + ".\n" +
				" Оператор " + getMerchant() + ".\n" +
				" Кэшбэк " + cashbackAmount + ".");
	}

	public void setCashbackAmount(int cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}
}
