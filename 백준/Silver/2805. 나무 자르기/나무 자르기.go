package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

func main() {
	defer rw.Flush()
	nm := strings.Split(getInputLine(rw), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	tStrings := strings.Split(getInputLine(rw), " ")
	trees := make([]int, n)
	for i := range trees {
		trees[i], _ = strconv.Atoi(tStrings[i])
	}
	res := binarySearchTree(trees, m)
	fmt.Fprintln(rw, res)
}

func binarySearchTree(trees []int, m int) int {
	sort.Ints(trees)
	low := 0
	high := trees[len(trees)-1]
	res := 0 // 결과를 저장할 변수 초기화

	for low <= high { // 표준 이진 탐색 조건
		mid := (low + high) / 2
		cutAmount := CurTree(trees, mid)

		if cutAmount >= m {
			res = mid   // 가능한 높이를 찾았으므로 res 업데이트
			low = mid + 1 // 더 높은 높이에서 가능한지 탐색
		} else {
			high = mid - 1 // 높이를 낮춰서 나무를 더 많이 얻어야 함
		}
	}
	return res
}
func CurTree(trees []int, h int) int {
	sum := 0
	for _, v := range trees {
		cutHeight := v - h
		if cutHeight < 0 {
			cutHeight = 0
		}
		sum += cutHeight
	}
	return sum
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
