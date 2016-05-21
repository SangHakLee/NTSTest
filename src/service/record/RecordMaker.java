package service.record;
/*
 * [이해되지 않는 부분] 
 * SRS 중 score가 100점 '미만'인 부분이 이해되지 않습니다.
 * 성적의 만점이 99점인건지, 100점 '이하'를 '미만'으로 오타난건지 
 * 명확히 성적의 만점이 서술되어있지 않아서 애매한 부분인 것 같습니다.
 * 그래서 저는 보편적인 성적의 만점으로 100점을 성적의 만점으로 재조정하여 구현했습니다. 
 */

import java.util.ArrayList;
import java.util.Random;

public class RecordMaker {

	private static int count;
	ArrayList<String> arr_Employee_Ids;		//사원번호를 담을 array list
	ArrayList<Integer> arr_Employee_Grades;	//사원성적을 담을 array list
	
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

	//Record 출력 메소드
	public void printRecord() {
		int i = 0;
		while(i < count) {
			String employeeId = arr_Employee_Ids.get(i);
			int employeeGrade = arr_Employee_Grades.get(i);
			i++;
			// n개의 줄을 맞추기 위해 마지막 요소는 줄바꿈없이 출력.
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
			RecordMaker rm = new RecordMaker(inputArgs);	//생성자를 통하여 초기화
			
			Random employee_num = new Random();		//사원번호를 위한 랜덤 객체 생성
			Random employee_grade = new Random();	//사원점수를 위한 랜덤 객체 생성
			
			for(int i=0; i < count; i++) {
				//사원번호 생성 : 일의 자리, 십의 자리 등 자리 수 마다 0부터 9까지 랜덤한 숫자 생성하여 붙임
				String tempStr = "NT" + employee_num.nextInt(10) + employee_num.nextInt(10) + employee_num.nextInt(10)
				+ employee_num.nextInt(10) + employee_num.nextInt(10);
				//사원점수 생성 : 0 ~ 100
				int tempInt = employee_grade.nextInt(101);
			
				//첫 사원번호, 사원점수 삽입
				if( i == 0 ) {
					//rm 객체의 사원번호, 사원점수 array list에 각각 삽입
					rm.arr_Employee_Ids.add(tempStr);
					rm.arr_Employee_Grades.add(tempInt);
				}
				//만들어진 사원번호 중복 검사
				else if (rm.arr_Employee_Ids.contains(tempStr) == true) {
					System.out.println("데이터 중복, 다시 생성합니다. ");
					i--;	//중복된 횟수만큼 i값을 다시 감소시킴
					continue;
				}
				
				else {
					//rm 객체의 사원번호, 사원점수 array list에 각각 추가
					rm.arr_Employee_Ids.add(tempStr);
					rm.arr_Employee_Grades.add(tempInt);
				}
			}
			
			rm.printRecord();	//Record 출력
		}	//End of try
		catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("정수 형태가 아닌 값이 입력되었습니다. 정수값(int)으로 입력바랍니다. ");
		}	//End of catch
				
	}	//End of main

	
}