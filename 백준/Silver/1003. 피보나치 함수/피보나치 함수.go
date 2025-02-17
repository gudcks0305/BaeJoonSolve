package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var fiboDp [][]int

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	fiboDp = make([][]int, 41)
	/*for i,_ := range fiboDp{
		fiboDp[i] = make([]int, 2)
	}*/
	fiboDp[0] = []int{1, 0}
	fiboDp[1] = []int{0, 1}
	for i := 0; i < n; i++ {
		nums, _ := strconv.Atoi(getInputLine(rw))
		callNums, one := calcCallNums(nums)
		fmt.Fprintln(rw, callNums, one)
	}

}

func calcCallNums(nums int) (int, int) {
	if fiboDp[nums] != nil {
		return fiboDp[nums][0], fiboDp[nums][1]
	}
	for i := 2; i <= nums; i++ {
		zero := fiboDp[i-1][0] + fiboDp[i-2][0]
		one := fiboDp[i-1][1] + fiboDp[i-2][1]
		fiboDp[i] = []int{zero, one}
	}
	return fiboDp[nums][0], fiboDp[nums][1]

	// 2 ^ n + 1 호출에서 ...
	// 0  = 1 0
	// 1 =  0 1
	// 2 =  1 1
	// 3 =  1 2
	// 4 =  2 3
	// 5 =  3 4
	// 6 =  4 6
	// 7 =  6 9
	// 8 =  9 13
}

func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSuffix(readString, "\n")
}
