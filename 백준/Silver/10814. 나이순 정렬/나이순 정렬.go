package main

import (
	"bufio"
	"fmt"
	"os"
	"slices"
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
	userList := make([]*User, n)
	for i := range userList {
		st := getInputLine(rw)
		sArrs := strings.Split(st, " ")
		age, _ := strconv.Atoi(sArrs[0])
		name := sArrs[1]
		userList[i] =
			&User{Age: age, Name: name}
	}
	slices.SortStableFunc(userList, func(a, b *User) int {
		return a.Age - b.Age
	})
	for _, v := range userList {
		fmt.Fprintln(rw, v.Age, v.Name)
	}
}

type User struct {
	Age  int
	Name string
}

func getInputLine(writer *bufio.ReadWriter) string {
	readString, _ := writer.ReadString('\n')
	return strings.TrimSpace(readString)
}
