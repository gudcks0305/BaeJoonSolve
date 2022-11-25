import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
class Solution {
    public String[] solution(String[] files) {
        String[] answer;
        List<File> fileList = new ArrayList<>();
        for (String file : files) {
            fileList.add(new File(file));
        }
        fileList.sort((o1, o2) -> {
            if (o1.getHead().equals(o2.getHead())) {
                return o1.getNumber() - o2.getNumber();
            } else {
                return o1.getHead().compareToIgnoreCase(o2.getHead());
            }
        });
        answer = fileList.stream().map(File::getFileName).toArray(String[]::new);
        return answer;
    }
    public static class File {
        private String fileName;
        private String head;
        private int number;
        private String tail;

        public File(String fileName) {
            this.fileName = fileName;
            this.head = getHead(fileName);
            this.number = getNumber(fileName);
            this.tail = getTail(fileName);
        }

        public String getFileName() {
            return fileName;
        }

        public String getHead() {
            return head;
        }

        public int getNumber() {
            return number;
        }

        public String getTail() {
            return tail;
        }

        public String getHead(String fileName) {
            String head = "";
            for (int i = 0; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    break;
                }
                head += fileName.charAt(i);
            }
            return head.toLowerCase();
        }

        public int getNumber(String fileName) {
            String number = "";
            int numberStartIndex = 0;
            for (int i = 0; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    numberStartIndex = i;
                    break;
                }
            }
            for (int i = numberStartIndex; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    number += fileName.charAt(i);
                }else break;
                if (number.length() == 5) {
                    break;
                }
            }
            return Integer.parseInt(number);
        }

        public String getTail(String fileName) {
            String tail = "";
            for (int i = 0; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    tail = fileName.substring(i + 1);
                    break;
                }
            }
            return tail.toLowerCase();
        }
    }
}