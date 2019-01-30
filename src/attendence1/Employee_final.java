package attendence1;

	
	import java.text.SimpleDateFormat;

	import java.time.temporal.ChronoUnit;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;
	import java.util.Scanner;
	public class Employee_final {

		public static void main(String[] args) {
			try {
				List<EmployeeTimer> allemployees = LoadEmployeeDetail();

				for (int i = 0; i < allemployees.size(); i++) {
					String strCurrentEmployee = allemployees.get(i).EmployeeID;
					Calendar startTime = Calendar.getInstance();
					Calendar endTime = Calendar.getInstance();
					long dblTotalMinutes = 0;
					boolean boolEmployeeEntered = false;
					boolean boolEmployeeExited = false;
					for (int j = 0; j < allemployees.size(); j++) {
						EmployeeTimer lobjAdminTemp = allemployees.get(j);
						if ((lobjAdminTemp.EmployeeID
								.equalsIgnoreCase(strCurrentEmployee))) {
							if (lobjAdminTemp.OfficeStatus == 1) {
								startTime = lobjAdminTemp.OfficeTime;
								boolEmployeeEntered = true;
							} else {
								endTime = lobjAdminTemp.OfficeTime;
								boolEmployeeExited = true;
							}
						}
					}

					if (boolEmployeeEntered && boolEmployeeExited) {
						dblTotalMinutes += ChronoUnit.HOURS.between(
								startTime.toInstant(), endTime.toInstant());
						System.out.println(strCurrentEmployee + " worked for "
								+ dblTotalMinutes);
					} else if (boolEmployeeEntered && !boolEmployeeExited) {
						System.out.println(strCurrentEmployee
								+ " employee hasn't exited the office");
					} else {
						System.out.println(strCurrentEmployee
								+ " employee hasn't recorded the entry of office");
					}
				}

				/*
				 * Scanner input = new Scanner(System.in); String[] objEmployees =
				 * new String[] { "1000", "1001", "1002", "1003" };
				 * ArrayList<EmployeeTimer> objEmployeeData = new
				 * ArrayList<EmployeeTimer>(); while (true) {
				 * System.out.println("Employee Login : Press 1");
				 * System.out.println("Admin Login : Press 2");
				 * System.out.println("Exit: Press any other key"); input = new
				 * Scanner(System.in); String strLoginInput = input.next(); if
				 * (strLoginInput.equals("1")) {
				 * System.out.println("Please Enter the Employee ID"); input = new
				 * Scanner(System.in); String strEmployeeID = input.next(); int
				 * lintOfficeStatus = CheckEntry(objEmployeeData, strEmployeeID); if
				 * (lintOfficeStatus == 0) {
				 * System.out.println("Are you sure want to enter office ? Y/N");
				 * input = new Scanner(System.in); String strUserInput =
				 * input.next(); if (strUserInput.toLowerCase().equals("y")) {
				 * EmployeeTimer objTempEmployeeData = new EmployeeTimer();
				 * objTempEmployeeData.EmployeeID = strEmployeeID;
				 * objTempEmployeeData.OfficeStatus = 1; Date now = new Date();
				 * Calendar cal = Calendar.getInstance(); cal.setTime(now);
				 * objTempEmployeeData.OfficeTime = cal; if
				 * (cal.get(Calendar.HOUR_OF_DAY) < 10) {
				 * objTempEmployeeData.OfficeTime.set(Calendar.HOUR_OF_DAY, 10); }
				 * objEmployeeData.add(objTempEmployeeData); } } else {
				 * System.out.println
				 * ("Are you sure want to leave the office ? Y/N"); input = new
				 * Scanner(System.in); String strUserInput = input.next(); if
				 * (strUserInput.toLowerCase().equals("y")) { EmployeeTimer
				 * objTempEmployeeData = new EmployeeTimer();
				 * objTempEmployeeData.EmployeeID = strEmployeeID;
				 * objTempEmployeeData.OfficeStatus = 0; Date now = new Date();
				 * Calendar cal = Calendar.getInstance(); cal.setTime(now);
				 * objTempEmployeeData.OfficeTime = cal; if
				 * (cal.get(Calendar.HOUR_OF_DAY) > 18) {
				 * objTempEmployeeData.OfficeTime.set(Calendar.HOUR_OF_DAY, 18); }
				 * objEmployeeData.add(objTempEmployeeData); } } } else if
				 * (strLoginInput.equals("2")) { List<EmployeeTimer>
				 * objAdminEmployeeData = objEmployeeData; for (int i = 0; i <
				 * objEmployees.length; i++) { String strCurrentEmployee =
				 * objEmployees[i]; Calendar startTime = Calendar.getInstance();
				 * Calendar endTime = Calendar.getInstance(); long dblTotalMinutes =
				 * 0; boolean boolEmployeeEntered = false; boolean
				 * boolEmployeeExited = false; for (int j = 0; j <
				 * objAdminEmployeeData.size(); j++) { EmployeeTimer lobjAdminTemp =
				 * objAdminEmployeeData.get(j); if
				 * ((lobjAdminTemp.EmployeeID.equalsIgnoreCase(strCurrentEmployee)))
				 * { if (lobjAdminTemp.OfficeStatus == 1) { startTime =
				 * lobjAdminTemp.OfficeTime; boolEmployeeEntered = true; } else {
				 * endTime = lobjAdminTemp.OfficeTime; boolEmployeeExited = true; }
				 * } }
				 * 
				 * if (boolEmployeeEntered && boolEmployeeExited) { dblTotalMinutes
				 * += ChronoUnit.MINUTES.between(startTime.toInstant(),
				 * endTime.toInstant()); System.out.println(strCurrentEmployee +
				 * " worked for " + dblTotalMinutes); } else if (boolEmployeeEntered
				 * && !boolEmployeeExited) { System.out.println(strCurrentEmployee +
				 * " employee hasn't exited the office"); } else {
				 * System.out.println(strCurrentEmployee +
				 * " employee hasn't recorded the entry of office"); } } } else {
				 * break; } } input.close();
				 */

				System.out
						.println("Thank you for using the Attendance application!");
			} catch (Exception e) {

			}
		}

		public static int CheckEntry(List<EmployeeTimer> pobjEmployeeData,
				String pstrEmployeeID) {
			List<EmployeeTimer> objCheckEmployeeData = pobjEmployeeData;
			int lintReturnStatus = 0;
			if (pobjEmployeeData.size() > 0) {

				for (int i = 0; i < objCheckEmployeeData.size(); i++) {
					EmployeeTimer lobjCheckTemp = pobjEmployeeData.get(i);
					if (lobjCheckTemp.EmployeeID.equals(pstrEmployeeID)) {
						lintReturnStatus = lobjCheckTemp.OfficeStatus;
					}
				}
			}
			return lintReturnStatus;
		}

		public static List<EmployeeTimer> LoadEmployeeDetail() throws Exception {
			List<EmployeeTimer> allemployees = new ArrayList<EmployeeTimer>();
			EmployeeTimer obj1 = new EmployeeTimer();
			obj1.Sno = "1";

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			obj1.OfficeTime = Calendar.getInstance();
			obj1.OfficeTime.setTime(sdf.parse("2015-04-01 9:13:00"));
			obj1.EmployeeID = "RCS004";
            obj1.OfficeStatus = Integer.parseInt("1");
			if (obj1.OfficeStatus == 1) {

				if (obj1.OfficeTime.get(Calendar.HOUR_OF_DAY) < 10)

				{
					obj1.OfficeTime.set(Calendar.HOUR_OF_DAY, 10);
				}
			} else {
				if (obj1.OfficeTime.get(Calendar.HOUR_OF_DAY) > 18) {
					obj1.OfficeTime.set(Calendar.HOUR_OF_DAY, 18);
				}
			}
			EmployeeTimer obj2 = new EmployeeTimer();
			obj2.Sno = "1";
			obj2.EmployeeID = "RCS004";
			obj2.OfficeTime = Calendar.getInstance();
			obj2.OfficeTime.setTime(sdf.parse("2015-04-01 23:13:00"));

			obj2.OfficeStatus = Integer.parseInt("0");
			if (obj2.OfficeStatus == 1) {

				if (obj2.OfficeTime.get(Calendar.HOUR_OF_DAY) < 10)

				{
					obj2.OfficeTime.set(Calendar.HOUR_OF_DAY, 10);
				}
			} else {
				if (obj2.OfficeTime.get(Calendar.HOUR_OF_DAY) > 18) {
					obj2.OfficeTime.set(Calendar.HOUR_OF_DAY, 18);
				}
			}
			EmployeeTimer obj3 = new EmployeeTimer();
			obj3.Sno = "2";
			obj3.EmployeeID = "RCS003";
			obj3.OfficeTime = Calendar.getInstance();
			obj3.OfficeTime.setTime(sdf.parse("2015-04-01 10:13:00"));
            obj3.OfficeStatus = Integer.parseInt("1");
            if (obj1.OfficeStatus == 1) {

				if (obj1.OfficeTime.get(Calendar.HOUR_OF_DAY) < 10)

				{
					obj1.OfficeTime.set(Calendar.HOUR_OF_DAY, 10);
				}
			} else {
				if (obj1.OfficeTime.get(Calendar.HOUR_OF_DAY) > 18) {
					obj1.OfficeTime.set(Calendar.HOUR_OF_DAY, 18);
				}
			}
			EmployeeTimer obj4 = new EmployeeTimer();
			obj4.Sno = "2";
			obj4.EmployeeID = "RCS003";

			obj4.OfficeTime = Calendar.getInstance();
			obj4.OfficeTime.setTime(sdf.parse("2015-04-01 16:13:00"));

			obj4.OfficeStatus = Integer.parseInt("0");
			if (obj1.OfficeStatus == 1) {

				if (obj1.OfficeTime.get(Calendar.HOUR_OF_DAY) < 10)

				{
					obj1.OfficeTime.set(Calendar.HOUR_OF_DAY, 10);
				}
			} else {
				if (obj1.OfficeTime.get(Calendar.HOUR_OF_DAY) > 18) {
					obj1.OfficeTime.set(Calendar.HOUR_OF_DAY, 18);
				}
			}
			EmployeeTimer obj5 = new EmployeeTimer();
			obj5.Sno = "3";
			obj5.EmployeeID = "RCS007";

			obj5.OfficeStatus = Integer.parseInt("1");

			obj5.OfficeTime = Calendar.getInstance();
			obj5.OfficeTime.setTime(sdf.parse("2015-04-01 9:13:00"));
			if (obj5.OfficeStatus == 1) {

				if (obj5.OfficeTime.get(Calendar.HOUR_OF_DAY) < 10)

				{
					obj5.OfficeTime.set(Calendar.HOUR_OF_DAY, 10);
				}
			} else {
				if (obj5.OfficeTime.get(Calendar.HOUR_OF_DAY) > 18) {
					obj5.OfficeTime.set(Calendar.HOUR_OF_DAY, 18);
				}
			}
			EmployeeTimer obj6 = new EmployeeTimer();
			obj6.Sno = "3";
			obj6.EmployeeID = "RCS007";

			obj6.OfficeStatus = Integer.parseInt("0");

			obj6.OfficeTime = Calendar.getInstance();
			obj6.OfficeTime.setTime(sdf.parse("2015-04-01 18:13:00"));
			if (obj6.OfficeStatus == 1) {

				if (obj6.OfficeTime.get(Calendar.HOUR_OF_DAY) < 10)

				{
					obj6.OfficeTime.set(Calendar.HOUR_OF_DAY, 10);
				}
			} else {
				if (obj6.OfficeTime.get(Calendar.HOUR_OF_DAY) > 18) {
					obj6.OfficeTime.set(Calendar.HOUR_OF_DAY, 18);
				}
			}
			allemployees.add(obj1);
			allemployees.add(obj2);
			allemployees.add(obj3);
			allemployees.add(obj4);
			allemployees.add(obj5);
			allemployees.add(obj6);
			return allemployees;

		}
	}

	class EmployeeTimer {
		String Sno;

		String EmployeeID;
		int OfficeStatus;
		Calendar OfficeTime;
	}

