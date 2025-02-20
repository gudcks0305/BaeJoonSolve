package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

type Node struct {
	value  int
	vertex map[int]*Node
}

func main() {
	defer rw.Flush()
	expression := getInputLine(rw)
	numbers := make([]int, 0)
	sign := make([]rune, 0)
	numString := ""
	for _, v := range expression {
		if '0' <= v && v <= '9' {
			numString += string(v)
		}
		if v == '+' || v == '-' {
			sign = append(sign, v)
			atoi, _ := strconv.Atoi(numString)
			numbers = append(numbers, atoi)
			numString = ""
		}
	}
	// 마지막은 등호가 없어서 추가 필요
	atoi, _ := strconv.Atoi(numString)
	numbers = append(numbers, atoi)
	// - 시작 부터 다음 - 까지 더하기
	// - 시작 부터 다음 + 까지 더하기

	for i := 0; i < len(sign); i++ {
		if sign[i] == '+' {
			numbers[i] += numbers[i+1]
			numbers = append(numbers[:i+1], numbers[i+2:]...)
			sign = append(sign[:i], sign[i+1:]...)
			i--
		}
	}
	for i := 0; i < len(sign); i++ {
		if sign[i] == '-' {
			numbers[i] -= numbers[i+1]
			numbers = append(numbers[:i+1], numbers[i+2:]...)
			sign = append(sign[:i], sign[i+1:]...)
			i--
		}
	}
	fmt.Fprintln(rw, numbers[0])

}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line) // TrimSpace for more robust whitespace handling
}
