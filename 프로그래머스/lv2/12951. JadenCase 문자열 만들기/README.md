# [level 2] JadenCase 문자열 만들기 - 12951 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12951) 

### 성능 요약

메모리: 76.3 MB, 시간: 1.59 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

<br/>정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p style="user-select: auto;">JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)<br style="user-select: auto;">
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.</p>

<h5 style="user-select: auto;">제한 조건</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">s는 길이 1 이상 200 이하인 문자열입니다.</li>
<li style="user-select: auto;">s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.

<ul style="user-select: auto;">
<li style="user-select: auto;">숫자는 단어의 첫 문자로만 나옵니다.</li>
<li style="user-select: auto;">숫자로만 이루어진 단어는 없습니다.</li>
<li style="user-select: auto;">공백문자가 연속해서 나올 수 있습니다.</li>
</ul></li>
</ul>

<h5 style="user-select: auto;">입출력 예</h5>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">s</th>
<th style="text-align: center; user-select: auto;">return</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">"3people unFollowed me"</td>
<td style="text-align: center; user-select: auto;">"3people Unfollowed Me"</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">"for the last week"</td>
<td style="text-align: center; user-select: auto;">"For The Last Week"</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<p style="user-select: auto;">※ 공지 - 2022년 1월 14일 제한 조건과 테스트 케이스가 추가되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges