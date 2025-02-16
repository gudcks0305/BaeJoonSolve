package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	rw := bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)
	defer rw.Flush()

	n, _ := strconv.Atoi(getInputLine(rw)) // 한 줄 전체 입력 받기
	q := make([]int, n)
	for i := 0; i < n; i++ {
		q[i] = i + 1
	}
	// q 마지막에 pop 하기 위해서 하나는 냅둡
	for len(q) > 1 {
		// pop
		q = q[1:]
		// pop and push
		if len(q) == 1 {
			break
		}
		data := q[0]
		q = q[1:]
		q = append(q, data)

	}
	fmt.Println(q[len(q)-1])
}
func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSpace(readString)
}
