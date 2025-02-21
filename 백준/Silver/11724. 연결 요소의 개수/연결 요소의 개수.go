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

func main() {
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	graph := make(map[int]map[int]int)
	for i := 1; i <= n; i++ {
		graph[i] = make(map[int]int)
	}
	for i := 0; i < m; i++ {
		vv := strings.Split(getInputLine(rw), " ")
		v1, _ := strconv.Atoi(vv[0])
		v2, _ := strconv.Atoi(vv[1])
		graph[v1][v2] = v1
		graph[v2][v1] = v2
	}
	visit := make([]bool, n+1)
	cnt := 0
	for i := 1; i <= n; i++ {
		if BFS(visit, i, graph) {
			cnt++
		}
	}
	fmt.Fprintln(rw, cnt)
}

func BFS(visit []bool, start int, graph map[int]map[int]int) bool {
	if visit[start] {
		return false
	}
	q := []int{start}
	visit[start] = true
	for len(q) != 0 {
		qPop := q[0]
		q = q[1:]
		for k, _ := range graph[qPop] {
			if visit[k] {
				continue
			}
			visit[k] = true
			q = append(q, k)
		}
	}

	return true
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
