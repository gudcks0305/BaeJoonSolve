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

func main() {
	defer rw.Flush()
	T, _ := strconv.Atoi(getInputLine(rw))
	for i := 0; i < T; i++ {
		command := getInputLine(rw)
		getInputLine(rw) // skip line
		ars := getInputLine(rw)
		ars = strings.TrimPrefix(ars, "[")
		ars = strings.TrimSuffix(ars, "]")
		arrays := strings.Split(ars, ",")
		ok := true
		if arrays[0] == "" {
			arrays = make([]string, 0)
		}
		left := true
		for _, v := range command {
			if v == 'D' {
				if len(arrays) == 0 {
					fmt.Fprintln(rw, "error")
					ok = false
					break
				}
				if left {
					arrays = arrays[1:]
				} else {
					arrays = arrays[:len(arrays)-1]
				}
			} else if v == 'R' {
				left = !left
			}
		}
		if !ok {
			continue
		}
		sb := strings.Builder{}
		sb.WriteString("[")
		if left {
			for k, v := range arrays {
				if k == len(arrays)-1 {
					sb.WriteString(v)
					continue
				}
				sb.WriteString(v + ",")
			}
		} else {
			for j := len(arrays) - 1; j >= 0; j-- {
				if j == 0 {
					sb.WriteString(arrays[j])
					continue
				}
				sb.WriteString(arrays[j] + ",")
			}
		}

		sb.WriteString("]")
		fmt.Fprintln(rw, sb.String())
		//fmt.Fprintln(rw, arrays)
	}
}

func ReverseArrays(arrs []string) {
	for i := 0; i < len(arrs)/2; i++ {
		arrs[i], arrs[len(arrs)-i-1] = arrs[len(arrs)-i-1], arrs[i]
	}
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
