package service.record;
/*
 * [���ص��� �ʴ� �κ�] 
 * SRS �� score�� 100�� '�̸�'�� �κ��� ���ص��� �ʽ��ϴ�.
 * ������ ������ 99���ΰ���, 100�� '����'�� '�̸�'���� ��Ÿ������ 
 * ��Ȯ�� ������ ������ �����Ǿ����� �ʾƼ� �ָ��� �κ��� �� �����ϴ�.
 * �׷��� ���� �������� ������ �������� 100���� ������ �������� �������Ͽ� �����߽��ϴ�. 
 */

import java.util.ArrayList;
import java.util.Random;

public class RecordMaker {

	private static int count;
	ArrayList<String> arr_Employee_Ids;		//�����ȣ�� ���� array list
	ArrayList<Integer> arr_Employee_Grades;	//��������� ���� array list
	
	public RecordMaker() {
		// TODO Auto-generated constructor stub
		setCount();
	}

	public RecordMaker(int count) {
		setCount(count);
		arr_Employee_Ids = new ArrayList<String>();
		arr_Employee_Grades = new ArrayList<Integer>();
		
	}
	
	public int getCount() {
		return count;
	}

	public void setCount() {
		RecordMaker.count = 0;
	}
	
	public void setCount(int count) {
		RecordMaker.count = count;
	}

	//Record ��� �޼ҵ�
	public void printRecord() {
		int i = 0;
		while(i < count) {
			String employeeId = arr_Employee_Ids.get(i);
			int employeeGrade = arr_Employee_Grades.get(i);
			i++;
			// n���� ���� ���߱� ���� ������ ��Ҵ� �ٹٲ޾��� ���.
			if(i == count) {
				System.out.print(employeeId + " " + employeeGrade);
			}
			else {
				System.out.println(employeeId + " " + employeeGrade);
			}
		}	//End of while
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			
			int inputArgs = Integer.parseInt(args[0]);
			RecordMaker rm = new RecordMaker(inputArgs);	//�����ڸ� ���Ͽ� �ʱ�ȭ
			
			Random employee_num = new Random();		//�����ȣ�� ���� ���� ��ü ����
			Random employee_grade = new Random();	//��������� ���� ���� ��ü ����
			
			for(int i=0; i < count; i++) {
				//�����ȣ ���� : ���� �ڸ�, ���� �ڸ� �� �ڸ� �� ���� 0���� 9���� ������ ���� �����Ͽ� ����
				String tempStr = "NT" + employee_num.nextInt(10) + employee_num.nextInt(10) + employee_num.nextInt(10)
				+ employee_num.nextInt(10) + employee_num.nextInt(10);
				//������� ���� : 0 ~ 100
				int tempInt = employee_grade.nextInt(101);
			
				//ù �����ȣ, ������� ����
				if( i == 0 ) {
					//rm ��ü�� �����ȣ, ������� array list�� ���� ����
					rm.arr_Employee_Ids.add(tempStr);
					rm.arr_Employee_Grades.add(tempInt);
				}
				//������� �����ȣ �ߺ� �˻�
				else if (rm.arr_Employee_Ids.contains(tempStr) == true) {
					System.out.println("������ �ߺ�, �ٽ� �����մϴ�. ");
					i--;	//�ߺ��� Ƚ����ŭ i���� �ٽ� ���ҽ�Ŵ
					continue;
				}
				
				else {
					//rm ��ü�� �����ȣ, ������� array list�� ���� �߰�
					rm.arr_Employee_Ids.add(tempStr);
					rm.arr_Employee_Grades.add(tempInt);
				}
			}
			
			rm.printRecord();	//Record ���
		}	//End of try
		catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("���� ���°� �ƴ� ���� �ԷµǾ����ϴ�. ������(int)���� �Է¹ٶ��ϴ�. ");
		}	//End of catch
				
	}	//End of main

	
}