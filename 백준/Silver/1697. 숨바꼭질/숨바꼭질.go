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

type Value struct {
	value int
	rank  int
	index int
}

var dx = []string{"+1", "-1", "*2"}

func main() {
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	// bfs 로 해야 할 듯? - 1 1 2x 로 하는 경우
	points := make([]int, 100001)
	// 방문한 경우 처리
	visited := make([]bool, 100001)
	visited[n] = true
	q := []int{n}
	for len(q) != 0 {
		point := q[0]
		q = q[1:]
		if point == m {
			break
		}
		for _, v := range dx {
			next := point
			sign := v[0]
			val, _ := strconv.Atoi(string(v[1]))
			if sign == '+' {
				next += val
			}
			if sign == '-' {
				next -= val
			}
			if sign == '*' {
				next *= val
			}
			if next >= 0 && next < 100001 && !visited[next] {
				q = append(q, next)
				points[next] = points[point] + 1
				visited[next] = true
			}
		}
	}
	//fmt.Fprintln(rw, points[:m+1])
	fmt.Fprintln(rw, points[m])
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
