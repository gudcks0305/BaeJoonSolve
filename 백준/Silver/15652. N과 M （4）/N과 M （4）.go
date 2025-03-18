package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Setup buffered I/O for faster input/output operations
var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

func main() {
	// Ensure all buffered output is written before program exits
	defer rw.Flush()
	nm := strings.Split(getInputLine(), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	BackTracking(n, m, 0, 1, "")
}

func BackTracking(n, m, cnt, pre int, str string) {
	if cnt == m {
		fmt.Println(strings.TrimSpace(str))
		return
	}
	for i := pre; i <= n; i++ {
		BackTracking(n, m, cnt+1, i, str+" "+string(rune(i+'0')))
	}
}

// getInputLine reads a line from stdin and returns it without trailing whitespace
func getInputLine() string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
