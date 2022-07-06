package jv251.varxyz.jv251.service;

import java.util.List;

import jv251.varxyz.jv251.domain.Account;
import jv251.varxyz.jv251.domain.Customer;
import jv251.varxyz.jv251.exception.EntityNotFoundException;

public class BankServiceTest {
	public static void main(String[] args) {
		BankService service = BankService.getInstance();
		String name = "동탁";
		String ssn = "900612-1234567";
		String phone = "010-3333-3555";
		String userId = "framework";
		String passwd = "1112";
		//1. 신규 고객 등록
		//단위별로 테스트를 하세요
//		service.addCustomer(name, ssn, phone, userId, passwd);
//		try {
//		//2. savingsAccount 생성
//			service.addSanvingsAccount(7000.0, 0.4, ssn);
//		} catch (EntityNotFoundException e) {
//			e.printStackTrace();
//		}
//		//3. 고객 등록 확인
		Customer customer = service.getCustomerBySsn(ssn);
		System.out.println(customer);
//		for (Account account : customer.getAccountList()) {
//			System.out.println(account);
//		}
		//4. 고객 계좌 확인
		List<Account> myList = service.getAccountBySsn(ssn);
		for (Account account : myList) {
			System.out.println(account);
		//입출금 로직 구현
		}
	}
}
