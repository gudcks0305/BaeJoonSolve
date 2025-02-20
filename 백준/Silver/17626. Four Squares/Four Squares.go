package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var dp []int
var minimum = 50000

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	dp = make([]int, 50001)
	n, _ := strconv.Atoi(getInputLine(rw))

	for i := 1; i <= n; i++ {
		minimum = 50000
		for j := 1; j*j <= i; j++ {
			if minimum > dp[i-j*j] {
				minimum = dp[i-j*j]
			}
		}
		dp[i] = minimum + 1
	}
	fmt.Fprintln(rw, dp[n])
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
