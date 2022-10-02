# [level 3] 정수 삼각형 - 43105 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43105) 

### 성능 요약

메모리: 61.9 MB, 시간: 9.03 ms

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

### 채점결과

<br/>정확성: 64.3<br/>효율성: 35.7<br/>합계: 100.0 / 100.0

### 문제 설명

<p style="user-select: auto;"><img src="https://grepp-programmers.s3.amazonaws.com/files/production/97ec02cc39/296a0863-a418-431d-9e8c-e57f7a9722ac.png" title="" alt="스크린샷 2018-09-14 오후 5.44.19.png" style="user-select: auto;"></p>

<p style="user-select: auto;">위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.</p>

<p style="user-select: auto;">삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.</p>

<h5 style="user-select: auto;">제한사항</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">삼각형의 높이는 1 이상 500 이하입니다.</li>
<li style="user-select: auto;">삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.</li>
</ul>

<h5 style="user-select: auto;">입출력 예</h5>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">triangle</th>
<th style="user-select: auto;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]</td>
<td style="user-select: auto;">30</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto;"><a href="http://stats.ioinformatics.org/countries/SWE" target="_blank" rel="noopener" style="user-select: auto;">출처</a></p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges