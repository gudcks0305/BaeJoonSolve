# [level 1] 숫자 문자열과 영단어 - 81301 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/81301) 

### 성능 요약

메모리: 77.6 MB, 시간: 0.23 ms

### 구분

코딩테스트 연습 > 2021 카카오 채용연계형 인턴십

### 채점결과

<br/>정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p style="user-select: auto;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d31cb063-4025-4412-8cbc-6ac6909cf93e/img1.png" title="" alt="img1.png" style="user-select: auto;"></p>

<p style="user-select: auto;">네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.<br style="user-select: auto;"><br style="user-select: auto;">
다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.</p>

<ul style="user-select: auto;">
<li style="user-select: auto;">1478 → "one4seveneight"</li>
<li style="user-select: auto;">234567 → "23four5six7"</li>
<li style="user-select: auto;">10203 → "1zerotwozero3"</li>
</ul>

<p style="user-select: auto;">이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 <code style="user-select: auto;">s</code>가 매개변수로 주어집니다. <code style="user-select: auto;">s</code>가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.</p>

<p style="user-select: auto;">참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.</p>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">숫자</th>
<th style="user-select: auto;">영단어</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">0</td>
<td style="user-select: auto;">zero</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">1</td>
<td style="user-select: auto;">one</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">2</td>
<td style="user-select: auto;">two</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">3</td>
<td style="user-select: auto;">three</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">4</td>
<td style="user-select: auto;">four</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">5</td>
<td style="user-select: auto;">five</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">6</td>
<td style="user-select: auto;">six</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">7</td>
<td style="user-select: auto;">seven</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">8</td>
<td style="user-select: auto;">eight</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">9</td>
<td style="user-select: auto;">nine</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<h5 style="user-select: auto;">제한사항</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">1 ≤ <code style="user-select: auto;">s</code>의 길이 ≤ 50</li>
<li style="user-select: auto;"><code style="user-select: auto;">s</code>가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.</li>
<li style="user-select: auto;">return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 <code style="user-select: auto;">s</code>로 주어집니다.</li>
</ul>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">입출력 예</h5>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">s</th>
<th style="user-select: auto;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;"><code style="user-select: auto;">"one4seveneight"</code></td>
<td style="user-select: auto;">1478</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;"><code style="user-select: auto;">"23four5six7"</code></td>
<td style="user-select: auto;">234567</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;"><code style="user-select: auto;">"2three45sixseven"</code></td>
<td style="user-select: auto;">234567</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;"><code style="user-select: auto;">"123"</code></td>
<td style="user-select: auto;">123</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<h5 style="user-select: auto;">입출력 예 설명</h5>

<p style="user-select: auto;"><strong style="user-select: auto;">입출력 예 #1</strong></p>

<ul style="user-select: auto;">
<li style="user-select: auto;">문제 예시와 같습니다.</li>
</ul>

<p style="user-select: auto;"><strong style="user-select: auto;">입출력 예 #2</strong></p>

<ul style="user-select: auto;">
<li style="user-select: auto;">문제 예시와 같습니다.</li>
</ul>

<p style="user-select: auto;"><strong style="user-select: auto;">입출력 예 #3</strong></p>

<ul style="user-select: auto;">
<li style="user-select: auto;">"three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.</li>
<li style="user-select: auto;">입출력 예 #2와 #3과 같이 같은 정답을 가리키는 문자열이 여러 가지가 나올 수 있습니다.</li>
</ul>

<p style="user-select: auto;"><strong style="user-select: auto;">입출력 예 #4</strong></p>

<ul style="user-select: auto;">
<li style="user-select: auto;"><code style="user-select: auto;">s</code>에는 영단어로 바뀐 부분이 없습니다.</li>
</ul>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">제한시간 안내</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">정확성 테스트 : 10초</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges