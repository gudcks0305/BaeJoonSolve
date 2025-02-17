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
	dp = make([]int, n+2)
	dp[0] = 0
	dp[1] = 0
	dp[2] = 1
	fmt.Fprintln(rw, makeOne(n))
}

// 16 8 4 2 1
// 16
func makeOne(nums int) int {
	if nums == 1 || nums == 0 || nums == 2 {
		return dp[nums]
	}
	if dp[nums] == 0 {
		if nums%6 == 0 {
			dp[nums] = min(min(makeOne(nums/3), makeOne(nums/2)), makeOne(nums-1)) + 1
		} else if nums%3 == 0 {
			dp[nums] = min(makeOne(nums/3), makeOne(nums-1)) + 1
		} else if nums%2 == 0 {
			dp[nums] = min(makeOne(nums/2), makeOne(nums-1)) + 1
		} else {
			dp[nums] = makeOne(nums-1) + 1
		}
	}
	return dp[nums]
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
