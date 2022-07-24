# Dev-Wiki

## git branch 전략
- main (상용 서비스 단계)
    - develop (개발 단계)
        - feature/signup
        - feature/signin
        - release
        - hotfix

## git commit 전략
- ⚡ feat : 새로운 기능 추가
- 🛠️ fix : 버그 수정
- 📘 docs : 문서 수정
- ✨ style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- ♻️ refactor : 코드 리펙토링
- ⛑️ test : 테스트 코드, 리펙토링 테스트 코드 추가
- 🧹 chore : 빌드 업무 수정, 패키지 매니저 수정
- 🏗️ build : 프로젝트 빌드, 의존성 추가, 빌드 툴 변경사항이 있는 경우