package main

import (
	"bufio"
	"fmt"
	"os"
	"slices"
	"strconv"
	"strings"
)

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	points := make([]*Point, n)
	for i := range points {
		st := getInputLine(rw)
		sArrs := strings.Split(st, " ")
		xi, _ := strconv.Atoi(sArrs[0])
		yi, _ := strconv.Atoi(sArrs[1])
		points[i] = &Point{
			x: xi,
			y: yi,
		}
	}
	slices.SortFunc(points, func(a, b *Point) int {
		if a.y == b.y {
			return a.x - b.x
		}
		return a.y - b.y
	})
	for _, v := range points {
		fmt.Fprintln(rw, v.x, v.y)
	}

}

type Point struct {
	x int
	y int
}

func getInputLine(writer *bufio.ReadWriter) string {
	readString, _ := writer.ReadString('\n')
	return strings.TrimSpace(readString)
}
