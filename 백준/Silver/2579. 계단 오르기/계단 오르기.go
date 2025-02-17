package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var dp []int

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	dp = make([]int, n+1)
	stairs := make([]int, n+1)
	for i := 1; i < n+1; i++ {
		score, _ := strconv.Atoi(getInputLine(rw))
		stairs[i] = score
	}
	dp[0] = stairs[0]
	dp[1] = stairs[1]
	if n >= 2 {
		dp[2] = stairs[1] + stairs[2]
	}
	fmt.Fprintln(rw, Dp(n, stairs))

}
func Dp(num int, stairs []int) int {
	if num <= 2 {
		return dp[num]
	}
	if dp[num] == 0 {
		dp[num] = max(Dp(num-2, stairs), Dp(num-3, stairs)+stairs[num-1]) + stairs[num]
	}
	return dp[num]
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
