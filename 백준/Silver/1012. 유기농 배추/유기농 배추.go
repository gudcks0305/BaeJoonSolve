package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	T, _ := strconv.Atoi(getInputLine(rw))
	for i := 0; i < T; i++ {
		mnk := strings.Split(getInputLine(rw), " ")
		m, _ := strconv.Atoi(mnk[0])
		n, _ := strconv.Atoi(mnk[1])
		k, _ := strconv.Atoi(mnk[2])
		bat := make([][]int, n)
		visit := make([][]bool, n)
		for j := range bat {
			bat[j] = make([]int, m)
			visit[j] = make([]bool, m)
		}
		for j := 0; j < k; j++ {
			xy := strings.Split(getInputLine(rw), " ")
			x, _ := strconv.Atoi(xy[0])
			y, _ := strconv.Atoi(xy[1])
			bat[y][x] = 1
		}
		cnt := 0
		for j := 0; j < n; j++ {
			for l := 0; l < m; l++ {
				if !visit[j][l] && bat[j][l] == 1 {
					Bfs(j, l, visit, bat)
					cnt++
				}
			}
		}
		/*for _, v := range bat {
			fmt.Fprintln(rw, v)
		}
		fmt.Fprintln(rw)*/
		fmt.Fprintln(rw, cnt)
	}
}

var dy = []int{1, -1, 0, 0}
var dx = []int{0, 0, 1, -1}

func Bfs(i, j int, visit [][]bool, bat [][]int) {
	visit[i][j] = true
	for k := 0; k < len(dy); k++ {
		y := i + dy[k]
		x := j + dx[k]
		if IsInSide(y, x, len(visit)-1, len(visit[0])-1) && visit[y][x] == false && bat[y][x] == 1 {
			Bfs(y, x, visit, bat)
		}
	}
}
func IsInSide(y, x, m, n int) bool {
	if y > m || y < 0 {
		return false
	}
	if x > n || x < 0 {
		return false
	}
	return true
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
