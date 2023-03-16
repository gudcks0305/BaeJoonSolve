function solution(s) {
    var input = s.split(" ").map((n) => parseInt(n,10));
    var output = Math.min(...input) + " " +  Math.max(...input);
    return output;
}