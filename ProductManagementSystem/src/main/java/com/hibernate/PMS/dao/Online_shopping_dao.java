package com.hibernate.PMS.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.PMS.model.Online_shopping;
import com.hibernate.PMS.util.Hibernate_util;

public class Online_shopping_dao extends Thread {

	Scanner sc = new Scanner(System.in);

	public void saveOnline(Online_shopping online_shopping) {
		Transaction transaction = null;
		try (Session session = Hibernate_util.getsessioFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(online_shopping);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void deleteOnline(int id) {
		Transaction transaction = null;
		try (Session session = Hibernate_util.getsessioFactory().openSession()) {

			transaction = session.beginTransaction();
			Online_shopping onlineshopping = session.get(Online_shopping.class, id);
			session.delete(onlineshopping);
			transaction.commit();
			System.out.println("product id " + id + " is successfully deleted");

		} catch (Exception e) {
			System.out.println("Data not found with id " + id);
		}
	}

	public void updateOnline() {
		int n;
		Transaction transaction = null;

		try (Session session = Hibernate_util.getsessioFactory().openSession();) {
			transaction = session.beginTransaction();

			System.out.println("Enter product ID to update: ");
			n = sc.nextInt();

			// Retrieve the entity from the database
			Online_shopping onlineShopping = session.get(Online_shopping.class, n);

			if (onlineShopping != null) {

				System.out.println("Enter new name: ");
				onlineShopping.setP_name(sc.next());
				System.out.println("Enter new brand: ");
				onlineShopping.setP_brand(sc.next());
				System.out.println("Enter new category: ");

				onlineShopping.setP_cate(sc.next());
				System.out.println("Enter new price: ");
				onlineShopping.setP_price(sc.nextInt());
				System.out.println("Enter new quantity: ");
				onlineShopping.setP_qun(sc.nextInt());

				// Save the updated entity back to the database
				session.update(onlineShopping);
				transaction.commit();
				System.out.println("Data updated successfully......");
			} else {
				System.out.println("Product not found with ID: " + n);
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateOnlineSpecific() {
		int n;
		Transaction transaction = null;

		try (Session session = Hibernate_util.getsessioFactory().openSession();) {
			transaction = session.beginTransaction();

			System.out.println("Enter product ID to update: ");
			n = sc.nextInt();

			// Retrieve the entity from the database
			Online_shopping onlineShopping = session.get(Online_shopping.class, n);

			if (onlineShopping != null) {

				int choice;

				System.out.println("enter how many row you want to update:-");
				n = sc.nextInt();
				for (int i = 1; i <= n; i++) {

					System.out.println("1) name\n2) brand\n3) cate\n4) price\n5) qun");

					System.out.println("enter column no:-");
					choice = sc.nextInt();

					switch (choice) {
					case 1: {
						System.out.println("Enter new name: ");
						onlineShopping.setP_name(sc.next());
						break;
					}
					case 2: {
						System.out.println("Enter new brand: ");
						onlineShopping.setP_brand(sc.next());
						break;
					}
					case 3: {
						System.out.println("Enter new category: ");
						onlineShopping.setP_cate(sc.next());
						break;
					}
					case 4: {
						System.out.println("Enter new price: ");
						onlineShopping.setP_price(sc.nextInt());
						break;
					}
					case 5: {
						System.out.println("Enter new quantity: ");
						onlineShopping.setP_qun(sc.nextInt());
						break;
					}

					default:
						System.out.println("enter valid input........!!!");
						break;
					}

				}

				// Save the updated entity back to the database
				session.update(onlineShopping);
				transaction.commit();
				System.out.println("Data updated successfully.");
			} else {
				System.out.println("Product not found with ID: " + n);
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void getDataById(int id) {
		Transaction transaction = null;
		try (Session session = Hibernate_util.getsessioFactory().openSession()) {
			transaction = session.beginTransaction();
			Online_shopping onlineshopping = session.get(Online_shopping.class, id);

			if (onlineshopping != null) {
				System.out.println(onlineshopping.getId() + " | Name:- " + onlineshopping.getP_name() + " | Categ:- "
						+ onlineshopping.getP_cate() + " | Brand:- " + onlineshopping.getP_brand() + " | Price:- "
						+ onlineshopping.getP_price() + " | Qun:- " + onlineshopping.getP_qun());
				System.out.println("\nData fetched successfully.......");
			} else {
				System.out.println("\nData not found .......");
			}

			transaction.commit();
		} catch (Exception e) {
			System.out.println("\nError occurred while fetching data: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
