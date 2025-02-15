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
	n, _ := strconv.Atoi(getInputLine(rw))
	peoples := make([][]int, n)

	for i := range peoples {
		s := getInputLine(rw)
		sArr := strings.Split(s, " ")
		sn1, _ := strconv.Atoi(sArr[0])
		sn2, _ := strconv.Atoi(sArr[1])
		peoples[i] = make([]int, 2)
		peoples[i][0], peoples[i][1] = sn1, sn2
	}
	for i := 0; i < n; i++ {
		rank := 1
		for j := 0; j < n; j++ {
			if peoples[i][0] < peoples[j][0] && peoples[i][1] < peoples[j][1] {
				rank++
			}
		}
		fmt.Print(rank, " ")
	}
}

func getInputLine(writer *bufio.ReadWriter) string {
	readString, _ := writer.ReadString('\n')
	return strings.TrimSpace(readString)
}
