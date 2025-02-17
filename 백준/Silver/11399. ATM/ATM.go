package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
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
	timestr := strings.Split(getInputLine(rw), " ")
	var times []int
	for _, v := range timestr {
		vs, _ := strconv.Atoi(v)
		times = append(times, vs)
	}
	sort.Ints(times)
	accumSum := make([]int, n)
	accumSum[0] = times[0]
	sum := accumSum[0]
	for i := 1; i < n; i++ {
		accumSum[i] = accumSum[i-1] + times[i]
		sum += accumSum[i]
	}
	fmt.Fprintln(rw, sum)
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
