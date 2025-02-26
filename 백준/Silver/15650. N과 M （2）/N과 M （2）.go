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
var visited []bool

func main() {
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	// recur
	recur(n, m, 0, "")
}

func recur(n, m, prev int, res string) string {
	if len(res) == m {
		return res
	}
	for i := 1; i <= n; i++ {
		if prev >= i {
			continue
		}
		result := recur(n, m, i, res+strconv.Itoa(i))
		if result == "" {
			continue
		}
		for _, v := range result {
			fmt.Fprint(rw, string(v), " ")
		}
		fmt.Fprintln(rw)
	}
	return ""
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
