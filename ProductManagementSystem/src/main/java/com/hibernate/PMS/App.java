package com.hibernate.PMS;

import java.util.Scanner;

import com.hibernate.PMS.dao.Online_shopping_dao;
import com.hibernate.PMS.model.Online_shopping;

public class App {

	static int price, qun, n;
	static String name, cate, brand;
	static char repeat;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		do {
			System.out.println("__________________________________________________________________________________\n");
			int choice;
			System.out.println("1) add rows.... \n2) delete data.... \n3) update data.... \n4) get data by id....");

			System.out.println("\nEnter 1 / 2 / 3 / 4:- ");
			choice = sc.nextInt();

			switch (choice) {
			case 1: {
				rowInsert();
				break;
			}
			case 2: {
				deletedata();
				break;
			}
			case 3: {
				update_OnlineSpecific();
//				updatedata();
				break;
			}

			case 4: {
				getById();
				break;
			}

//			case 5: {
//				update_OnlineSpecific();
//				break;
//			}

			}

			System.out.println("__________________________________________________________________________________\n");

			System.out.println("Do you want another operation:- ");
			repeat = sc.next().charAt(0);
		} while (repeat == 'y' || repeat == 'Y');
		System.out.println(
				"\n____________________________________thank you ! visit again_______________________________________\n");
	}

	public static void rowInsert() {
		System.out.println("how many row do you want to add:- ");
		n = sc.nextInt();
		System.out.println("\n\n");

		for (int i = 1; i <= n; i++) {
			System.out.println("___________________________________________________________________________");

			System.out.println("enter product name:- ");
			name = sc.next();

			System.out.println("enter product category:- ");
			cate = sc.next();

			System.out.println("enter product brand:- ");
			brand = sc.next();

			System.out.println("enter product price:- ");
			price = sc.nextInt();

			System.out.println("enter product quntity:- ");
			qun = sc.nextInt();

			Online_shopping_dao onsdao = new Online_shopping_dao();

			Online_shopping ons = new Online_shopping(name, brand, cate, price, qun);
			onsdao.saveOnline(ons);

			System.out.println("___________________________________________________________________________");

		}

		System.out.println("rows added succesfully...................");

	}

	public static void deletedata() {
		Online_shopping_dao onsdao = new Online_shopping_dao();
		System.out.println("enter product id which you want to delete:- ");
		n = sc.nextInt();

		onsdao.deleteOnline(n);

	}

	public static void updatedata() {
		Online_shopping_dao onsdao = new Online_shopping_dao();
		onsdao.updateOnline();

	}

	public static void update_OnlineSpecific() {
		Online_shopping_dao onsdao = new Online_shopping_dao();
		onsdao.updateOnlineSpecific();

	}

	public static void getById() {
		Online_shopping_dao onsdao = new Online_shopping_dao();
		System.out.println("enter id you want:- ");
		n = sc.nextInt();

		onsdao.getDataById(n);
	}

}
