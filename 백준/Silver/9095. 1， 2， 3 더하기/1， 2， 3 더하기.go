package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Node struct {
	value int
	edges map[int]*Node
}

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()

	n, _ := strconv.Atoi(getInputLine(rw))
	for i := 0; i < n; i++ {
		value, _ := strconv.Atoi(getInputLine(rw))
		fmt.Fprintln(rw, recur(value))
	}

}

func recur(num int) int {
	if num < 0 {
		return 0
	}
	if num <= 1 {
		return 1
	}
	return recur(num-1) + recur(num-2) + recur(num-3)
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
