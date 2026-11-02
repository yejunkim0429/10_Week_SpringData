학번: 22400132
이름:김예준

프로젝트
- 영화 관리 프로그램.
- java 17, spring boot, gradle 사용.
- spring data jpa로 mariadb에 데이터 저장.
- controller → service → repository 순서로 처리.
- 영화 제목, 감독, 장르, 평점, 개봉연도 관리.
- id는 db에서 자동 생성.

sql 실습
- 기존 book 테이블에 데이터 한 개 추가.
- select로 추가 결과 확인.
- movie_sql 테이블 생성.
- 영화 데이터 추가.
- lalaland 평점을 9.9에서 9.6으로 수정.
- demon slayer infinite castle 삭제.
- 제목과 평점만 조회.
- marvel 장르만 조건 조회.

  jpa 구현
- movie 클래스를 movies 테이블에 연결.
- sql 실습 테이블과 이름을 다르게 사용.
- jpa repository를 상속해서 사용.
- 등록과 수정에 save() 사용.
- 전체 조회, 단건 조회, 삭제 메서드 사용.
- 없는 id는 controller에서 404 응답 처리.

테스트
- postman으로 등록,조회,수정,삭제 요청.
- 등록 응답은 201.
- 조회와 수정 응답은 200.
- 삭제 응답은 204.
- 삭제한 id를 다시 조회하면 404.
- dbeaver에서 실제 저장·수정·삭제 결과 확인.
- 로컬과 render 주소에서 각각 테스트.

환경 설정과 배포
- db 접속 정보는 환경변수로 분리.
- intellij와 render에 각각 등록.
- dockerfile로 빌드와 실행 방법 설정.
- 학교 저장소가 render 목록에 안 보여 개인 저장소 연결.
- render에서 등록한 영화가 학교 mariadb에 저장되는 것 확인.

발생한 문제
- 파일명과 클래스명의 대소문자가 달라 오류 발생. 파일명 수정.
- where 줄만 실행해서 sql 오류 발생. select와 함께 실행.
- postman 주소에 get까지 입력해서 오류 발생. 주소만 입력.
- 등록할 때 get을 사용해 데이터가 저장되지 않음. post로 변경.
- db 연결 timeout 발생. 접속 복구 후 재실행. 정확한 장애 원인은 확인하지 못함.
- render의 db 주소 형식 오류 발생. jdbc:mariadb://로 시작하도록 수정.

이해한 내용
- 요청은 controller에서 받고 service에서 처리함.
- repository로 db에 저장하고 조회함.
- jpa를 사용해도 실제로는 sql이 실행됨.

중요한 코드 설명
- 영화 수정 메서드.
- id로 기존 영화를 찾음.
- 없으면 null을 반환함.
- 있으면 setter로 값을 바꾸고 save()로 저장함.
- controller는 null을 받으면 404로 응답함.

배운 점 3가지
1. entity와 db 테이블이 연결되는 방식.
2. get, post, put, delete의 차이.
3. postman 응답뿐 아니라 db 반영 결과도 확인해야 한다는 점.

공부할 내용
- 여러 테이블을 연결하는 방법.
- db 연결이 끊겼을 때 원인을 찾는 방법.
- 요청과 응답을 dto로 분리하는 방법.

실제로 받은 ai 도움
- sql 예시와 entity, repository, service, controller 코드 기능 설명
- 코드의 역할과 오류 원인 설명.
- 환경변수, git 명령, dockerfile, render 배포 안내.


