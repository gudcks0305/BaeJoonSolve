package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Node[T any] struct {
	value any
	edges map[int]*Node[T]
}

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	k, _ := strconv.Atoi(getInputLine(rw))
	visit := make([]bool, n+1)
	graph := make(map[int]*Node[int], n+1)
	for i := 0; i < k; i++ {
		vertexs := strings.Split(getInputLine(rw), " ")
		v1, _ := strconv.Atoi(vertexs[0])
		v2, _ := strconv.Atoi(vertexs[1])
		if _, ok := graph[v1]; !ok {
			graph[v1] = &Node[int]{
				value: v1,
				edges: make(map[int]*Node[int]),
			}
		}
		if _, ok := graph[v2]; !ok {
			graph[v2] = &Node[int]{
				value: v2,
				edges: make(map[int]*Node[int]),
			}
		}
		graph[v1].edges[v2] = graph[v2]
		graph[v2].edges[v1] = graph[v1]
	}
	startNode, ok := graph[1]
	if !ok {
		fmt.Fprintln(rw, 0)
		return
	}
	q := make([]*Node[int], 0)
	q = append(q, startNode)
	visit[1] = true
	cnt := 0 // 1번  방문 제외
	for len(q) > 0 {
		node := q[len(q)-1]
		q = q[:len(q)-1]
		for _, v := range node.edges {
			if visit[v.value.(int)] {
				continue
			}
			q = append(q, v)
			visit[v.value.(int)] = true
			cnt++
		}
	}
	fmt.Fprintln(rw, cnt)

}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
