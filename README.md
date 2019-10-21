# ssafy-blind

> SSAFY 1기 ssafyns팀
> SSAFY생들만을 위한 익명으로 소통하는 웹

## Member

| 이름   | 역할     |
| ------ | -------- |
| 김준호 | PM & AWS |
| 박민형 | Auth     |
| 이지은 | Login    |
| 이호빈 | Board    |

## Environment

- Spring boot
- Spring Security
- Mybatis
- Maven
- MySQL
- AWS EC2
- gitlab API

## 주요 기능

1. SSAFY 학생 인증 후 회원가입
2. 익명 게시판 작성, 조회, 수정, 삭제
3. 익명 댓글 작성, 조회, 수정, 삭제

## RESTAPI 설계

### 게시판

#### 자유 게시판 (CRUD)

| URL                        | Method | Description      |
| -------------------------- | ------ | ---------------- |
| /api/board/free            | GET    | 게시판 목록 조회 |
| /api/board/free            | POST   | 게시판 등록      |
| /api/board/free/{board-id} | GET    | 게시판 상세 조회 |
| /api/board/free/{board-id} | PUT    | 게시판 수정      |
| /api/board/free/{board-id} | DELETE | 게시판 삭제      |

#### 자유 게시판 댓글 (CRUD)

| URL                                      | Method | Description    |
| ---------------------------------------- | ------ | -------------- |
| /api/board/free/{board-id}/comments      | GET    | 댓글 목록 조회 |
| /api/board/free/{board-id}/comments      | POST   | 댓글 추가      |
| /api/board/free/{board-id}/comments/{id} | PUT    | 댓글 수정      |
| /api/board/free/{board-id}/comments/{id} | DELETE | 댓글 삭제      |

### 회원 CRUD

| URL                | Method | Description                    |
| ------------------ | ------ | ------------------------------ |
| /api/accounts      | GET    | 회원 목록 조회 ( ADMIN 만)     |
| /api/accounts      | POST   | 회원 추가                      |
| /api/accounts/{id} | GET    | 회원 하나 조회 ( 본인, ADMIN ) |
| /api/accounts/{id} | PUT    | 회원 정보 수정 ( 본인, ADMIN ) |
| /api/accounts/{id} | DELETE | 회원 탈퇴 ( 본인, ADMIN )      |
