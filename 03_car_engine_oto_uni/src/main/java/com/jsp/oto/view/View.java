package com.jsp.oto.view;

import java.util.Scanner;

import com.jsp.oto.controller.Controller;
import com.jsp.oto.model.Car;
import com.jsp.oto.model.Engine;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	static Car car = new Car();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		do {
			System.out.println("----------------------------------------");
			System.out.print("| Select operation to perform :         |");
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println();
			System.out.println("-----------------------------------------");
			System.out.println("| 1. Add car                            |\n| 2.Update car                          |\n| 3.Remove Car                          | \n| 4.Fetch car                           | \n| 0.Exit                                |");
			System.out.println("-----------------------------------------");
			System.out.println();
			System.out.println("-----------------------------------------");
			System.out.print("Enter digit respective to desired option :  |");
			System.out.println();
			System.out.println("-----------------------------------------");
			
			int userInput = myInput.nextInt();
			myInput.nextLine();
			
			switch (userInput) {
			case 0:
				myInput.close();
				System.out.println("- - - - EXITED - - - -");
				System.exit(0);
				break;
				
			case 1 : 
				System.out.println("Enter the data of car   : ");
				System.out.println("-------------------------");
				
				System.out.print("car_id: ");
				int insertId = myInput.nextInt();
				myInput.nextLine();
				
				System.out.print("car_name: ");
				String insertName = myInput.nextLine();
				
				System.out.print("Chasis: ");
				String insertChasis = myInput.nextLine();
				
				System.out.print("Cost: ");
				double insertCost = myInput.nextDouble();
				myInput.nextLine();
				

				car.setId(insertId);
				car.setCar_name(insertName);
				car.setChasis(insertChasis);
				car.setCost(insertCost);
				
				System.out.print("engine_id: ");
				int insert_engine_Id = myInput.nextInt();
				myInput.nextLine();
				System.out.print("CC: ");
				double insert_engine_CC = myInput.nextDouble();
				myInput.nextLine();
				System.out.print("No_of_cylinder: ");
				int insert_engine_no_of_cylinder = myInput.nextInt();
				myInput.nextLine();
				Engine engine = new Engine();
				engine.setId(insert_engine_Id);
				engine.setCc(insert_engine_CC);
				engine.setNo_of_cylinder((byte)insert_engine_no_of_cylinder);
				car.setEngine(engine);
				boolean fullDetails = controller.addDetail(car, engine);
				
				if (fullDetails) {
					System.out.println("Inserted data");
				} else {
					System.out.println("failed to insert data");
				}
			
				break;
			case 2:
				
				System.out.println("Enter new data of the Car to Update    :");
				System.out.println("-----------------------------------");
				
				System.out.print("Enter id to update: ");
				int updateId = myInput.nextInt();
				System.out.println("enter new cost for respective id : ");
				int updatePrice = myInput.nextInt();
				boolean updateCar = controller.updateCar(updateId, updatePrice);
				
				if(updateCar) {
					System.out.println("Data is Updated Successfully");
				}
				else {
					System.out.println("id not exists ... no update performed");
				}
				System.out.println();
				break;
				
			case 3:
				
				System.out.println("Select which record to delete from table ");
				System.out.println("------------------------------------------");
				
				System.out.print("Enter id to delete: ");
				int deleteId = myInput.nextInt();
				
				boolean removeCar = controller.removeCar(deleteId);
				if (removeCar) {
					System.out.println("car removed successfully");
				} else {
					System.out.println("car with given id doesn't exits ... hence no delete action performed");
				}
				
				
				System.out.println();
				break;
				
			case 4:

				
				System.out.print("Enter id to find: ");
				int findId = myInput.nextInt();
				myInput.nextLine();
				
				Car findCar = controller.findCar(findId);
				if (findCar != null) {
					System.out.println("------------------------------------");
					System.out.println("           CAR and ENGINE           ");
					System.out.println("------------------------------------");
					System.out.println();
					System.out.println("car id 			:  " + findCar.getId());
					System.out.println("car name 		:  " + findCar.getCar_name());
					System.out.println("car chasis 		:  " + findCar.getChasis());
					System.out.println("car cost 		:  " + findCar.getCost());
					Engine engine2 = findCar.getEngine();
					System.out.println("engine id 		:  " +engine2.getId());
					System.out.println("engine cc	 	:  "+engine2.getCc());
					System.out.println("engine cylinder 	:  " +engine2.getNo_of_cylinder());
				} else {
					System.out.println("car with given id doesnt exists");
				}
				
				System.out.println("-----------------------------------");
				System.out.println();
				break;

			default:
				System.out.println("- - - - INVALID SELECTION - - - -");
				break;
			}
		} while (true);
		
	
	
}
}
