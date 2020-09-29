<img width="1522" alt="image" src="https://user-images.githubusercontent.com/48542327/94383822-0ff1a800-017c-11eb-8add-61c37156663d.png">

# MySolution.java
* dp, O(n)
* left[i] = i 왼쪽 배열 중 최소값
* right[i] = i 오른족 배열 중 최소값
* for문의 다양한 응용

# ReferenceSolution.java
* 시간복잡도는 MySolution.java가 훨씬 빠르다
* 별도의 dp 배열을 생성하지 않음
* 해당 인덱스의 양 옆의 최소값을 set에 담는 방식
* 한 번이라도 최소값인 적이 있으면 그 값은 true
