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

	_ = getInputLine(rw) // 한 줄 전체 입력 받기
	nStrings := strings.Split(getInputLine(rw), " ")
	nMaps := make(map[int]bool)
	strconv.Atoi(getInputLine(rw))
	for _, v := range nStrings {
		vn, _ := strconv.Atoi(v)
		if _, ok := nMaps[vn]; !ok {
			nMaps[vn] = true
		}
	}
	mStrings := strings.Split(getInputLine(rw), " ")
	for _, v := range mStrings {
		vn, _ := strconv.Atoi(v)

		if _, ok := nMaps[vn]; ok {
			fmt.Fprintln(rw,1)
		} else {
			fmt.Fprintln(rw,0)
		}
	}
}
func getInputLine(rw *bufio.ReadWriter) string {
	readString, _ := rw.ReadString('\n')
	return strings.TrimSpace(readString)
}
