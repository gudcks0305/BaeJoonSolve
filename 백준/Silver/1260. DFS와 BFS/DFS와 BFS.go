package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

type Node struct {
	value  int
	vertex map[int]*Node
}

func main() {
	defer rw.Flush()
	nmv := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nmv[0])
	m, _ := strconv.Atoi(nmv[1])
	v, _ := strconv.Atoi(nmv[2])
	graph := make(map[int]*Node)
	for i := 1; i <= n; i++ {
		graph[i] = &Node{value: i, vertex: map[int]*Node{}}

	}
	for i := 0; i < m; i++ {
		vv := strings.Split(getInputLine(rw), " ")
		v1, _ := strconv.Atoi(vv[0])
		v2, _ := strconv.Atoi(vv[1])
		_, ok := graph[v1]
		_, ok2 := graph[v2]
		if !ok {
			graph[v1] = &Node{value: v1, vertex: map[int]*Node{}}
		}
		if !ok2 {
			graph[v2] = &Node{value: v2, vertex: map[int]*Node{}}
		}
		graph[v1].vertex[v2] = graph[v2]
		graph[v2].vertex[v1] = graph[v1]
	}
	// dfs bfs
	visit := make([]bool, n+1)
	Dfs(graph, visit, v)
	fmt.Fprintln(rw)
	visit = make([]bool, n+1)
	Bfs(graph, visit, v)

}

/*
5 5 5
1 2
1 3
1 4
2 4
3 4
*/

func Dfs(graph map[int]*Node, visit []bool, start int) {
	fmt.Fprint(rw, start, " ")
	visit[start] = true
	vertex := graph[start].vertex
	keys := GetMapSortedKeys(vertex)
	for _, v := range keys {
		if visit[v] {
			continue
		}
		Dfs(graph, visit, v)
	}
}

func Bfs(graph map[int]*Node, visit []bool, start int) {
	q := make([]int, 0)
	q = append(q, start)
	visit[start] = true
	for len(q) != 0 {
		peek := q[0]
		fmt.Fprint(rw, peek, " ")
		q = q[1:]
		vertex := graph[peek]
		keys := GetMapSortedKeys(vertex.vertex)
		for _, v := range keys {
			if visit[v] {
				continue
			}
			q = append(q, v)
			visit[v] = true
		}
	}
}
func GetMapSortedKeys(m map[int]*Node) []int {
	keys := make([]int, len(m))
	i := 0
	for k := range m {
		keys[i] = k
		i++
	}
	sort.Ints(keys)
	return keys
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
