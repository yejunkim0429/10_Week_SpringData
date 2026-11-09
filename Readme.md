학번: 22400132
이름:김예준
① 프로젝트 소개

프로젝트 주제 및 주요 기능 - 영화 관리 프로그램이다. 기존 등록, 조회, 수정, 삭제 기능에 검색과 정렬을 추가했다. 수정은 dirty checking으로 바꿨다. 생성 시간과 수정 시간도 자동으로 기록하게 했다.
GitHub Repository URL - https://github.com/yejunkim0429/10_Week_SpringData.git
Render Deployment URL - https://one0-week-springdata.onrender.com/api/movies
② 주요 구현 내용 및 결과

Query Method 3개: 검색 조건 및 API 실행 결과 - 검색은 세가지다. 장르검색, 감독이랑 장르검색, 평점이랑 정렬이다. 
Dirty Checking: 수정 기능 구현 및 실행 결과 - @transactional을 붙여서 dirty checking 했다. 기존 영화를 조회해서 값 바꾸었다. postman에서 수정하고 dbever에서도 바뀐 것을 확인했다.
Auditing: 생성·수정 시간 자동 기록 결과 - createAt과 updateAt을 추가했다. 시간을 따로 입력하지 않아도 자동으로 추가될 수 있게 했다. 수정을 할때는 생성 기간은 유지되고 수정 시간만 바뀐다. 배포 서버에서도 확인했다.
※ 소스 코드에 작성한 설명이나 주석을 README에 중복 작성할 필요는 없습니다. 주요 기능의 실행 결과를 중심으로 정리하세요.

③ Weekly Review

Key Learning: 새롭게 배운 내용 2~3가지 - query mehthod(메서드 이름이랑 조건을 해석한다.) / 트랜젝션에서 조회한 엔티티는 변경하면 dirty checking으로 수정 가능하다.
Problem & Solution: 어려웠던 점과 해결 방법 - findByDirectoryAndGenre가 너무 길어서 findByDG로 했는데 계속 안됬다. 그 이유가 실제 필드명을 사용해야 했다. 시간 컬럼도 자동 추가를 실패했다. sql오류를 발견하고 지피티와 함께 문제가 뭔지 알고 dbever에서 직접 추가했다. render에서는 db 주소가 jdbc로 시작해야하는 것을 까먹고 실패했다. 환경변수 값을 다시 수정했다.
Reflection: 이번 과제를 통해 느낀 점 - ai에게 계속 물으면서 과제를 진행했는데 하면서도 오류가 간간히 났다. 근데 이 오류가 왜 나오는지 조차도 ai한테 물어봐야해서 답답했다. 그리고 그 오류가 알고보면 저번 과제에서도 나왔고 해결했던 오류들이었음을 알았다. 
④ AI Usage

사용한 생성형 AI 도구 및 주요 질문 - codex를 사용했다. PA 개념, 검색 메서드 작성, dirty checking과 auditing 구현, 오류 원인과 배포 설정을 질문했다. 구현 코드 예시도 제공받았다.
AI가 제공한 내용 중 직접 수정하거나 검증한 부분 - 코드를 직접 입력했고, 메서드 이름과 API 경로 등을 수정했다. postman과 dbeaver로 실행 결과를 확인했다. render에 배포한 뒤에도 기능을 테스트했다.
AI 사용 비율에 대한 자기 평가 - 8/10
