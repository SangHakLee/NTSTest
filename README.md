# NTSTest
NHN Tech Service Test Repo

문제 : 사원번호와 성적을 출력하는 프로그램을 만드시오.  
실행 : ~> java RecordMaker [count]  
동작 예 : ~> java RecordMaker 3
NT00002 80 NT11206 85 NT01321 15  
설명 : "사원번호공백점수"형태로 count 개의 줄이 출력되어야 합니다.  
조건) - 사원번호에서 NT는 바뀔 수 없고, 뒤의 다섯자리는 random 숫자. 
random 값이 99999 이하면 0으로 채움.(30이라면 NT00030) 
- 사원번호 중복 안됨.  
- score는 0점 이상 100점 미만. random.  

** 이해되지 않는 부분이 있다면, 이해한 바대로 서술하고, 구현하시오.

# [이해되지 않는 부분] 
SRS 중 score가 100점 '미만'인 부분이 이해되지 않습니다.
성적의 만점이 99점인건지, 100점 '이하'를 '미만'으로 오타난건지 
명확히 성적의 만점이 서술되어있지 않아서 애매한 부분인 것 같습니다.
그래서 저는 보편적인 성적의 만점으로 100점을 성적의 만점으로 재조정하여 구현했습니다. 

# [Test]
- java /service/record/RecordMaker 100
- java /service/record/RecordMaker 1000
- java /service/record/RecordMaker 5000
- java /service/record/RecordMaker 20000
- java /service/record/RecordMaker 50000
- java /service/record/RecordMaker 99999

=> service.record 패키지로 포함되어 있음.
