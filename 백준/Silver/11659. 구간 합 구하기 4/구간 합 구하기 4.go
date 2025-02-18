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
	dp = make([]int, 100001)
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	arr := make([]int, n+1)
	sArr := strings.Split(getInputLine(rw), " ")
	for i := 1; i <= n; i++ {
		arr[i], _ = strconv.Atoi(sArr[i-1])
		dp[i] = dp[i-1] + arr[i]
	}
	for i := 0; i < m; i++ {
		ab := strings.Split(getInputLine(rw), " ")
		a, _ := strconv.Atoi(ab[0])
		b, _ := strconv.Atoi(ab[1])
		fmt.Fprintln(rw, dp[b]-dp[a-1])
	}

}

/*
1 1
2 1
3 1
4 2
5 2
6 3  p(5) p(1)
7 4  p(6) p(2)
8 5  p(7) p(3)
9 7  p(8) p(4)
*/

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
