package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)
var m, n, h int

func main() {
	defer rw.Flush()
	mnh := strings.Split(getInputLine(rw), " ")
	m, _ = strconv.Atoi(mnh[0]) // 가로
	n, _ = strconv.Atoi(mnh[1]) // 세로
	h, _ = strconv.Atoi(mnh[2]) // 높이

	// 3D 배열 초기화: tmt[세로][가로][높이]
	tmt := make([][][]int, n)
	for i := 0; i < n; i++ {
		tmt[i] = make([][]int, m)
		for j := 0; j < m; j++ {
			tmt[i][j] = make([]int, h)
		}
	}

	// 입력 처리: 높이(h)별로 n x m 행렬 입력
	for k := 0; k < h; k++ {
		for i := 0; i < n; i++ {
			dts := strings.Split(getInputLine(rw), " ")
			for j, v := range dts {
				tmt[i][j][k], _ = strconv.Atoi(v)
			}
		}
	}

	// BFS 실행
	BFS(tmt)

	// 결과 확인
	mx := 0
	ok := true
	for _, v := range tmt {
		for _, v2 := range v {
			for _, v3 := range v2 {
				if v3 == 0 { // 익지 않은 토마토가 있으면 실패
					ok = false
					break
				} else if v3 > 0 { // 익은 토마토의 최대 일수 계산
					mx = max(v3, mx)
				}
			}
			if !ok {
				break
			}
		}
		if !ok {
			break
		}
	}

	// 출력: 모든 토마토가 익지 못하면 -1, 아니면 최대 일수
	if !ok {
		fmt.Fprintln(rw, -1)
	} else if mx == 1 {
		fmt.Fprintln(rw, 0)
	} else {
		fmt.Fprintln(rw, mx)
	}
}

// 방향 벡터: 상, 하, 좌, 우, 앞, 뒤
var dy = []int{-1, 1, 0, 0, 0, 0}
var dx = []int{0, 0, -1, 1, 0, 0}
var dz = []int{0, 0, 0, 0, -1, 1}

type Node struct {
	value Point
	cnt   int
}
type Point struct {
	y, x, z int
}

func BFS(tmt [][][]int) {
	q := []*Node{}
	// 모든 익은 토마토(1)를 큐에 추가, 초기 cnt는 0
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			for k := 0; k < h; k++ {
				if tmt[i][j][k] == 1 {
					q = append(q, &Node{Point{i, j, k}, 0})
				}
			}
		}
	}

	// BFS 실행
	for len(q) != 0 {
		point := q[0]
		q = q[1:]
		for i := range dy {
			nextY := point.value.y + dy[i]
			nextX := point.value.x + dx[i]
			nextZ := point.value.z + dz[i]
			if IsRange(nextX, nextY, nextZ) && tmt[nextY][nextX][nextZ] == 0 {
				tmt[nextY][nextX][nextZ] = point.cnt + 1
				q = append(q, &Node{Point{nextY, nextX, nextZ}, point.cnt + 1})
			}
		}
	}
}

func IsRange(x, y, z int) bool {
	return x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
