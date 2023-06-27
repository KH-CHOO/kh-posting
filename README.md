# 스프링 부트로 로그인 기능이 없는 나만의 항해 블로그 백엔드 서버 만들기

usecase & api명세서

https://velog.io/@khchoo/230623Fri

1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
`둘다 body 사용했습니다`

2. 어떤 상황에 어떤 방식의 request를 써야하나요?
`Client에서 게시글을 요청할 때에는 GET, 새로운 게시글 작성 시 POST, 
수정 시 PUT, 삭제 시 DELETE를 사용했습니다`

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
`최대한 동일한 URL로 자원을 표기하고 HTTP Method를 통해 요청받고 조작하였습니다.`

4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
`3계층으로 관심사 분리를 하였습니다.`

5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
https://learn.microsoft.com/ko-kr/azure/architecture/best-practices/api-design
![image](https://github.com/KH-CHOO/kh-posting/assets/106093449/6e23efb3-4145-4cb9-b2e3-375154f3e3af)
