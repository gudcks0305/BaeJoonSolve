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

var dy = []int{-1, 1, 0, 0}
var dx = []int{0, 0, -1, 1}

type Node struct {
	y, x int
}

type Search interface {
	Search(y, x int)
	GetGrid() []string
	GetVisit() [][]bool
}

type RedGreenBlindNessSearch struct {
	grid  []string
	visit [][]bool
}

func (rgb *RedGreenBlindNessSearch) GetGrid() []string {
	return rgb.grid
}

func (rgb *RedGreenBlindNessSearch) GetVisit() [][]bool {
	return rgb.visit
}

func NewRedGreenBlindNessSearch(grid []string) *RedGreenBlindNessSearch {
	return &RedGreenBlindNessSearch{grid: grid, visit: NewDoubleDimensionVisit(len(grid), len(grid[0]))}
}

func (rgb *RedGreenBlindNessSearch) Search(y, x int) {
	q := []*Node{{y: y, x: x}}
	rgb.visit[y][x] = true
	for len(q) != 0 {
		node := q[0]
		q = q[1:]
		//fmt.Fprintln(rw, node)
		for i := range dy {
			nextY := node.y + dy[i]
			nextX := node.x + dx[i]
			if IsRange(len(rgb.grid)-1, len(rgb.grid[0])-1, nextY, nextX) && !rgb.visit[nextY][nextX] {
				previousColor := rgb.grid[node.y][node.x]
				nextColor := rgb.grid[nextY][nextX]
				// red == green 처리
				if previousColor == nextColor || (previousColor == 'R' && nextColor == 'G') || (previousColor == 'G' && nextColor == 'R') {
					q = append(q, &Node{
						y: nextY,
						x: nextX,
					})
					rgb.visit[nextY][nextX] = true
				}
			}
		}
	}
}

type OkSearch struct {
	grid  []string
	visit [][]bool
}

func (oks *OkSearch) GetGrid() []string {
	return oks.grid
}

func (oks *OkSearch) GetVisit() [][]bool {
	return oks.visit
}

func NewOkSearch(grid []string) *OkSearch {
	return &OkSearch{grid: grid, visit: NewDoubleDimensionVisit(len(grid), len(grid[0]))}
}

func (oks *OkSearch) Search(y, x int) {
	q := []*Node{{y: y, x: x}}
	oks.visit[y][x] = true
	for len(q) != 0 {
		node := q[0]
		q = q[1:]
		//fmt.Fprintln(rw, node)
		for i := range dy {
			nextY := node.y + dy[i]
			nextX := node.x + dx[i]
			if IsRange(len(oks.grid)-1, len(oks.grid[0])-1, nextY, nextX) && !oks.visit[nextY][nextX] {
				previousColor := oks.grid[node.y][node.x]
				nextColor := oks.grid[nextY][nextX]
				// red == green 처리
				if previousColor == nextColor {
					q = append(q, &Node{
						y: nextY,
						x: nextX,
					})
					oks.visit[nextY][nextX] = true
				}
			}
		}
	}
}

func NewDoubleDimensionVisit(y, x int) [][]bool {
	visited := make([][]bool, y)
	for i := range visited {
		visited[i] = make([]bool, x)
	}

	return visited
}

func BFS(search Search) int {
	cnt := 0
	for i, grid := range search.GetGrid() {
		for j := range grid {
			if !search.GetVisit()[i][j] {
				search.Search(i, j)
				cnt++
			}
		}
	}
	return cnt
}

func IsRange(y, x, y1, x1 int) bool {
	if y1 > y || y1 < 0 {
		return false
	}
	if x1 > x || x1 < 0 {
		return false
	}
	return true
}

func main() {
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	grid := make([]string, n)
	for i := 0; i < n; i++ {
		grid[i] = getInputLine(rw)
	}
	oks := NewOkSearch(grid)
	cnt1 := BFS(oks)
	rgBlinedSearch := NewRedGreenBlindNessSearch(grid)
	cnt := BFS(rgBlinedSearch)
	fmt.Fprintln(rw, cnt1, cnt)

}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
